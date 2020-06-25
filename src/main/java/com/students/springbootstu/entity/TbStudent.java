package com.students.springbootstu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.io.Serializable;

/**
 * (TbStudent)实体类
 *
 * @author makejava
 * @since 2020-06-11 17:32:29
 */
@Data
@ApiModel(value = "学生")
public class TbStudent implements Serializable {
    private static final long serialVersionUID = -81830263341066208L;

    @NotNull(message = "用户id不能为空")
    @ApiModelProperty(value = "学生id（自增）")
    private Integer stuid;

    @NotNull(message = "用户名不能为空")
    @ApiModelProperty(value = "学生姓名")
    private String stuname;

    @NotNull(message = "用户性别不能为空")
    @ApiModelProperty(value = "性别")
    private Boolean stusex;

    @NotNull(message = "出生日期不能为空")
    @ApiModelProperty(value = "出生年月")
    private Date stubirth;

    @ApiModelProperty(value = "电话")
    private String stutel;

    @ApiModelProperty(value = "家庭地址")
    private String stuadr;

    @ApiModelProperty(value = "个人照")
    private byte[] stuphoto;

}