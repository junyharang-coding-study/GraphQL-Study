import { IsInt, IsNotEmpty, IsString, Min } from "class-validator";
import { Field, InputType } from "@nestjs/graphql";
import { EquipmentEntity } from "../../entities/equipment.entity";
import { Logger } from "@nestjs/common";

@InputType()
export class EquipmentRequestDto {
  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  equipmentId: string;

  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  usedBy: string;

  @IsNotEmpty()
  @IsInt()
  @Min(1)
  @Field(() => Number)
  count: number;

  @IsNotEmpty()
  @IsString()
  @Field(() => String)
  newOrUsed: string;

  static toEntity(equipmentRequestDto: EquipmentRequestDto): EquipmentEntity {
    const equipment = new EquipmentEntity();
    equipment.equipmentId = equipmentRequestDto.equipmentId;
    equipment.usedBy = equipmentRequestDto.usedBy;
    equipment.count = equipmentRequestDto.count;
    equipment.newOrUsed = equipmentRequestDto.newOrUsed;

    console.log(
      `EquipmentRequestDto.toEntity() equipmentId: ${equipment.equipmentId}, usedBy: ${equipment.usedBy}, count: ${equipment.count}, newOrUsed: ${equipment.newOrUsed}`,
    );

    return equipment;
  }
}
