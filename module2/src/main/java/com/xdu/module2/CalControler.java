package com.xdu.module2;

import kotlin.reflect.KType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.NumberFormat;

/**
 * @projectName: MyJavaStudyProject
 * @package: com.xdu.module2
 * @className: CalControler
 * @author: Sea
 * @description: 等额本息还款计算器控制器类
 * @date: 2023/5/27 10:13
 * @version: 1.0
 */
// 加注解表示这是一个控制器类
@Controller
public class CalControler {
    @RequestMapping("/cal")
    @ResponseBody
    /*
     @param       p         本金
     @param       mr        月利率
     @param       m         还款月数
     @param       type      选择还款方式
     @return      String    还款详情
     @author      Sea
     @description 这是一个可选等额本息/等额本金还款方式计算器
     @date        2023/5/27 10:35
     */
    String[] cal(double p, double yr, int m, int type) {
        String[] cal_result;
        Calculator[] calculator=new Calculator[]{
                new Calculator1(p, yr, m),
                new Calculator2(p, yr, m)
        };
        cal_result=calculator[type].cal();
        return cal_result;
    }

    @RequestMapping("/details")
    @ResponseBody
    String[][] details(double p, double yr, int m,int type) {
        String[][] detail_result = new String[m][];
        Calculator[] calculator=new Calculator[]{
                new Calculator1(p, yr, m),
                new Calculator2(p, yr, m)
        };
        detail_result=calculator[type].details();
        return detail_result;

    }
}
