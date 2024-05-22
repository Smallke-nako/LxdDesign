package com.example.lxd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lxd.config.page.PageRequest;
import com.example.lxd.entity.PersonLoginLog;
import com.example.lxd.service.PersonLoginLogService;
import com.example.lxd.mapper.PersonLoginLogMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Smallke
* @description 针对表【person_login_log(登录日志表)】的数据库操作Service实现
* @createDate 2023-02-08 23:35:05
*/
@Service
public class PersonLoginLogServiceImpl implements PersonLoginLogService{
    @Resource
    private PersonLoginLogMapper personLoginLogMapper;
    @Override
    public void saveLog(PersonLoginLog personLoginLog) {
    personLoginLogMapper.createLog(personLoginLog);
    }



    @Override
    public List<PersonLoginLog> getLogPage(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        return personLoginLogMapper.getLogPage();

    }

    @Override
    public void deleteLog(int id) {
        personLoginLogMapper.deleteById(id);
    }
}




