package com.junyharangstudy.kotlingraphqltest.api.role.resolver;

@org.springframework.stereotype.Controller
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0017J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0017J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\f\u001a\u00020\rH\u0017J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/role/resolver/RoleResolver;", "", "roleService", "Lcom/junyharangstudy/kotlingraphqltest/api/role/service/RoleService;", "(Lcom/junyharangstudy/kotlingraphqltest/api/role/service/RoleService;)V", "deleteRole", "Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "", "roleId", "getRoleByRoleId", "Lcom/junyharangstudy/kotlingraphqltest/api/role/model/dto/response/RoleResponseDto;", "saveRole", "roleCreateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/role/model/dto/request/RoleCreateRequestDto;", "updateRole", "roleUpdateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/role/model/dto/request/RoleUpdateRequestDto;", "kotlin-graphql-test"})
public class RoleResolver {
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.role.service.RoleService roleService = null;
    
    public RoleResolver(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.role.service.RoleService roleService) {
        super();
    }
    
    @org.springframework.graphql.data.method.annotation.MutationMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> saveRole(@org.springframework.graphql.data.method.annotation.Argument(value = "input")
    @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleCreateRequestDto roleCreateRequestDto) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.QueryMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<com.junyharangstudy.kotlingraphqltest.api.role.model.dto.response.RoleResponseDto> getRoleByRoleId(@org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.NotNull
    java.lang.String roleId) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.MutationMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> updateRole(@org.springframework.graphql.data.method.annotation.Argument(value = "roleId")
    @org.jetbrains.annotations.NotNull
    java.lang.String roleId, @org.springframework.graphql.data.method.annotation.Argument(value = "input")
    @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.role.model.dto.request.RoleUpdateRequestDto roleUpdateRequestDto) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.MutationMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.String> deleteRole(@org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.NotNull
    java.lang.String roleId) {
        return null;
    }
}