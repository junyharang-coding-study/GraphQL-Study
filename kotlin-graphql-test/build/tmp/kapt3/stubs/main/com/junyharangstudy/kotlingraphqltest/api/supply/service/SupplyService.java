package com.junyharangstudy.kotlingraphqltest.api.supply.service;

@org.springframework.stereotype.Service
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0012J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0017J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0017J-\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00150\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0017\u00a2\u0006\u0002\u0010\u0018J$\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00150\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0012J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015H\u0012J\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00150\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0012J\b\u0010\u001c\u001a\u00020\u001dH\u0012J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0017J\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/supply/service/SupplyService;", "", "supplyRepository", "Lcom/junyharangstudy/kotlingraphqltest/api/supply/repository/SupplyRepository;", "teamRepository", "Lcom/junyharangstudy/kotlingraphqltest/api/team/repository/TeamRepository;", "supplyQueryDslRepository", "Lcom/junyharangstudy/kotlingraphqltest/api/supply/repository/SupplyQueryDslRepository;", "(Lcom/junyharangstudy/kotlingraphqltest/api/supply/repository/SupplyRepository;Lcom/junyharangstudy/kotlingraphqltest/api/team/repository/TeamRepository;Lcom/junyharangstudy/kotlingraphqltest/api/supply/repository/SupplyQueryDslRepository;)V", "checkUpdateRequest", "Lcom/junyharangstudy/kotlingraphqltest/api/supply/model/entity/Supply;", "teamId", "", "supply", "deleteSupply", "Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "", "supplyId", "getSupplyBySupplyId", "Lcom/junyharangstudy/kotlingraphqltest/api/supply/model/dto/response/SupplyResponseDto;", "getSupplyList", "", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "(Ljava/lang/Long;Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;)Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "processingParameterNotNull", "processingParameterNull", "processingParameterPagingNotNull", "processingTotalElementCount", "", "saveSupply", "supplyCreateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/supply/model/dto/request/SupplyCreateRequestDto;", "updateSupply", "kotlin-graphql-test"})
public class SupplyService {
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.supply.repository.SupplyRepository supplyRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.team.repository.TeamRepository teamRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.supply.repository.SupplyQueryDslRepository supplyQueryDslRepository = null;
    
    public SupplyService(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.supply.repository.SupplyRepository supplyRepository, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.repository.TeamRepository teamRepository, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.supply.repository.SupplyQueryDslRepository supplyQueryDslRepository) {
        super();
    }
    
    @org.springframework.transaction.annotation.Transactional
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> saveSupply(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.request.SupplyCreateRequestDto supplyCreateRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.response.SupplyResponseDto>> getSupplyList(@org.jetbrains.annotations.Nullable
    java.lang.Long teamId, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.response.SupplyResponseDto> getSupplyBySupplyId(@org.jetbrains.annotations.NotNull
    java.lang.String supplyId) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> updateSupply(@org.jetbrains.annotations.NotNull
    java.lang.String supplyId, long teamId) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> deleteSupply(@org.jetbrains.annotations.NotNull
    java.lang.String supplyId) {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.response.SupplyResponseDto>> processingParameterNotNull(com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, long teamId) {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.response.SupplyResponseDto>> processingParameterPagingNotNull(com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    private java.util.List<com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.response.SupplyResponseDto> processingParameterNull() {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.api.supply.model.entity.Supply checkUpdateRequest(long teamId, com.junyharangstudy.kotlingraphqltest.api.supply.model.entity.Supply supply) {
        return null;
    }
    
    private int processingTotalElementCount() {
        return 0;
    }
}