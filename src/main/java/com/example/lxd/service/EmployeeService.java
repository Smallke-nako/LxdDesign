package com.example.lxd.service;

import com.example.lxd.config.page.PageRequest;
import com.example.lxd.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.lxd.entity.Users;

import java.util.List;

/**
* @author Smallke
* @description 针对表【employee】的数据库操作Service
* @createDate 2023-03-01 16:36:50
*/
public interface EmployeeService {
    /**
     * 查询所有员工列表
     * @return
     */
    List<Employee> findAll(PageRequest pageRequest);

    List<Employee> findByName(PageRequest pageRequest,String name);

    /**
     * 添加员工
     * @param employee
     */
    void createEmployee(Employee employee);

    /**
     * 修改员工信息
     * @param employee
     */
    void updateEmployee(Employee employee);

    /**
     * 删除员工
     * @param id
     */
    void deleteEmployee(int id);
}
