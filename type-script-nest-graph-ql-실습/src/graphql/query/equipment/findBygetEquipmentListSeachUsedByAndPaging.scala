query findBygetEquipmentListSeachUsedByAndPaging {
  getEquipmentList(
    usedBy: "developer",
    page: 1,
    size: 1
  ) {
    statusCode,
    message,
    pagination {
      perPageSize,
      totalCount,
      totalPage
    },
    data {
      equipmentId,
      usedBy,
      count,
      newOrUsed
    }
  }
}