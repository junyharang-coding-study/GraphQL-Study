mutation saveSupply {
  saveSupply(input: {
    supplyId: "magic trackpad",
    teamId: 5,
  }) {
    statusCode,
    message,
    data
  }
}