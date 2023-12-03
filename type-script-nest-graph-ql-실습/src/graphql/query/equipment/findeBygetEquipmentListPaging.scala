query findeBygetEquipmentListPaging {
  getEquipmentList(
    page: 1,
    size: 3
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