package com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/dto/response/EquipmentResponseDto;", "", "equipmentId", "", "usedBy", "count", "", "newOrUsed", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "Companion", "kotlin-graphql-test"})
public final class EquipmentResponseDto {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String equipmentId = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String usedBy = null;
    private final int count = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String newOrUsed = null;
    @org.jetbrains.annotations.NotNull
    public static final com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentResponseDto.Companion Companion = null;
    
    public EquipmentResponseDto(@org.jetbrains.annotations.NotNull
    java.lang.String equipmentId, @org.jetbrains.annotations.NotNull
    java.lang.String usedBy, int count, @org.jetbrains.annotations.NotNull
    java.lang.String newOrUsed) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/dto/response/EquipmentResponseDto$Companion;", "", "()V", "equipmentToDto", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/dto/response/EquipmentResponseDto;", "equipment", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/entity/Equipment;", "kotlin-graphql-test"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentResponseDto equipmentToDto(@org.jetbrains.annotations.NotNull
        com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment equipment) {
            return null;
        }
    }
}