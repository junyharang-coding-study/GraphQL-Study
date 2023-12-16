package com.junyharangstudy.kotlingraphqltest.api.people.service;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u0005\u001a\u00020\u0004H&J(\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t0\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J&\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t0\u00032\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H&\u00a8\u0006\u0016"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/people/service/PeopleService;", "", "deletePeople", "Lcom/junyharangstudy/kotlingraphqltest/common/constant/DefaultResponse;", "", "peopleId", "getPeopleByPeopleId", "Lcom/junyharangstudy/kotlingraphqltest/api/people/model/dto/response/PeopleResponseDto;", "getPeopleList", "", "peopleSearchRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/people/model/dto/request/PeopleSearchRequestDto;", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "getPeopleListByTeamId", "teamId", "savePeople", "peopleCreateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/people/model/dto/request/PeopleCreateRequestDto;", "updatePeople", "peopleUpdateRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/people/model/dto/request/PeopleUpdateRequestDto;", "kotlin-graphql-test"})
public abstract interface PeopleService {
    
    @org.jetbrains.annotations.NotNull
    public abstract com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.Long> savePeople(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleCreateRequestDto peopleCreateRequestDto);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto>> getPeopleList(@org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleSearchRequestDto peopleSearchRequestDto, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto> getPeopleByPeopleId(long peopleId);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.util.List<com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto>> getPeopleListByTeamId(long teamId, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.Long> updatePeople(long peopleId, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.people.model.dto.request.PeopleUpdateRequestDto peopleUpdateRequestDto);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.junyharangstudy.kotlingraphqltest.common.constant.DefaultResponse<java.lang.Long> deletePeople(long peopleId);
}