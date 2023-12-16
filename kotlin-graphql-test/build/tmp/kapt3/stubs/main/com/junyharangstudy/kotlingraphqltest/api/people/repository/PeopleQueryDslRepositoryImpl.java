package com.junyharangstudy.kotlingraphqltest.api.people.repository;

@org.springframework.stereotype.Repository
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0012J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0012J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0012J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0012J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0012J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0012\u00a2\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0012J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0012\u00a2\u0006\u0002\u0010\u001dJ \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J%\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016\u00a2\u0006\u0002\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/people/repository/PeopleQueryDslRepositoryImpl;", "Lcom/junyharangstudy/kotlingraphqltest/api/people/repository/PeopleQueryDslRepository;", "jpaQueryFactory", "Lcom/querydsl/jpa/impl/JPAQueryFactory;", "(Lcom/querydsl/jpa/impl/JPAQueryFactory;)V", "eqBloodType", "Lcom/querydsl/core/types/dsl/BooleanExpression;", "bloodType", "Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/BloodType;", "eqFirstName", "firstName", "", "eqHometown", "hometown", "eqLastName", "lastName", "eqRole", "role", "Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Role;", "eqServeYears", "serveYears", "", "(Ljava/lang/Integer;)Lcom/querydsl/core/types/dsl/BooleanExpression;", "eqSex", "sex", "Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Sex;", "eqTeamId", "teamId", "", "(Ljava/lang/Long;)Lcom/querydsl/core/types/dsl/BooleanExpression;", "findBySearchAndPaging", "", "Lcom/junyharangstudy/kotlingraphqltest/api/people/model/entity/People;", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "peopleSearchRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/people/model/dto/request/PeopleSearchRequestDto;", "findByTeamIdAndPaging", "(Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;Ljava/lang/Long;)Ljava/util/List;", "kotlin-graphql-test"})
public class PeopleQueryDslRepositoryImpl implements com.junyharangstudy.kotlingraphqltest.api.people.repository.PeopleQueryDslRepository {
    @org.jetbrains.annotations.NotNull
    private final com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory = null;
    
    public PeopleQueryDslRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.util.List<com.junyharangstudy.kotlingraphqltest.api.people.model.entity.People> findBySearchAndPaging(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleSearchRequestDto peopleSearchRequestDto) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.util.List<com.junyharangstudy.kotlingraphqltest.api.people.model.entity.People> findByTeamIdAndPaging(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, @org.jetbrains.annotations.Nullable
    java.lang.Long teamId) {
        return null;
    }
    
    private com.querydsl.core.types.dsl.BooleanExpression eqLastName(java.lang.String lastName) {
        return null;
    }
    
    private com.querydsl.core.types.dsl.BooleanExpression eqFirstName(java.lang.String firstName) {
        return null;
    }
    
    private com.querydsl.core.types.dsl.BooleanExpression eqSex(com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex sex) {
        return null;
    }
    
    private com.querydsl.core.types.dsl.BooleanExpression eqBloodType(com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType bloodType) {
        return null;
    }
    
    private com.querydsl.core.types.dsl.BooleanExpression eqServeYears(java.lang.Integer serveYears) {
        return null;
    }
    
    private com.querydsl.core.types.dsl.BooleanExpression eqRole(com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role role) {
        return null;
    }
    
    private com.querydsl.core.types.dsl.BooleanExpression eqHometown(java.lang.String hometown) {
        return null;
    }
    
    private com.querydsl.core.types.dsl.BooleanExpression eqTeamId(java.lang.Long teamId) {
        return null;
    }
}