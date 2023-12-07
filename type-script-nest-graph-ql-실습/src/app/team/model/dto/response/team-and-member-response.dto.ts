import { PeopleResponseDto } from "../../../../people/model/dto/response/people.response.dto";
import { TeamEntity } from "../../entities/team.entity";

export class TeamAndMemberResponseDto {
  private teamId: number;
  private manager: string;
  private office: string;
  private extensionNumber: string;
  private mascot: string;
  private cleaningDuty: string;
  private project: string;
  private members: PeopleResponseDto[];

  constructor(entity: TeamEntity, peopleResponseDto: PeopleResponseDto[]) {
    this.teamId = entity.teamId;
    this.manager = entity.manager;
    this.office = entity.office;
    this.extensionNumber = entity.extensionNumber;
    this.mascot = entity.mascot;
    this.cleaningDuty = entity.cleaningDuty;
    this.project = entity.project;
    this.members = peopleResponseDto || [];
  }
}
