query findBygetPeopleListSeachAndPaging {
  getPeopleList(
    peopleSearchRequestDto: {
      # lastName: "",
      # firstName: "",
      # sex: "",
      # bloodType: "",
      # serveYears: "",
      # role: "",
      hometown: "California",
    },
    pageRequestDto: {
      currentPage: 1,
      perPageSize: 10,
      orderBy: true
    }) {
    statusCode,
    message,
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
    },
    pagination {
      perPageSize,
      totalElementCount,
      totalPage,
      orderBy
    }
  }
}