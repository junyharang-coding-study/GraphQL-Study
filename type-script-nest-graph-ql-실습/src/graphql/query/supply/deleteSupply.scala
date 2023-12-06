mutation deleteSupply {
  deleteSupply(supplyId: "magic trackpad") {
    statusCode,
    message,
    data
  }
}