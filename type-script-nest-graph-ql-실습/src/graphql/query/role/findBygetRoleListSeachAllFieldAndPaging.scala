query findBygetRoleListSeachAllFieldAndPaging {
  getRoleList(roleSearchRequestDto: {
    job: "programming",
    requirement: "computer science degree",
    pageNumber: 1,
    perPageSize: 1,
    orderBy: true
  }) {
    statusCode,
    message,
    pagination {
      perPageSize,
      totalCount,
      totalPage,
      data {
        roleId,
        job,
        requirement
      }
    }
  }
}