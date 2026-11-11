package com.korai.study01.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// ctrl f5 서버 재실행
// 200번대 ok, 300번대 리다이렉트, 400 클라이언트 오류 응답, 500 서버 오류 응답


@Controller
public class StudyController01 {
    // 메서드 단위로 요청과 응답
    // body 는 데이터
//    @ResponseBody // responseBody 있으면 return 이 실제 데이터. 없으면 return이 경로임.

    @Value("${user.dir}")
    private String projectDir;


    @GetMapping("/api/get01")
    public String get01() {
        return "/index.html"; // 프록시, 라우팅.  / 빼면 상대경로가 됨 RestController 에서 rest 빼서.
    }

    @GetMapping("/api/get02")
    public String get02() {
        System.out.println(projectDir + "/src/main/resources/upload");
        String uploadPath = projectDir + "/src/main/resources/upload";
        return "/file:///" + uploadPath + "/123.png";
    }

    @ResponseBody
    @GetMapping("/api/get03")
    public String get03() {
        return "데이터 응답!!";
    }

}

// responseBody 가 있으면 return 값 그대로 없으면 주소


