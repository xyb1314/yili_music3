package com.bilitech.yilimusic.exception;

public class BizException extends RuntimeException{
    private final Integer code ; //业务报错码 不是HTTP的


    public BizException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.code = exceptionType.getCode() ;
    }

    public Integer getCode() {
        return code;
    }
}
