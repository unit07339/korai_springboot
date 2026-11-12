package com.korai.study03.domain.coupon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CouponResponse {
    private int Id;
    private String code;
    private String name;
    private String discountType;
    private int discountValue;
    private Integer max_discount;
    private int minOrderAmount;
    private int validDays;
    private int isActive;
    private LocalDateTime createAt;
}
