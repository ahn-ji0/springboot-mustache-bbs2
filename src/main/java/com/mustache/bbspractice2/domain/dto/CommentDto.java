package com.mustache.bbspractice2.domain.dto;

import com.mustache.bbspractice2.domain.entity.ArticleEntity;
import com.mustache.bbspractice2.domain.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentDto {
    private String userName;
    private String commentContent;

    public CommentEntity toEntity(ArticleEntity articleEntity){
        return new CommentEntity(this.userName,this.commentContent,articleEntity);
    }
}
