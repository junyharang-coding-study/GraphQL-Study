query getSupplyListPaging {
  getSupplyList(
  # teamId: 2,
  pageRequestDto: {
    # currentPage: 1,
    # perPageSize: 5,
    # orderBy: true
  }) {
    statusCode,
    message,
    data {
      supplyId,
      teamId
    },
    pagination {
      perPageSize,
      totalElementCount,
      totalPage,
      orderBy
    }
  }
}