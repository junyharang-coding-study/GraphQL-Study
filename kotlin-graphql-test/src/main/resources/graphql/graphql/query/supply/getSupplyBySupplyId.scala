query getSupplyBySupplyId {
  getSupplyBySupplyId(
    supplyId: "calculator",
  ) {
    statusCode,
    message,
    data {
      supplyId,
      teamId
    },
  }
}