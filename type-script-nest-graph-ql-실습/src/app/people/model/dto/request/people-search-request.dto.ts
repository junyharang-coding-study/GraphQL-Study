import { PageRequestDto } from "../../../../common/constant/page.request.dto";
import { Sex } from "../../../../../common/enum/people.sex.enum";
import { BloodType } from "../../../../../common/enum/people.blood-type.enum";
import { Role } from "../../../../../common/enum/people.role.enum";
import { InputType } from "@nestjs/graphql";

@InputType()
export class PeopleSearchRequestDto extends PageRequestDto {
  teamId: number | null;
  lastName: string | null;
  firstName: string | null;
  sex: Sex | null;
  bloodType: BloodType | null;
  serveYears: number | null;
  role: Role | null;
  hometown: string | null;

  constructor() {
    super();
  }
}
