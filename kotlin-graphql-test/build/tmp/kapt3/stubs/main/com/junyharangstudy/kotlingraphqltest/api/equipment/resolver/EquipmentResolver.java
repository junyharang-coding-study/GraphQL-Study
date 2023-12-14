package com.junyharangstudy.kotlingraphqltest.api.equipment.resolver;

@org.springframework.stereotype.Controller
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0017J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0017J,\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0017J\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/equipment/resolver/EquipmentResolver;", "", "equipmentService", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/service/EquipmentService;", "(Lcom/junyharangstudy/kotlingraphqltest/api/equipment/service/EquipmentService;)V", "deleteEquipment", "Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "", "equipmentId", "getEquipment", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/dto/response/EquipmentResponseDto;", "getEquipmentList", "", "equipmentSearchRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/dto/request/EquipmentSearchRequestDto;", "pagingRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PagingRequestDto;", "saveEquipment", "equipmentCreateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/dto/request/EquipmentCreateRequestDto;", "updateEquipment", "equipmentUpdateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/equipment/model/dto/request/EquipmentUpdateRequestDto;", "kotlin-graphql-test"})
public class EquipmentResolver {
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.equipment.service.EquipmentService equipmentService = null;
    
    public EquipmentResolver(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.equipment.service.EquipmentService equipmentService) {
        super();
    }
    
    /**
     * @MuationMapping은 REST API 구축 시 @PostMapping과 같은 어노테이션으로 graphql의 Mutaion에 사용.
     * GraphQL은 Endpoint가 하나이기 때문에 @MutaionMapping만 지정하고, 다른 설정을 해 줄 필요가 없음.
     */
    @org.springframework.graphql.data.method.annotation.MutationMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> saveEquipment(@org.springframework.graphql.data.method.annotation.Argument(value = "input")
    @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentCreateRequestDto equipmentCreateRequestDto) {
        return null;
    }
    
    /**
     * @QueryMapping도 Rest API 구축 시 @GetMapping과 같은 어노테이션이며, @SubscriptionMapping도 존재
     */
    @org.springframework.graphql.data.method.annotation.QueryMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentResponseDto>> getEquipmentList(@org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentSearchRequestDto equipmentSearchRequestDto, @org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PagingRequestDto pagingRequestDto) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.QueryMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.response.EquipmentResponseDto> getEquipment(@org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.NotNull
    java.lang.String equipmentId) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.MutationMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> updateEquipment(@org.springframework.graphql.data.method.annotation.Argument(value = "equipmentId")
    @org.jetbrains.annotations.NotNull
    java.lang.String equipmentId, @org.springframework.graphql.data.method.annotation.Argument(value = "input")
    @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.equipment.model.dto.request.EquipmentUpdateRequestDto equipmentUpdateRequestDto) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.MutationMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> deleteEquipment(@org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.NotNull
    java.lang.String equipmentId) {
        return null;
    }
}