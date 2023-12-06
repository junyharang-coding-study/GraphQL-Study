mutation updateSupply {
  updateSupply(input: {
    supplyId: "magic trackpad",
    teamId: 4,
  }) {
    statusCode,
    message,
    data
  }
}