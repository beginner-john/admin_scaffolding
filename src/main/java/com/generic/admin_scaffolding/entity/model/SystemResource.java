package com.generic.admin_scaffolding.entity.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 系统资源表
 *
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/29 11:20
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_system_resource")
@Data
public class SystemResource extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 资源code
     */
    @Column(name = "code")
    private String code;

    /**
     * 资源的url
     */
    @Column(name = "res_url")
    private String resUrl;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 资源类型
     * 1：菜单，2：按钮，3：功能
     * 菜单和按钮属于前端资源
     * 功能属于后端资源，指后端某些接口或功能的权限
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 排序
     */
    @Column(name = "show_order")
    private Integer showOrder;

}
