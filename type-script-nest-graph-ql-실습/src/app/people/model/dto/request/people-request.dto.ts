import { Field, InputType } from "@nestjs/graphql";
import { IsNotEmpty, IsNumber, IsString, Min } from "class-validator";
import { Sex } from "../../../../../common/enum/people.sex.enum";
import { BloodType } from "../../../../../common/enum/people.blood-type.enum";
import { Role } from "../../../../../common/enum/people.role.enum";
import { PeopleEntity } from "../../entities/people.entity";
import { TeamEntity } from "../../../../team/model/entities/team.entity";

@InputType()
export class PeopleRequestDto {
  @IsNotEmpty()
  @IsNumber()
  @Min(1)
  @Field(() => Number)
  teamId: number;

  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  lastName: string;

  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  firstName: string;

  @IsNotEmpty()
  @Field(() => Sex)
  sex: Sex;

  @IsNotEmpty()
  @Field(() => BloodType)
  bloodType: BloodType;

  @IsNotEmpty()
  @IsNumber()
  @Field(() => Number)
  serveYears: number;

  @Field(() => Role)
  role: Role;

  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  hometown: string;

  toEntity(peopleRequestDto: PeopleRequestDto): PeopleEntity {
    const people = new PeopleEntity();
    people.team = new TeamEntity();
    people.team.teamId = peopleRequestDto.teamId;
    people.lastName = peopleRequestDto.lastName;
    people.firstName = peopleRequestDto.firstName;
    people.sex = peopleRequestDto.sex;
    people.bloodType = peopleRequestDto.bloodType;
    people.serveYears = peopleRequestDto.serveYears;
    people.role = peopleRequestDto.role;
    people.hometown = peopleRequestDto.hometown;

    return people;
  }
}
