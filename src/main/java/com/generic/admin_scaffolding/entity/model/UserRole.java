package com.generic.admin_scaffolding.entity.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 用户和系统角色的管理表
 *
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/21 11:13
 */

@Entity
@Table(name = "t_user_role")
@Data
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Timestamp createdTime;

    /**
     * 创建者
     */
    @Column(name = "created_by")
    private Long createdBy;

}
