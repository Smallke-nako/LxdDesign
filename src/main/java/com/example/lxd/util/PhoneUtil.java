package com.example.lxd.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneUtil {
    /**
     * 验证手机号
     * @param mobile
     * @return
     */
    public static boolean checkMobile(String mobile){
        String phone_regex = "^((13[0-9])|(14[1,2,3,5,7,8,9])|(15[0-9])|(166)|(191)|(17[0,1,2,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (mobile.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(phone_regex);
            Matcher m = p.matcher(mobile);
            boolean isPhone = m.matches();
            if (!isPhone) {
                return false;
            }
            return true;
        }
    }

}
