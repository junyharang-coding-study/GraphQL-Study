import { Field, InputType } from "@nestjs/graphql";

@InputType()
export abstract class PageRequestDto {
  @Field(() => Number)
  pageNumber?: number;

  @Field(() => Number)
  perPageSize?: number;

  @Field(() => Boolean)
  orderBy?: boolean;

  getOffset(): number {
    return (this.pageNumber - 1) * this.perPageSize;
  }

  getLimit(): number {
    return this.perPageSize;
  }
}
