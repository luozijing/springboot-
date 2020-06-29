package com.students.springbootstu.common.page;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class PageRequest {

    @NotNull(message = "查询页码不能为空")
    @Pattern(regexp = "[0-9]*", message = "必须输入数字查询")
    String pageNum;

    @NotNull(message = "查询数量不能为空")
    @Pattern(regexp = "[0-9]*", message = "必须输入数字查询")
    String pageSize;
}
