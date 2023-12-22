package com.junyharangstudy.kotlingraphqltest.api.team.resolver;

@io.swagger.v3.oas.annotations.tags.Tag(name = "Team \uad00\ub828 API", description = "Team \uad00\ub828 API")
@org.springframework.web.bind.annotation.RestController
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/team/resolver/TeamRestApiController;", "", "teamService", "Lcom/junyharangstudy/kotlingraphqltest/api/team/service/TeamService;", "(Lcom/junyharangstudy/kotlingraphqltest/api/team/service/TeamService;)V", "getTeamAndMemberByTeamId", "Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/response/TeamAndMemberResponseDto;", "teamId", "", "kotlin-graphql-test"})
public class TeamRestApiController {
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.team.service.TeamService teamService = null;
    
    public TeamRestApiController(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.service.TeamService teamService) {
        super();
    }
    
    @io.swagger.v3.oas.annotations.Operation(summary = "Team\uacfc People \uc815\ubcf4 \uc0c1\uc138 \uc870\ud68c", description = "Team\uacfc People \uc815\ubcf4 \uc0c1\uc138 \uc870\ud68c API Router")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "NOT FOUND DATA")
    @org.springframework.web.bind.annotation.GetMapping(value = {"/team/{teamId}"})
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamAndMemberResponseDto> getTeamAndMemberByTeamId(@org.springframework.web.bind.annotation.PathVariable(value = "teamId")
    long teamId) {
        return null;
    }
}