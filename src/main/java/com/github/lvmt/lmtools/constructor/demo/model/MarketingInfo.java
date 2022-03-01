package com.github.lvmt.lmtools.constructor.demo.model;

import java.util.ArrayList;
import java.util.List;

import sun.swing.StringUIClientPropertyKey;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-02-28
 * 营销信息
 */
public class MarketingInfo {
    private List<CouponInfo> couponInfoList;

    // mock数据模拟下游请求
    public static MarketingInfo mockMarketingInfo() {
        MarketingInfo marketingInfo = new MarketingInfo();
        List<CouponInfo> couponInfoList = new ArrayList<>();
        couponInfoList.add(new CouponInfo(50, 5));
        marketingInfo.setCouponInfoList(couponInfoList);
        // 模拟下游请求耗时
        try {
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return marketingInfo;
    }

    public List<CouponInfo> getCouponInfoList() {
        return couponInfoList;
    }

    public void setCouponInfoList(List<CouponInfo> couponInfoList) {
        this.couponInfoList = couponInfoList;
    }

    @Override
    public String toString() {
        String str = "";
        for (CouponInfo couponInfo : couponInfoList) {
            if (!"".equals(str)) { str += ";";}
            str += couponInfo.toString();
        }
        return super.toString();
    }
}
