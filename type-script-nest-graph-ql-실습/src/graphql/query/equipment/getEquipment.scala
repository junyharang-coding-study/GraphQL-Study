query getEquipment {
  getEquipment(
    equipmentId: "machanical keyboard"
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