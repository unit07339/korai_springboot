package com.korai.study03.domain.coupon.controller;


import com.korai.study03.domain.coupon.dto.CouponCreateRequest;
import com.korai.study03.domain.coupon.dto.CouponResponse;
import com.korai.study03.domain.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping
    public CouponResponse create(@RequestBody CouponCreateRequest request) {
        System.out.println(request);
        CouponResponse couponResponse = couponService.create(request);
        return couponResponse;
    }

    @GetMapping
    public List<CouponResponse> getAll() {
        return couponService.getAll();
    }

    @GetMapping("/{couponId}")
    public CouponResponse getById(@PathVariable int couponId) {
        return couponService.get(couponId);
    }
}
