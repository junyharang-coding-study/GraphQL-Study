package com.junyharangstudy.kotlingraphqltest.api.people.repository;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0003H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/people/repository/PeopleRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lcom/junyharangstudy/kotlingraphqltest/api/people/model/entity/People;", "", "findAllByTeamId", "", "teamId", "kotlin-graphql-test"})
public abstract interface PeopleRepository extends org.springframework.data.jpa.repository.JpaRepository<com.junyharangstudy.kotlingraphqltest.api.people.model.entity.People, java.lang.Long> {
    
    @org.springframework.data.jpa.repository.Query(value = "SELECT people FROM People people where people.team.teamId = :teamId")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.junyharangstudy.kotlingraphqltest.api.people.model.entity.People> findAllByTeamId(@org.springframework.data.repository.query.Param(value = "teamId")
    long teamId);
}