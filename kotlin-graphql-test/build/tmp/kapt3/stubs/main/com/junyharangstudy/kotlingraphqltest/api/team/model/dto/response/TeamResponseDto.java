package com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/response/TeamResponseDto;", "", "teamId", "", "manager", "", "office", "extensionNumber", "mascot", "cleaningDuty", "project", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "kotlin-graphql-test"})
public final class TeamResponseDto {
    private final long teamId = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String manager = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String office = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String extensionNumber = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String mascot = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String cleaningDuty = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String project = null;
    @org.jetbrains.annotations.NotNull
    public static final com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamResponseDto.Companion Companion = null;
    
    public TeamResponseDto(long teamId, @org.jetbrains.annotations.NotNull
    java.lang.String manager, @org.jetbrains.annotations.NotNull
    java.lang.String office, @org.jetbrains.annotations.NotNull
    java.lang.String extensionNumber, @org.jetbrains.annotations.NotNull
    java.lang.String mascot, @org.jetbrains.annotations.NotNull
    java.lang.String cleaningDuty, @org.jetbrains.annotations.NotNull
    java.lang.String project) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/response/TeamResponseDto$Companion;", "", "()V", "teamToDto", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/response/TeamResponseDto;", "team", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;", "kotlin-graphql-test"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamResponseDto teamToDto(@org.jetbrains.annotations.NotNull
        com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team team) {
            return null;
        }
    }
}