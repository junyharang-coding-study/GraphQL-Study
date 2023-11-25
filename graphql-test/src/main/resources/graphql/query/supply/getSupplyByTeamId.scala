query getSupplyByTeamId {
  getSupplyByTeamId(
    teamId: 1,
    page: 1,
    size: 1
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}