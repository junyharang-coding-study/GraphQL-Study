package com.junyharangstudy.kotlingraphqltest.api.team.resolver;

@org.springframework.stereotype.Controller
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0017J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0017J,\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0\u00062\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0017J\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/team/resolver/TeamResolver;", "", "teamService", "Lcom/junyharangstudy/kotlingraphqltest/api/team/service/TeamService;", "(Lcom/junyharangstudy/kotlingraphqltest/api/team/service/TeamService;)V", "deleteTeam", "Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "", "teamId", "getTeamByTeamId", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/response/TeamResponseDto;", "getTeamList", "", "teamSearchRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/request/TeamSearchRequestDto;", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "saveTeam", "teamCreateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/request/TeamCreateRequestDto;", "updateTeam", "teamUpdateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/request/TeamUpdateRequestDto;", "kotlin-graphql-test"})
public class TeamResolver {
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.team.service.TeamService teamService = null;
    
    public TeamResolver(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.service.TeamService teamService) {
        super();
    }
    
    @org.springframework.graphql.data.method.annotation.MutationMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.Long> saveTeam(@org.springframework.graphql.data.method.annotation.Argument(value = "input")
    @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamCreateRequestDto teamCreateRequestDto) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.QueryMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamResponseDto>> getTeamList(@org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamSearchRequestDto teamSearchRequestDto, @org.springframework.graphql.data.method.annotation.Argument
    @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.QueryMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamResponseDto> getTeamByTeamId(@org.springframework.graphql.data.method.annotation.Argument
    long teamId) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.MutationMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.Long> updateTeam(@org.springframework.graphql.data.method.annotation.Argument(value = "teamId")
    long teamId, @org.springframework.graphql.data.method.annotation.Argument(value = "input")
    @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamUpdateRequestDto teamUpdateRequestDto) {
        return null;
    }
    
    @org.springframework.graphql.data.method.annotation.MutationMapping
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.Long> deleteTeam(@org.springframework.graphql.data.method.annotation.Argument
    long teamId) {
        return null;
    }
}