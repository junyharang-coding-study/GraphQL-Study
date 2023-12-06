import { SupplyEntity } from "../../entities/supply.entity";

export class SupplyResponseDto {
  private supplyId: string;
  private teamId: number;
  constructor(supply: SupplyEntity) {
    this.supplyId = supply.supplyId;
    this.teamId = supply.team.teamId;
  }
}
