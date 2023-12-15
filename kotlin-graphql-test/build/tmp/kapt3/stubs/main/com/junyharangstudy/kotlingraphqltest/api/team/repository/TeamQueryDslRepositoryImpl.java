package com.junyharangstudy.kotlingraphqltest.api.team.repository;

@org.springframework.stereotype.Repository
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016J \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/team/repository/TeamQueryDslRepositoryImpl;", "Lcom/junyharangstudy/kotlingraphqltest/api/team/repository/TeamQueryDslRepository;", "jpaQueryFactory", "Lcom/querydsl/jpa/impl/JPAQueryFactory;", "(Lcom/querydsl/jpa/impl/JPAQueryFactory;)V", "eqCleaningDuty", "Lcom/querydsl/core/types/dsl/BooleanExpression;", "cleaningDuty", "", "eqExtensionNumber", "extensionNumber", "eqManager", "manager", "eqMascot", "mascot", "eqOffice", "office", "eqProject", "project", "findBySearchAndPaging", "", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "teamSearchRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/request/TeamSearchRequestDto;", "kotlin-graphql-test"})
public class TeamQueryDslRepositoryImpl implements com.junyharangstudy.kotlingraphqltest.api.team.repository.TeamQueryDslRepository {
    @org.jetbrains.annotations.NotNull
    private final com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory = null;
    
    public TeamQueryDslRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.util.List<com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team> findBySearchAndPaging(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamSearchRequestDto teamSearchRequestDto) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public com.querydsl.core.types.dsl.BooleanExpression eqManager(@org.jetbrains.annotations.Nullable
    java.lang.String manager) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public com.querydsl.core.types.dsl.BooleanExpression eqOffice(@org.jetbrains.annotations.Nullable
    java.lang.String office) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public com.querydsl.core.types.dsl.BooleanExpression eqExtensionNumber(@org.jetbrains.annotations.Nullable
    java.lang.String extensionNumber) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public com.querydsl.core.types.dsl.BooleanExpression eqMascot(@org.jetbrains.annotations.Nullable
    java.lang.String mascot) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public com.querydsl.core.types.dsl.BooleanExpression eqCleaningDuty(@org.jetbrains.annotations.Nullable
    java.lang.String cleaningDuty) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public com.querydsl.core.types.dsl.BooleanExpression eqProject(@org.jetbrains.annotations.Nullable
    java.lang.String project) {
        return null;
    }
}