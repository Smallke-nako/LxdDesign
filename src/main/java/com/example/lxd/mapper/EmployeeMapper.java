package com.example.lxd.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.lxd.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author Smallke
* @description 针对表【employee】的数据库操作Mapper
* @createDate 2023-03-01 16:36:50
* @Entity com.example.lxd.entity.Employee
*/
@Repository
public interface EmployeeMapper {
   /**
    * 员工列表
    * @return
    */
   List<Employee> findAll();

   /**
    * 根据name查询员工信息
    * @param name
    * @return
    */
   List<Employee> findByName(String name);

   /**
    * 添加员工信息
    * @param employee
    */
   void insert(Employee employee);

   /**
    * 修改员工信息
    * @param employee
    */
   void update(Employee employee);

   /**
    * 删除
    * @param id
    * @return
    */
   int deleteById(int id);

   /**
    * 定时制作每日打卡表
    */
   void copyList();
}




