package com.github.lvmt.lmtools.mchecker;

import java.util.List;

import com.github.lvmt.lmtools.mchecker.impl.SimpleMChecker;
import com.github.lvmt.lmtools.mchecker.model.MCheckerRuleConfig;
import com.github.lvmt.lmtools.mchecker.model.SkuParam;

public class MChecker {

    public static void main(String[] args)  {
        // 校验规则
        List<MCheckerRuleConfig> ruleConfigList = MCheckerRuleConfig.defaultCfgList4SkuParam();

        // 模拟被校验对象
        SkuParam skuParam = SkuParam.build2();

        IMChecker checker = new SimpleMChecker();
        try {
            checker.check(skuParam, ruleConfigList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
