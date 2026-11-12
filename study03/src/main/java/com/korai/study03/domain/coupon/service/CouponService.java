package com.korai.study03.domain.coupon.service;

import com.korai.study03.domain.coupon.dto.CouponCreateRequest;
import com.korai.study03.domain.coupon.dto.CouponResponse;
import com.korai.study03.domain.coupon.entity.Coupon;
import com.korai.study03.domain.coupon.mapper.CouponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    @Autowired
    private CouponMapper couponMapper;

    public CouponResponse create(CouponCreateRequest request) {
        Coupon coupon = request.toCoupon();
        System.out.println(coupon);
        couponMapper.insert(coupon);
        System.out.println(coupon);
        return coupon.toCouponResponse();
    }

    public List<CouponResponse> getAll() {
        return couponMapper.findAll()
                .stream()
                .map(Coupon::toCouponResponse)
                .toList();
    }

    public CouponResponse get(int couponId) {
        return couponMapper.findById(couponId).toCouponResponse();
    }

    /* 없는 번호 오류 해결
     public CouponResponse get(int couponId) {
    Coupon coupon = couponMapper.findById(couponId);
    if (coupon == null) {
        return null;
    }
    return coupon.toCouponResponse();
}
    */
}
