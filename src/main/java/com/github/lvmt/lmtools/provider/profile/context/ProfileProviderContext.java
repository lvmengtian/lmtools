package com.github.lvmt.lmtools.provider.profile.context;

import java.util.List;

import com.github.lvmt.lmtools.provider.IProviderContext;

import lombok.Data;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2021-08-09
 */
@Data
public class ProfileProviderContext implements IProviderContext {
    private List<Long> sellerIdList;
}
