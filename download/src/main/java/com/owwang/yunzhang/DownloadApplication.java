package com.owwang.yunzhang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Classname downloadApplication
 * @Description TODO
 * @Date 2020-02-12
 * @Created by WANG
 */
@SpringBootApplication
public class DownloadApplication {
    public static void main(String[] args) {
        SpringApplication.run(DownloadApplication.class, args);
    }
}
