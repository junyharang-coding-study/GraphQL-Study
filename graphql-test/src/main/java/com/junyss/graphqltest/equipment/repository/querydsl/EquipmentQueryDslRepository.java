package com.junyss.graphqltest.equipment.repository.querydsl;

import static com.junyss.graphqltest.equipment.model.entity.QEquipment.equipment;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.junyss.graphqltest.equipment.model.dto.request.EquipmentSearchRequestDto;
import com.junyss.graphqltest.equipment.model.entity.Equipment;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class EquipmentQueryDslRepository {

	private final JPAQueryFactory jpaQueryFactory;
	private final EntityManager entityManager;

	public List<Equipment> findBySearchAndPaging(EquipmentSearchRequestDto equipmentSearchRequestDto, Pageable pageable) {
		return jpaQueryFactory.select(equipment)
		.from(equipment)
		.where(equipment.equipmentId.eq(equipmentSearchRequestDto.getEquipmentId()),
			eqUsedBy(equipmentSearchRequestDto.getUsedBy()),
			eqNewOrUsed(equipmentSearchRequestDto.getNewOrUsed()))
		.offset(pageable.getOffset())
		.limit(pageable.getPageSize())
		.fetch();
	}

	private BooleanExpression eqUsedBy(String usedBy) {
		if (!StringUtils.hasText(usedBy)) {
			return null;
		}
		return equipment.usedBy.eq(usedBy);
	}

	private BooleanExpression eqNewOrUsed(String newOrUsed) {
		if (!StringUtils.hasText(newOrUsed)) {
			return null;
		}
		return equipment.newOrUsed.eq(newOrUsed);
	}
}
