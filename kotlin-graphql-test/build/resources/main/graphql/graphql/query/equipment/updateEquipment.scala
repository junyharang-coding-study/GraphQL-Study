mutation updateEquipment {
  updateEquipment(input: {
    equipmentId: "MacBook",
    usedBy: "developer",
    count: 150
    newOrUsed: "new"
  }) {
    statusCode,
    message,
    data
  }
}