package com.korai.study02.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Study01", description = "HTTP 메서드별 매핑 연습 API")
@RequestMapping("/api/study") // 공통주소일때/c
@RestController
public class StudyController01 {

//    private String test; /diff 연습용


    @Operation(summary = "POST 요청 테스트", description = "POST /api/study/a 호출 시 \"2\"를 반환합니다.")
    @ApiResponse(responseCode = "200", description = "성공 - \"2\" 반환")
    @PostMapping("/a")
    public String post01() {
        return "2";
    }

    @Operation(summary = "GET 요청 테스트", description = "GET /api/study/b 호출 시 \"1\"을 반환합니다.")
    @ApiResponse(responseCode = "200", description = "성공 - \"1\" 반환")
    @GetMapping("/b")
    public String get01() {
        return "1";
    }


    @Operation(summary = "PUT 요청 테스트", description = "PUT /api/study/c 호출 시 \"3\"을 반환합니다.")
    @ApiResponse(responseCode = "200", description = "성공 - \"3\" 반환")
    @PutMapping("/c")
    public String put01() {
        return "3";
    }

    @Operation(summary = "DELETE 요청 테스트", description = "DELETE /api/study/d 호출 시 \"4\"를 반환합니다.")
    @ApiResponse(responseCode = "200", description = "성공 - \"4\" 반환")
    @DeleteMapping("/d")
    public String delete01() {
        return "4";
    }



}
