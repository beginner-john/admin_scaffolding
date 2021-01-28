package com.generic.admin_scaffolding.entity.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2021/1/7 12:01
 */
@Entity
@Table(name = "t_operation_log")
@Data
public class OperationRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 访问的用户名
     */
    private String username;

    /**
     * 访问路径
     */
    @Column(name = "access_path")
    private String accessPath;

    /**
     * 访问描述
     */
    @Column(name = "access_desc")
    private String accessDesc;

    /**
     * 访问者的ip
     */
    @Column(name = "access_ip")
    private String accessIp;


    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Timestamp createTime;


}
