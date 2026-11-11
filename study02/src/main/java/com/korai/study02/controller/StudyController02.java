package com.korai.study02.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Study02", description = "List / Map 응답 연습 API")
@RequestMapping("/api/study2") // 공통주소
@RestController
public class StudyController02 {

    // ===================== List 응답 =====================

    @Operation(summary = "List<String> 응답", description = "문자열 리스트를 JSON 배열로 반환합니다.")
    @ApiResponse(responseCode = "200", description = "성공 - [\"사과\", \"바나나\", \"포도\"] 반환")
    @GetMapping("/list/strings")
    public List<String> getStringList() {
        List<String> fruits = new ArrayList<>();
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("포도");
        return fruits; // ["사과","바나나","포도"]
    }

    @Operation(summary = "List<Integer> 응답", description = "List.of()로 만든 숫자 리스트를 반환합니다.")
    @ApiResponse(responseCode = "200", description = "성공 - [10, 20, 30, 40] 반환")
    @GetMapping("/list/numbers")
    public List<Integer> getNumberList() {
        return List.of(10, 20, 30, 40); // List.of는 수정 불가능한(immutable) 리스트
    }


    // ===================== Map 응답 =====================

    @Operation(summary = "Map<String, Object> 응답", description = "Map을 JSON 객체로 반환합니다.")
    @ApiResponse(responseCode = "200", description = "성공 - {\"name\":\"홍길동\",\"age\":20,\"student\":true} 반환")
    @GetMapping("/map")
    public Map<String, Object> getMap() {
        Map<String, Object> user = new LinkedHashMap<>(); // LinkedHashMap: 넣은 순서대로 출력
        user.put("name", "홍길동");
        user.put("age", 20);
        user.put("student", true);
        return user; // {"name":"홍길동","age":20,"student":true}
    }

    @Operation(summary = "Map.of() 응답", description = "Map.of()로 간단하게 만든 Map을 반환합니다. (키 순서는 보장되지 않음)")
    @ApiResponse(responseCode = "200", description = "성공 - {\"code\":200,\"message\":\"OK\"} 반환")
    @GetMapping("/map/simple")
    public Map<String, Object> getSimpleMap() {
        return Map.of("code", 200, "message", "OK");
    }


    // ===================== List + Map 조합 =====================

    @Operation(summary = "List<Map> 응답", description = "Map 여러 개를 담은 리스트(객체 배열)를 반환합니다.")
    @ApiResponse(responseCode = "200", description = "성공 - [{\"id\":1,\"name\":\"홍길동\"}, ...] 반환")
    @GetMapping("/list/maps")
    public List<Map<String, Object>> getListOfMaps() {
        List<Map<String, Object>> users = new ArrayList<>();

        Map<String, Object> user1 = new LinkedHashMap<>();
        user1.put("id", 1);
        user1.put("name", "홍길동");
        users.add(user1);

        Map<String, Object> user2 = new LinkedHashMap<>();
        user2.put("id", 2);
        user2.put("name", "김철수");
        users.add(user2);

        return users; // [{"id":1,"name":"홍길동"},{"id":2,"name":"김철수"}]
    }

    @Operation(summary = "Map 안에 List 응답", description = "실무에서 자주 쓰는 형태: 응답 코드 + 데이터 목록 + 개수")
    @ApiResponse(responseCode = "200", description = "성공 - {\"status\":\"success\",\"count\":3,\"data\":[...]} 반환")
    @GetMapping("/map/list")
    public Map<String, Object> getMapWithList() {
        List<String> data = List.of("Java", "Spring", "JPA");

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", "success");
        result.put("count", data.size());
        result.put("data", data);
        return result; // {"status":"success","count":3,"data":["Java","Spring","JPA"]}
    }

}
