package com.example.lxd;

import com.example.lxd.Realm.MyShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {

    /**
     * 配置过滤规则
     *
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/users/logout", "anon");
        // 配置不会被拦截的链接 顺序判断
        /*
            anon：无需认证就可以访问
            authc：必须认证了才能访问
            user：必须拥有 记住我 功能才能使用
            perms：拥有对某个资源的权限才能访问
            role：拥有某个角色权限才能访问
         */
        filterChainDefinitionMap.put("/static/**", "anon");
        /**
         * User账号管理
         */
        filterChainDefinitionMap.put("/user/login", "anon");
        filterChainDefinitionMap.put("/user/list", "anon");
        filterChainDefinitionMap.put("/users/login", "anon");
        filterChainDefinitionMap.put("/users/register", "anon");
        filterChainDefinitionMap.put("/user/delete", "anon");
        filterChainDefinitionMap.put("/user/create", "anon");
        filterChainDefinitionMap.put("/user/update", "anon");
        filterChainDefinitionMap.put("/users/info", "anon");
        //配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
        filterChainDefinitionMap.put("/user/unauth", "anon");
        filterChainDefinitionMap.put("/users/unauth", "anon");
        /**
         * 图片记录
         */
        filterChainDefinitionMap.put("/warn/list", "anon");
        filterChainDefinitionMap.put("/warn/delete", "anon");
        /**
         * 登录日志管理
         */
        filterChainDefinitionMap.put("/loginlog/list", "anon");
        filterChainDefinitionMap.put("/loginlog/delete", "anon");
        /**
         * 每日打卡表管理
         */
        filterChainDefinitionMap.put("/attendance/list", "anon");
        filterChainDefinitionMap.put("/attendance/date", "anon");
        filterChainDefinitionMap.put("/attendance/update", "anon");
        filterChainDefinitionMap.put("/attendance/deleteTable", "anon");
        filterChainDefinitionMap.put("/attendance/createTable", "anon");
        /**
         * 员工信息管理
         */
        filterChainDefinitionMap.put("/employee/list", "anon");
        filterChainDefinitionMap.put("/employee/create", "anon");
        filterChainDefinitionMap.put("/employee/delete", "anon");
        filterChainDefinitionMap.put("/employee/update", "anon");
        /**
         * Echarts获取
         */
        filterChainDefinitionMap.put("/echarts/employeeCount", "anon");
        filterChainDefinitionMap.put("/echarts/oneTeamCount", "anon");
        filterChainDefinitionMap.put("/echarts/twoTeamCount", "anon");
        filterChainDefinitionMap.put("/echarts/threeTeamCount", "anon");
        filterChainDefinitionMap.put("/echarts/fourTeamCount", "anon");
        filterChainDefinitionMap.put("/echarts/fiveTeamCount", "anon");
        filterChainDefinitionMap.put("/echarts/AttendanceCount", "anon");
        filterChainDefinitionMap.put("/echarts/oneTeamAttendanceCount", "anon");
        filterChainDefinitionMap.put("/echarts/twoTeamAttendanceCount", "anon");
        filterChainDefinitionMap.put("/echarts/threeTeamAttendanceCount", "anon");
        filterChainDefinitionMap.put("/echarts/fourTeamAttendanceCount", "anon");
        filterChainDefinitionMap.put("/echarts/fiveTeamAttendanceCount", "anon");
        filterChainDefinitionMap.put("/echarts/UnAttendanceCount", "anon");
        filterChainDefinitionMap.put("/echarts/oneTeamUnAttendanceCount", "anon");
        filterChainDefinitionMap.put("/echarts/twoTeamUnAttendanceCount", "anon");
        filterChainDefinitionMap.put("/echarts/threeTeamUnAttendanceCount", "anon");
        filterChainDefinitionMap.put("/echarts/fourTeamUnAttendanceCount", "anon");
        filterChainDefinitionMap.put("/echarts/fiveTeamUnAttendanceCount", "anon");
        filterChainDefinitionMap.put("/echarts/SystemLoginCount", "anon");
        filterChainDefinitionMap.put("/echarts/SystemLoginSuccessCount", "anon");
        filterChainDefinitionMap.put("/echarts/SystemLoginFailCount", "anon");
        filterChainDefinitionMap.put("/echarts/UsersCount", "anon");

        filterChainDefinitionMap.put("/**", "authc");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * ）
     *
     *
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
//        //散列的次数，比如散列两次，相当于 md5(md5(""));
//        hashedCredentialsMatcher.setHashIterations(1);
        hashedCredentialsMatcher.setHashIterations(1024);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }

    /**
     * 创建 Realm
     * 作用： 将该方法返回的对象放入spring容器
     */
    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setAuthorizationCachingEnabled(false);
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    /**
     * 开启aop注解支持
     *
     *
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }




}
