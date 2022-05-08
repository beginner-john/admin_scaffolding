package com.generic.admin_scaffolding.utils;

import com.generic.admin_scaffolding.common.PageInfo;
import org.springframework.data.domain.Page;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/18 18:35
 */
public class PageInfoUtils {


    /**
     * 获取分页信息
     * 总页数和总数
     *
     * @param data
     * @return
     */
    public static PageInfo getPageInfo(Page data){
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalElements(data.getTotalElements());
        pageInfo.setTotalPages(data.getTotalPages());
        pageInfo.setCurrent(data.getNumber());
        pageInfo.setPageSize(data.getSize());
        return pageInfo;
    }

}
