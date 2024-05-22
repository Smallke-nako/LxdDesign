package com.example.lxd.service;

import com.example.lxd.config.page.PageRequest;
import com.example.lxd.entity.AttendanceRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Smallke
* @description 针对表【attendance_record】的数据库操作Service
* @createDate 2023-03-01 21:22:12
*/
public interface AttendanceRecordService {
    /**
     * 打卡列表
     * @param pageRequest
     * @return
     */
    List<AttendanceRecord> findAll(PageRequest pageRequest);

    /**
     * 更新打卡状态
     * @param attendanceRecord
     */
    void update(AttendanceRecord attendanceRecord);

    void createList();

    List<AttendanceRecord> selectDateTime(PageRequest pageRequest,String dateValue);

}
