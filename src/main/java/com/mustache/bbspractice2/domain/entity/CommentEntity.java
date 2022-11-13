package com.mustache.bbspractice2.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private String userName;
    private String commentContent;

    @ManyToOne
    @JoinColumn(name="id")
    private ArticleEntity articleEntity;

    public CommentEntity(String userName, String commentContent, ArticleEntity articleEntity) {
        this.userName = userName;
        this.commentContent = commentContent;
        this.articleEntity = articleEntity;
    }
}
