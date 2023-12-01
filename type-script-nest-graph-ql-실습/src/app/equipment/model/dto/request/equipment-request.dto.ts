import { IsInt, IsNotEmpty, IsString, Min } from "class-validator";

export class EquipmentRequestDto {
  @IsNotEmpty()
  @IsString()
  equipmentId: string;

  @IsNotEmpty()
  @IsString()
  usedBy: string;

  @IsNotEmpty()
  @IsInt()
  @Min(1)
  count: number;

  @IsNotEmpty()
  @IsString()
  newOrUsed: string;
}
