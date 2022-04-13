package com.github.lvmt.lmtools.mchecker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.github.lvmt.lmtools.helper.JsonHelper;
import com.google.common.collect.Lists;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-02-24
 * 校验规则配置
 */
public class MCheckerRuleConfig {
    /**
     * field name in the object that need to be checked
     */
    private String field;

    /**
     * filed is required
     */
    private boolean required;

    /**
     * field check rules
     */
    private List<String> rules;

    public MCheckerRuleConfig() {
    }

    public MCheckerRuleConfig(String field, boolean required) {
        this(field, required, Collections.emptyList());
    }

    public MCheckerRuleConfig(String field, String rule) {
        this(field, Collections.singletonList(rule));
    }

    public MCheckerRuleConfig(String field, List<String> rules) {
        this(field, Boolean.FALSE, rules);
    }

    public MCheckerRuleConfig(String field, boolean required, String rule) {
        this(field, required, Collections.singletonList(rule));
    }

    public MCheckerRuleConfig(String field, boolean required, List<String> rules) {
        this.field = field;
        this.required = required;
        this.rules = rules;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public List<String> getRules() {
        return rules;
    }

    public void setRules(List<String> rules) {
        this.rules = rules;
    }

    public static List<MCheckerRuleConfig> defaultCfgList4SkuParam() {
        return Lists.newArrayList(
                new MCheckerRuleConfig("skuExtra", Boolean.TRUE, "skuExtra != null"),
                new MCheckerRuleConfig("skuExtra.desc", Boolean.TRUE, "skuExtra.desc != null && skuExtra.desc != \"\""),
                new MCheckerRuleConfig("skuExtra.desc", Boolean.TRUE, "skuExtra.imgList != null && !skuExtra.imgList.isEmpty()"),
                new MCheckerRuleConfig("skuName", Boolean.TRUE),
                new MCheckerRuleConfig("skuPrice", Boolean.TRUE, "skuPrice >= 10"),
                new MCheckerRuleConfig("skuStock", Boolean.TRUE, Lists.newArrayList("skuStock >= 50", "skuStock <= 200"))
        );
    }

    public static String defaultCfgStr4SkuParam() {
        List<MCheckerRuleConfig> configs = Lists.newArrayList(
                new MCheckerRuleConfig("skuName", Boolean.TRUE),
                new MCheckerRuleConfig("skuPrice", Boolean.TRUE, "skuPrice >= 10"),
                new MCheckerRuleConfig("skuStock", Boolean.TRUE,
                        Lists.newArrayList("skuStock >= 50", "skuStock <= 200"))

        );
        return JsonHelper.toJSON(configs);
    }
}
