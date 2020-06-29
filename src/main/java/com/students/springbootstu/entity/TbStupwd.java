package com.students.springbootstu.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * (TbStupwd)实体类
 *
 * @author makejava
 * @since 2020-06-28 14:52:12
 */
@Data
public class TbStupwd implements Serializable {
    private static final long serialVersionUID = 843105976907130866L;

    private Integer id;

    private Integer stuid;

    @NotNull(message = "用户账号不能为空")
    private String stuaccount;

    @NotNull(message = "用户密码不能为空")
    private String stupwd;

    private String role;

}