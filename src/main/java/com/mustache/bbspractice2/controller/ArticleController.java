package com.mustache.bbspractice2.controller;

import com.mustache.bbspractice2.domain.ArticleDto;
import com.mustache.bbspractice2.domain.ArticleEntity;
import com.mustache.bbspractice2.respository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("")
    public String home(){
        return "redirect:/articles/list";
    }

    // add new
    @GetMapping("/new")
    public String addNew(){
        return "articles/new";
    }

    @PostMapping("/post")
    public String postNew(ArticleDto articleDto){
        log.info("title: {}, content: {}",articleDto.getTitle(),articleDto.getContent());
        articleRepository.save(articleDto.toEntity());
        return "redirect:/articles/list";
    }

    // get all
    @GetMapping("/list")
    public String listAll(Model model){
        List<ArticleEntity> entityList = articleRepository.findAll();
        model.addAttribute("articles",entityList);
        return "articles/list";
    }

    // find by Id
    @GetMapping("/{id}")
    public String findSingle(@PathVariable Long id, Model model){
        Optional<ArticleEntity> optionalArticle = articleRepository.findById(id);
        if(!optionalArticle.isEmpty()){
            model.addAttribute("article",optionalArticle.get());
            return "articles/show";
        }
        else {
            return "articles/error";
        }
    }

    //delete
    @GetMapping("/{id}/delete")
    public String deleteSingle(@PathVariable Long id, Model model){
        Optional<ArticleEntity> optionalArticle = articleRepository.findById(id);
        if(!optionalArticle.isEmpty()){
            articleRepository.delete(optionalArticle.get());
            return "redirect:/articles/list";
        }
        else {
            return "articles/error";
        }
    }

    //edit
    @GetMapping("/{id}/edit")
    public String editSingle(@PathVariable Long id, Model model){
        Optional<ArticleEntity> optionalArticle = articleRepository.findById(id);
        if(!optionalArticle.isEmpty()){
            model.addAttribute("article",optionalArticle.get());
            return "articles/edit";
        }
        else {
            return "articles/error";
        }
    }
    @PostMapping("/{id}/update")
    public String updateSingle(@PathVariable Long id, ArticleDto articleDto){
        log.info(articleDto.getTitle(),articleDto.getContent());
        articleRepository.save(articleDto.toEntity(id));
        return "redirect:/articles/list";
    }
}
