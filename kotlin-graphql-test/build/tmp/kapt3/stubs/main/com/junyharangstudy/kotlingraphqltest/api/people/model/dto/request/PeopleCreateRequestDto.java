package com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BU\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/people/model/dto/request/PeopleCreateRequestDto;", "", "teamId", "", "lastName", "", "firstName", "sex", "Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Sex;", "bloodType", "Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/BloodType;", "serveYears", "", "role", "Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Role;", "hometown", "(JLjava/lang/String;Ljava/lang/String;Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Sex;Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/BloodType;ILcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Role;Ljava/lang/String;)V", "getBloodType", "()Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/BloodType;", "getFirstName", "()Ljava/lang/String;", "getHometown", "getLastName", "getRole", "()Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Role;", "getServeYears", "()I", "getSex", "()Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Sex;", "getTeamId", "()J", "toEntity", "Lcom/junyharangstudy/kotlingraphqltest/api/people/model/entity/People;", "peopleCreateRequestDto", "team", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;", "kotlin-graphql-test"})
public final class PeopleCreateRequestDto {
    private final long teamId = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String lastName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String firstName = null;
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex sex = null;
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType bloodType = null;
    private final int serveYears = 0;
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role role = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String hometown = null;
    
    public PeopleCreateRequestDto(@jakarta.validation.constraints.NotNull
    @jakarta.validation.constraints.Min(value = 1L)
    long teamId, @jakarta.validation.constraints.NotBlank
    @org.jetbrains.annotations.NotNull
    java.lang.String lastName, @jakarta.validation.constraints.NotBlank
    @org.jetbrains.annotations.NotNull
    java.lang.String firstName, @jakarta.validation.constraints.NotBlank
    @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex sex, @jakarta.validation.constraints.NotBlank
    @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType bloodType, @jakarta.validation.constraints.NotNull
    @jakarta.validation.constraints.Min(value = 0L)
    int serveYears, @jakarta.validation.constraints.NotBlank
    @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role role, @jakarta.validation.constraints.NotBlank
    @org.jetbrains.annotations.NotNull
    java.lang.String hometown) {
        super();
    }
    
    public final long getTeamId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLastName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFirstName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex getSex() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType getBloodType() {
        return null;
    }
    
    public final int getServeYears() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role getRole() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getHometown() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.junyharangstudy.kotlingraphqltest.api.people.model.entity.People toEntity(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleCreateRequestDto peopleCreateRequestDto, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team team) {
        return null;
    }
}