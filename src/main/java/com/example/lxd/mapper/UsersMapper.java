package com.example.lxd.mapper;

import com.example.lxd.entity.Users;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author Smallke
* @description 针对表【users】的数据库操作Mapper
* @createDate 2022-10-07 00:34:42
* @Entity com.example.lxda.entity.Users
*/
@Repository
public interface UsersMapper {
   List<Users> findAll();
    /**
     * 添加用户
     * @param user
     * @return
     */
    void insert(Users user);

    /**
     * 更新用户
     * @param user
     */
    void update(Users user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int delete(int id);

    Users findByUsername(String username);
}




