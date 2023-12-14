package com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/dto/request/EquipmentCreateRequestDto;", "", "equipmentId", "", "usedBy", "count", "", "newOrUsed", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getCount", "()I", "getEquipmentId", "()Ljava/lang/String;", "getNewOrUsed", "getUsedBy", "toEntity", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/entity/Equipment;", "equipmentCreateRequestDto", "kotlin-graphql-test"})
public final class EquipmentCreateRequestDto {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String equipmentId = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String usedBy = null;
    private final int count = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String newOrUsed = null;
    
    public EquipmentCreateRequestDto(@jakarta.validation.constraints.NotBlank
    @org.jetbrains.annotations.NotNull
    java.lang.String equipmentId, @jakarta.validation.constraints.NotBlank
    @org.jetbrains.annotations.NotNull
    java.lang.String usedBy, @jakarta.validation.constraints.NotNull
    @jakarta.validation.constraints.Min(value = 1L)
    int count, @jakarta.validation.constraints.NotBlank
    @org.jetbrains.annotations.NotNull
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
    
    public final int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNewOrUsed() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment toEntity(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentCreateRequestDto equipmentCreateRequestDto) {
        return null;
    }
}