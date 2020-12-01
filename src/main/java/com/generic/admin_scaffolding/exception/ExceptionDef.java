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


    /*
        业务自定义状态码
     */
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
