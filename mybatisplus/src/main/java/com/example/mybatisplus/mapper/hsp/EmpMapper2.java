package com.example.mybatisplus.mapper.hsp;

import com.example.mybatisplus.pojo.Clazz;
import com.example.mybatisplus.pojo.hsp.CName2;
import com.example.mybatisplus.pojo.hsp.EmpBean2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper2 {
    List<EmpBean2> queryEmpBean2();

    CName2 queryEmpBean3(@Param("name") String name);
    List<CName2> queryEmpBeanAll();

    List<Clazz> queryTClazz();
}
