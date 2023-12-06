query getSoftwareListSearchByAllAndDesc {
  getTeamList(
  # manager: "Stewart Grant",
  # office: "103B",
  # extensionNumber: "#5709",
  # mascot: "Falcon",
  # cleaningDuty: "Monday",
  # project: "Genghis",
  pageNumber: 1,
  perPageSize: 10,
  orderBy: true
  ) {
    statusCode,
    message,
    pagination {
      perPageSize,
      totalCount,
      totalPage,
      data {
        teamId,
        manager,
        office,
        extensionNumber,
        mascot,
        cleaningDuty,
        project,
      }
    }
  }
}