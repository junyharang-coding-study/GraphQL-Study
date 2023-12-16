package com.junyharangstudy.kotlingraphqltest.api.people.service;

@org.springframework.stereotype.Service
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0012J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0017J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0017J(\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00150\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017J&\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00150\u000f2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J5\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00150\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0012\u00a2\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015H\u0012J\u001c\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00150\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0012J\b\u0010 \u001a\u00020!H\u0012J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010#\u001a\u00020$H\u0017J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/people/service/PeopleServiceImpl;", "Lcom/junyharangstudy/kotlingraphqltest/api/people/service/PeopleService;", "peopleRepository", "Lcom/junyharangstudy/kotlingraphqltest/api/people/repository/PeopleRepository;", "teamRepository", "Lcom/junyharangstudy/kotlingraphqltest/api/team/repository/TeamRepository;", "peopleQueryDslRepository", "Lcom/junyharangstudy/kotlingraphqltest/api/people/repository/PeopleQueryDslRepository;", "(Lcom/junyharangstudy/kotlingraphqltest/api/people/repository/PeopleRepository;Lcom/junyharangstudy/kotlingraphqltest/api/team/repository/TeamRepository;Lcom/junyharangstudy/kotlingraphqltest/api/people/repository/PeopleQueryDslRepository;)V", "checkUpdateRequest", "Lcom/junyharangstudy/kotlingraphqltest/api/people/model/entity/People;", "peopleUpdateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/people/model/dto/request/PeopleUpdateRequestDto;", "people", "deletePeople", "Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "", "peopleId", "getPeopleByPeopleId", "Lcom/junyharangstudy/kotlingraphqltest/api/people/model/dto/response/PeopleResponseDto;", "getPeopleList", "", "peopleSearchRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/people/model/dto/request/PeopleSearchRequestDto;", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "getPeopleListByTeamId", "teamId", "processingParameterNotNull", "(Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;Lcom/junyharangstudy/kotlingraphqltest/api/people/model/dto/request/PeopleSearchRequestDto;Ljava/lang/Long;)Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "processingParameterNull", "processingParameterPagingNotNull", "processingTotalElementCount", "", "savePeople", "peopleCreateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/people/model/dto/request/PeopleCreateRequestDto;", "updatePeople", "kotlin-graphql-test"})
public class PeopleServiceImpl implements com.junyharangstudy.kotlingraphqltest.api.people.service.PeopleService {
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.people.repository.PeopleRepository peopleRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.team.repository.TeamRepository teamRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.junyharangstudy.kotlingraphqltest.api.people.repository.PeopleQueryDslRepository peopleQueryDslRepository = null;
    
    public PeopleServiceImpl(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.people.repository.PeopleRepository peopleRepository, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.repository.TeamRepository teamRepository, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.people.repository.PeopleQueryDslRepository peopleQueryDslRepository) {
        super();
    }
    
    @org.springframework.transaction.annotation.Transactional
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.Long> savePeople(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleCreateRequestDto peopleCreateRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto>> getPeopleList(@org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleSearchRequestDto peopleSearchRequestDto, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto>> getPeopleListByTeamId(long teamId, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto> getPeopleByPeopleId(long peopleId) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.Long> updatePeople(long peopleId, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleUpdateRequestDto peopleUpdateRequestDto) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.Long> deletePeople(long peopleId) {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto>> processingParameterNotNull(com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleSearchRequestDto peopleSearchRequestDto, java.lang.Long teamId) {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto>> processingParameterPagingNotNull(com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto) {
        return null;
    }
    
    private java.util.List<com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto> processingParameterNull() {
        return null;
    }
    
    private com.junyharangstudy.kotlingraphqltest.api.people.model.entity.People checkUpdateRequest(com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleUpdateRequestDto peopleUpdateRequestDto, com.junyharangstudy.kotlingraphqltest.api.people.model.entity.People people) {
        return null;
    }
    
    private int processingTotalElementCount() {
        return 0;
    }
}