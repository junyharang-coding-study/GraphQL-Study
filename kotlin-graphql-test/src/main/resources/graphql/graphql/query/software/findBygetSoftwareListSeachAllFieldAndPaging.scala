query findBygetSoftwareListSeachAllFieldAndPaging {
  getSoftwareList(
    usedBy: "developer",
    developedBy: "Eclipse Foundation",
    page: 1,
    size: 1
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}