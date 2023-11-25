mutation saveForSupply {
  saveForSupply(input: {
    supplyId: "Labtop",
    teamId: 1
  }) {
    statusCode,
    message,
    data
  }
}