package com.xdu;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {


        double p = inputAndCheckP();

        double mr = inputAndCheckMr();

        int m = inputAndCheckM();

        double payment = calculate(p, mr, m);

        printDetails(p, mr, m, payment);

    }

    /*
     @param       p         本金
     @param       mr        月利率
     @param       m         还款月数
     @param       payment   每月还款金额
     @return      void
     @author      Sea
     @description 打印每月还款详细信息
     @date        2023/5/25 10:36
     */
    static void printDetails(double p, double mr, int m, double payment) {
        for (int i = 0; i < m; i++) {
            double payInterest = p * mr;                    // 偿还利息
            double payPrincipal = payment - payInterest;    // 偿还本金
            p -= payPrincipal;                              // 剩余本金
            System.out.print("月份" + (i + 1));
            System.out.print("\t本月还款" + NumberFormat.getCurrencyInstance().format(payment));
            System.out.print("\t偿还本金" + NumberFormat.getCurrencyInstance().format(payPrincipal));
            System.out.print("\t偿还利息" + NumberFormat.getCurrencyInstance().format(payInterest));
            System.out.println("\t剩余本金" + NumberFormat.getCurrencyInstance().format(p));

        }
        System.out.println("总还款额" + NumberFormat.getCurrencyInstance().format(payment * m));
    }

    /*
     @return      double
     @author      Sea
     @description 检查输入的本金是否合法，不合法则抛错
     @date        2023/5/25 10:40
     */
    static double inputAndCheckP() {
        var scanner = new Scanner(System.in);
        System.out.println("请输入本金");
        double p = scanner.nextDouble();
        if (p <= 0) {
            // throw new 异常类型(消息提示)
            throw new IllegalArgumentException("本金必须大于0！");     // 非法参数
        }
        return p;
    }

    /*
    @return      double
    @author      Sea
    @description 检查输入的年利率是否合法，不合法则抛错
    @date        2023/5/25 10:40
    */
    static double inputAndCheckMr() {
        var scanner = new Scanner(System.in);
        // 输入sout即可联想输出
        System.out.println("请输入年利率");
        double yr = scanner.nextDouble();
        if (!(yr >= 1.0 && yr <= 36.0)) {
            throw new RuntimeException("年利率必须在1~36之间！");
        }
        double mr = yr / 12.0 / 100;
        return mr;
    }

    /*
    @return      int
    @author      Sea
    @description 检查输入的还款月数是否合法，不合法则抛错
    @date        2023/5/25 10:40
    */
    static int inputAndCheckM() {
        var scanner = new Scanner(System.in);
        System.out.println("请输入还款月数");
        int m = scanner.nextInt();
        if (!(m >= 1 && m <= 360)) {
            throw new RuntimeException("贷款月数必须是1~360之间！");
        }
        return m;
    }

    /*
     @param       p         本金
     @param       mr        月利率
     @param       m         还款月数
     @return      double    每月还款金额
     @author      Sea
     @description 以等额本息方式计算每月还款金额
     @date        2023/5/25 10:32
     */
    static double calculate(double p, double mr, int m) {
        double pow = Math.pow(1 + mr, m);
        double payment = p * mr * pow / (pow - 1);
        return payment;
    }

}
