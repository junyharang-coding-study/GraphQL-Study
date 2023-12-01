export class Page {
  perPageSize: number;
  totalCount: number;
  totalPage: number;

  constructor(pageSize: number, totalCount: number) {
    this.perPageSize = pageSize;
    this.totalCount = totalCount;
    this.totalPage = Math.ceil(totalCount / pageSize);
  }
}
