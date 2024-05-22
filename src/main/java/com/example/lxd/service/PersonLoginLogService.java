package com.example.lxd.service;

import com.example.lxd.config.page.PageRequest;
import com.example.lxd.entity.PersonLoginLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Smallke
* @description 针对表【person_login_log(登录日志表)】的数据库操作Service
* @createDate 2023-02-08 23:35:05
*/
public interface PersonLoginLogService {

    /**
     * 登录日志
     */
    void saveLog(PersonLoginLog personLoginLog);


    /**
     * 获取日志列表（分页）
     */
    List<PersonLoginLog> getLogPage(PageRequest pageRequest);

    void deleteLog(int id);
}
