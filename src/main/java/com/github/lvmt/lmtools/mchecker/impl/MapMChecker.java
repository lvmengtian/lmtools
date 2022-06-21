package com.github.lvmt.lmtools.mchecker.impl;

import java.util.List;

import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.github.lvmt.lmtools.mchecker.IMChecker;
import com.github.lvmt.lmtools.mchecker.MChecker;
import com.github.lvmt.lmtools.mchecker.model.MCheckerRuleConfig;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-04-13
 */
public class MapMChecker implements IMChecker {
    @Override
    public <T> void check(T obj, List<MCheckerRuleConfig> ruleList, boolean failFast) {
        SpelExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext evaluationContext = new StandardEvaluationContext(obj);
        evaluationContext.addPropertyAccessor(new MapAccessor());
        for (MCheckerRuleConfig config : ruleList) {
            boolean required = config.isRequired();
            String field = config.getField();
            List<String> rules = config.getRules();

            // 非必需,跳过校验
            if (!required) {
                continue;
            }
            // 根据规则列表校验
            for (String rule : rules) {
                Expression expression = parser.parseExpression(rule);
                Boolean result = expression.getValue(evaluationContext, Boolean.class);
                if (!Boolean.TRUE.equals(result)) {
                    System.out.println(field + " rule not match");
                }
            }
        }
    }
}
