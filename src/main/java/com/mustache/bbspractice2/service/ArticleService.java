package com.mustache.bbspractice2.service;

import com.mustache.bbspractice2.domain.dto.ArticleDto;
import com.mustache.bbspractice2.domain.entity.ArticleEntity;
import com.mustache.bbspractice2.respository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleDto getArticleById(Long id) {
        Optional<ArticleEntity> optionalArticle = articleRepository.findById(id);
        ArticleEntity articleEntity = optionalArticle.get();
        ArticleDto articleDto = ArticleEntity.of(articleEntity);
        return articleDto;
    }
}
