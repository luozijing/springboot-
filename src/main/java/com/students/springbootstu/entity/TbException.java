package com.students.springbootstu.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbException)实体类
 *
 * @author makejava
 * @since 2020-06-14 16:29:56
 */

@Data
public class TbException implements Serializable {
    private static final long serialVersionUID = 446908659655710154L;
    
    private String exception;

    private Integer id;
    
    private Date createdtime;

    public TbException(Date date, String exMsg){
        this.createdtime = date;
        this.exception = exMsg;
    }
}