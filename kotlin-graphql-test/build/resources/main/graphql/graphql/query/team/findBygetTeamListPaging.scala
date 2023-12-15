query findBygetTeamListPaging {
  getTeamList(
    teamSearchRequestDto: {
      manager: "Blake Smith",
      # office: "",
      # extensionNumber: "",
      # mascot: "",
      # cleaningDuty: "",
      # project: ""
    },
    pageRequestDto: {
      currentPage: 1,
      perPageSize: 10
      orderBy: true
    },
  ) {
    statusCode,
    message,
    data {
      teamId,
      manager,
      office,
      extensionNumber,
      mascot,
      cleaningDuty,
      project
    },
    pagination {
      perPageSize,
      totalElementCount,
      totalPage
    }
  }
}