mutation updateEquipment {
  updateEquipment(
    equipmentId: "MacBook",
    input: {
    usedBy: "developer",
    count: 150
    newOrUsed: "new"
  }) {
    statusCode,
    message,
    data
  }
}