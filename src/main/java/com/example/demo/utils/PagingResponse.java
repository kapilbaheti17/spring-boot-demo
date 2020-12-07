package com.example.demo.utils;

import java.util.List;

import com.example.demo.CardHolder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PagingResponse {
	
	public PagingResponse(long totalElements, long number, long numberOfElements, long offset, long totalPages,
			List<CardHolder> content) {
		// TODO Auto-generated constructor stub
	}
	/**
     * entity count
     */
    private Long count;
    /**
     * page number, 0 indicate the first page.
     */
    private Long pageNumber;
    /**
     * size of page, 0 indicate infinite-sized.
     */
    private Long pageSize;
    /**
     * Offset from the of pagination.
     */
    private Long pageOffset;
    /**
     * the number total of pages.
     */
    private Long pageTotal;
    /**
     * elements of page.
     */
    private List<CardHolder> elements;
}
