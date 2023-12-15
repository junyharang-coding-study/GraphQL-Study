query findeBygetEquipmentListPagingAndSearch {
  getEquipmentList (
    pageRequestDto: {
      currentPage: 1,
      perPageSize: 10
      orderBy: true
    },
    equipmentSearchRequestDto: {
      usedBy: "developer"
    }
  ) {
    statusCode,
    message,
    data {
      equipmentId,
      usedBy,
      count,
      newOrUsed
    },
    pagination {
      perPageSize,
      totalElementCount,
      totalPage
    }
  }
}