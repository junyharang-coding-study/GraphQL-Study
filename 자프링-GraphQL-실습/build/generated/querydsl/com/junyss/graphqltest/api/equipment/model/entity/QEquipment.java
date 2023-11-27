package com.junyss.graphqltest.api.equipment.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEquipment is a Querydsl query type for Equipment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEquipment extends EntityPathBase<Equipment> {

    private static final long serialVersionUID = -866528934L;

    public static final QEquipment equipment = new QEquipment("equipment");

    public final NumberPath<Integer> count = createNumber("count", Integer.class);

    public final StringPath equipmentId = createString("equipmentId");

    public final StringPath newOrUsed = createString("newOrUsed");

    public final StringPath usedBy = createString("usedBy");

    public QEquipment(String variable) {
        super(Equipment.class, forVariable(variable));
    }

    public QEquipment(Path<? extends Equipment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEquipment(PathMetadata metadata) {
        super(Equipment.class, metadata);
    }

}

