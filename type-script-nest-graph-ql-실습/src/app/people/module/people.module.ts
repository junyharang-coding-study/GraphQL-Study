import { Module } from "@nestjs/common";
import { TypeOrmModule } from "@nestjs/typeorm";
import { PeopleEntity } from "../model/entities/people.entity";
import { PeopleResolver } from "../resolver/people.resolver";
import { PeopleServiceImpl } from "../service/people-service-impl.service";
import { PeopleQueryBuilderRepository } from "../repository/people-query-builder.repository";
import { TeamEntity } from "../../team/model/entities/team.entity";

@Module({
  imports: [TypeOrmModule.forFeature([PeopleEntity, TeamEntity])],
  providers: [
    PeopleResolver,
    PeopleServiceImpl,
    {
      provide: "PeopleService",
      useClass: PeopleServiceImpl,
    },
    PeopleQueryBuilderRepository,
    {
      provide: "PeopleQueryBuilderRepository",
      useClass: PeopleQueryBuilderRepository,
    },
  ],
})
export class PeopleModule {}
