package com.example.lxd.service.impl;

import com.example.lxd.config.page.PageRequest;
import com.example.lxd.entity.Warning;
import com.example.lxd.mapper.WarningMapper;
import com.example.lxd.service.WarningService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Smallke
* @description 针对表【warning】的数据库操作Service实现
* @createDate 2022-12-01 20:38:52
*/
@Service
public class WarningServiceImpl implements WarningService{
    @Autowired
    WarningMapper warningMapper;

    @Override
    public List<Warning> findAll(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        return warningMapper.findAll();
    }

    @Override
    public void deletePicture(int id) {
    warningMapper.deleteById(id);
    }
}




