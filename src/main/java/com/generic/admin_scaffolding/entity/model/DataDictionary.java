package com.generic.admin_scaffolding.entity.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 数据字典主表
 * 保存字段key，只能手动往数据库添加
 *
 * @author xiong.bo
 * @version 1.0
 * @date 2020/12/1 15:08
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_data_dictionary")
@Data
public class DataDictionary extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 字典编码
     */
    @Column(name = "key_code")
    private String keyCode;

    /**
     * 字典英文名
     */
    @Column(name = "key_en")
    private String keyEn;

    /**
     * 字典中文名
     */
    @Column(name = "key_cn")
    private String keyCn;


}
