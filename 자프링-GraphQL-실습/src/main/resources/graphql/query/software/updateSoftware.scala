mutation updateSoftware {
  updateSoftware(input: {
    softwareId: "InteilJ",
    usedBy: "developer",
    developedBy: "Jet Brain",
    description: "주니가 좋아하는 Integrated Development Environment(IDE)"
  }) {
    statusCode,
    message,
    data
  }
}