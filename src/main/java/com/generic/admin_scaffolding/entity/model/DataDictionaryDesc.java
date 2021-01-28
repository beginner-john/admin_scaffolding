package com.generic.admin_scaffolding.entity.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
     * 数据字典 详情表
     * 配合数据字典主表一起使用
     *
 * @author xiong.bo
 * @version 1.0
 * @date 2020/12/1 16:13
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_data_dictionary_desc")
@Data
public class DataDictionaryDesc extends BaseModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 字典主表id
     */
    @Column(name = "dictionary_id")
    private String dictionaryId;

    /**
     * 字典编码
     */
    @Column(name = "value_code")
    private String valueCode;

    /**
     * 字典英文名
     */
    @Column(name = "value_en")
    private String valueEn;

    /**
     * 字典中文名
     */
    @Column(name = "value_cn")
    private String valueCn;

}
