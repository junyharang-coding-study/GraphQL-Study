package com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity;

@jakarta.persistence.Entity
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0003J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0003R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/entity/Equipment;", "", "equipmentId", "", "usedBy", "count", "", "newOrUsed", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getCount", "()I", "setCount", "(I)V", "getEquipmentId", "()Ljava/lang/String;", "getNewOrUsed", "setNewOrUsed", "(Ljava/lang/String;)V", "getUsedBy", "setUsedBy", "updateCount", "", "updateNewOrUsed", "updateUsedBy", "kotlin-graphql-test"})
public final class Equipment {
    @jakarta.persistence.Id
    @org.jetbrains.annotations.NotNull
    private final java.lang.String equipmentId = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String usedBy;
    private int count;
    @org.jetbrains.annotations.NotNull
    private java.lang.String newOrUsed;
    
    public Equipment(@org.jetbrains.annotations.NotNull
    java.lang.String equipmentId, @org.jetbrains.annotations.NotNull
    java.lang.String usedBy, int count, @org.jetbrains.annotations.NotNull
    java.lang.String newOrUsed) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEquipmentId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUsedBy() {
        return null;
    }
    
    public final void setUsedBy(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int getCount() {
        return 0;
    }
    
    public final void setCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNewOrUsed() {
        return null;
    }
    
    public final void setNewOrUsed(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final void updateUsedBy(@org.jetbrains.annotations.NotNull
    java.lang.String usedBy) {
    }
    
    public final void updateCount(int count) {
    }
    
    public final void updateNewOrUsed(@org.jetbrains.annotations.NotNull
    java.lang.String newOrUsed) {
    }
}