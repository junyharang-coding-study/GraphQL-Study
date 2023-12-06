import { IsInt, IsNotEmpty, IsNumber, IsString } from "class-validator";
import { Field, InputType } from "@nestjs/graphql";
import { Sex } from "../../../../../common/enum/people.sex.enum";
import { BloodType } from "../../../../../common/enum/people.blood-type.enum";
import { Role } from "../../../../../common/enum/people.role.enum";
import { PeopleEntity } from "../../entities/people.entity";
import { Logger } from "@nestjs/common";
import { TeamEntity } from "../../../../team/model/entities/team.entity";

@InputType()
export class PeopleUpdateRequestDto {
  @IsNotEmpty()
  @IsNumber()
  @Field(() => Number)
  peopleId: number;

  @IsNumber()
  @Field(() => Number)
  teamId: number;

  @IsString()
  @Field(() => String)
  lastName: string;

  @IsString()
  @Field(() => String)
  firstName: string;

  @Field(() => Sex)
  sex: Sex;

  @Field(() => BloodType)
  bloodType: BloodType;

  @IsNumber()
  @Field(() => Number)
  serveYears: number;

  @Field(() => Role)
  role: Role;

  @IsString()
  @Field(() => String)
  hometown: string;

  toEntity(peopleUpdateRequestDto: PeopleUpdateRequestDto): PeopleEntity {
    const people = new PeopleEntity();
    people.team = new TeamEntity(); // team을 초기화
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
