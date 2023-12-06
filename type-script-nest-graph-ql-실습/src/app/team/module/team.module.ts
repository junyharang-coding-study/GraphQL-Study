import { Module } from "@nestjs/common";
import { TypeOrmModule } from "@nestjs/typeorm";
import { TeamQueryBuilderRepository } from "../repository/team-query-builder.repository";
import { TeamImplService } from "../service/team-impl.service";
import { TeamResolver } from "../resolver/team.resolver";
import { TeamEntity } from "../model/entities/team.entity";

@Module({
  imports: [TypeOrmModule.forFeature([TeamEntity])],
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
  ],
})
export class TeamModule {}
