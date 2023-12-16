package com.junyharangstudy.kotlingraphqltest.api.software.service;

@org.springframework.stereotype.Service
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0012J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017J(\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00130\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0017J$\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00130\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0012J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0012J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00130\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0012J\b\u0010\u001b\u001a\u00020\u001cH\u0012J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0017J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/software/service/SoftwareService;", "", "softwareRepository", "Lcom/junyharangstudy/kotlingraphqltest/api/software/repository/SoftwareRepository;", "softwareQueryDslRepository", "Lcom/junyharangstudy/kotlingraphqltest/api/software/repository/SoftwareQueryDslRepository;", "(Lcom/junyharangstudy/kotlingraphqltest/api/software/repository/SoftwareRepository;Lcom/junyharangstudy/kotlingraphqltest/api/software/repository/SoftwareQueryDslRepository;)V", "checkUpdateRequest", "Lcom/junyharangstudy/kotlingraphqltest/api/software/model/entity/Software;", "softwareUpdateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/software/model/dto/request/SoftwareUpdateRequestDto;", "software", "deleteSoftware", "Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "", "softwareId", "getSoftwareBySoftwareId", "Lcom/junyharangstudy/kotlingraphqltest/api/software/model/dto/response/SoftwareResponseDto;", "getSoftwareList", "", "softwareSearchRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/software/model/dto/request/SoftwareSearchRequestDto;", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "processingParameterNotNull", "processingParameterNull", "processingParameterPagingNotNull", "processingTotalElementCount", "", "saveSoftware", "softwareCreateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/software/model/dto/request/SoftwareCreateRequestDto;", "updateSoftware", "kotlin-graphql-test"})
public class SoftwareService {
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.software.repository.SoftwareRepository softwareRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.software.repository.SoftwareQueryDslRepository softwareQueryDslRepository = null;
    
    public SoftwareService(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.software.repository.SoftwareRepository softwareRepository, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.software.repository.SoftwareQueryDslRepository softwareQueryDslRepository) {
        super();
    }
    
    @org.springframework.transaction.annotation.Transactional
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> saveSoftware(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareCreateRequestDto softwareCreateRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.software.model.dto.response.SoftwareResponseDto>> getSoftwareList(@org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareSearchRequestDto softwareSearchRequestDto, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<com.junyharangstudy.kotlingraphqltest.api.software.model.dto.response.SoftwareResponseDto> getSoftwareBySoftwareId(@org.jetbrains.annotations.NotNull
    java.lang.String softwareId) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> updateSoftware(@org.jetbrains.annotations.NotNull
    java.lang.String softwareId, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareUpdateRequestDto softwareUpdateRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> deleteSoftware(@org.jetbrains.annotations.NotNull
    java.lang.String softwareId) {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.api.software.model.entity.Software checkUpdateRequest(com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareUpdateRequestDto softwareUpdateRequestDto, com.junyharangstudy.kotlingraphqltest.api.software.model.entity.Software software) {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.software.model.dto.response.SoftwareResponseDto>> processingParameterNotNull(com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareSearchRequestDto softwareSearchRequestDto) {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.software.model.dto.response.SoftwareResponseDto>> processingParameterPagingNotNull(com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    private java.util.List<com.junyharangstudy.kotlingraphqltest.api.software.model.dto.response.SoftwareResponseDto> processingParameterNull() {
        return null;
    }
    
    private int processingTotalElementCount() {
        return 0;
    }
}