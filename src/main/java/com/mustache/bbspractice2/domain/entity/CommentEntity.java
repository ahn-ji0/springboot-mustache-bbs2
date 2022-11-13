package com.mustache.bbspractice2.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private String userName;

    @ManyToOne
    @JoinColumn(name="id")
    private ArticleEntity articleEntity;

    public CommentEntity(String userName, ArticleEntity articleEntity) {
        this.userName = userName;
        this.articleEntity = articleEntity;
    }
}
