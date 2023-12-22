query getEquipmentsAdv {
  getEquipmentsAdv(
    equipmentSearchRequestDto: {
      # usedBy: "developer"
    },
    pageRequestDto: {
      # currentPage: 1,
      # perPageSize: 10
      # orderBy: true
    },
  ){
    statusCode,
    message,
    data {
      equipmentId,
      usedBy,
      count,
      useRate,
      isNew
    },
    pagination {
      perPageSize,
      totalElementCount,
      totalPage,
      orderBy
    }
  }
}