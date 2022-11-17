package com.mustache.bbspractice2.controller;

import com.mustache.bbspractice2.domain.dto.ArticleAddRequest;
import com.mustache.bbspractice2.domain.dto.ArticleAddResponse;
import com.mustache.bbspractice2.domain.dto.ArticleDto;
import com.mustache.bbspractice2.service.ArticleService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {
    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable Long id){
        ArticleDto articleDto = articleService.getArticleById(id);
        return ResponseEntity.ok().body(articleDto);
    }
    @PostMapping
    public ResponseEntity<ArticleAddResponse> add(@RequestBody ArticleAddRequest articleAddRequest){
        ArticleAddResponse articleAddResponse = articleService.add(articleAddRequest);
        return ResponseEntity.ok().body(articleAddResponse);
    }
}
