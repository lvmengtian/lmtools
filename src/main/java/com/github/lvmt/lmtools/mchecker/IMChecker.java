package com.github.lvmt.lmtools.mchecker;

import java.util.List;

import com.github.lvmt.lmtools.mchecker.model.MCheckerRuleConfig;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-02-25
 */
public interface IMChecker {

    <T> void check(T obj, List<MCheckerRuleConfig> ruleList);

    <T> void check(T obj, List<MCheckerRuleConfig> ruleList, boolean failFast);
}
