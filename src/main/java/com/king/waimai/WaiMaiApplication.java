package com.king.waimai;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@Configuration // 表示配置类
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass=true)
@MapperScan("com.king.waimai.mapper")
public class WaiMaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaiMaiApplication.class, args);
    }

}
