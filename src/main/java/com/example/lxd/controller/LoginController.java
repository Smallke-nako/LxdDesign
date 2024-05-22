package com.example.lxd.controller;

import com.example.lxd.entity.ErrorCode;
import com.example.lxd.entity.PersonLoginLog;
import com.example.lxd.entity.Users;
import com.example.lxd.mapper.EchartsMapper;
import com.example.lxd.mapper.EmployeeMapper;
import com.example.lxd.service.EchartsService;
import com.example.lxd.service.PersonLoginLogService;
import com.example.lxd.service.UsersService;
import com.example.lxd.util.IpUtil;
import com.example.lxd.util.JsonResult;
import com.example.lxd.util.PhoneUtil;
import com.example.lxd.util.ServletUtils;
import eu.bitwalker.useragentutils.UserAgent;
import io.swagger.annotations.Api;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Api(tags = "用户登录")
@CrossOrigin
@RestController
@RequestMapping("/users")
public class LoginController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private PersonLoginLogService personLoginLogService;
    @Autowired
    private EchartsService echartsService;

    /**
     * 登录
     * @param users
     * @return
     */
    @CrossOrigin
    @PostMapping("/login")
    public JsonResult<Object> login(@RequestBody Users users){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(users.getUsername(), users.getPassword(),false);
        try {
            //执行登录方法，如果没有异常，就OK
            //login()方法会调用 Realm类中执行认证逻辑的方法，
            //并将这个参数传递给doGetAuthenticationInfo()方法
            subject.login(token);
            Map<String, Object> ret = new HashedMap();
            ret.put("token", subject.getSession().getId());
            getLoginInfoLog(users,0);
            echartsService.updateSystemLoginSuccessCount();
            echartsService.updateSystemLoginCount();
            return JsonResult.success(ret);
        } catch (Exception e) {
            e.printStackTrace();
            getLoginInfoLog(users,1);
            echartsService.updateSystemLoginFailCount();
            echartsService.updateSystemLoginCount();
            return JsonResult.error("用户名or密码有误");
        }
    }

    /**
     * 获取登录日志
     */
    public void getLoginInfoLog(Users users, Integer status) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) Objects.requireNonNull(requestAttributes).resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //解析agent字符串
        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));

        //登录账号
        PersonLoginLog personLoginLog = new PersonLoginLog();
        personLoginLog.setLoginName(users.getUsername());

        //登录IP地址
        String ipAddr = IpUtil.getIpAddr(request);
        personLoginLog.setIpAddress(ipAddr);
        //登录地点
        String ipInfo = IpUtil.getIpInfo(ipAddr);
        personLoginLog.setLoginLocation(ipInfo);
        //浏览器类型
        String browser = userAgent.getBrowser().getName();
        personLoginLog.setBrowserType(browser);
        //操作系统
        String os = userAgent.getOperatingSystem().getName();
        personLoginLog.setOs(os);
        //登录状态
        personLoginLog.setStatus(status);
        personLoginLogService.saveLog(personLoginLog);
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @CrossOrigin
    @PostMapping("/register")
    public JsonResult<Object> addUser(@RequestBody @Valid Users user){
        if(user.getUsername() == null && user.getPassword() == null){
            return JsonResult.error("用户名和密码不能为空");
        }
        //检查手机格式是否正确
        if(user.getPhone() == null){
            return JsonResult.error("手机号码不能为空");
        }
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
            } else if("023".equals(msg)){
                return JsonResult.error("手机号码不能为空");
            } else {
                return JsonResult.success();
            }
        }else {
            return JsonResult.error("用户名和密码不能为空");
        }

    }

    /**
     * 登录info信息
     * @return
     */
    @CrossOrigin
    @GetMapping("/info")
    public JsonResult<Object> info(){
        Map<String, Object> ret = new HashMap<>(3);
        ret.put("roles", "[admin]");
        ret.put("name", "admin");
        ret.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return JsonResult.success(ret);
//        https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif
    }

    /**
     * 登出账号
     * @return
     */
    @CrossOrigin
    @PostMapping("/logout")
    public JsonResult<Object> logout(){
        Subject subject =SecurityUtils.getSubject();
        subject.logout();
        return JsonResult.success("成功登出");
    }

    @CrossOrigin
    @RequestMapping("/unauth")
    public JsonResult<Object> unauth(){
        return JsonResult.error(ErrorCode.NOT_LOGIN);
    }
}
