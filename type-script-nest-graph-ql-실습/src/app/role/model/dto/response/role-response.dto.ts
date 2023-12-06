import { RoleEntity } from "../../entities/role.entity";

export class RoleResponseDto {
  private roleId: string;
  private job: string;
  private requirement: string;

  constructor(entity: RoleEntity) {
    this.roleId = entity.roleId;
    this.job = entity.job;
    this.requirement = entity.requirement;
  }
}