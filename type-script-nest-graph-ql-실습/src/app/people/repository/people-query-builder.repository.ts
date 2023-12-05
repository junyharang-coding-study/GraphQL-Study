import { Injectable } from "@nestjs/common";
import { InjectRepository } from "@nestjs/typeorm";
import { PeopleEntity } from "../model/entities/people.entity";
import { Repository } from "typeorm";
import { PeopleSearchRequestDto } from "../model/dto/request/people-search-request.dto";
import { PeopleRepository } from "./people-repository.interface";
import { TeamEntity } from "../../team/model/entities/team.entity";

@Injectable()
export class PeopleQueryBuilderRepository implements PeopleRepository {
  constructor(@InjectRepository(PeopleEntity) private readonly peopleRepository: Repository<PeopleEntity>) {}

  async dynamicQuerySearchAndPagingByDto(peopleSearchRequestDto: PeopleSearchRequestDto): Promise<[PeopleEntity[], number]> {
    const selectQueryBuilder = this.peopleRepository
      .createQueryBuilder("people")
      .leftJoinAndSelect(TeamEntity, "team", "team.teamId = people.teamId")
      .limit(peopleSearchRequestDto.getPerPageSize())
      .offset(peopleSearchRequestDto.getPageNumber());

    if (peopleSearchRequestDto.teamId) {
      selectQueryBuilder.andWhere("people.teamId = :teamId", { teamId: peopleSearchRequestDto.teamId });
    }

    if (peopleSearchRequestDto.lastName) {
      selectQueryBuilder.andWhere("people.lastName = :lastName", { lastName: peopleSearchRequestDto.lastName });
    }

    if (peopleSearchRequestDto.firstName) {
      selectQueryBuilder.andWhere("people.firstName = :firstName", { firstName: peopleSearchRequestDto.firstName });
    }

    if (peopleSearchRequestDto.sex) {
      selectQueryBuilder.andWhere("people.sex = :sex", { sex: peopleSearchRequestDto.sex });
    }

    if (peopleSearchRequestDto.bloodType) {
      selectQueryBuilder.andWhere("people.bloodType = :bloodType", { bloodType: peopleSearchRequestDto.bloodType });
    }

    if (peopleSearchRequestDto.serveYears) {
      selectQueryBuilder.andWhere("people.serveYears = :serveYears", { serveYears: peopleSearchRequestDto.serveYears });
    }

    if (peopleSearchRequestDto.role) {
      selectQueryBuilder.andWhere("people.role = :role", { role: peopleSearchRequestDto.role });
    }

    if (peopleSearchRequestDto.hometown) {
      selectQueryBuilder.andWhere("people.hometown = :hometown", { hometown: peopleSearchRequestDto.hometown });
    }

    if (peopleSearchRequestDto.orderBy === true) {
      selectQueryBuilder.orderBy("people.peopleId", "DESC");
    }

    return await selectQueryBuilder.getManyAndCount();
  }
}
