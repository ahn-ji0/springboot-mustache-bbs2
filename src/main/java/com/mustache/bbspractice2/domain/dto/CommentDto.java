package com.mustache.bbspractice2.domain.dto;

import com.mustache.bbspractice2.domain.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentDto {
    private String userName;
    private String content;
}
