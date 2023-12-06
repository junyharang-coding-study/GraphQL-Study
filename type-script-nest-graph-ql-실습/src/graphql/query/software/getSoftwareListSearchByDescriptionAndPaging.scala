query getSoftwareListSearchByDescriptionAndPaging {
  getSoftwareList(
  # usedBy: "developer",
  # developedBy: "Eclipse Foundation",
  description: "integrated development environment",
  pageNumber: 1,
  perPageSize: 5,
  orderBy: true
  ) {
    statusCode,
    message,
    pagination {
      perPageSize,
      totalCount,
      totalPage,
      data {
        softwareId,
        usedBy,
        developedBy,
        description
      }
    }
  }
}