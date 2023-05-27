package com.xdu.module2;

import java.text.NumberFormat;

/**
 * @projectName: MyJavaStudyProject
 * @package: com.xdu.module2
 * @className: Calculator
 * @author: Sea
 * @description: 计算器类父类
 * @date: 2023/5/27 10:47
 * @version: 1.0
 */

public class Calculator {
    double p;         // 本金
    double yr;        // 年利率
    int m;            // 还款月数

    // 父类的构造方法
    Calculator(double p, double yr, int m) {
        this.m = m;
        this.p = p;
        this.yr = yr;
    }

    // 父类计算器还款信息方法，然后子类重写
    String[] cal() {
        return null;
    }
    // 父类计算器的还款详情方法，子类需要重写
    String[][] details() {
        return null;
    }

    // 父类计算器的一行字符串方法，无须重写，子类直接调用
    String[] creatline(int i, double payment, double payPrincipal, double payInterest){
        String[] line = new String[]{
                (i + 1) + "",
                NumberFormat.getCurrencyInstance().format(payment),
                NumberFormat.getCurrencyInstance().format(payPrincipal),
                NumberFormat.getCurrencyInstance().format(payInterest),
                NumberFormat.getCurrencyInstance().format(p)
        };
        return line;
    }
}

