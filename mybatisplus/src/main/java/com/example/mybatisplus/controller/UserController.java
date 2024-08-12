package com.example.mybatisplus.controller;

import com.example.mybatisplus.pojo.User;
import com.example.mybatisplus.service.UserService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@ResponseBody
public class UserController {
    @Resource
    UserService userService;
    @Value("${myapp.greeting}")
    String value;
    @GetMapping("/test")
    public String testValue() {
        return value;
    }
    @GetMapping("/selectList")
    public List<User> selectList() {
        return userService.selectList();
    }

    @GetMapping("/listUsers")
    public PageInfo<User> listUsers(@RequestParam(name = "pageSize", required = false, defaultValue = "1") int pageSize,
                                    @RequestParam(name = "pageNum", required = false, defaultValue = "10") int pageNum) {
        log.info("listUsers pageSize:" + pageSize + "pageNum" + pageNum);
        return userService.listUsers(pageNum, pageSize);
    }
}
