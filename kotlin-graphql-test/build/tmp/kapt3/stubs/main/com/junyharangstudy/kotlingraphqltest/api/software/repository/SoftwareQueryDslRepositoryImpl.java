package com.junyharangstudy.kotlingraphqltest.api.software.repository;

@org.springframework.stereotype.Repository
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/software/repository/SoftwareQueryDslRepositoryImpl;", "Lcom/junyharangstudy/kotlingraphqltest/api/software/repository/SoftwareQueryDslRepository;", "jpaQueryFactory", "Lcom/querydsl/jpa/impl/JPAQueryFactory;", "(Lcom/querydsl/jpa/impl/JPAQueryFactory;)V", "eqDescription", "Lcom/querydsl/core/types/dsl/BooleanExpression;", "description", "", "eqDevelopedBy", "developedBy", "eqUsedBy", "usedBy", "findBySearchAndPaging", "", "Lcom/junyharangstudy/kotlingraphqltest/api/software/model/entity/Software;", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "softwareSearchRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/software/model/dto/request/SoftwareSearchRequestDto;", "kotlin-graphql-test"})
public class SoftwareQueryDslRepositoryImpl implements com.junyharangstudy.kotlingraphqltest.api.software.repository.SoftwareQueryDslRepository {
    @org.jetbrains.annotations.NotNull
    private final com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory = null;
    
    public SoftwareQueryDslRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.util.List<com.junyharangstudy.kotlingraphqltest.api.software.model.entity.Software> findBySearchAndPaging(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareSearchRequestDto softwareSearchRequestDto) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public com.querydsl.core.types.dsl.BooleanExpression eqUsedBy(@org.jetbrains.annotations.Nullable
    java.lang.String usedBy) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public com.querydsl.core.types.dsl.BooleanExpression eqDevelopedBy(@org.jetbrains.annotations.Nullable
    java.lang.String developedBy) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public com.querydsl.core.types.dsl.BooleanExpression eqDescription(@org.jetbrains.annotations.Nullable
    java.lang.String description) {
        return null;
    }
}