package com.generic.admin_scaffolding.common.annotation;

import java.lang.annotation.*;

/**
 * 操作记录日志注解
 * 对需要记录用户访问的接口加上此注解
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

    /**
     * 访问路径
     */
    String accessPath() default "";

    /**
     * 访问描述
     */
    String accessDesc() default "";

}
