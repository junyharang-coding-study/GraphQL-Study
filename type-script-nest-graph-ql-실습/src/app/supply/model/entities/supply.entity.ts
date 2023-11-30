import { Entity, JoinColumn, ManyToOne, PrimaryColumn, Unique } from "typeorm";
import { TeamEntity } from "../../../team/model/entities/team.entity";

@Entity("supply")
@Unique(["supplyId"])
export class SupplyEntity {
  @PrimaryColumn("varchar", { name: "supply_id", length: 255, nullable: false, comment: "ID" })
  supplyId!: string;

  @ManyToOne(() => TeamEntity)
  @JoinColumn({ name: "team_id" })
  team!: Promise<TeamEntity>;
}
