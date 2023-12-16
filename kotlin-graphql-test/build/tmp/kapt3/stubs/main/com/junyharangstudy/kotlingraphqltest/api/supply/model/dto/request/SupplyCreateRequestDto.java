package com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.request;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/supply/model/dto/request/SupplyCreateRequestDto;", "", "supplyId", "", "teamId", "", "(Ljava/lang/String;J)V", "getSupplyId", "()Ljava/lang/String;", "getTeamId", "()J", "toEntity", "Lcom/junyharangstudy/kotlingraphqltest/api/supply/model/entity/Supply;", "team", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;", "kotlin-graphql-test"})
public final class SupplyCreateRequestDto {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String supplyId = null;
    private final long teamId = 0L;
    
    public SupplyCreateRequestDto(@jakarta.validation.constraints.NotBlank
    @org.jetbrains.annotations.NotNull
    java.lang.String supplyId, @jakarta.validation.constraints.NotNull
    @jakarta.validation.constraints.Min(value = 1L)
    long teamId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSupplyId() {
        return null;
    }
    
    public final long getTeamId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.junyharangstudy.kotlingraphqltest.api.supply.model.entity.Supply toEntity(@org.jetbrains.annotations.NotNull
    java.lang.String supplyId, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team team) {
        return null;
    }
}