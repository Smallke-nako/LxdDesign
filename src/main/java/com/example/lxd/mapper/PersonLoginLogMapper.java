package com.example.lxd.mapper;

import com.example.lxd.entity.PersonLoginLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Smallke
* @description 针对表【person_login_log(登录日志表)】的数据库操作Mapper
* @createDate 2023-02-08 23:35:05
* @Entity com.example.lxd.entity.PersonLoginLog
*/
public interface PersonLoginLogMapper {
    //记录登录日志
    int createLog(PersonLoginLog personLoginLog);
    List<PersonLoginLog> getLogPage();
    int deleteById(int id);
}




