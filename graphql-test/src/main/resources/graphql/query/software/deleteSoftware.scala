mutation deleteSoftware {
  deleteSoftware(softwareId: "Eclipse") {
    statusCode,
    message,
    data
  }
}