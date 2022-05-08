package com.generic.admin_scaffolding.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息表
 * 这里用户指登录系统的用户
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_user")
@Data
public class User extends BaseModel implements Serializable {

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

    /**
     * 拥有的角色
     */
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<SystemRole> roleList = new ArrayList<SystemRole>();


    public List<SystemRole> getRoleList() {
        return roleList;
    }


}
