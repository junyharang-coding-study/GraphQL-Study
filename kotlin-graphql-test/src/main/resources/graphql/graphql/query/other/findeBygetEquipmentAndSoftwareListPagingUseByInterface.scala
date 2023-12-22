query findeBygetEquipmentAndSoftwareListPagingUseByInterface {
  getEquipmentList (
    pageRequestDto: {
      currentPage: 1,
      perPageSize: 10
      orderBy: true
    },
    equipmentSearchRequestDto: {
      usedBy: "developer"
    }
  ) {
    statusCode,
    message,
    data {
      equipmentId,
      usedBy,
      count,
      newOrUsed
    },
    pagination {
      perPageSize,
      totalElementCount,
      totalPage
    }
  }

  getSoftwareList(
    softwareSearchRequestDto: {
      # usedBy: "developed",
      # developedBy: "",
      # description: ""
    },

    pageRequestDto: {
      currentPage: 1,
      perPageSize: 10,
      orderBy: true
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