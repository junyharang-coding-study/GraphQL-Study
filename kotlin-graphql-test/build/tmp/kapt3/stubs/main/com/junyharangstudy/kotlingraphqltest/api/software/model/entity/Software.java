package com.junyharangstudy.kotlingraphqltest.api.software.model.entity;

@jakarta.persistence.Entity
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0003J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0003R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/software/model/entity/Software;", "", "softwareId", "", "usedBy", "developedBy", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getDevelopedBy", "setDevelopedBy", "getSoftwareId", "setSoftwareId", "getUsedBy", "setUsedBy", "updateDescription", "", "updateDevelopedBy", "updateUsedBy", "kotlin-graphql-test"})
public final class Software {
    @jakarta.persistence.Id
    @org.jetbrains.annotations.NotNull
    private java.lang.String softwareId;
    @org.jetbrains.annotations.NotNull
    private java.lang.String usedBy;
    @org.jetbrains.annotations.NotNull
    private java.lang.String developedBy;
    @org.jetbrains.annotations.Nullable
    private java.lang.String description;
    
    public Software(@org.jetbrains.annotations.NotNull
    java.lang.String softwareId, @org.jetbrains.annotations.NotNull
    java.lang.String usedBy, @org.jetbrains.annotations.NotNull
    java.lang.String developedBy, @org.jetbrains.annotations.Nullable
    java.lang.String description) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSoftwareId() {
        return null;
    }
    
    public final void setSoftwareId(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUsedBy() {
        return null;
    }
    
    public final void setUsedBy(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDevelopedBy() {
        return null;
    }
    
    public final void setDevelopedBy(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final void updateUsedBy(@org.jetbrains.annotations.NotNull
    java.lang.String usedBy) {
    }
    
    public final void updateDevelopedBy(@org.jetbrains.annotations.NotNull
    java.lang.String developedBy) {
    }
    
    public final void updateDescription(@org.jetbrains.annotations.NotNull
    java.lang.String description) {
    }
}