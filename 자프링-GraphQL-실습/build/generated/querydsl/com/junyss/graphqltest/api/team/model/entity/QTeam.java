package com.junyss.graphqltest.api.team.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTeam is a Querydsl query type for Team
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeam extends EntityPathBase<Team> {

    private static final long serialVersionUID = -1151022268L;

    public static final QTeam team = new QTeam("team");

    public final StringPath cleaningDuty = createString("cleaningDuty");

    public final StringPath extensionNumber = createString("extensionNumber");

    public final StringPath manager = createString("manager");

    public final StringPath mascot = createString("mascot");

    public final StringPath office = createString("office");

    public final StringPath project = createString("project");

    public final NumberPath<Long> teamId = createNumber("teamId", Long.class);

    public QTeam(String variable) {
        super(Team.class, forVariable(variable));
    }

    public QTeam(Path<? extends Team> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTeam(PathMetadata metadata) {
        super(Team.class, metadata);
    }

}

