package com.woodystudio.api.model;

import lombok.Data;

@Data
public class PagingMeta {
    private int pageSize;
    private int pageNumber;
    private int totalPages;
    private long totalElements;
}
