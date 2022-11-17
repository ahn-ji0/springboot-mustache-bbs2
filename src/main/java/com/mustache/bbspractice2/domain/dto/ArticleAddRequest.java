package com.mustache.bbspractice2.domain.dto;

import com.mustache.bbspractice2.domain.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleAddRequest {
    private String title;
    private String content;

    public ArticleEntity toEntity(){
        return new ArticleEntity(this.title,this.content);
    }
}
