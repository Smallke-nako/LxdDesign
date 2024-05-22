package com.example.lxd.util;

import com.example.lxd.config.page.PageRequest;
import com.example.lxd.config.page.PageResult;
import com.github.pagehelper.PageInfo;

public class PageUtil {

    /**
     *  分页信息封装
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setResult(pageInfo.getList());
        return pageResult;
    }

}
