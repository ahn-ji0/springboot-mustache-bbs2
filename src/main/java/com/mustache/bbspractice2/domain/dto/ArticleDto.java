package com.mustache.bbspractice2.domain.dto;

import com.mustache.bbspractice2.domain.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
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
