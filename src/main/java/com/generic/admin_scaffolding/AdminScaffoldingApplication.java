package com.generic.admin_scaffolding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AdminScaffoldingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminScaffoldingApplication.class, args);
        System.out.println("======= AdminScaffoldingApplication run ok！=======");
    }

}
