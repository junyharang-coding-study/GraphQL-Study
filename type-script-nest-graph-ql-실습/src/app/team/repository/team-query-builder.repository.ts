import { Injectable } from "@nestjs/common";
import { TeamRepository } from "./team-interface.repository";
import { InjectRepository } from "@nestjs/typeorm";
import { Repository } from "typeorm";
import { TeamEntity } from "../model/entities/team.entity";
import { TeamSearchRequestDto } from "../model/dto/request/team-search-request.dto";

@Injectable()
export class TeamQueryBuilderRepository implements TeamRepository {
  constructor(@InjectRepository(TeamEntity) private readonly teamRepository: Repository<TeamEntity>) {}

  async dynamicQuerySearchAndPagingByDto(teamSearchRequestDto: TeamSearchRequestDto): Promise<[TeamEntity[], number]> {
    const selectQueryBuilder = this.teamRepository
      .createQueryBuilder("team")
      .limit(teamSearchRequestDto.getLimit())
      .offset(teamSearchRequestDto.getOffset());

    if (teamSearchRequestDto.manager) {
      selectQueryBuilder.andWhere("team.manager = :manager", { manager: `${teamSearchRequestDto.manager}` });
    }

    if (teamSearchRequestDto.office) {
      selectQueryBuilder.andWhere("team.office = :office", { office: `${teamSearchRequestDto.office}` });
    }

    if (teamSearchRequestDto.extensionNumber) {
      selectQueryBuilder.andWhere("team.extensionNumber = :extensionNumber", { extensionNumber: `${teamSearchRequestDto.extensionNumber}` });
    }

    if (teamSearchRequestDto.mascot) {
      selectQueryBuilder.andWhere("team.mascot = :mascot", { mascot: `${teamSearchRequestDto.mascot}` });
    }

    if (teamSearchRequestDto.cleaningDuty) {
      selectQueryBuilder.andWhere("team.cleaningDuty = :cleaningDuty", { cleaningDuty: `${teamSearchRequestDto.cleaningDuty}` });
    }

    if (teamSearchRequestDto.project) {
      selectQueryBuilder.andWhere("team.project = :project", { project: `${teamSearchRequestDto.project}` });
    }

    if (teamSearchRequestDto.orderBy === true) {
      selectQueryBuilder.orderBy("team.teamId", "DESC");
    }

    return await selectQueryBuilder.getManyAndCount();
  }
}
