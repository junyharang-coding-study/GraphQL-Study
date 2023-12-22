query findeBygetEquipmentAndSoftwareListPagingUseByInterface {
  getEquipmentList(
    page: 1,
    size: 3
  ) {
    statusCode,
    message,
    data {
      equipmentId,
      usedBy,
      count,
      newOrUsed
    },
    pagination
  }

  getSoftwareList(
    page: 1,
    size: 5
  ) {
    statusCode,
    message,
    data {
      softwareId,
      usedBy,
      developedBy,
      description
    },
    pagination
  }
}