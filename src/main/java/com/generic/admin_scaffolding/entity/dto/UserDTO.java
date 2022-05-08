package com.generic.admin_scaffolding.entity.dto;

import com.generic.admin_scaffolding.entity.model.SystemRole;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2021/10/11 9:00 下午
 */
@Data
public class UserDTO implements Serializable {


    private Long id;

    /**
     * 用户名，登录名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;

    /**
     * 状态：1 启用，0 禁用
     */
    private Integer status;

    /**
     * 标识是否是管理员：0 默认普通用户，1 为系统管理员
     */
    private Integer isAdmin;

    /**
     * 拥有的角色
     */
    private List<SystemRole> roleList = new ArrayList<SystemRole>();
}
