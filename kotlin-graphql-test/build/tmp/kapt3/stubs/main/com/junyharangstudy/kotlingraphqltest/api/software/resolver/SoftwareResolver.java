package com.junyharangstudy.kotlingraphqltest.api.software.resolver;

@org.springframework.stereotype.Controller
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0017J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0017J,\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0017J\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/software/resolver/SoftwareResolver;", "", "softwareService", "Lcom/junyharangstudy/kotlingraphqltest/api/software/service/SoftwareService;", "(Lcom/junyharangstudy/kotlingraphqltest/api/software/service/SoftwareService;)V", "deleteSoftware", "Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "", "softwareId", "getSoftwareBySoftwareId", "Lcom/junyharangstudy/kotlingraphqltest/api/software/model/dto/response/SoftwareResponseDto;", "getSoftwareList", "", "softwareSearchRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/software/model/dto/request/SoftwareSearchRequestDto;", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "saveSoftware", "softwareCreateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/software/model/dto/request/SoftwareCreateRequestDto;", "updateSoftware", "softwareUpdateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/software/model/dto/request/SoftwareUpdateRequestDto;", "kotlin-graphql-test"})
public class SoftwareResolver {
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.software.service.SoftwareService softwareService = null;
    
    public SoftwareResolver(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.software.service.SoftwareService softwareService) {
        super();
    }
    
    @org.springframework.graphql.data.method.annotation.MutationMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> saveSoftware(@org.springframework.graphql.data.method.annotation.Argument(value = "input")
    @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareCreateRequestDto softwareCreateRequestDto) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.QueryMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.software.model.dto.response.SoftwareResponseDto>> getSoftwareList(@org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareSearchRequestDto softwareSearchRequestDto, @org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.QueryMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<com.junyharangstudy.kotlingraphqltest.api.software.model.dto.response.SoftwareResponseDto> getSoftwareBySoftwareId(@org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.NotNull
    java.lang.String softwareId) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.MutationMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> updateSoftware(@org.springframework.graphql.data.method.annotation.Argument(value = "softwareId")
    @org.jetbrains.annotations.NotNull
    java.lang.String softwareId, @org.springframework.graphql.data.method.annotation.Argument(value = "input")
    @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareUpdateRequestDto softwareUpdateRequestDto) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.MutationMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> deleteSoftware(@org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.NotNull
    java.lang.String softwareId) {
        return null;
    }
}