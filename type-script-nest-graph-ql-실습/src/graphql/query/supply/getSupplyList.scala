query getSupplyList {
  getSupplyList(
    teamId: 3,
    pageNumber: 1,
    perPageSize: 10,
    orderBy: true
  ) {
    statusCode,
    message,
    pagination {
      perPageSize,
      totalCount,
      totalPage,
      data {
        supplyId,
        teamId,
      }
    }
  }
}