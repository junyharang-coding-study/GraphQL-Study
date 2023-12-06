import { Field, InputType } from "@nestjs/graphql";
import { IsInt, IsNotEmpty, IsString, Min } from "class-validator";
import { TeamEntity } from "../../../../team/model/entities/team.entity";
import { SupplyEntity } from "../../entities/supply.entity";

@InputType()
export class SupplyRequestDto {
  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  supplyId: string;

  @IsNotEmpty()
  @IsInt()
  @Min(1)
  @Field(() => Number)
  teamId: number;

  toEntity(supplyRequestDto: SupplyRequestDto): SupplyEntity {
    const supply = new SupplyEntity();
    supply.supplyId = supplyRequestDto.supplyId;
    supply.team = new TeamEntity();
    supply.team.teamId = supplyRequestDto.teamId;
    return supply;
  }
}
