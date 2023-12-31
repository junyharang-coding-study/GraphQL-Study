query findBygetEquipmentListSeachAllFieldAndPaging {
  getEquipmentList(
    usedBy: "developer",
    newOrUsed: "used",
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
        equipmentId,
        usedBy,
        count,
        newOrUsed
      }
    }
  }
}