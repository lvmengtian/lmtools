package com.github.lvmt.lmtools.constructor.demo.model;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-02-28
 * 券信息,即 满${condition}元减${discount}元
 */
public class CouponInfo {
    // 券条件
    private int condition;
    // 券折扣
    private int discount;

    public CouponInfo(int condition, int discount) {
        this.condition = condition;
        this.discount = discount;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
