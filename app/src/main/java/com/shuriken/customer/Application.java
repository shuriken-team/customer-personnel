package com.shuriken.customer;

import com.shuriken.customer.dal.MybatisConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by wb-wyh270612 on 2018/8/3.
 */
@SpringBootApplication
@ComponentScan("com.shuriken.customer.web")
@Import(MybatisConfigurer.class)
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
