package com.mustache.bbspractice2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
// @AllArgsConstructor 하면 no primary or single constructor 오류
public class ArticleDto {
    private Long id;
    private String title;
    private String content;

    public ArticleDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public ArticleEntity toEntity(){
        return new ArticleEntity(title,content);
    }
    public ArticleEntity toEntity(Long id){
        return new ArticleEntity(id,title,content);
    }
}
