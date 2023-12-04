export abstract class PageRequestDto {
  pageNumber: number | 1;
  perPageSize: number | 10;
  orderBy: boolean | true;

  getPageNumber(): number {
    return this.pageNumber;
  }

  getPerPageSize(): number {
    return this.perPageSize;
  }

  getOrderBy(): boolean {
    return this.orderBy;
  }
}
