package com.students.springbootstu.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbSelect)实体类
 *
 * @author makejava
 * @since 2020-06-11 19:46:12
 */
@Data
public class TbSelect implements Serializable {
    private static final long serialVersionUID = 691337868461062934L;
    
    private Integer sid;
    
    private Integer stuid;
    
    private Integer cosid;
    
    private Date stime;
    
    private Float sscore;


}