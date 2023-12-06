import { Entity, JoinColumn, ManyToOne, PrimaryColumn, Unique } from "typeorm";
import { TeamEntity } from "../../../team/model/entities/team.entity";
import { Field, InputType, ObjectType } from "@nestjs/graphql";

@InputType()
@ObjectType()
@Entity("supply")
@Unique(["supplyId"])
export class SupplyEntity {
  @Field(() => String)
  @PrimaryColumn("varchar", { name: "supply_id", length: 255, nullable: false, comment: "ID" })
  supplyId: string;

  @Field(() => Number)
  @ManyToOne(() => TeamEntity, { onDelete: "CASCADE" })
  @JoinColumn({ name: "team_id" })
  team: Promise<TeamEntity>;
}
