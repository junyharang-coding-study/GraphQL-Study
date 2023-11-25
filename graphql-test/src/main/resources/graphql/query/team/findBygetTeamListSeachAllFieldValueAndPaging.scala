query findBygetTeamListSeachAllFieldValueAndPaging {
  getTeamList(
    manager: "Stewart Grant",
    office: "101B",
    extensionNumber: "#4012",
    mascot: "Tadpole",
    cleaningDuty: "Tuesday",
    project: "Zen",
    page: 1,
    size: 1
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}