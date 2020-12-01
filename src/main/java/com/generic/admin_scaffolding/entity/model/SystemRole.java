package com.generic.admin_scaffolding.entity.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 系统角色表
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_system_role")
@Data
public class SystemRole  extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "role_name")
    private String roleName;

    private String remark;

    private Integer status;


}
