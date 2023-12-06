import { HttpStatus, Inject, Injectable } from "@nestjs/common";
import { SupplyService } from "./supply-service.interface";
import { InjectRepository } from "@nestjs/typeorm";
import { Repository } from "typeorm";
import { SupplyEntity } from "../model/entities/supply.entity";
import { DefaultResponse } from "../../common/constant/default.response";
import { SupplyResponseDto } from "../model/dto/response/supply-response.dto";
import { SupplySearchRequestDto } from "../model/dto/request/supply-search-request.dto";
import { SupplyRequestDto } from "../model/dto/request/supply-request.dto";
import { SupplyUpdateRequestDto } from "../model/dto/request/supply-update-request.dto";
import { Page } from "../../common/constant/page";
import { SupplyRepository } from "../repository/supply-repository.interface";
import { TeamEntity } from "../../team/model/entities/team.entity";
import { SoftwareSearchRequestDto } from "../../software/model/dto/request/software-search-request.dto";

@Injectable()
export class SupplyServiceImpl implements SupplyService {
  constructor(
    @InjectRepository(SupplyEntity) private readonly supplyRepository: Repository<SupplyEntity>,
    @Inject("SupplyQueryBuilderRepository") private readonly supplyQueryBuilderRepository: SupplyRepository,
    @InjectRepository(TeamEntity) private readonly teamRepository: Repository<TeamEntity>,
  ) {}

  async saveSupply(supplyRequestDto: SupplyRequestDto): Promise<DefaultResponse<string>> {
    if (supplyRequestDto === null) {
      return DefaultResponse.response(HttpStatus.NO_CONTENT, "Failed Create");
    }

    const teamId = supplyRequestDto.teamId;

    if ((await this.teamRepository.findOne({ where: { teamId } })) === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Non-existent team information");
    }

    const savedSupply = await this.supplyRepository.save(supplyRequestDto.toEntity(supplyRequestDto));

    if (savedSupply === null) {
      return DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error");
    }

    return DefaultResponse.responseWithData(HttpStatus.CREATED, "Success Create", savedSupply.supplyId);
  }

  async getSupplyList(teamId: number, pageNumber: number, perPageSize: number, orderBy: boolean): Promise<DefaultResponse<SupplyResponseDto>> {
    const result = await this.supplyQueryBuilderRepository.dynamicQuerySearchAndPagingByDto(
      SupplySearchRequestDto.toDto(teamId, pageNumber, perPageSize, orderBy),
    );

    if (result[0].length === 0) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.responseWithPaginationAndData(
      HttpStatus.OK,
      "Success",
      new Page(
        result[0].length,
        result[1],
        result[0].map((supply: SupplyEntity) => new SupplyResponseDto(supply)),
      ),
    );
  }

  async getSupply(supplyId: string): Promise<DefaultResponse<SupplyResponseDto>> {
    if (supplyId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    const supply = await this.supplyQueryBuilderRepository.findOneJoinTeam(supplyId);

    if (supply === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.responseWithData(HttpStatus.OK, "OK", new SupplyResponseDto(supply));
  }

  async updateSupply(supplyUpdateRequestDto: SupplyUpdateRequestDto): Promise<DefaultResponse<string>> {
    const supplyId = supplyUpdateRequestDto.supplyId;

    if (supplyId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    if ((await this.supplyQueryBuilderRepository.findOneJoinTeam(supplyId)) === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Update Target Data Not Found");
    }

    await this.supplyRepository.update(supplyId, supplyUpdateRequestDto.toEntity(supplyUpdateRequestDto));

    return DefaultResponse.responseWithData(HttpStatus.OK, "Success Update", supplyId);
  }

  async deleteSupply(supplyId: string): Promise<DefaultResponse<string>> {
    if (supplyId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    if ((await this.supplyQueryBuilderRepository.findOneJoinTeam(supplyId)) === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Delete Target Data Not Found");
    }

    if ((await this.supplyRepository.delete({ supplyId: supplyId })) === null) {
      return DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR, "Delete Failed");
    }

    return DefaultResponse.responseWithData(HttpStatus.OK, "OK", supplyId);
  }
}
