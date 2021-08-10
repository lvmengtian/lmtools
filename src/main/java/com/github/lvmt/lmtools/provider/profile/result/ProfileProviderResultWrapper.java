package com.github.lvmt.lmtools.provider.profile.result;

import java.util.List;

import com.github.lvmt.lmtools.provider.IProviderResultWrapper;
import com.github.lvmt.lmtools.provider.profile.model.ProfileModel;

import lombok.Data;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-09
 */
@Data
public class ProfileProviderResultWrapper implements IProviderResultWrapper<ProfileModel> {
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

    @Override
    public ProfileModel build() {
        return ProfileModel.builder()
                .sellerId(this.getSellerId())
                .sellerName(this.getSellerName())
                .sellerAvatar(this.getSellerAvatar())
                .sellerTags(this.getSellerTags())
                .liveCnt(this.getLiveCnt())
                .newFollowerCnt(this.newFollowerCnt)
                .saleAmt(this.saleAmt)
                .build();
    }
}
