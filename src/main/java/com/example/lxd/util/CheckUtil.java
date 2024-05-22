package com.example.lxd.util;

/**
 * 格式检查正则表达式
 */
public class CheckUtil {
    //密码格式检查正则表达式
    public static final String LETTER_PATTERN="^[A-Z][A-Za-z0-9]{1,11}$";

    //密码格式检测函数
    public boolean check(String pwd){
        return pwd.matches(LETTER_PATTERN);
    }

}
