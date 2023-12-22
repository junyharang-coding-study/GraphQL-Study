package com.junyharangstudy.kotlingraphqltest.api.equipment.service;

@org.springframework.stereotype.Service
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0012J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017J(\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J(\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00130\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J$\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00130\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0012J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0012J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0012J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0012J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00130\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0012J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0012J\b\u0010 \u001a\u00020!H\u0012J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010#\u001a\u00020$H\u0017J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/equipment/service/EquipmentService;", "", "equipmentRepository", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/repository/EquipmentRepository;", "equipmentQueryDslRepository", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/repository/EquipmentQueryDslRepository;", "(Lcom/junyharangstudy/kotlingraphqltest/api/equipment/repository/EquipmentRepository;Lcom/junyharangstudy/kotlingraphqltest/api/equipment/repository/EquipmentQueryDslRepository;)V", "checkUpdateRequest", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/entity/Equipment;", "equipmentUpdateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/dto/request/EquipmentUpdateRequestDto;", "equipment", "deleteEquipment", "Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "", "equipmentId", "getEquipment", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/dto/response/EquipmentResponseDto;", "getEquipmentAdv", "", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/dto/response/EquipmentAdvResponseDto;", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "equipmentSearchRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/dto/request/EquipmentSearchRequestDto;", "getEquipmentList", "processingParameterNotNull", "processingParameterNotNullAdv", "processingParameterNull", "processingParameterNullAdv", "processingParameterPagingNotNull", "processingParameterPagingNotNullAdv", "processingTotalElementCount", "", "saveEquipment", "equipmentCreateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/dto/request/EquipmentCreateRequestDto;", "updateEquipment", "kotlin-graphql-test"})
public class EquipmentService {
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.equipment.repository.EquipmentRepository equipmentRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.equipment.repository.EquipmentQueryDslRepository equipmentQueryDslRepository = null;
    
    public EquipmentService(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.equipment.repository.EquipmentRepository equipmentRepository, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.equipment.repository.EquipmentQueryDslRepository equipmentQueryDslRepository) {
        super();
    }
    
    @org.springframework.transaction.annotation.Transactional
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> saveEquipment(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentCreateRequestDto equipmentCreateRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentResponseDto>> getEquipmentList(@org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentSearchRequestDto equipmentSearchRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentAdvResponseDto>> getEquipmentAdv(@org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentSearchRequestDto equipmentSearchRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentResponseDto> getEquipment(@org.jetbrains.annotations.NotNull
    java.lang.String equipmentId) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> updateEquipment(@org.jetbrains.annotations.NotNull
    java.lang.String equipmentId, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentUpdateRequestDto equipmentUpdateRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> deleteEquipment(@org.jetbrains.annotations.NotNull
    java.lang.String equipmentId) {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment checkUpdateRequest(com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentUpdateRequestDto equipmentUpdateRequestDto, com.junyharangstudy.kotlingraphqltest.api.equipment.model.entity.Equipment equipment) {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentResponseDto>> processingParameterNotNull(com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentSearchRequestDto equipmentSearchRequestDto) {
        return null;
    }
    
    private java.util.List<com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentAdvResponseDto> processingParameterNotNullAdv(com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentSearchRequestDto equipmentSearchRequestDto) {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentResponseDto>> processingParameterPagingNotNull(com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    private java.util.List<com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentAdvResponseDto> processingParameterPagingNotNullAdv(com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    private java.util.List<com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentResponseDto> processingParameterNull() {
        return null;
    }
    
    private java.util.List<com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentAdvResponseDto> processingParameterNullAdv() {
        return null;
    }
    
    private int processingTotalElementCount() {
        return 0;
    }
}