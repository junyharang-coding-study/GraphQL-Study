package com.junyharangstudy.kotlingraphqltest.api.role.service;

@org.springframework.stereotype.Service
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0012J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017J(\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00130\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0017J$\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00130\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0012J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0012J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00130\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0012J\b\u0010\u001b\u001a\u00020\u001cH\u0012J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0017J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/role/service/RoleService;", "", "roleRepository", "Lcom/junyharangstudy/kotlingraphqltest/api/role/repository/RoleRepository;", "roleQueryDslRepository", "Lcom/junyharangstudy/kotlingraphqltest/api/role/repository/RoleQueryDslRepository;", "(Lcom/junyharangstudy/kotlingraphqltest/api/role/repository/RoleRepository;Lcom/junyharangstudy/kotlingraphqltest/api/role/repository/RoleQueryDslRepository;)V", "checkUpdateRequest", "Lcom/junyharangstudy/kotlingraphqltest/api/role/model/entity/Role;", "roleUpdateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/role/model/dto/request/RoleUpdateRequestDto;", "role", "deleteRole", "Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "", "roleId", "getRoleByRoleId", "Lcom/junyharangstudy/kotlingraphqltest/api/role/model/dto/response/RoleResponseDto;", "getRoleList", "", "roleSearchRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/role/model/dto/request/RoleSearchRequestDto;", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "processingParameterNotNull", "processingParameterNull", "processingParameterPagingNotNull", "processingTotalElementCount", "", "saveRole", "roleCreateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/role/model/dto/request/RoleCreateRequestDto;", "updateRole", "kotlin-graphql-test"})
public class RoleService {
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.role.repository.RoleRepository roleRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.role.repository.RoleQueryDslRepository roleQueryDslRepository = null;
    
    public RoleService(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.role.repository.RoleRepository roleRepository, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.role.repository.RoleQueryDslRepository roleQueryDslRepository) {
        super();
    }
    
    @org.springframework.transaction.annotation.Transactional
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> saveRole(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleCreateRequestDto roleCreateRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.role.model.dto.response.RoleResponseDto>> getRoleList(@org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleSearchRequestDto roleSearchRequestDto, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<com.junyharangstudy.kotlingraphqltest.api.role.model.dto.response.RoleResponseDto> getRoleByRoleId(@org.jetbrains.annotations.NotNull
    java.lang.String roleId) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> updateRole(@org.jetbrains.annotations.NotNull
    java.lang.String roleId, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleUpdateRequestDto roleUpdateRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> deleteRole(@org.jetbrains.annotations.NotNull
    java.lang.String roleId) {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.api.role.model.entity.Role checkUpdateRequest(com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleUpdateRequestDto roleUpdateRequestDto, com.junyharangstudy.kotlingraphqltest.api.role.model.entity.Role role) {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.role.model.dto.response.RoleResponseDto>> processingParameterNotNull(com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleSearchRequestDto roleSearchRequestDto) {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.role.model.dto.response.RoleResponseDto>> processingParameterPagingNotNull(com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    private java.util.List<com.junyharangstudy.kotlingraphqltest.api.role.model.dto.response.RoleResponseDto> processingParameterNull() {
        return null;
    }
    
    private int processingTotalElementCount() {
        return 0;
    }
}