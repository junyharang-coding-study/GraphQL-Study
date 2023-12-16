package com.junyharangstudy.kotlingraphqltest.api.supply.model.entity;

@jakarta.persistence.Entity
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/supply/model/entity/Supply;", "", "supplyId", "", "team", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;", "(Ljava/lang/String;Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;)V", "getSupplyId", "()Ljava/lang/String;", "setSupplyId", "(Ljava/lang/String;)V", "getTeam", "()Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;", "setTeam", "(Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;)V", "updateTeam", "", "kotlin-graphql-test"})
public final class Supply {
    @jakarta.persistence.Id
    @org.jetbrains.annotations.NotNull
    private java.lang.String supplyId;
    @jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @jakarta.persistence.JoinColumn(name = "team_id")
    @org.jetbrains.annotations.NotNull
    private com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team team;
    
    public Supply(@org.jetbrains.annotations.NotNull
    java.lang.String supplyId, @org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team team) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSupplyId() {
        return null;
    }
    
    public final void setSupplyId(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team getTeam() {
        return null;
    }
    
    public final void setTeam(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team p0) {
    }
    
    public final void updateTeam(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team team) {
    }
}