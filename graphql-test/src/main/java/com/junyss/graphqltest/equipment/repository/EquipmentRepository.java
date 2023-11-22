package com.junyss.graphqltest.equipment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.junyss.graphqltest.equipment.model.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, String> {

	@Query(value = "select equipment from Equipment equipment where equipment.equipmentId = :equipmentId")
	Equipment findAllByStringId(String equipmentId);
}
