package com.example.lxd.service.impl;

import com.example.lxd.config.page.PageRequest;
import com.example.lxd.entity.Users;
import com.example.lxd.mapper.UsersMapper;
import com.example.lxd.service.UsersService;
import com.example.lxd.util.CheckUtil;
import com.example.lxd.util.MD5Util;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
* @author Smallke
* @description 针对表【users】的数据库操作Service实现
* @createDate 2022-10-07 00:34:42
*/
@Service
public class UsersServiceImpl  implements UsersService {
    @Autowired
    UsersMapper usersMapper;
    //获取用户信息列表
    @Override
    public List<Users> findAll(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        return usersMapper.findAll();
    }
    //添加用户
    @Override
    public String createUser(Users user) {
        Users info = usersMapper.findByUsername(user.getUsername());
        String pwd = user.getPassword();
        String phone = user.getPhone();
        char []chars = pwd.toCharArray();
        CheckUtil testUtil = new CheckUtil();
        testUtil.check(pwd);
        if (chars.length <= 5) {
            return "203";//检查密码长度是否小于6位
        }else if(chars.length >= 11){
            return "205";//密码长度小于12位
        } else if(!testUtil.check(pwd)){
            return "204";//检查首字母是否为大写
        } else if (info != null) {
                    return "134";
        } else if (phone == null){
                return "023";
        } else {
                    try {
                        String uuid = UUID.randomUUID().toString().replace("-", "");
                        String newPwd = MD5Util.encryptPassword("MD5", user.getPassword(), uuid, 1024);//1024：加密次数,uuid:生成的UUID编码，作为加密使用的盐值
                        user.setPassword(newPwd);
                        user.setSalt(uuid);
                        usersMapper.insert(user);
                        return "200";
                    } catch (Exception e) {
                        e.printStackTrace();
                        return "502";
                    }
                }
    }
    //更新用户信息
    @Override
    public String updateUser(Users user) {
                usersMapper.update(user);
                return "200";
    }
    //删除用户信息
    @Override
    public void deleteUser(int id) {
        usersMapper.delete(id);
    }
    //根据用户查找
    @Override
    public Users getUsersByusername(String username) {
        if(username == null){
            return null;
        }
        return usersMapper.findByUsername(username);
    }
}




