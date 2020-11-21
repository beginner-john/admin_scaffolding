package com.generic.admin_scaffolding.utils;

import java.sql.Timestamp;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/21 10:06
 */
public class DateUtils {


    /**
     * 获取当前时间，Timestamp格式的
     *
     * @return Timestamp
     */
    public static Timestamp getCurrentTimestamp() {
        long time = System.currentTimeMillis();
        return new Timestamp(time);
    }


}
