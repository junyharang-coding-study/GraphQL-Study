mutation saveForSoftware {
  saveForSoftware(input: {
    softwareId: "InteilJ",
    usedBy: "developer",
    developedBy: "Jet Brain",
    description: "Integrated Development Environment(IDE)"
  }) {
    statusCode,
    message,
    data
  }
}