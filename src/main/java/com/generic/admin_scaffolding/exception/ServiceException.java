package com.generic.admin_scaffolding.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 通用异常返回类
 *
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/18 16:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException{

    private int code;
    private String message;

    public ServiceException(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ServiceException(ExceptionDef def) {
        super();
        this.code = def.getCode();
        this.message = def.getName();
    }
}
