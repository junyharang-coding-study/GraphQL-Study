package com.junyharangstudy.kotlingraphqltest.api.supply.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSupply is a Querydsl query type for Supply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSupply extends EntityPathBase<Supply> {

    private static final long serialVersionUID = -795741721L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSupply supply = new QSupply("supply");

    public final StringPath supplyId = createString("supplyId");

    public final com.junyharangstudy.kotlingraphqltest.api.team.model.entity.QTeam team;

    public QSupply(String variable) {
        this(Supply.class, forVariable(variable), INITS);
    }

    public QSupply(Path<Supply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSupply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSupply(PathMetadata metadata, PathInits inits) {
        this(Supply.class, metadata, inits);
    }

    public QSupply(Class<? extends Supply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.team = inits.isInitialized("team") ? new com.junyharangstudy.kotlingraphqltest.api.team.model.entity.QTeam(forProperty("team")) : null;
    }

}

