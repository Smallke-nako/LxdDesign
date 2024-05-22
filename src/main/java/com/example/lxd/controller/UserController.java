package com.example.lxd.controller;

import cn.hutool.core.util.StrUtil;
import com.example.lxd.config.page.PageRequest;
import com.example.lxd.config.page.PageResult;
import com.example.lxd.controller.common.PageRequestApi;
import com.example.lxd.entity.Users;
import com.example.lxd.service.UsersService;
import com.example.lxd.util.JsonResult;
import com.example.lxd.util.PageUtil;
import com.example.lxd.util.PhoneUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "用户信息管理")
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UsersService usersService;
    /**
     * 获取用户列表
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "用户列表")
    @PostMapping("/list")
    public JsonResult<Object> list(@RequestBody @Valid PageRequestApi<PageRequest> pageRequest){
        List<Users> usersList = usersService.findAll(pageRequest.getBody());
        PageInfo pageInfo = new PageInfo(usersList);
        PageResult pageResult = PageUtil.getPageResult(pageRequest.getBody(),pageInfo);
        return JsonResult.success(pageResult);
    }

    /**
     * 添加用户
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "添加用户")
    @PostMapping("/create")
    public JsonResult<Object> userCreate(@RequestBody @Valid Users user) {
        //检查手机格式是否正确
        if(!PhoneUtil.checkMobile(user.getPhone())){
            return JsonResult.error("手机号码格式有误");
        }
        if(user.getUsername() != null && user.getPassword() != null) {
            String msg = usersService.createUser(user);
            if ("134".equals(msg)) {
                return JsonResult.error("该账户已被注册！");
            } else if ("502".equals(msg)) {
                return JsonResult.error("注册失败");
            }else if("204".equals(msg)){
                return JsonResult.error("密码首字符为字母且首字母要求大写");
            }else if("203".equals(msg)){
                return JsonResult.error("密码长度不小于6位");
            } else if("205".equals(msg)){
                return JsonResult.error("密码长度不超过12位");
            }else if("023".equals(msg)){
                return JsonResult.success("请注意手机号码为空");
            } else {
                return JsonResult.success();
            }
        }else {
            return JsonResult.error("用户名和密码不能为空");
        }
    }

    /**
     *
     * 修改用户
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "更新用户")
    @PostMapping("/update")
    public JsonResult<Object> userUpdate(@RequestBody @Valid Users user) {
        //检查手机格式是否正确
        if(!PhoneUtil.checkMobile(user.getPhone())){
            return JsonResult.error("手机号码格式有误");
        }
        usersService.updateUser(user);
        return JsonResult.success();
    }


    /**
     * 删除
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "删除用户")
    @PostMapping("/delete")
    public JsonResult<Object> userDelete(@RequestParam(value = "id") int id) {
        usersService.deleteUser(id);
        return JsonResult.success();
    }

}
