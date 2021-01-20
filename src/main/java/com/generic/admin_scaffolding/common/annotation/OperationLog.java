package com.generic.admin_scaffolding.common.annotation;

import java.lang.annotation.*;

/**
 * 操作记录日志注解
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

}
