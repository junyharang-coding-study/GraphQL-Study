query findBygetSoftwareListSeachUsedByAndPaging {
  getSoftwareList(
    usedBy: "developer",
    page: 1,
    size: 2
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}