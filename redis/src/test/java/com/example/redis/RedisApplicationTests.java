package com.example.redis;

import com.example.redis.pojo.Student;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
class RedisApplicationTests {

    @Resource
    private RedisTemplate<String, Student> redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedisTemplate() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));
        ValueOperations<String, Student> valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("name", "或者哪个是你");
//        Object name = valueOperations.get("name");
        valueOperations.set("1", new Student("张三", 20));
        System.out.println("===name2:" + valueOperations.get("1"));
        valueOperations.set("2", new Student("李四", 20), 30, TimeUnit.MINUTES);
//        System.out.println("===name3:" + redisTemplate2.opsForValue().get("1"));
//        valueOperations.set("name","或者哪个是你");
        System.out.println("===name4:" + stringRedisTemplate.opsForValue().get("1"));
        System.out.println("===name5:" + stringRedisTemplate.opsForValue().get("1"));
        log.info("=====testRedisTemplate==");
    }

    @Test
    public void testStringRedisTemplate() {
    }

    @Test
    void contextLoads() {
    }

}
