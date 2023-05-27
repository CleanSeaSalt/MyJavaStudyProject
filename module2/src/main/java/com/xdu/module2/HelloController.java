package com.xdu.module2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @projectName: MyJavaStudyProject
 * @package: com.xdu.module2
 * @className: HelloController
 * @author: Sea
 * @description: 这是一个控制器类
 * @date: 2023/5/26 23:38
 * @version: 1.0
 */

// 加注解表示这是一个控制器类
@Controller
public class HelloController {
    // http://localhost/myhello?名=值&名=值
    @RequestMapping("/hello")
    @ResponseBody
    // 默认值为iexiaohai
    String hello(@RequestParam(name = "name", defaultValue = "xiaohai")String name) {
        return "hello "+name+",this is java!";
    }

    @RequestMapping("/bye")
    @ResponseBody
    String bye(String name) {
        return "byebye,"+name+"!";
    }

}
