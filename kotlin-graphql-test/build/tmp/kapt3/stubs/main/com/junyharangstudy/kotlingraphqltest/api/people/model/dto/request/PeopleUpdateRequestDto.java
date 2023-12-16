package com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u0006/"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/people/model/dto/request/PeopleUpdateRequestDto;", "", "teamId", "", "lastName", "", "firstName", "sex", "Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Sex;", "bloodType", "Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/BloodType;", "serveYears", "", "role", "Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Role;", "hometown", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Sex;Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/BloodType;Ljava/lang/Integer;Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Role;Ljava/lang/String;)V", "getBloodType", "()Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/BloodType;", "setBloodType", "(Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/BloodType;)V", "getFirstName", "()Ljava/lang/String;", "setFirstName", "(Ljava/lang/String;)V", "getHometown", "setHometown", "getLastName", "setLastName", "getRole", "()Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Role;", "setRole", "(Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Role;)V", "getServeYears", "()Ljava/lang/Integer;", "setServeYears", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSex", "()Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Sex;", "setSex", "(Lcom/junyharangstudy/kotlingraphqltest/api/common/enumtype/Sex;)V", "getTeamId", "()Ljava/lang/Long;", "setTeamId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "kotlin-graphql-test"})
public final class PeopleUpdateRequestDto {
    @org.jetbrains.annotations.Nullable
    private java.lang.Long teamId;
    @org.jetbrains.annotations.Nullable
    private java.lang.String lastName;
    @org.jetbrains.annotations.Nullable
    private java.lang.String firstName;
    @org.jetbrains.annotations.Nullable
    private com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex sex;
    @org.jetbrains.annotations.Nullable
    private com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType bloodType;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer serveYears;
    @org.jetbrains.annotations.Nullable
    private com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role role;
    @org.jetbrains.annotations.Nullable
    private java.lang.String hometown;
    
    public PeopleUpdateRequestDto(@org.jetbrains.annotations.Nullable
    java.lang.Long teamId, @org.jetbrains.annotations.Nullable
    java.lang.String lastName, @org.jetbrains.annotations.Nullable
    java.lang.String firstName, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex sex, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType bloodType, @org.jetbrains.annotations.Nullable
    java.lang.Integer serveYears, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role role, @org.jetbrains.annotations.Nullable
    java.lang.String hometown) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getTeamId() {
        return null;
    }
    
    public final void setTeamId(@org.jetbrains.annotations.Nullable
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLastName() {
        return null;
    }
    
    public final void setLastName(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFirstName() {
        return null;
    }
    
    public final void setFirstName(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex getSex() {
        return null;
    }
    
    public final void setSex(@org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Sex p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType getBloodType() {
        return null;
    }
    
    public final void setBloodType(@org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.BloodType p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getServeYears() {
        return null;
    }
    
    public final void setServeYears(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role getRole() {
        return null;
    }
    
    public final void setRole(@org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.enumtype.Role p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getHometown() {
        return null;
    }
    
    public final void setHometown(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
}