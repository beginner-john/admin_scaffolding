package com.generic.admin_scaffolding.entity.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 系统角色表
 */

@Entity
@Table(name = "t_system_role")
@Data
public class SystemRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "role_name")
    private String roleName;

    private String remark;

    private Integer status;

    @Column(name = "created_time")
    private Timestamp createdTime;

    @Column(name = "created_by")
    private Long createdBy;


}
