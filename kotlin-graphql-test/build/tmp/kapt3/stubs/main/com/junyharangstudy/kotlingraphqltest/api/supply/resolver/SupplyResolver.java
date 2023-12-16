package com.junyharangstudy.kotlingraphqltest.api.supply.resolver;

@org.springframework.stereotype.Controller
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0017J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0017J1\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017\u00a2\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\u0017J\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/supply/resolver/SupplyResolver;", "", "supplyService", "Lcom/junyharangstudy/kotlingraphqltest/api/supply/service/SupplyService;", "(Lcom/junyharangstudy/kotlingraphqltest/api/supply/service/SupplyService;)V", "deleteSupply", "Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "", "supplyId", "getSupplyBySupplyId", "Lcom/junyharangstudy/kotlingraphqltest/api/supply/model/dto/response/SupplyResponseDto;", "getSupplyList", "", "teamId", "", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "(Ljava/lang/Long;Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;)Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "saveSupply", "supplyCreateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/supply/model/dto/request/SupplyCreateRequestDto;", "updateSupply", "kotlin-graphql-test"})
public class SupplyResolver {
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.supply.service.SupplyService supplyService = null;
    
    public SupplyResolver(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.supply.service.SupplyService supplyService) {
        super();
    }
    
    @org.springframework.graphql.data.method.annotation.MutationMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> saveSupply(@org.springframework.graphql.data.method.annotation.Argument(value = "input")
    @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.request.SupplyCreateRequestDto supplyCreateRequestDto) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.QueryMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.response.SupplyResponseDto>> getSupplyList(@org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.Nullable
    java.lang.Long teamId, @org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.QueryMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.response.SupplyResponseDto> getSupplyBySupplyId(@org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.NotNull
    java.lang.String supplyId) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.MutationMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> updateSupply(@org.springframework.graphql.data.method.annotation.Argument(value = "supplyId")
    @org.jetbrains.annotations.NotNull
    java.lang.String supplyId, @org.springframework.graphql.data.method.annotation.Argument(value = "teamId")
    long teamId) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.MutationMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> deleteSupply(@org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.NotNull
    java.lang.String supplyId) {
        return null;
    }
}