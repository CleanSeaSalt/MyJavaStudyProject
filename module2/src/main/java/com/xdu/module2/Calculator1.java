package com.xdu.module2;

import java.text.NumberFormat;

/**
 * @projectName: MyJavaStudyProject
 * @package: com.xdu.module2
 * @className: Calculator1
 * @author: Sea
 * @description: 等额本息还款计算器
 * @date: 2023/5/27 10:50
 * @version: 1.0
 */

public class Calculator1 extends  Calculator{
    Calculator1(double p, double yr, int m) {
        super(p,yr,m);
    }

    @Override
    String[] cal(){
        String[] cal_result;
        double mr = yr / 12 / 100.0;
        double pow = Math.pow(1 + mr, m);
        double payment = p * mr * pow / (pow - 1);
        cal_result = new String[]{
                NumberFormat.getCurrencyInstance().format(payment * m),
                NumberFormat.getCurrencyInstance().format(payment * m - p)
        };
        return cal_result;
    }

    @Override
    String[][] details(){
        String[][] detail_result = new String[m][];
        double mr = yr / 12 / 100.0;
        double pow = Math.pow(1 + mr, m);
        double payment = p * mr * pow / (pow - 1);
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr;
            double payPrincipal = payment - payInterest;
            p -= payPrincipal;
            detail_result[i] = creatline(i,payment,payPrincipal,payInterest);
        }
        return detail_result;
    }
}
