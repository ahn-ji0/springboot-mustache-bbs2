package com.mustache.bbspractice2.domain.dto;

import com.mustache.bbspractice2.domain.entity.ArticleEntity;
import lombok.*;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Setter
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
