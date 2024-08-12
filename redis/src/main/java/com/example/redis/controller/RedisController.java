package com.example.redis.controller;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    //注入 RedisTemplate
    //泛型 key，value 都是 String ，或者 Object， 不写
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @GetMapping("/")
    public String getName(){
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("name","或者哪个是你");
//        Object name = valueOperations.get("name");
        return "或者哪个是你";
    }
}
