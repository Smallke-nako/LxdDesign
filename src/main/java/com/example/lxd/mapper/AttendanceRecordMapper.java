package com.example.lxd.mapper;

import com.example.lxd.entity.AttendanceRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author Smallke
* @description 针对表【attendance_record】的数据库操作Mapper
* @createDate 2023-03-01 21:22:12
* @Entity com.example.lxd.entity.AttendanceRecord
*/
@Repository
public interface AttendanceRecordMapper  {
    /**
     * 每日打卡列表
     * @return
     */
    List<AttendanceRecord> findAll();

    /**
     *  更新打卡状态
     * @param attendanceRecord
     */
    void updateStatusInt(AttendanceRecord attendanceRecord);

    void updateAttendanceCount();

    void updateUnAttendanceCount();



    void updateTeamAttendanceCount(AttendanceRecord attendanceRecord);


    List<AttendanceRecord> selectDateTime(AttendanceRecord attendanceRecord);
}




