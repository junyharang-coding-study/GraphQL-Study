query findBygetPeopleListSeachlastName {
  getPeopleList(peopleSearchRequestDto: {
    # teamId: 1,
    lastName: "Nathan",
    # firstName: "",
    # sex: male,
    # bloodType: B,
    # serveYears: 1,
    # role: developer,
    # hometown: "",
    # page: 1,
    # perPageSize: 5,
    # orderBy: true,
  }) {
    statusCode,
    message,
    pagination {
      perPageSize,
      totalCount,
      totalPage,
      data {
        peopleId,
        teamId,
        lastName,
        firstName,
        sex,
        bloodType,
        serveYears,
        role,
        hometown
      }
    }
  }
}