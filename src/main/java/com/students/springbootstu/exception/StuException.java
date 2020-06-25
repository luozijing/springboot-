package com.students.springbootstu.exception;

public class StuException extends Exception{

    /**
     *项目的父异常
     */

    public StuException(){
    }


    public StuException(String msg){
        super(msg);
    }

    public StuException(String msg, Throwable cause){
        super(msg, cause);
    }

    public StuException( Throwable cause){
        super( cause);
    }

}
