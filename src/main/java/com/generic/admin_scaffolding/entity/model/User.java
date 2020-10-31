package com.generic.admin_scaffolding.entity.model;

import lombok.Getter;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/10/31 19:59
 */

@Getter
public class User {

    private Long id;
    private String username;
    private String password;
    private String phone;
    private String sex;

}
