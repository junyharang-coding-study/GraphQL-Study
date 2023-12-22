package com.junyharangstudy.kotlingraphqltest.api.team.service;

@org.springframework.stereotype.Service
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0012J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0017J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0017J(\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0017J$\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0012J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0012J\u001c\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0012J\b\u0010\u001e\u001a\u00020\u001fH\u0012J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010!\u001a\u00020\"H\u0017J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/team/service/TeamService;", "", "teamRepository", "Lcom/junyharangstudy/kotlingraphqltest/api/team/repository/TeamRepository;", "teamQueryDslRepository", "Lcom/junyharangstudy/kotlingraphqltest/api/team/repository/TeamQueryDslRepository;", "peopleRepository", "Lcom/junyharangstudy/kotlingraphqltest/api/people/repository/PeopleRepository;", "(Lcom/junyharangstudy/kotlingraphqltest/api/team/repository/TeamRepository;Lcom/junyharangstudy/kotlingraphqltest/api/team/repository/TeamQueryDslRepository;Lcom/junyharangstudy/kotlingraphqltest/api/people/repository/PeopleRepository;)V", "checkUpdateRequest", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;", "teamUpdateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/request/TeamUpdateRequestDto;", "team", "deleteTeam", "Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "", "teamId", "getTeamAndMemberByTeamId", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/response/TeamAndMemberResponseDto;", "getTeamList", "", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/response/TeamResponseDto;", "teamSearchRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/request/TeamSearchRequestDto;", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "processingParameterNotNull", "processingParameterNull", "processingParameterPagingNotNull", "processingTotalElementCount", "", "saveTeam", "teamCreateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/request/TeamCreateRequestDto;", "updateTeam", "kotlin-graphql-test"})
public class TeamService {
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.team.repository.TeamRepository teamRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.team.repository.TeamQueryDslRepository teamQueryDslRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.people.repository.PeopleRepository peopleRepository = null;
    
    public TeamService(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.repository.TeamRepository teamRepository, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.repository.TeamQueryDslRepository teamQueryDslRepository, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.people.repository.PeopleRepository peopleRepository) {
        super();
    }
    
    @org.springframework.transaction.annotation.Transactional
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.Long> saveTeam(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamCreateRequestDto teamCreateRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamResponseDto>> getTeamList(@org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamSearchRequestDto teamSearchRequestDto, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamAndMemberResponseDto> getTeamAndMemberByTeamId(long teamId) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.Long> updateTeam(long teamId, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamUpdateRequestDto teamUpdateRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.Long> deleteTeam(long teamId) {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamResponseDto>> processingParameterNotNull(com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamSearchRequestDto teamSearchRequestDto) {
        return null;
    }
    
    private java.util.List<com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamResponseDto> processingParameterNull() {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamResponseDto>> processingParameterPagingNotNull(com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team checkUpdateRequest(com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamUpdateRequestDto teamUpdateRequestDto, com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team team) {
        return null;
    }
    
    private int processingTotalElementCount() {
        return 0;
    }
}