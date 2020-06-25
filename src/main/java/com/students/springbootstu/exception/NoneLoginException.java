package com.students.springbootstu.exception;

public class NoneLoginException extends StuException{

    public NoneLoginException(String msg){
        super(msg);
    }

    public NoneLoginException(String msg, Throwable cause){
        super(msg, cause);
    }

}
