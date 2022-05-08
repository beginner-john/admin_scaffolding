package com.generic.admin_scaffolding.common;

import lombok.Data;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/18 18:20
 */
@Data
public class PageInfo {

    private long totalPages;//总页数
    private long totalElements;//总个数
    private long current;//当前页
    private long pageSize;//每页个数

}
