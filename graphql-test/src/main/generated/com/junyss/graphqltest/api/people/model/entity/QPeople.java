package com.junyss.graphqltest.api.people.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPeople is a Querydsl query type for People
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPeople extends EntityPathBase<People> {

    private static final long serialVersionUID = 1804885096L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPeople people = new QPeople("people");

    public final EnumPath<com.junyss.graphqltest.common.enumtype.BloodType> bloodType = createEnum("bloodType", com.junyss.graphqltest.common.enumtype.BloodType.class);

    public final StringPath firstName = createString("firstName");

    public final StringPath hometown = createString("hometown");

    public final StringPath lastName = createString("lastName");

    public final NumberPath<Long> peopleId = createNumber("peopleId", Long.class);

    public final EnumPath<com.junyss.graphqltest.common.enumtype.Role> role = createEnum("role", com.junyss.graphqltest.common.enumtype.Role.class);

    public final NumberPath<Integer> serveYears = createNumber("serveYears", Integer.class);

    public final EnumPath<com.junyss.graphqltest.common.enumtype.Sex> sex = createEnum("sex", com.junyss.graphqltest.common.enumtype.Sex.class);

    public final com.junyss.graphqltest.api.team.model.entity.QTeam team;

    public QPeople(String variable) {
        this(People.class, forVariable(variable), INITS);
    }

    public QPeople(Path<? extends People> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPeople(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPeople(PathMetadata metadata, PathInits inits) {
        this(People.class, metadata, inits);
    }

    public QPeople(Class<? extends People> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.team = inits.isInitialized("team") ? new com.junyss.graphqltest.api.team.model.entity.QTeam(forProperty("team")) : null;
    }

}

