package com.junyharangstudy.kotlingraphqltest.common.constant;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0013\b\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0002\u0010\u0004B5\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/common/constant/Pagination;", "", "page", "Lorg/springframework/data/domain/Page;", "(Lorg/springframework/data/domain/Page;)V", "totalPages", "", "totalElements", "", "currentElements", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Ljava/lang/Long;", "calculateTotalPages", "numberOfElements", "Companion", "kotlin-graphql-test"})
public final class Pagination {
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer totalPages;
    @org.jetbrains.annotations.Nullable
    private java.lang.Long totalElements;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer page;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer currentElements;
    @org.jetbrains.annotations.NotNull
    public static final com.junyharangstudy.kotlingraphqltest.common.constant.Pagination.Companion Companion = null;
    
    public Pagination(@org.jetbrains.annotations.Nullable
    java.lang.Integer totalPages, @org.jetbrains.annotations.Nullable
    java.lang.Long totalElements, @org.jetbrains.annotations.Nullable
    java.lang.Integer page, @org.jetbrains.annotations.Nullable
    java.lang.Integer currentElements) {
        super();
    }
    
    public Pagination(@org.jetbrains.annotations.NotNull
    org.springframework.data.domain.Page<?> page) {
        super();
    }
    
    private final int calculateTotalPages(long totalElements, int numberOfElements) {
        return 0;
    }
    
    public Pagination() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f2\u0006\u0010\r\u001a\u00020\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/junyharangstudy/kotlingraphqltest/common/constant/Pagination$Companion;", "", "()V", "processPaging", "Lorg/springframework/data/domain/PageRequest;", "page", "", "perPageSize", "queryDslPagingProcessing", "", "T", "jpaQuery", "Lcom/querydsl/jpa/impl/JPAQuery;", "pageable", "Lorg/springframework/data/domain/Pageable;", "kotlin-graphql-test"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final org.springframework.data.domain.PageRequest processPaging(int page, int perPageSize) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final <T extends java.lang.Object>java.util.List<T> queryDslPagingProcessing(@org.jetbrains.annotations.NotNull
        com.querydsl.jpa.impl.JPAQuery<T> jpaQuery, @org.jetbrains.annotations.NotNull
        org.springframework.data.domain.Pageable pageable) {
            return null;
        }
    }
}