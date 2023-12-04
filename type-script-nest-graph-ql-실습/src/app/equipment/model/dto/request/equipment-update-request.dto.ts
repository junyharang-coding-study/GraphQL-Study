import { IsInt, IsNotEmpty, IsString } from "class-validator";
import { Field, InputType } from "@nestjs/graphql";
import { EquipmentEntity } from "../../entities/equipment.entity";

@InputType()
export class EquipmentUpdateRequestDto {
  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  equipmentId: string;

  @IsString()
  @Field(() => String)
  usedBy: string;

  @IsInt()
  @Field(() => Number)
  count: number;

  @IsString()
  @Field(() => String)
  newOrUsed: string;

  toEntity(equipmentUpdateRequestDto: EquipmentUpdateRequestDto): EquipmentEntity {
    const equipment = new EquipmentEntity();
    equipment.usedBy = equipmentUpdateRequestDto.usedBy;
    equipment.count = equipmentUpdateRequestDto.count;
    equipment.newOrUsed = equipmentUpdateRequestDto.newOrUsed;
    return equipment;
  }
}
