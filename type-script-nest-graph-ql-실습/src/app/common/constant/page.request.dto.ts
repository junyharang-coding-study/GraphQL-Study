export abstract class PageRequestDto {
  pageNumber: number;
  perPageSize: number;
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
