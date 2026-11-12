package com.korai.study03.domain.coupon.mapper;

import com.korai.study03.domain.coupon.entity.Coupon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CouponMapper {
    int insert(Coupon coupon);

    List<Coupon> findAll();

//            (@Param("couponId") int couponId);

    Coupon findById(@Param("couponId") int couponId);

}
