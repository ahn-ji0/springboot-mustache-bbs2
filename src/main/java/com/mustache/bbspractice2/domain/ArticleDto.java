package com.mustache.bbspractice2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleDto {
    String title;
    String content;

    public ArticleEntity toEntity(){
        return new ArticleEntity(title,content);
    }
}
