export abstract class PageRequestDto {
  pageNumber: number | 1;
  perPageSize: number | 10;

  getOffset(): number {
    return (this.pageNumber - 1) * this.perPageSize;
  }

  getLimit(): number {
    return this.perPageSize;
  }
}
