package com.junyharangstudy.kotlingraphqltest.api.team.repository;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\t"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/team/repository/TeamQueryDslRepository;", "", "findBySearchAndPaging", "", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;", "pageRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/common/constant/PageRequestDto;", "teamSearchRequestDto", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/request/TeamSearchRequestDto;", "kotlin-graphql-test"})
public abstract interface TeamQueryDslRepository {
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team> findBySearchAndPaging(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.common.constant.PageRequestDto pageRequestDto, @org.jetbrains.annotations.Nullable
    com.junyharangstudy.kotlingraphqltest.api.team.model.dto.request.TeamSearchRequestDto teamSearchRequestDto);
}