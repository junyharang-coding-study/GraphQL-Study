query findBygetTeamListSeachCleaningDutyAndPaging {
  getTeamList(
    cleaningDuty: "Wednesday",
    page: 1,
    size: 1
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}