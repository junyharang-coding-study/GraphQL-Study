import { Injectable } from "@nestjs/common";
import { SupplyRepository } from "./supply-repository.interface";
import { InjectRepository } from "@nestjs/typeorm";
import { PeopleEntity } from "../../people/model/entities/people.entity";
import { Repository } from "typeorm";
import { SupplyEntity } from "../model/entities/supply.entity";
import { SupplySearchRequestDto } from "../model/dto/request/supply-search-request.dto";

@Injectable()
export class SupplyQueryBuilderRepository implements SupplyRepository {
  constructor(@InjectRepository(SupplyEntity) private readonly supplyRepository: Repository<SupplyEntity>) {}

  async dynamicQuerySearchAndPagingByDto(supplySearchRequestDto: SupplySearchRequestDto): Promise<[SupplyEntity[], number]> {
    const selectQueryBuilder = this.supplyRepository
      .createQueryBuilder("supply")
      .leftJoinAndSelect("supply.team", "team")
      .take(supplySearchRequestDto.getLimit())
      .skip(supplySearchRequestDto.getOffset());

    if (supplySearchRequestDto.supplyId) {
      selectQueryBuilder.andWhere("supply.supplyId = :supplyId", { supplyId: `${supplySearchRequestDto.supplyId}` });
    }

    if (supplySearchRequestDto.teamId) {
      selectQueryBuilder.andWhere("supply.team.teamId = :teamId", { teamId: `${supplySearchRequestDto.teamId}` });
    }

    if (supplySearchRequestDto.orderBy === true) {
      selectQueryBuilder.orderBy("supply.supplyId", "DESC");
    }

    return await selectQueryBuilder.getManyAndCount();
  }

  findOneJoinTeam(supplyId: string): Promise<SupplyEntity> {
    return this.supplyRepository
      .createQueryBuilder("supply")
      .leftJoinAndSelect("supply.team", "team")
      .where("supply.supplyId = :supplyId", { supplyId: supplyId })
      .getOne();
  }
}
