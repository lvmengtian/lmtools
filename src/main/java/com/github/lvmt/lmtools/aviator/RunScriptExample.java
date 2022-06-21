package com.github.lvmt.lmtools.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-04-28
 */
public class RunScriptExample {
    public static void main(final String[] args) throws Exception {
        // Compile the script into a Expression instance.
        Expression exp = AviatorEvaluator.getInstance().compileScript("examples/hello.av");
        // Run the expression.
        Boolean result = (Boolean) exp.execute();
        System.out.println(result);
    }
}
