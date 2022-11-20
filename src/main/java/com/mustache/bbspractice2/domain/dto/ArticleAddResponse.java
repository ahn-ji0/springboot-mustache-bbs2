package com.mustache.bbspractice2.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ArticleAddResponse {
    private Long id;
    private String title;
    private String content;
}
