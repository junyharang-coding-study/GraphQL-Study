query getRoleAndMembersAndEquipmentAndSoftware {
  getRoleAndMembersAndEquipmentAndSoftware(roleId: "developer") {
    statusCode,
    message,
    data {
      roleId,
      requirement,
      members {
        peopleId,
        lastName,
        serveYears,
      },
      equipments {
        equipmentId,
      },
      softwares {
        softwareId
      },
    },
  }
}