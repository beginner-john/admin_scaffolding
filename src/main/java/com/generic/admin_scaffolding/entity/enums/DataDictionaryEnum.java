package com.generic.admin_scaffolding.entity.enums;

/**
 * 数据字典 枚举类
 *
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/19 11:19
 */
public enum DataDictionaryEnum {

    ENABLE(1,"enable","启用"),
    DISABLE(0,"disable","禁用"),
    SYSTEM_ADMIN(1,"system_admin","系统管理员"),
    ADMIN(2,"admin","管理员"),
    CUSTOMER(0,"customer","普通用户"),
    ;


    private int code;
    private String name;
    private String message;


    DataDictionaryEnum(int code, String name, String message) {
        this.code = code;
        this.name = name;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
