package com.mustache.bbspractice2.domain.entity;

import com.mustache.bbspractice2.domain.dto.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor // 안하면 findAll 할때 no default constructor for entity 오류
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
    public static ArticleDto of(ArticleEntity articleEntity){
        return new ArticleDto(articleEntity.getId(), articleEntity.getTitle(),articleEntity.getContent());
    }
}
