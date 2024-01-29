package com.example.user.api.utils;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.user.api.dto.PaginatedResponse;

@Component
public class CommonUtils {

	public <T> PaginatedResponse<T> calculatePaginationAndPrepareResponse(final Page<?> page, final T response) {
        final PaginatedResponse<T> paginatedResponse = new PaginatedResponse<>();
        paginatedResponse.setTotalCount(page.getTotalElements());
        paginatedResponse.setTotalPages(page.getTotalPages());
        paginatedResponse.setPageNo(page.getNumber() + 1);
        paginatedResponse.setPageSize(page.getContent().size());
        paginatedResponse.setResponse(response);
        return paginatedResponse;
    }
}
