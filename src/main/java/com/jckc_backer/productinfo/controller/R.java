package com.jckc_backer.productinfo.controller;

import java.io.Serializable;

/**
 * @author zhao zhongren
 * @date 2019-08-30 18:21
 */
public class R<T> implements Serializable {
    private static final long serialVersionUID = 2523377728598055414L;
    private int code;
    private String message;
    private T result;

    public R() {
    }

    private R(int code, T data, String msg) {
        this.setCode(code);
        this.setMessage(msg);
        this.result = data;
    }

    public static <T> R<T> error() {
        R<T> response = new R();
        response.setCode(500000);
        response.setMessage("system error");
        return response;
    }

    public static <T> R<T> error(String msg) {
        R<T> response = new R();
        response.setCode(500000);
        response.setMessage(msg);
        return response;
    }

    public static <T> R<T> error(int code, String msg) {
        R<T> response = new R();
        response.setCode(code);
        response.setMessage(msg);
        return response;
    }

    public static <T> R<T> success(T data) {
        R<T> response = new R();
        response.setCode(200000);
        response.setMessage("success");
        response.setResult(data);
        return response;
    }

    public static <T> R<T> success() {
        R<T> response = new R();
        response.setCode(200000);
        response.setMessage("success");
        return response;
    }

    public static R newInstance(int code, Object data, String msg) {
        return new R(code, data, msg);
    }

    public String toString() {
        return "R(result=" + this.getResult() + ")";
    }

    public void setResult(final T result) {
        this.result = result;
    }

    public T getResult() {
        return this.result;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
