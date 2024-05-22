package com.example.lxd.service;

import com.example.lxd.config.page.PageRequest;
import com.example.lxd.entity.Warning;

import java.util.List;

/**
* @author Smallke
* @description 针对表【warning】的数据库操作Service
* @createDate 2022-12-01 20:38:52
*/
public interface WarningService {
    /**
     * 获取图片信息
     * @return
     */
    List<Warning> findAll(PageRequest pageRequest);
    /**
     * 删除图片
     */
    void deletePicture(int id);
}
