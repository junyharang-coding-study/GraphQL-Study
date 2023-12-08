import { HttpStatus, Inject, Injectable } from "@nestjs/common";
import { RoleService } from "./role-service.interface";
import { RoleRepository } from "../resository/role-repository.interface";
import { DefaultResponse } from "../../common/constant/default.response";
import { RoleResponseDto } from "../model/dto/response/role-response.dto";
import { RoleSearchRequestDto } from "../model/dto/request/role-search-request.dto";
import { RoleRequestDto } from "../model/dto/request/role-request.dto";
import { RoleUpdateRequestDto } from "../model/dto/request/role-update-request.dto";
import { InjectRepository } from "@nestjs/typeorm";
import { Repository } from "typeorm";
import { RoleEntity } from "../model/entities/role.entity";
import { Page } from "../../common/constant/page";
import { PeopleEntity } from "../../people/model/entities/people.entity";
import { EquipmentEntity } from "../../equipment/model/entities/equipment.entity";
import { SoftwareEntity } from "../../software/model/entities/software.entity";
import { Role } from "../../../common/enum/people.role.enum";
import { RoleAndMebmersAndSoftwaresResponseDto } from "../model/dto/response/role-members-equipment.resonpose.dto";

@Injectable()
export class RoleServiceImpl implements RoleService {
  constructor(
    @InjectRepository(EquipmentEntity) private readonly equipmentRepository: Repository<EquipmentEntity>,
    @InjectRepository(PeopleEntity) private readonly peopleRepository: Repository<PeopleEntity>,
    @InjectRepository(SoftwareEntity) private readonly softwareRepository: Repository<SoftwareEntity>,
    @InjectRepository(RoleEntity) private readonly roleRepository: Repository<RoleEntity>,
    @Inject("RoleQueryBuilderRepository") private readonly roleQueryBuilderRepository: RoleRepository,
  ) {}

  async saveRole(roleRequestDto: RoleRequestDto): Promise<DefaultResponse<string>> {
    if (roleRequestDto === null) {
      return DefaultResponse.response(HttpStatus.NO_CONTENT, "Failed Create");
    }

    const roleId = roleRequestDto.roleId;

    if ((await this.roleRepository.findOne({ where: { roleId } })) !== null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Target ID For Save is Already in the DB");
    }

    const saveRole = await this.roleRepository.save(roleRequestDto.toEntity(roleRequestDto));

    if (saveRole === null) {
      return DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error");
    }

    return DefaultResponse.responseWithData(HttpStatus.CREATED, "Success Create", saveRole.roleId);
  }

  async getRoleList(roleSearchRequestDto: RoleSearchRequestDto): Promise<DefaultResponse<RoleResponseDto>> {
    const result = await this.roleQueryBuilderRepository.dynamicQuerySearchAndPagingByDto(roleSearchRequestDto);

    if (result[0].length === 0) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.responseWithPaginationAndData(
      HttpStatus.OK,
      "Success",
      new Page(
        result[0].length,
        result[1],
        result[0].map((role: RoleEntity) => new RoleResponseDto(role)),
      ),
    );
  }

  async getRoles(): Promise<DefaultResponse<RoleResponseDto>> {
    const result = await this.roleRepository.findAndCount();

    if (result[0].length === 0) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.responseWithPaginationAndData(
      HttpStatus.OK,
      "Success",
      new Page(
        result[0].length,
        result[1],
        result[0].map((role: RoleEntity) => new RoleResponseDto(role)),
      ),
    );
  }

  async getRole(roleId: string): Promise<DefaultResponse<RoleResponseDto>> {
    if (roleId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    const role = await this.roleRepository.findOne({ where: { roleId } });

    if (role === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.responseWithData(HttpStatus.OK, "OK", new RoleResponseDto(role));
  }

  async getRoleAndMembersAndEquipmentAndSoftware(roleId: string): Promise<DefaultResponse<RoleAndMebmersAndSoftwaresResponseDto>> {
    if (roleId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    const members = await this.peopleRepository.findBy({ role: this.checkRole(roleId) });
    const role = await this.roleRepository.findOne({ where: { roleId } });
    const equipments = await this.equipmentRepository.findBy({ usedBy: roleId });
    const softwareArray = await this.softwareRepository.findBy({ usedBy: roleId });

    if (this.checkNull(members, role, equipments, softwareArray) === false) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.responseWithData(
      HttpStatus.OK,
      "Success",
      new RoleAndMebmersAndSoftwaresResponseDto(members, role, equipments, softwareArray),
    );
  }

  async updateRole(roleUpdateRequestDto: RoleUpdateRequestDto): Promise<DefaultResponse<string>> {
    const roleId = roleUpdateRequestDto.roleId;

    if (roleId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    if ((await this.roleRepository.findOne({ where: { roleId } })) === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Update Target Data Not Found");
    }

    await this.roleRepository.update(roleId, roleUpdateRequestDto.toEntity(roleUpdateRequestDto));

    return DefaultResponse.responseWithData(HttpStatus.OK, "Success Update", roleId);
  }

  async deleteRole(roleId: string): Promise<DefaultResponse<string>> {
    if (roleId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    const deleteTarget = await this.roleRepository.findOne({ where: { roleId } });

    if (deleteTarget === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Delete Target Data Not Found");
    }

    const deleteResult = await this.roleRepository.delete(roleId);

    if (deleteResult === null) {
      return DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR, "Delete Failed");
    }

    return DefaultResponse.responseWithData(HttpStatus.OK, "OK", roleId);
  }

  private checkRole(roleId: string) {
    if (roleId === "developer") {
      return Role.developer;
    } else if (roleId === "designer") {
      return Role.designer;
    } else {
      return Role.planner;
    }
  }

  private checkNull(members: PeopleEntity[], role: RoleEntity, equipments: EquipmentEntity[], softwareArray: SoftwareEntity[]): boolean {
    if (equipments.length === 0) {
      return false;
    }

    if (role === null) {
      return false;
    }

    if (members.length === 0) {
      return false;
    }

    return softwareArray.length !== 0;
  }
}
