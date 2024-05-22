package com.example.lxd.service.impl;

import com.example.lxd.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Configuration
@EnableScheduling
public class CopyListTask {
    @Autowired
    EmployeeMapper employeeMapper;

    LocalDateTime time = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
    String date = formatter.format(time);

    //添加计时任务
    //@Scheduled(cron = "0/5 * * * * ?") 每隔5秒执行一次（测试用）
    @Scheduled(cron = "0 0 4 * * ?") //每日早上4点创建打卡表
    private void configureTasks(){
        employeeMapper.copyList();
        System.out.println("已制作打卡表（每日4点）");
    }
}
