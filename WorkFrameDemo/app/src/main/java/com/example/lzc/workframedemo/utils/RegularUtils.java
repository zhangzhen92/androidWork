package com.example.lzc.workframedemo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类描述：正则验证
 * 创建人：zz
 * 创建时间： 2016/11/24 17:38
 */


public class RegularUtils {
    public static boolean isPhone(String inputText) {
        Pattern p = Pattern
                .compile("^(1[3-9])\\d{9}$");
        Matcher m = p.matcher(inputText);
        return m.matches();
    }

    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }


    /** 身份证号 */
    public static boolean identity_card(String identity_card) {
        // 验证通过返回true否则返回false
        return Pattern.matches("^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))+$", identity_card);
    }

    /** 名字 */
    public static boolean etName(String name) {
        // 验证通过返回true否则返回false
        return Pattern.matches("^[a-zA-Z0-9\u4e00-\u9fa5]{2,10}+$", name);
    }

}
