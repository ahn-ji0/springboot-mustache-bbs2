package com.mustache.bbspractice2.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleAddResponse {
    private Long id;
    private String title;
    private String content;
}
