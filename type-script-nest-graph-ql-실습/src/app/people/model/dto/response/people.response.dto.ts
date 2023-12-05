import { Sex } from "../../../../../common/enum/people.sex.enum";
import { BloodType } from "../../../../../common/enum/people.blood-type.enum";
import { Role } from "../../../../../common/enum/people.role.enum";
import { PeopleEntity } from "../../entities/people.entity";

export class PeopleResponseDto {
  private peopleId: number;
  private teamId: number;
  private lastName: string;
  private firstName: string;
  private sex: Sex;
  private bloodType: BloodType;
  private serveYears: number;
  private role: Role;
  private hometown: string;

  constructor(peopleEntity: PeopleEntity) {
    this.peopleId = peopleEntity.peopleId;
    this.teamId = peopleEntity.team.teamId;
    this.lastName = peopleEntity.lastName;
    this.firstName = peopleEntity.firstName;
    this.sex = peopleEntity.sex;
    this.bloodType = peopleEntity.bloodType;
    this.serveYears = peopleEntity.serveYears;
    this.role = peopleEntity.role;
    this.hometown = peopleEntity.hometown;
  }
}
