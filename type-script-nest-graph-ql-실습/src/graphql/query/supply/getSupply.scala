query getSupply {
  getSupply(supplyId: "ergonomic mouse") {
    statusCode,
    message,
    data {
      supplyId,
      teamId,
    }
  }
}