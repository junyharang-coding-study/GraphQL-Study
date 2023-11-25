query findBygetSoftwareListSeachDevelopedByAndPaging {
  getSoftwareList(
    developedBy: "Eclipse Foundation",
    page: 1,
    size: 2
  ) {
    statusCode,
    message,
    data,
    pagination
  }
}