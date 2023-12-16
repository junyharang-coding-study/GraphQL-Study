package com.junyharangstudy.kotlingraphqltest.api.role.repository;

@org.springframework.stereotype.Repository
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0012J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0012J \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/role/repository/RoleQueryDslRepositoryImpl;", "Lcom/junyharangstudy/kotlingraphqltest/api/role/repository/RoleQueryDslRepository;", "jpaQueryFactory", "Lcom/querydsl/jpa/impl/JPAQueryFactory;", "(Lcom/querydsl/jpa/impl/JPAQueryFactory;)V", "eqJob", "Lcom/querydsl/core/types/dsl/BooleanExpression;", "job", "", "eqRequirement", "requirement", "findBySearchAndPaging", "", "Lcom/junyharangstudy/kotlingraphqltest/api/role/model/entity/Role;", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "roleSearchRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/role/model/dto/request/RoleSearchRequestDto;", "kotlin-graphql-test"})
public class RoleQueryDslRepositoryImpl implements com.junyharangstudy.kotlingraphqltest.api.role.repository.RoleQueryDslRepository {
    @org.jetbrains.annotations.NotNull
    private final com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory = null;
    
    public RoleQueryDslRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.util.List<com.junyharangstudy.kotlingraphqltest.api.role.model.entity.Role> findBySearchAndPaging(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleSearchRequestDto roleSearchRequestDto) {
        return null;
    }
    
    private com.querydsl.core.types.dsl.BooleanExpression eqJob(java.lang.String job) {
        return null;
    }
    
    private com.querydsl.core.types.dsl.BooleanExpression eqRequirement(java.lang.String requirement) {
        return null;
    }
}