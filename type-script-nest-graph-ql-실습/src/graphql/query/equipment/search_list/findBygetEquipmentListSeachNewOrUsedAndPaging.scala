query findBygetEquipmentListSeachUsedByAndPaging {
  getEquipmentList(
    newOrUsed: "used",
    pageNumber: 1,
    perPageSize: 10
  ) {
    statusCode,
    message,
    pagination {
      perPageSize,
      totalCount,
      totalPage
      data {
        equipmentId,
        usedBy,
        count,
        newOrUsed
      }
    }
    ,
  }
}