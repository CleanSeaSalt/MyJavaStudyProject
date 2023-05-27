package com.xdu.module2;

import java.text.NumberFormat;

/**
 * @projectName: MyJavaStudyProject
 * @package: com.xdu.module2
 * @className: Calculator2
 * @author: Sea
 * @description: 等额本金还款计算器
 * @date: 2023/5/27 11:02
 * @version: 1.0
 */

public class Calculator2 extends Calculator {
    Calculator2(double p, double yr, int m) {
        super(p, yr, m);                //构造方法需要使用super
    }

    @Override
    String[] cal() {
        String[] cal_result;
        double mr = yr / 12 / 100.0;            // 月利率
        double payPrincipal = p / m;            // 偿还本金
        double backup = p;                      // 备份本金
        double payInterestTotal = 0.0;          // 总利息
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr;         // 偿还利息
            p -= payPrincipal;                   // 剩余本金
            payInterestTotal += payInterest;     //
        }
        cal_result = new String[]{
                NumberFormat.getCurrencyInstance().format(backup + payInterestTotal),
                NumberFormat.getCurrencyInstance().format(payInterestTotal)
        };
        return cal_result;
    }

    @Override
    String[][] details() {
        String[][] detail_result = new String[m][];
        double mr = yr / 12 / 100.0;
        double payPrincipal = p / m;                        // 偿还本金
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr;                    // 偿还利息
            p -= payPrincipal;                              // 剩余本金
            double payment=payPrincipal+payInterest;        //月供
            detail_result[i] =creatline(i,payment,payPrincipal,payInterest);
        }
        return detail_result;
    }
}
