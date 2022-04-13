package com.github.lvmt.lmtools.mchecker;

import java.util.List;

import com.github.lvmt.lmtools.mchecker.model.MCheckerRuleConfig;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-02-25
 */
public interface IMChecker {

    default <T> void check(T obj, List<MCheckerRuleConfig> ruleList) {
        check(obj, ruleList, false);
    };

    <T> void check(T obj, List<MCheckerRuleConfig> ruleList, boolean failFast);
}
