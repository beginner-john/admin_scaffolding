package com.generic.admin_scaffolding.entity.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2021/10/4 10:11 下午
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_feedback")
@Data
public class Feedback extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 反馈内容
     */
    private String content;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 处理状态，0:未处理，1:已处理
     */
    private Integer status;

    /**
     * 图片url
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 处理描述
     */
    private String dispose;


}
