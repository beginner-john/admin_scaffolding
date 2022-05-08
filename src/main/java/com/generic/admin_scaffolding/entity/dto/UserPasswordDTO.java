package com.generic.admin_scaffolding.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/12/21 16:14
 */
@Data
public class UserPasswordDTO implements Serializable {

    private Long id;
    private String oldPassword;
    private String newPassword;
    private String renewPassword;

}
