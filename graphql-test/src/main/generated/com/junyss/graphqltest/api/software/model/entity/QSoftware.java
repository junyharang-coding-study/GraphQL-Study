package com.junyss.graphqltest.api.software.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSoftware is a Querydsl query type for Software
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSoftware extends EntityPathBase<Software> {

    private static final long serialVersionUID = 1181835736L;

    public static final QSoftware software = new QSoftware("software");

    public final StringPath description = createString("description");

    public final StringPath developedBy = createString("developedBy");

    public final StringPath softwareId = createString("softwareId");

    public final StringPath usedBy = createString("usedBy");

    public QSoftware(String variable) {
        super(Software.class, forVariable(variable));
    }

    public QSoftware(Path<? extends Software> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSoftware(PathMetadata metadata) {
        super(Software.class, metadata);
    }

}

