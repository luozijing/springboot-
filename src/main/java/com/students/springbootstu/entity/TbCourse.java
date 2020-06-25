package com.students.springbootstu.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (TbCourse)实体类
 *
 * @author makejava
 * @since 2020-06-11 19:23:15
 */
@Data
public class TbCourse implements Serializable {
    private static final long serialVersionUID = 129301572047020003L;
    
    private Integer cosid;
    
    private String cosname;
    
    private Integer coscredit;
    
    private String cosintro;

}