query getEquipmentsAndSupplies {
  getEquipmentList(
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
        newOrUsed
      }
    }
  }

  getSupplyList(
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
        supplyId,
        teamId,
      }
    }
  }
}