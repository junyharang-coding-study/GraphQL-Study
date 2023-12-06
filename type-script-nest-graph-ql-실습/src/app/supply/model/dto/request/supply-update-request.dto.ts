import { Field, InputType } from "@nestjs/graphql";
import { IsNotEmpty, IsNumber, IsString } from "class-validator";
import { TeamEntity } from "../../../../team/model/entities/team.entity";
import { SupplyEntity } from "../../entities/supply.entity";

@InputType()
export class SupplyUpdateRequestDto {
  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  supplyId: string;

  @IsNumber()
  @Field(() => Number)
  teamId: number;

  toEntity(supplyUpdateRequestDto: SupplyUpdateRequestDto): SupplyEntity {
    const supply = new SupplyEntity();
    supply.supplyId = supplyUpdateRequestDto.supplyId;

    supply.team = new TeamEntity(); // team을 초기화
    supply.team.teamId = supplyUpdateRequestDto.teamId;
    return supply;
  }
}
