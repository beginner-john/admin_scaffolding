package com.generic.admin_scaffolding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})//排除oauth2认证
public class AdminScaffoldingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminScaffoldingApplication.class, args);
        System.out.println("======= AdminScaffoldingApplication run ok！=======");
    }

}
