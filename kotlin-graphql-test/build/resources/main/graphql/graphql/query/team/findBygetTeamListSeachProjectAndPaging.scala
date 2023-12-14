query findBygetTeamListSeachProjectAndPaging {
  getTeamList(
    project: "Genghis"
      page: 1,
  size: 1
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}