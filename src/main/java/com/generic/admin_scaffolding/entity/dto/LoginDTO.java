package com.generic.admin_scaffolding.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2021/10/11 8:10 下午
 */
@Data
public class LoginDTO implements Serializable {

    private String username;

    private String password;

    private String autoLogin;//是否自动登录

    private String type;//mobile：手机号登录，account：账号登录

}
