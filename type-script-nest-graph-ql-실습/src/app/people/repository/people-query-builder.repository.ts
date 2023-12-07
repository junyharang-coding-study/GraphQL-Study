import { Injectable } from "@nestjs/common";
import { InjectRepository } from "@nestjs/typeorm";
import { PeopleEntity } from "../model/entities/people.entity";
import { Repository } from "typeorm";
import { PeopleSearchRequestDto } from "../model/dto/request/people-search-request.dto";
import { PeopleRepository } from "./people-repository.interface";

@Injectable()
export class PeopleQueryBuilderRepository implements PeopleRepository {
  constructor(@InjectRepository(PeopleEntity) private readonly peopleRepository: Repository<PeopleEntity>) {}

  async dynamicQuerySearchAndPagingByDto(peopleSearchRequestDto: PeopleSearchRequestDto): Promise<[PeopleEntity[], number]> {
    const selectQueryBuilder = this.peopleRepository
      .createQueryBuilder("people")
      .leftJoinAndSelect("people.team", "team")
      .take(peopleSearchRequestDto.getLimit())
      .skip(peopleSearchRequestDto.getOffset());

    if (peopleSearchRequestDto.teamId) {
      selectQueryBuilder.andWhere("people.team.teamId = :teamId", { teamId: `${peopleSearchRequestDto.teamId}` });
    }

    if (peopleSearchRequestDto.lastName) {
      selectQueryBuilder.andWhere("people.lastName = :lastName", { lastName: `${peopleSearchRequestDto.lastName}` });
    }

    if (peopleSearchRequestDto.firstName) {
      selectQueryBuilder.andWhere("people.firstName = :firstName", { firstName: `${peopleSearchRequestDto.firstName}` });
    }

    if (peopleSearchRequestDto.sex) {
      selectQueryBuilder.andWhere("people.sex = :sex", { sex: `${peopleSearchRequestDto.sex}` });
    }

    if (peopleSearchRequestDto.bloodType) {
      selectQueryBuilder.andWhere("people.bloodType = :bloodType", { bloodType: `${peopleSearchRequestDto.bloodType}` });
    }

    if (peopleSearchRequestDto.serveYears) {
      selectQueryBuilder.andWhere("people.serveYears = :serveYears", { serveYears: `${peopleSearchRequestDto.serveYears}` });
    }

    if (peopleSearchRequestDto.role) {
      selectQueryBuilder.andWhere("people.role = :role", { role: `${peopleSearchRequestDto.role}` });
    }

    if (peopleSearchRequestDto.hometown) {
      selectQueryBuilder.andWhere("people.hometown = :hometown", { hometown: `${peopleSearchRequestDto.hometown}` });
    }

    if (peopleSearchRequestDto.orderBy === true) {
      selectQueryBuilder.orderBy("people.peopleId", "DESC");
    }

    return await selectQueryBuilder.getManyAndCount();
  }

  findOneJoinTeam(peopleId: number): Promise<PeopleEntity> {
    return this.peopleRepository
      .createQueryBuilder("people")
      .leftJoinAndSelect("people.team", "team")
      .where("people.peopleId = :peopleId", { peopleId: peopleId })
      .getOne();
  }

  findAllByTeamId(teamId: number): Promise<PeopleEntity[]> {
    return this.peopleRepository
      .createQueryBuilder("people")
      .leftJoinAndSelect("people.team", "team")
      .where("people.team.teamId = :teamId", { teamId: `${teamId}` })
      .getMany();
  }
}
