import { TeamEntity } from "../../entities/team.entity";

export class TeamResponseDto {
  private teamId: number;
  private manager: string;
  private office: string;
  private extensionNumber: string;
  private mascot: string;
  private cleaningDuty: string;
  private project: string;

  constructor(entity: TeamEntity) {
    this.teamId = entity.teamId;
    this.manager = entity.manager;
    this.office = entity.office;
    this.extensionNumber = entity.extensionNumber;
    this.mascot = entity.mascot;
    this.cleaningDuty = entity.cleaningDuty;
    this.project = entity.project;
  }
}