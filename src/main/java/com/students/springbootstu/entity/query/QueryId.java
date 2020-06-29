package com.students.springbootstu.entity.query;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class QueryId {
    @NotNull(message = "用户id不能为空")
    @Pattern(regexp = "[0-9]*", message = "必须输入数字查询")
    String id;

}
