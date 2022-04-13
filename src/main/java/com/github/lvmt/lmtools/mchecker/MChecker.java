package com.github.lvmt.lmtools.mchecker;

import java.util.List;
import java.util.Map;

import com.github.lvmt.lmtools.helper.JsonHelper;
import com.github.lvmt.lmtools.mchecker.impl.MapMChecker;
import com.github.lvmt.lmtools.mchecker.impl.SimpleMChecker;
import com.github.lvmt.lmtools.mchecker.model.MCheckerRuleConfig;
import com.github.lvmt.lmtools.mchecker.model.SkuParam;

public class MChecker {

    public static void main(String[] args)  {
        // 校验规则
        List<MCheckerRuleConfig> ruleConfigList = MCheckerRuleConfig.defaultCfgList4SkuParam();

        // 模拟被校验对象
        SkuParam skuParam = SkuParam.build2();
        String json = JsonHelper.toJSON(skuParam);
        Map<String, Object> map = JsonHelper.fromJSON(json);

        IMChecker checker = new SimpleMChecker();
        IMChecker mapChecker = new MapMChecker();
        try {
            mapChecker.check(map, ruleConfigList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
