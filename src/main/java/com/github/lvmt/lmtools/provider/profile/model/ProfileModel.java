package com.github.lvmt.lmtools.provider.profile.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-09
 */
@Data
@Builder
public class ProfileModel {
    // 商家基础信息
    public long sellerId;
    private String sellerName;
    private String sellerAvatar;

    // 商家标签
    private List<String> sellerTags;

    // 商家直播数据
    private long liveCnt;
    private long newFollowerCnt;
    private long saleAmt;
}
