package com.imock.mmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * TODO
 *
 * @author: Chen Kj
 * @date: 2018/8/21 16:16
 * @version: 1.0
 */
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = {"com.imock.mmall.mapper"})
public class MmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmallApplication.class, args);
    }
}
