package com.junyharangstudy.kotlingraphqltest.api.supply.repository;

@org.springframework.stereotype.Repository
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0012\u00a2\u0006\u0002\u0010\tJ%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/supply/repository/SupplyQueryDslRepositoryImpl;", "Lcom/junyharangstudy/kotlingraphqltest/api/supply/repository/SupplyQueryDslRepository;", "jpaQueryFactory", "Lcom/querydsl/jpa/impl/JPAQueryFactory;", "(Lcom/querydsl/jpa/impl/JPAQueryFactory;)V", "eqTeamId", "Lcom/querydsl/core/types/dsl/BooleanExpression;", "teamId", "", "(Ljava/lang/Long;)Lcom/querydsl/core/types/dsl/BooleanExpression;", "findBySearchAndPaging", "", "Lcom/junyharangstudy/kotlingraphqltest/api/supply/model/entity/Supply;", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "(Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;Ljava/lang/Long;)Ljava/util/List;", "kotlin-graphql-test"})
public class SupplyQueryDslRepositoryImpl implements com.junyharangstudy.kotlingraphqltest.api.supply.repository.SupplyQueryDslRepository {
    @org.jetbrains.annotations.NotNull
    private final com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory = null;
    
    public SupplyQueryDslRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.util.List<com.junyharangstudy.kotlingraphqltest.api.supply.model.entity.Supply> findBySearchAndPaging(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, @org.jetbrains.annotations.Nullable
    java.lang.Long teamId) {
        return null;
    }
    
    private com.querydsl.core.types.dsl.BooleanExpression eqTeamId(java.lang.Long teamId) {
        return null;
    }
}