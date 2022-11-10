package com.mustache.bbspractice2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "article4")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    public ArticleEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
