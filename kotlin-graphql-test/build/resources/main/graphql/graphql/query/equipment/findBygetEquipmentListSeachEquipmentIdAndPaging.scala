query findBygetEquipmentListSeachEquipmentIdAndPaging {
  getEquipmentList(
    equipmentId: "machanical keyboard",
    page: 1,
    size: 3
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}