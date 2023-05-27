package com.xdu.module2;

import java.text.NumberFormat;

/**
 * @projectName: MyJavaStudyProject
 * @package: com.xdu.module2
 * @className: Calculator3
 * @author: Sea
 * @description: 零息还款计算器
 * @date: 2023/5/27 11:22
 * @version: 1.0
 */

public class Calculator3 extends Calculator {
    Calculator3(double p, double yr, int m) {
        super(p,yr,m);
    }

    @Override
    String[] cal() { // 0 还款总额  1 总利息
        return new String[]{
                NumberFormat.getCurrencyInstance().format(p),
                "0"
        };
    }

    @Override
    String[][] details() {
        String[][] detail_result = new String[m][];
        double payment = p / m;
        for (int i = 0; i < m; i++) {
            p -= payment;
            detail_result[i] = creatline(i, payment, payment, 0);
        }
        return detail_result;
    }
}
