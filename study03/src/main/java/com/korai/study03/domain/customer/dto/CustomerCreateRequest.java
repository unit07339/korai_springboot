package com.korai.study03.domain.customer.dto;


import com.korai.study03.domain.customer.entity.Customer;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

// entity명 + 목적 + 요청인지 응답인지
@Data
public class CustomerCreateRequest {
    private String name;
    private String phone;
    private String email;
    private LocalDate birthDate;
    private String district;
    private String address;
    private String grade;
    private boolean marketingAgreed;

    public Customer toCustomer() {
        return new Customer(0, name, phone, email, birthDate, district, address, grade, marketingAgreed, LocalDateTime.now());
    }
}

// 클라이언트와 요청과 응답을 맞춤