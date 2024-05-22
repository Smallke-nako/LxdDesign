package com.example.lxd.service;


import com.example.lxd.config.page.PageRequest;
import com.example.lxd.entity.Users;

import java.util.List;

/**
* @author Smallke
* @description 针对表【users】的数据库操作Service
* @createDate 2022-10-07 00:34:42
*/
public interface UsersService {
    /**
     * 查询所有用户列表
     * @return
     */
    List<Users> findAll(PageRequest pageRequest);

    /**
     * 添加用户
     * @param user
     */
    String createUser(Users user);

    /**
     * 修改用户信息
     * @param user
     */
    String updateUser(Users user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(int id);

    Users getUsersByusername(String username);

}
