package com.example.lxd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lxd.config.page.PageRequest;
import com.example.lxd.entity.Employee;
import com.example.lxd.service.EmployeeService;
import com.example.lxd.mapper.EmployeeMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Smallke
* @description 针对表【employee】的数据库操作Service实现
* @createDate 2023-03-01 16:36:50
*/
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        return employeeMapper.findAll();
    }

    @Override
    public List<Employee> findByName(PageRequest pageRequest,String name) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        return employeeMapper.findByName(name);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.update(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeMapper.deleteById(id);
    }
}




