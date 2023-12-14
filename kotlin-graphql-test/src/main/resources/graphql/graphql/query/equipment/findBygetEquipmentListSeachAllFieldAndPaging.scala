query findBygetEquipmentListSeachAllFieldAndPaging {
  getEquipmentList(
    equipmentId: "machanical keyboard",
    usedBy: "developer",
    newOrUsed: "used"
      page: 1,
  size: 3
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}