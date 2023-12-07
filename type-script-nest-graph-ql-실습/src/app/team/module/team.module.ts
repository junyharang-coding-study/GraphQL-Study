import { Module } from "@nestjs/common";
import { TypeOrmModule } from "@nestjs/typeorm";
import { TeamQueryBuilderRepository } from "../repository/team-query-builder.repository";
import { TeamImplService } from "../service/team-impl.service";
import { TeamResolver } from "../resolver/team.resolver";
import { TeamEntity } from "../model/entities/team.entity";
import { PeopleEntity } from "../../people/model/entities/people.entity";
import { PeopleQueryBuilderRepository } from "../../people/repository/people-query-builder.repository";
import { TeamRestApiController } from "../controller/team-rest-api.controller";

@Module({
  imports: [TypeOrmModule.forFeature([TeamEntity, PeopleEntity])],
  controllers: [TeamRestApiController],
  providers: [
    TeamResolver,
    TeamImplService,
    {
      provide: "TeamService",
      useClass: TeamImplService,
    },
    TeamQueryBuilderRepository,
    {
      provide: "TeamQueryBuilderRepository",
      useClass: TeamQueryBuilderRepository,
    },
    PeopleQueryBuilderRepository,
    {
      provide: "PeopleQueryBuilderRepository",
      useClass: PeopleQueryBuilderRepository,
    },
  ],
})
export class TeamModule {}
