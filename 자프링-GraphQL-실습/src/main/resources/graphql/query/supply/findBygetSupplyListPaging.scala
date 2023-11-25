query findBygetSupplyListPaging {
  getSupplyList(
    page: 1,
    size: 5
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}