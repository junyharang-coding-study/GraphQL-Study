query getEquipment {
  getEquipment(equipmentId: "sketchb") {
    statusCode,
    message,
    data {
      equipmentId,
      usedBy,
      count,
      newOrUsed
    }
  }
}