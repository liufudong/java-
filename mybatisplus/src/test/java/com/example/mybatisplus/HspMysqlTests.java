package com.example.mybatisplus;

import com.alibaba.fastjson.JSONObject;
import com.example.mybatisplus.mapper.*;
import com.example.mybatisplus.mapper.hsp.EmpMapper;
import com.example.mybatisplus.mapper.hsp.EmpMapper2;
import com.example.mybatisplus.pojo.*;
import com.example.mybatisplus.pojo.hsp.CName2;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest

@MapperScan(value = {"com.example.mybatisplus.mapper"})
class HspMysqlTests {
    @Autowired
    EmpMapper empMapper;
    @Autowired
    EmpMapper2 empMapper2;

    @Test
    public void testEmpMapper() {
        empMapper.getEmpList().forEach(empBean -> {
            System.out.println("====empBean===" + empBean.toString());
        });
    }

    @Test
    public void testEmpMapper2() {
        empMapper2.queryEmpBean2().forEach(empBean -> {
            System.out.println("====empBean2===" + empBean.toString());
        });
    }

    @Test
    public void testEmpMapper3() {
        CName2 cName2 = empMapper2.queryEmpBean3("高三1班");
        Object o = JSONObject.toJSON(cName2);
        System.out.println("====empBean3===" + o);
    }

    @Test
    public void testQueryEmpBeanAll() {
        List<CName2> cName2s = empMapper2.queryEmpBeanAll();
        Object o = JSONObject.toJSON(cName2s);
        System.out.println("====testQueryEmpBeanAll===" + o);
    }
    @Test
    public void testQueryEmpBeanAll2() {
        //获取第1页，10条内容，默认查询总数count
        PageHelper.startPage(2,10);
        List<Clazz> cName2s = empMapper2.queryTClazz();
        //用PageInfo对结果进行包装
        PageInfo pageInfo=new PageInfo(cName2s);
        Object o = JSONObject.toJSON(cName2s);
        System.out.println("====testQueryEmpBeanAll2===" + o);
        Object oPageInfo = JSONObject.toJSON(pageInfo);
        System.out.println("====testQueryEmpBeanAll2.1===" + oPageInfo);
    }
}
