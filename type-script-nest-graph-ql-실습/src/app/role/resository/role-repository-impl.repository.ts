import { Injectable } from "@nestjs/common";
import { RoleRepository } from "./role-repository.interface";
import { InjectRepository } from "@nestjs/typeorm";
import { RoleEntity } from "../model/entities/role.entity";
import { Repository } from "typeorm";
import { RoleSearchRequestDto } from "../model/dto/request/role-search-request.dto";

@Injectable()
export class RoleQueryBuilderRepository implements RoleRepository {
  constructor(@InjectRepository(RoleEntity) private readonly roleRepository: Repository<RoleEntity>) {}

  async dynamicQuerySearchAndPagingByDto(roleSearchRequestDto: RoleSearchRequestDto): Promise<[RoleEntity[], number]> {
    const selectQueryBuilder = this.roleRepository
      .createQueryBuilder("role")
      .limit(roleSearchRequestDto.getLimit())
      .offset(roleSearchRequestDto.getOffset());

    if (roleSearchRequestDto.job) {
      selectQueryBuilder.andWhere("role.job = :job", { usedBy: `${roleSearchRequestDto.job}` });
    }

    if (roleSearchRequestDto.requirement) {
      selectQueryBuilder.andWhere("role.requirement = :requirement", { usedBy: `${roleSearchRequestDto.requirement}` });
    }

    return await selectQueryBuilder.getManyAndCount();
  }
}
