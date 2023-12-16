query findBygetSoftwareListSeachAndPaging {
  getSoftwareList(
    softwareSearchRequestDto: {
      usedBy: "developed",
      # developedBy: "",
      # description: ""
    },

    pageRequestDto: {
      currentPage: 1,
      perPageSize: 0,
      # orderBy: true
    }
  ) {
    statusCode,
    message,
    data {
      usedBy,
      developedBy,
      description
    },
    pagination {
      perPageSize,
      totalElementCount,
      totalPage,
      orderBy
    }
  }
}