package com.xdu.module2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @projectName: MyJavaStudyProject
 * @package: com.xdu.module2
 * @className: AddControler
 * @author: Sea
 * @description: 网页加法计算器
 * @date: 2023/5/27 10:05
 * @version: 1.0
 */

// 加注解表示这是一个控制器类
@Controller
public class AddControler {
    // http://localhost/myhello?名=值&名=值
    @RequestMapping("/add")
    @ResponseBody
    // 默认值为iexiaohai
    int add(int a,int b) {
        return a+b;
    }

    // @RequestMapping("/bye")
    // @ResponseBody
    // String bye(String name) {
    //     return "byebye,"+name+"!";
    // }
}
