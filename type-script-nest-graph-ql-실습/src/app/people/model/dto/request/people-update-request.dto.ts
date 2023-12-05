import { IsInt, IsNotEmpty, IsString } from "class-validator";
import { Field, InputType } from "@nestjs/graphql";
import { Sex } from "../../../../../common/enum/people.sex.enum";
import { BloodType } from "../../../../../common/enum/people.blood-type.enum";
import { Role } from "../../../../../common/enum/people.role.enum";
import { PeopleEntity } from "../../entities/people.entity";
import { TeamEntity } from "../../../../team/model/entities/team.entity";

@InputType()
export class PeopleUpdateRequestDto {
  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  peopleId: number;

  @IsString()
  @Field(() => String)
  teamId: number;

  @IsInt()
  @Field(() => String)
  lastName: string;

  @IsString()
  @Field(() => String)
  firstName: string;

  @IsString()
  @Field(() => Sex)
  sex: Sex;

  @IsString()
  @Field(() => BloodType)
  bloodType: BloodType;

  @IsString()
  @Field(() => Number)
  serveYears: number;

  @IsString()
  @Field(() => Role)
  role: Role;

  @IsString()
  @Field(() => String)
  hometown: string;

  toEntity(peopleUpdateRequestDto: PeopleUpdateRequestDto): PeopleEntity {
    const people = new PeopleEntity();
    people.team.teamId = peopleUpdateRequestDto.teamId;
    people.lastName = peopleUpdateRequestDto.lastName;
    people.firstName = peopleUpdateRequestDto.firstName;
    people.sex = peopleUpdateRequestDto.sex;
    people.bloodType = peopleUpdateRequestDto.bloodType;
    people.serveYears = peopleUpdateRequestDto.serveYears;
    people.role = peopleUpdateRequestDto.role;
    people.hometown = peopleUpdateRequestDto.hometown;

    return people;
  }
}
