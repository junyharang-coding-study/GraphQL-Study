mutation saveForEquipment {
  saveForEquipment(input: {
    equipmentId: "MacBook",
    usedBy: "developer",
    count: 100,
    newOrUsed: "new"
  }) {
    statusCode,
    message,
    data
  }
}