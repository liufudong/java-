package com.java1234.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author java1234_小锋
 * @site www.java1234.com
 * @company Java知识分享网
 * @create 2021-03-22 16:54
 */
@RestController
@RequestMapping("/nacos")
@RefreshScope
public class NacosConfigController {

    @Autowired
    private PathSourceProperties pathSourceProperties;
    @Autowired
    private JDBCSourceProperties dataSourceProperties;
    @Autowired
    private RedisSourceProperties redisSourceProperties;

    @GetMapping("/mysql-url")
    public String getMysqlUrl() {
        return "JDBC数据:" + dataSourceProperties.toString() + "\n\n\n\n\n\t\t\t\t"
                + "redis数据" + redisSourceProperties.toString()
                + "\n\n\n\n\n\t\t\t\t" + "spring.path.text数据" + pathSourceProperties.toString();
    }
}
