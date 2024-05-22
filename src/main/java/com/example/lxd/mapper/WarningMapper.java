package com.example.lxd.mapper;

import com.example.lxd.entity.Warning;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author Smallke
* @description 针对表【warning】的数据库操作Mapper
* @createDate 2022-12-01 20:38:52
* @Entity com.example.lxd.entity.Warning
*/
@Repository
public interface WarningMapper {
    List<Warning> findAll();
    int deleteById(int id);
}




