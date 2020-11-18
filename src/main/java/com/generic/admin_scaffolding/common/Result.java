package com.generic.admin_scaffolding.common;

import lombok.Data;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/1 13:23
 */
@Data
public class Result<T> {

    private static final int SUCCESS = 200;
    private static final int ERROR = 500;

    private int code;

    private String message;

    private T content;

    //私有化
    private Result() {
    }

    public static <T> Result<T> of(T content) {
        Result<T> result = new Result<>();
        result.setContent(content);
        result.setCode(SUCCESS);
        return result;
    }

    public static <T> Result<T> of(String message, T content) {
        Result<T> result = new Result<>();
        result.setContent(content);
        result.setCode(SUCCESS);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> error(int code, String message, T content) {
        Result<T> result = new Result<>();
        result.setContent(content);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> error(int code, String message) {
        return error(code, message, null);
    }

    public static <T> Result<T> error(String message) {
        return error(ERROR, message, null);
    }

}
