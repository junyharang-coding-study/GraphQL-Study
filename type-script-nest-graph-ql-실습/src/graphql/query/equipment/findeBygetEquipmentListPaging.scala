query findeBygetEquipmentListPaging {
  getEquipmentList(
    page: 1,
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
  }
}