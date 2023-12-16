package com.junyharangstudy.kotlingraphqltest.api.role.model.entity;

@jakarta.persistence.Entity
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0003R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/role/model/entity/Role;", "", "roleId", "", "job", "requirement", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getJob", "()Ljava/lang/String;", "setJob", "(Ljava/lang/String;)V", "getRequirement", "setRequirement", "getRoleId", "setRoleId", "updateJob", "", "updateRequirment", "kotlin-graphql-test"})
public final class Role {
    @jakarta.persistence.Id
    @org.jetbrains.annotations.NotNull
    private java.lang.String roleId;
    @org.jetbrains.annotations.NotNull
    private java.lang.String job;
    @org.jetbrains.annotations.NotNull
    private java.lang.String requirement;
    
    public Role(@org.jetbrains.annotations.NotNull
    java.lang.String roleId, @org.jetbrains.annotations.NotNull
    java.lang.String job, @org.jetbrains.annotations.NotNull
    java.lang.String requirement) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoleId() {
        return null;
    }
    
    public final void setRoleId(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getJob() {
        return null;
    }
    
    public final void setJob(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRequirement() {
        return null;
    }
    
    public final void setRequirement(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final void updateJob(@org.jetbrains.annotations.NotNull
    java.lang.String job) {
    }
    
    public final void updateRequirment(@org.jetbrains.annotations.NotNull
    java.lang.String requirement) {
    }
}