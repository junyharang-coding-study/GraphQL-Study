package com.junyss.graphqltest.api.equipment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.junyss.graphqltest.api.equipment.model.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, String> {

	@Query(value = "select equipment from Equipment equipment where equipment.equipmentId = :equipmentId")
	Optional<Equipment> findByEquipmentId(String equipmentId);
}
