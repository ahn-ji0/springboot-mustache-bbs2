package com.mustache.bbspractice2.controller;

import com.mustache.bbspractice2.domain.dto.ArticleDto;
import com.mustache.bbspractice2.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ArticleRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    @Test
    @DisplayName("1개의 Json형태로 Response가 잘 오는지") //비즈니스로직(Service를 검증하지 않음) Controller만 검증
    void jsonResponse() throws Exception{
        ArticleDto articleDto = ArticleDto.builder()
                .id(15L)
                .title("테스트합니다")
                .content("테스트 내용입니다")
                .build();

        given(articleService.getArticleById(15L))
                .willReturn(articleDto);

        Long articleId = 15L;

        String url = String.format("/api/v1/articles/%d",articleId);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value("테스트합니다"))
                .andDo(print());
        verify(articleService).getArticleById(articleId);
    }
}