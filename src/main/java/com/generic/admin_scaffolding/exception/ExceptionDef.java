package com.generic.admin_scaffolding.exception;

/**
 * 异常code和message的通用定义枚举
 *
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/18 16:03
 */
public enum ExceptionDef {

    /*
        http常见状态码
     */
    ERROR_COMMON_PARAM_NULL(1,"ERROR_COMMON_PARAM_NULL","参数为空"),
    ERROR_DATA_NOT_EXIST(2,"ERROR_DATA_NOT_EXIST","数据不存在"),


    ERROR_USER_LOGIN_FAILED(401, "ERROR_USER_LOGIN_FAILED","用户名或密码错误，登录失败"),
    ERROR_USER_TOKEN_INVALID(402,"ERROR_USER_TOKEN_INVALID","Token失效"),


    /*
        业务自定义状态码
     */
    ERROR_PASSWORD_FAILED(1001, "ERROR_PASSWORD_FAILED","密码错误"),
    ERROR_PASSWORD_INCONSISTENCY(1002, "ERROR_PASSWORD_INCONSISTENCY","两次密码为空或者不一致"),
    ERROR_USER_EXIST(1003, "ERROR_USER_EXIST","用户已存在"),
    ;


    private int code;
    private String name;
    private String comment;

    ExceptionDef(int code, String name, String comment) {
        this.code = code;
        this.name = name;
        this.comment = comment;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
