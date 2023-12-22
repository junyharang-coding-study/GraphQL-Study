query getEquipmentsAndSupplies {
  getEquipmentList(
    pageRequestDto: {
      currentPage: 1,
      perPageSize: 10
      orderBy: true
    },
  ){
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

  getSupplyList(
  # teamId: 2,
  pageRequestDto: {
    currentPage: 1,
    perPageSize: 10,
    orderBy: true
  }) {
    statusCode,
    message,
    data {
      supplyId,
      teamId
    },
    pagination {
      perPageSize,
      totalElementCount,
      totalPage,
      orderBy
    }
  }
}