import { Field, InputType } from "@nestjs/graphql";
import { IsBoolean, IsInt, IsNotEmpty, Min } from "class-validator";

@InputType()
export abstract class PageRequestDto {
  @IsNotEmpty()
  @IsInt()
  @Min(1)
  @Field(() => Number)
  pageNumber: number;

  @IsNotEmpty()
  @IsInt()
  @Field(() => Number)
  perPageSize: number;

  @IsBoolean()
  @Field(() => Boolean)
  orderBy: boolean;

  getOffset(): number {
    return (this.pageNumber - 1) * this.perPageSize;
  }

  getLimit(): number {
    return this.perPageSize;
  }

  getOrderBy(): boolean {
    return this.orderBy;
  }
}
