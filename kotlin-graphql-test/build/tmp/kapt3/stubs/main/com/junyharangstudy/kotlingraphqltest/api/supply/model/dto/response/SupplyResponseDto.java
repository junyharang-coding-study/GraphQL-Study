package com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.response;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/supply/model/dto/response/SupplyResponseDto;", "", "supplyId", "", "teamId", "", "(Ljava/lang/String;J)V", "Companion", "kotlin-graphql-test"})
public final class SupplyResponseDto {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String supplyId = null;
    private final long teamId = 0L;
    @org.jetbrains.annotations.NotNull
    public static final com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.response.SupplyResponseDto.Companion Companion = null;
    
    public SupplyResponseDto(@org.jetbrains.annotations.NotNull
    java.lang.String supplyId, long teamId) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/supply/model/dto/response/SupplyResponseDto$Companion;", "", "()V", "supplyToDto", "Lcom/junyharangstudy/kotlingraphqltest/api/supply/model/dto/response/SupplyResponseDto;", "supply", "Lcom/junyharangstudy/kotlingraphqltest/api/supply/model/entity/Supply;", "kotlin-graphql-test"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.junyharangstudy.kotlingraphqltest.api.supply.model.dto.response.SupplyResponseDto supplyToDto(@org.jetbrains.annotations.NotNull
        com.junyharangstudy.kotlingraphqltest.api.supply.model.entity.Supply supply) {
            return null;
        }
    }
}