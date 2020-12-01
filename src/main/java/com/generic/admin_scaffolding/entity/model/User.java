package com.generic.admin_scaffolding.entity.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 用户信息表
 * 这里用户指登录系统的用户
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_user")
@Data
public class User extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "is_admin")
    private Integer isAdmin;

}
