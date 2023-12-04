export class Page<T> {
  perPageSize: number;
  totalCount: number;
  totalPage: number;
  data: T[];

  constructor(perPageSize: number, totalCount: number, results: T[]) {
    this.perPageSize = perPageSize;
    this.totalCount = totalCount;

    const tempTotalPage = Math.ceil(totalCount / perPageSize);

    if (tempTotalPage >= 1) {
      this.totalPage = tempTotalPage;
    } else {
      this.totalPage = 1;
    }

    this.data = results;
  }

  toString(): string {
    return `Page(perPageSize: ${this.perPageSize}, totalCount: ${this.totalCount}, totalPage: ${this.totalPage}, data: ${JSON.stringify(
      this.data,
      null,
      2,
    )})`;
  }
}
