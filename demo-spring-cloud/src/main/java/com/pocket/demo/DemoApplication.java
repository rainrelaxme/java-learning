package com.pocket.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用启动类
 * @author Shawn
 */
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@MapperScan("com.pocket.demo.mapper")  // 扫描Mapper接口
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("========================================");
        System.out.println("===  Pocket demo 应用启动成功！ ===");
//        System.out.println("===  Swagger文档: http://localhost:8080/doc.html ===");
        System.out.println("========================================");
    }
}