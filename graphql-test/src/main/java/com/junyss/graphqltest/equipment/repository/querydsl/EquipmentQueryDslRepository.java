package com.junyss.graphqltest.equipment.repository.querydsl;

import static com.junyss.graphqltest.equipment.model.entity.QEquipment.equipment;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.junyss.graphqltest.equipment.model.dto.request.EquipmentSearchRequestDto;
import com.junyss.graphqltest.equipment.model.dto.response.EquipmentResponseDto;
import com.junyss.graphqltest.equipment.model.entity.Equipment;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class EquipmentQueryDslRepository {

	private final JPAQueryFactory jpaQueryFactory;

	public Page<EquipmentResponseDto> findBySearchAndPaging(EquipmentSearchRequestDto equipmentSearchRequestDto, Pageable pageable) {
		JPAQuery<EquipmentResponseDto> query = jpaQueryFactory
			.select(Projections.constructor(
				EquipmentResponseDto.class,
				equipment.equipmentId,
				equipment.usedBy,
				equipment.count,
				equipment.newOrUsed))
			.from(equipment)
			.where(
				eqEquipmentId(equipmentSearchRequestDto.getEquipmentId()),
				eqUsedBy(equipmentSearchRequestDto.getUsedBy()),
				eqNewOrUsed(equipmentSearchRequestDto.getNewOrUsed())
			)
			.orderBy(equipment.equipmentId.desc());

		List<EquipmentResponseDto> result = query.offset(pageable.getOffset())
			.limit(pageable.getPageSize())
			.fetch();

		long totalCount = query.fetchCount();

		return new PageImpl<>(result, pageable, totalCount);

		// List<EquipmentResponseDto> result = jpaQueryFactory.select(Projections.constructor(EquipmentResponseDto.class))
		// 	.from(equipment)
		// 	.where(eqEquipmentId(equipmentSearchRequestDto.getEquipmentId()),
		// 			eqUsedBy(equipmentSearchRequestDto.getUsedBy()),
		// 			eqNewOrUsed(equipmentSearchRequestDto.getNewOrUsed()))
		// 	.fetch();
		//
		// if (result.size() >= 2) {
		// 	return new PageImpl<>(
		// 		jpaQueryFactory.select(Projections.constructor(EquipmentResponseDto.class))
		// 					   .from(equipment)
		// 			           .where(
		// 						   eqEquipmentId(equipmentSearchRequestDto.getEquipmentId()),
		// 						   eqUsedBy(equipmentSearchRequestDto.getUsedBy()),
		// 						   eqNewOrUsed(equipmentSearchRequestDto.getNewOrUsed()))
		// 						.orderBy(equipment.equipmentId.desc())
		// 						.offset(pageable.getOffset())
		// 						.limit(pageable.getPageSize())
		// 						.fetch(),
		// 		pageable,
		// 		result.size());
		// } else {
		// 	return new PageImpl<>(result, pageable, result.size());
		// }
	}

	private Predicate eqEquipmentId(String equipmentId) {
		if (!StringUtils.hasText(equipmentId)) {
			return null;
		}
		return equipment.equipmentId.eq(equipmentId);
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
