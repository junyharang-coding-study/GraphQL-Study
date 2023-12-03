export abstract class PageRequestDto {
  pageNumber: number | 1;
  perPageSize: number | 10;

  getPageNumber(): number {
    return (this.pageNumber - 1) * this.perPageSize;
  }

  getPerPageSize(): number {
    return this.perPageSize;
  }
}
