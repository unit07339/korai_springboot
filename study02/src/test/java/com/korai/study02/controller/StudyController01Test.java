package com.korai.study02.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class StudyController01Test {

    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    // ===== 1. 실제 API 호출 테스트 =====

    @Test
    @DisplayName("POST /api/study/a → \"2\"")
    void post01() throws Exception {
        mockMvc.perform(post("/api/study/a"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }

    @Test
    @DisplayName("GET /api/study/b → \"1\"")
    void get01() throws Exception {
        mockMvc.perform(get("/api/study/b"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    @DisplayName("PUT /api/study/c → \"3\"")
    void put01() throws Exception {
        mockMvc.perform(put("/api/study/c"))
                .andExpect(status().isOk())
                .andExpect(content().string("3"));
    }

    @Test
    @DisplayName("DELETE /api/study/d → \"4\"")
    void delete01() throws Exception {
        mockMvc.perform(delete("/api/study/d"))
                .andExpect(status().isOk())
                .andExpect(content().string("4"));
    }

    @Test
    @DisplayName("허용되지 않은 메서드 호출 시 405 (GET /api/study/a)")
    void methodNotAllowed() throws Exception {
        mockMvc.perform(get("/api/study/a"))
                .andExpect(status().isMethodNotAllowed());
    }

    // ===== 2. OpenAPI 문서(/v3/api-docs) 검증 테스트 =====

    @Test
    @DisplayName("OpenAPI 문서에 4개 엔드포인트가 HTTP 메서드별로 등록되어 있다")
    void openApiDocsContainsEndpoints() throws Exception {
        mockMvc.perform(get("/v3/api-docs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.openapi").exists())
                .andExpect(jsonPath("$.paths['/api/study/a'].post").exists())
                .andExpect(jsonPath("$.paths['/api/study/b'].get").exists())
                .andExpect(jsonPath("$.paths['/api/study/c'].put").exists())
                .andExpect(jsonPath("$.paths['/api/study/d'].delete").exists());
    }

    @Test
    @DisplayName("OpenAPI 문서에 @Operation summary와 @Tag가 반영되어 있다")
    void openApiDocsContainsSummaryAndTag() throws Exception {
        mockMvc.perform(get("/v3/api-docs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.paths['/api/study/a'].post.summary").value("POST 요청 테스트"))
                .andExpect(jsonPath("$.paths['/api/study/b'].get.summary").value("GET 요청 테스트"))
                .andExpect(jsonPath("$.paths['/api/study/c'].put.summary").value("PUT 요청 테스트"))
                .andExpect(jsonPath("$.paths['/api/study/d'].delete.summary").value("DELETE 요청 테스트"))
                .andExpect(jsonPath("$.paths['/api/study/b'].get.tags[0]").value("Study01"));
    }
}
