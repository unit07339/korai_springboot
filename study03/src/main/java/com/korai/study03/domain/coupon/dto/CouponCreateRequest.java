package com.korai.study03.domain.coupon.dto;

import com.korai.study03.domain.coupon.entity.Coupon;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CouponCreateRequest {
    private String code;
    private String name;
    private String discountType;
    private int discountValue;
    private Integer maxDiscount;
    private int minOrderAmount;
    private int validDays;
    private int isActive;
    private LocalDateTime createdAt;

    public Coupon toCoupon() {
        return new Coupon(0, code, name, discountType, discountValue, maxDiscount, minOrderAmount, validDays, isActive, createdAt);
    }

}