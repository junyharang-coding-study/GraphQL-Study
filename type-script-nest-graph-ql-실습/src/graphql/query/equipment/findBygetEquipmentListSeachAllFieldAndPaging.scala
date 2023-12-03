query findBygetEquipmentListSeachAllFieldAndPaging {
  getEquipmentList(
    usedBy: "developer",
    newOrUsed: "used",
    page: 1,
    perPageSize: 3
  )
  {
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