package com.generic.admin_scaffolding.entity.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 角色和资源的中间关联表
 *
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/29 17:13
 */

@Entity
@Table(name = "t_role_resource")
@Data
public class RoleResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 资源id
     */
    @Column(name = "resource_id")
    private Long resourceId;


    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Timestamp createTime;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private Long createBy;

}
