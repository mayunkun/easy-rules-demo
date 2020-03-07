package com.aeert.easyrules.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * @author l'amour solitaire
 * @description 被8整除
 * @date 2020/2/28 下午3:42
 */
@Rule(name = "被8整除", priority = 2, description = "number如果被8整除，打印：number is eight")
public class EightRule {

    /**
     * 条件
     */
    @Condition
    public boolean isThree(@Fact("number") int number) {
        return number % 8 == 0;
    }

    /**
     * 执行
     */
    @Action
    public void threeAction(@Fact("number") int number) {
        System.out.print(number + " is eight");
    }

}
