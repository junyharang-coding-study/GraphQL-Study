package com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fBK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/response/TeamAndMemberResponseDto;", "", "teamId", "", "manager", "", "office", "extensionNumber", "mascot", "cleaningDuty", "project", "members", "", "Lcom/junyharangstudy/kotlingraphqltest/api/people/model/dto/response/PeopleResponseDto;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Companion", "kotlin-graphql-test"})
public final class TeamAndMemberResponseDto {
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
    private final java.util.List<com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto> members = null;
    @org.jetbrains.annotations.NotNull
    public static final com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamAndMemberResponseDto.Companion Companion = null;
    
    public TeamAndMemberResponseDto(long teamId, @org.jetbrains.annotations.NotNull
    java.lang.String manager, @org.jetbrains.annotations.NotNull
    java.lang.String office, @org.jetbrains.annotations.NotNull
    java.lang.String extensionNumber, @org.jetbrains.annotations.NotNull
    java.lang.String mascot, @org.jetbrains.annotations.NotNull
    java.lang.String cleaningDuty, @org.jetbrains.annotations.NotNull
    java.lang.String project, @org.jetbrains.annotations.NotNull
    java.util.List<com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto> members) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a8\u0006\n"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/response/TeamAndMemberResponseDto$Companion;", "", "()V", "entityToDto", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/dto/response/TeamAndMemberResponseDto;", "team", "Lcom/junyharangstudy/kotlingraphqltest/api/team/model/entity/Team;", "peopleResponseDto", "", "Lcom/junyharangstudy/kotlingraphqltest/api/people/model/dto/response/PeopleResponseDto;", "kotlin-graphql-test"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.junyharangstudy.kotlingraphqltest.api.team.model.dto.response.TeamAndMemberResponseDto entityToDto(@org.jetbrains.annotations.NotNull
        com.junyharangstudy.kotlingraphqltest.api.team.model.entity.Team team, @org.jetbrains.annotations.NotNull
        java.util.List<com.junyharangstudy.kotlingraphqltest.api.people.model.dto.response.PeopleResponseDto> peopleResponseDto) {
            return null;
        }
    }
}