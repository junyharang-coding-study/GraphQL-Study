query getSoftwareBySoftwareId {
  getSoftwareBySoftwareId(softwareId: "Eclipse") {
    statusCode,
    message,
    data {
      softwareId,
      usedBy,
      developedBy,
      description
    }
  }
}