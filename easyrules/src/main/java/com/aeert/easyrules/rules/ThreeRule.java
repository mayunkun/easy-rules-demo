package com.aeert.easyrules.rules;

import org.jeasy.rules.annotation.*;

/**
 * @author l'amour solitaire
 * @description 被三整除
 * @date 2020/2/28 下午3:42
 */
@Rule(name = "被3整除", priority = 1, description = "number如果被3整除，打印：number is three")
public class ThreeRule {

    /**
     * 条件
     */
    @Condition
    public boolean isThree(@Fact("number") int number) {
        return number % 3 == 0;
    }

    /**
     * 执行
     */
    @Action
    public void threeAction(@Fact("number") int number) {
        System.out.print(number + " is three");
    }

}
