package com.xyhj.demo.base;

import org.springframework.util.StringUtils;

public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "success";
    private static final String DEFAULT_FAIL_MESSAGE = "fail";
    private static final int RESULT_CODE_SUCCESS = 200;
    private static final int RESULT_CODE_SERVER_ERROR = 500;


    public static Result genSuccessResult() {
        Result result = new Result();
        result.setCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    public static Result genSuccessResult(String message) {
        Result result = new Result();
        result.setCode(RESULT_CODE_SUCCESS);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    public static <T> Result<T> genSuccessResult(T data) {
        Result<T> result = new Result<T>();
        result.setCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> genSuccessResult(RetEnum retEnum, T data) {
        Result<T> result = new Result<T>();
        result.setCode(retEnum.getCode());
        result.setMessage(retEnum.getMessage());
        result.setData(data);
        return result;
    }


    public static Result genFailResult(String message) {
        Result result = new Result();
        result.setCode(RESULT_CODE_SERVER_ERROR);
        if (StringUtils.isEmpty(message)) {
            result.setMessage(DEFAULT_FAIL_MESSAGE);
        } else {
            result.setMessage(message);
        }
        return result;
    }

    public static Result genErrorResult(int code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(new Object());
        return result;
    }

    public static <T> Result<T> genResult(RetEnum retEnum, T data) {
        Result<T> result = new Result<T>();
        result.setCode(retEnum.getCode());
        result.setMessage(retEnum.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> genFailResult(RetEnum retEnum) {
        Result<T> result = new Result<T>();
        result.setCode(retEnum.getCode());
        result.setMessage(retEnum.getMessage());
        return result;
    }
}
