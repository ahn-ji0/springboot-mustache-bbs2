package com.mustache.bbspractice2.controller;

import com.mustache.bbspractice2.domain.ArticleDto;
import com.mustache.bbspractice2.respository.ArticleRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/new")
    public String addNew(){
        return "new";
    }

    @PostMapping("/post")
    public String postNew(ArticleDto articleDto){
        log.info("title: {}, content: {}",articleDto.getTitle(),articleDto.getContent());
        articleRepository.save(articleDto.toEntity());
        return "redirect:/articles/new";
    }
}
