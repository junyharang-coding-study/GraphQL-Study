query getSoftware {
  getSoftware(softwareId: "Eclipse") {
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