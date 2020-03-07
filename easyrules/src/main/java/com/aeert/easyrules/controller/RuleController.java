package com.aeert.easyrules.controller;

import com.aeert.easyrules.rules.EightRule;
import com.aeert.easyrules.rules.ThreeRule;
import io.swagger.annotations.Api;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author l'amour solitaire
 * @description TODO
 * @date 2020/2/28 下午3:51
 */
@RestController
@RequestMapping(value = "/rule")
@Api(tags = "easy rule 测试")
public class RuleController {

    @GetMapping(value = "test")
    public Map<Rule, Boolean> test(Integer number) {
        // skipOnFirstAppliedRule意思是，只要匹配到第一条规则就跳过后面规则匹配
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        RulesEngine rulesEngine = new DefaultRulesEngine(parameters);
        Rules rules = new Rules();
        rules.register(new ThreeRule());
        rules.register(new EightRule());
        Facts facts = new Facts();
        facts.put("number", number);
        rulesEngine.fire(rules, facts);
        return rulesEngine.check(rules, facts);
    }

}
