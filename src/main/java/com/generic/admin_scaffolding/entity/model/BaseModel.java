package com.generic.admin_scaffolding.entity.model;

import lombok.Data;

import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * 表模型的基础类
 *
 * @author xiong.bo
 * @version 1.0
 * @date 2020/12/1 16:26
 */
@Data
public class BaseModel {


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

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Timestamp updateTime;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private Long updateBy;

}
