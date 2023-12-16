package com.junyharangstudy.kotlingraphqltest.api.role.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = 1717248885L;

    public static final QRole role = new QRole("role");

    public final StringPath job = createString("job");

    public final StringPath requirement = createString("requirement");

    public final StringPath roleId = createString("roleId");

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    public QRole(Path<Role> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata metadata) {
        super(Role.class, metadata);
    }

}

