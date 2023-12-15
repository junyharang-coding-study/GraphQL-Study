package com.junyharangstudy.kotlingraphqltest.api.team.model.entity;

@jakarta.persistence.Entity
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u0005R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;", "", "teamId", "", "manager", "", "office", "mascot", "extensionNumber", "cleaningDuty", "project", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCleaningDuty", "()Ljava/lang/String;", "setCleaningDuty", "(Ljava/lang/String;)V", "getExtensionNumber", "setExtensionNumber", "getManager", "setManager", "getMascot", "setMascot", "getOffice", "setOffice", "getProject", "setProject", "getTeamId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "updateCleaningDuty", "", "updateExtensionNumber", "updateManager", "updateMascot", "updateOffice", "updateProject", "kotlin-graphql-test"})
public final class Team {
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @org.jetbrains.annotations.Nullable
    private final java.lang.Long teamId = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String manager;
    @org.jetbrains.annotations.NotNull
    private java.lang.String office;
    @org.jetbrains.annotations.NotNull
    private java.lang.String mascot;
    @org.jetbrains.annotations.NotNull
    private java.lang.String extensionNumber;
    @org.jetbrains.annotations.NotNull
    private java.lang.String cleaningDuty;
    @org.jetbrains.annotations.NotNull
    private java.lang.String project;
    
    public Team(@org.jetbrains.annotations.Nullable
    java.lang.Long teamId, @org.jetbrains.annotations.NotNull
    java.lang.String manager, @org.jetbrains.annotations.NotNull
    java.lang.String office, @org.jetbrains.annotations.NotNull
    java.lang.String mascot, @org.jetbrains.annotations.NotNull
    java.lang.String extensionNumber, @org.jetbrains.annotations.NotNull
    java.lang.String cleaningDuty, @org.jetbrains.annotations.NotNull
    java.lang.String project) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getTeamId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getManager() {
        return null;
    }
    
    public final void setManager(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getOffice() {
        return null;
    }
    
    public final void setOffice(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMascot() {
        return null;
    }
    
    public final void setMascot(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getExtensionNumber() {
        return null;
    }
    
    public final void setExtensionNumber(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCleaningDuty() {
        return null;
    }
    
    public final void setCleaningDuty(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getProject() {
        return null;
    }
    
    public final void setProject(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final void updateManager(@org.jetbrains.annotations.NotNull
    java.lang.String manager) {
    }
    
    public final void updateOffice(@org.jetbrains.annotations.NotNull
    java.lang.String office) {
    }
    
    public final void updateMascot(@org.jetbrains.annotations.NotNull
    java.lang.String mascot) {
    }
    
    public final void updateExtensionNumber(@org.jetbrains.annotations.NotNull
    java.lang.String extensionNumber) {
    }
    
    public final void updateCleaningDuty(@org.jetbrains.annotations.NotNull
    java.lang.String cleaningDuty) {
    }
    
    public final void updateProject(@org.jetbrains.annotations.NotNull
    java.lang.String project) {
    }
}