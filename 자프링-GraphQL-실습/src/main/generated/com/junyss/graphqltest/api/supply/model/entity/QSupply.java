package com.junyss.graphqltest.api.supply.model.entity;

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

    private static final long serialVersionUID = -1306896088L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSupply supply = new QSupply("supply");

    public final StringPath SupplyId = createString("SupplyId");

    public final com.junyss.graphqltest.api.team.model.entity.QTeam team;

    public QSupply(String variable) {
        this(Supply.class, forVariable(variable), INITS);
    }

    public QSupply(Path<? extends Supply> path) {
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
        this.team = inits.isInitialized("team") ? new com.junyss.graphqltest.api.team.model.entity.QTeam(forProperty("team")) : null;
    }

}

