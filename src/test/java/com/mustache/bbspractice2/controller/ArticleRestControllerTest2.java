package com.mustache.bbspractice2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustache.bbspractice2.domain.dto.ArticleAddRequest;
import com.mustache.bbspractice2.domain.dto.ArticleAddResponse;
import com.mustache.bbspractice2.domain.dto.ArticleDto;
import com.mustache.bbspractice2.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest2 {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("findById 테스트(get)")
    void findById() throws Exception {
        Long id = 1l;
        ArticleDto articleDto = ArticleDto.builder()
                .id(1l)
                .title("ppang")
                .content("hello").build();

        given(articleService.getArticleById(id))
                .willReturn(articleDto);
        String url = String.format("/api/v1/articles/%d",id);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value("ppang"))
                .andExpect(jsonPath("$.content").exists());

        verify(articleService).getArticleById(id);
    }

    @Test
    @DisplayName("add 테스트(post)")
    void add() throws Exception {
        ArticleAddRequest articleAddRequest = new ArticleAddRequest("테스트","이건 테스트 입니다.");
        given(articleService.add(any()))
                .willReturn(new ArticleAddResponse(1l,articleAddRequest.getTitle(),articleAddRequest.getContent()));
        String url = "/api/v1/articles";
        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(articleAddRequest)))

                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").value("테스트"))
                .andExpect(jsonPath("$.content").value("이건 테스트 입니다."));
    }
}