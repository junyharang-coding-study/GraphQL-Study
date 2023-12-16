package com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/api/software/model/dto/request/SoftwareCreateRequestDto;", "", "softwareId", "", "usedBy", "developedBy", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getDevelopedBy", "getSoftwareId", "getUsedBy", "toEntity", "Lcom/junyharangstudy/kotlingraphqltest/api/software/model/entity/Software;", "softwareCreateDto", "kotlin-graphql-test"})
public final class SoftwareCreateRequestDto {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String softwareId = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String usedBy = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String developedBy = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String description = null;
    
    public SoftwareCreateRequestDto(@jakarta.validation.constraints.NotBlank
    @org.jetbrains.annotations.NotNull
    java.lang.String softwareId, @jakarta.validation.constraints.NotBlank
    @org.jetbrains.annotations.NotNull
    java.lang.String usedBy, @jakarta.validation.constraints.NotBlank
    @org.jetbrains.annotations.NotNull
    java.lang.String developedBy, @org.jetbrains.annotations.Nullable
    java.lang.String description) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSoftwareId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUsedBy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDevelopedBy() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.junyharangstudy.kotlingraphqltest.api.software.model.entity.Software toEntity(@org.jetbrains.annotations.NotNull
    com.junyharangstudy.kotlingraphqltest.api.software.model.dto.request.SoftwareCreateRequestDto softwareCreateDto) {
        return null;
    }
}