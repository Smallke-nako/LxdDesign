package com.example.lxd.service.impl;

import com.example.lxd.config.page.PageRequest;
import com.example.lxd.entity.AttendanceRecord;
import com.example.lxd.mapper.EmployeeMapper;
import com.example.lxd.service.AttendanceRecordService;
import com.example.lxd.mapper.AttendanceRecordMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Smallke
* @description 针对表【attendance_record】的数据库操作Service实现
* @createDate 2023-03-01 21:22:12
*/
@Service
public class AttendanceRecordServiceImpl implements AttendanceRecordService{
    @Autowired
    AttendanceRecordMapper attendanceRecordMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<AttendanceRecord> findAll(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        return attendanceRecordMapper.findAll();
    }

    @Override
    public void update(AttendanceRecord attendanceRecord) {
        attendanceRecordMapper.updateStatusInt(attendanceRecord);
    }

    @Override
    public void createList() {
        employeeMapper.copyList();
    }


    @Override
    public List<AttendanceRecord> selectDateTime(PageRequest pageRequest, String dateValue) {
        AttendanceRecord attendanceRecord = new AttendanceRecord();
        attendanceRecord.setCreateTime(dateValue);
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        return attendanceRecordMapper.selectDateTime(attendanceRecord);
    }


}




