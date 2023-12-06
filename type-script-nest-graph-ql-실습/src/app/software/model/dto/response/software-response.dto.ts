import { SoftwareEntity } from "../../entities/software.entity";

export class SoftwareResponseDto {
  private softwareId: string;
  private usedBy: string;
  private developedBy: string;
  private description: string;

  constructor(entity: SoftwareEntity) {
    this.softwareId = entity.softwareId;
    this.usedBy = entity.usedBy;
    this.developedBy = entity.developedBy;
    this.description = entity.description;
  }
}
