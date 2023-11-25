query findBygetEquipmentListSeachUsedByAndPaging {
  getEquipmentList(
    usedBy: "developer",
    page: 1,
    size: 1
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}