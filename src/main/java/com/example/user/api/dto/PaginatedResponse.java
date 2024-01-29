package com.example.user.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedResponse<T> {
	
    private Integer pageNo;

    private Integer pageSize;

    private Long totalCount;

    private Integer totalPages;

    private T response;
}
