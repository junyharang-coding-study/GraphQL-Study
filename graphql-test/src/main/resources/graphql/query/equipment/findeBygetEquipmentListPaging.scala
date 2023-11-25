query findeBygetEquipmentListPaging {
  getEquipmentList(
    page: 1,
    size: 3
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}