mutation saveSupply {
  saveSupply(input: {
    supplyId: "Labtop",
    teamId: 1
  }) {
    statusCode,
    message,
    data
  }
}