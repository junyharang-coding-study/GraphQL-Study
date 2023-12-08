import { EquipmentEntity } from "../../../../equipment/model/entities/equipment.entity";
import { PeopleEntity } from "../../../../people/model/entities/people.entity";
import { SoftwareEntity } from "../../../../software/model/entities/software.entity";
import { RoleEntity } from "../../entities/role.entity";

export class RoleAndMebmersAndSoftwaresResponseDto {
  private roleId: string;
  private requirement: string;
  private members: PeopleEntity[];
  private equipments: EquipmentEntity[];
  private softwares: SoftwareEntity[];

  constructor(members: PeopleEntity[], role: RoleEntity, equipments: EquipmentEntity[], softwareArray: SoftwareEntity[]) {
    this.roleId = role.roleId;
    this.requirement = role.requirement;
    this.members = members;
    this.equipments = equipments;
    this.softwares = softwareArray;
  }
}
