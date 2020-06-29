package com.students.springbootstu.common.page;

import com.github.pagehelper.PageInfo;

public class PageUtils {
    public static PageResult getPageResult(PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
