package com.students.springbootstu.exception;

public class BusinessException extends StuException {
    /**
     * 业务异常
     */

    public BusinessException(){
    }


    public BusinessException(String msg){
        super(msg);
    }

    public BusinessException(String msg, Throwable cause){
        super(msg, cause);
    }

    public BusinessException( Throwable cause){
        super(cause);
    }
}
