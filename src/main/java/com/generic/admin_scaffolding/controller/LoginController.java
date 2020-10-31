package com.generic.admin_scaffolding.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/10/31 19:02
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public void login() {
        System.out.println("login");
    }
}
