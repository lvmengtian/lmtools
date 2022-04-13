package com.github.lvmt.lmtools.mchecker.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.github.lvmt.lmtools.helper.JsonHelper;
import com.github.lvmt.lmtools.mchecker.IMChecker;
import com.github.lvmt.lmtools.mchecker.model.MCheckerRuleConfig;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-02-25
 *
 * 简单校验器
 */
public class SimpleMChecker implements IMChecker {
    @Override
    public <T> void check(T obj, List<MCheckerRuleConfig> ruleList, boolean failFast) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Map<String, String> checkMap = failFast ? null : new HashMap<>();
        for (MCheckerRuleConfig config : ruleList) {
            boolean required = config.isRequired();
            String field = config.getField();
            List<String> rules = config.getRules();

            // 非必需,跳过校验
            if (!required) {
                continue;
            }
            // TODO 待考虑required是true,但是规则列表是空的情况
            // 根据规则列表校验
            for (String rule : rules) {
                Expression expression = parser.parseExpression(rule);
                Boolean match = expression.getValue(obj, Boolean.class);
                if (match == null || !match) {
                    String message = String.format("field:[%s] not match rule:[%s]", field, rule);
                    // 出现不满足的rule，结束
                    if (failFast) {
                        throw new IllegalArgumentException(message);
                    } else {
                        checkMap.put(field, message);
                    }
                }
            }
        }
        if (checkMap != null && !checkMap.isEmpty()) {
            throw new IllegalArgumentException(JsonHelper.toJSON(checkMap));
        }
    }
}
