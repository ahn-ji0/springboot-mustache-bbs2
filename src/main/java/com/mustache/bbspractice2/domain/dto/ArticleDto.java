package com.mustache.bbspractice2.domain.dto;

import com.mustache.bbspractice2.domain.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleDto {
    private String title;
    private String content;

    public ArticleEntity toEntity(){
        return new ArticleEntity(title,content);
    }
    public ArticleEntity toEntity(Long id){
        return new ArticleEntity(id,title,content);
    }
}
