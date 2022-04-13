package com.github.lvmt.lmtools.mchecker.model;

import java.util.List;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-04-13
 */
public class SkuExtra {
    private String desc; // 描述
    private List<String> imgList; // 图片列表

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public SkuExtra(String desc, List<String> imgList) {
        this.desc = desc;
        this.imgList = imgList;
    }
}
