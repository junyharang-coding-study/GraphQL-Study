package com.junyharangstudy.kotlingraphqltest.api.people.model.entity;

@jakarta.persistence.Entity
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0012J\u000e\u00104\u001a\u0002052\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u00106\u001a\u0002052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u00107\u001a\u0002052\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u00108\u001a\u0002052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u00109\u001a\u0002052\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010:\u001a\u0002052\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010;\u001a\u0002052\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010<\u001a\u0002052\u0006\u0010\u0004\u001a\u00020\u0005R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u0006="}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/people/model/entity/People;", "", "peopleId", "", "team", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;", "lastName", "", "firstName", "sex", "Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Sex;", "bloodType", "Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/BloodType;", "serveYears", "", "role", "Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Role;", "hometown", "(Ljava/lang/Long;Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;Ljava/lang/String;Ljava/lang/String;Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Sex;Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/BloodType;ILcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Role;Ljava/lang/String;)V", "getBloodType", "()Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/BloodType;", "setBloodType", "(Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/BloodType;)V", "getFirstName", "()Ljava/lang/String;", "setFirstName", "(Ljava/lang/String;)V", "getHometown", "setHometown", "getLastName", "setLastName", "getPeopleId", "()Ljava/lang/Long;", "setPeopleId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getRole", "()Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Role;", "setRole", "(Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Role;)V", "getServeYears", "()I", "setServeYears", "(I)V", "getSex", "()Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Sex;", "setSex", "(Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Sex;)V", "getTeam", "()Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;", "setTeam", "(Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;)V", "updateBloodType", "", "updateFirstName", "updateHomeTown", "updateLastName", "updateRole", "updateServeYears", "updateSex", "updateTeam", "kotlin-graphql-test"})
public final class People {
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @org.jetbrains.annotations.Nullable
    private java.lang.Long peopleId;
    @jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @jakarta.persistence.JoinColumn(name = "team_id")
    @org.jetbrains.annotations.NotNull
    private com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team team;
    @org.jetbrains.annotations.NotNull
    private java.lang.String lastName;
    @org.jetbrains.annotations.NotNull
    private java.lang.String firstName;
    @jakarta.persistence.Enumerated(value = jakarta.persistence.EnumType.STRING)
    @org.jetbrains.annotations.NotNull
    private com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex sex;
    @jakarta.persistence.Enumerated(value = jakarta.persistence.EnumType.STRING)
    @org.jetbrains.annotations.NotNull
    private com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType bloodType;
    private int serveYears;
    @jakarta.persistence.Enumerated(value = jakarta.persistence.EnumType.STRING)
    @org.jetbrains.annotations.NotNull
    private com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role role;
    @org.jetbrains.annotations.NotNull
    private java.lang.String hometown;
    
    public People(@org.jetbrains.annotations.Nullable
    java.lang.Long peopleId, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team team, @org.jetbrains.annotations.NotNull
    java.lang.String lastName, @org.jetbrains.annotations.NotNull
    java.lang.String firstName, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex sex, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType bloodType, int serveYears, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role role, @org.jetbrains.annotations.NotNull
    java.lang.String hometown) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getPeopleId() {
        return null;
    }
    
    public final void setPeopleId(@org.jetbrains.annotations.Nullable
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team getTeam() {
        return null;
    }
    
    public final void setTeam(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLastName() {
        return null;
    }
    
    public final void setLastName(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFirstName() {
        return null;
    }
    
    public final void setFirstName(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex getSex() {
        return null;
    }
    
    public final void setSex(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType getBloodType() {
        return null;
    }
    
    public final void setBloodType(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType p0) {
    }
    
    public final int getServeYears() {
        return 0;
    }
    
    public final void setServeYears(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role getRole() {
        return null;
    }
    
    public final void setRole(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getHometown() {
        return null;
    }
    
    public final void setHometown(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final void updateTeam(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team team) {
    }
    
    public final void updateLastName(@org.jetbrains.annotations.NotNull
    java.lang.String lastName) {
    }
    
    public final void updateFirstName(@org.jetbrains.annotations.NotNull
    java.lang.String firstName) {
    }
    
    public final void updateSex(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex sex) {
    }
    
    public final void updateBloodType(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType bloodType) {
    }
    
    public final void updateServeYears(int serveYears) {
    }
    
    public final void updateRole(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role role) {
    }
    
    public final void updateHomeTown(@org.jetbrains.annotations.NotNull
    java.lang.String hometown) {
    }
}