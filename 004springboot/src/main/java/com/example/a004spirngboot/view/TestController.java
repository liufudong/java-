package com.example.a004spirngboot.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
// 这里定义了上级URI路径为/api
@RequestMapping("/api")
public class TestController {
    // 实际的请求路径将会是/api/testjson
    @GetMapping("/testjson")
    public String test(@RequestParam(value = "name",required = false,defaultValue = "") String name) {
        System.out.println("用户传递的数据:" + name);
        String json = "{\"age\":20,\"name\":\"张三\"}";
        return json;
    }
}
