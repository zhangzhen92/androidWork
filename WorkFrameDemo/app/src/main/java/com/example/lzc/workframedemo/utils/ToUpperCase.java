package com.example.lzc.workframedemo.utils;

import android.text.method.ReplacementTransformationMethod;

/**
 * 类描述：直接将EditText输入的内容由小写转为大写
 * 创建人：zz
 * 创建时间：2016/11/24 17:47
 */
public class ToUpperCase extends ReplacementTransformationMethod {
    @Override
    protected char[] getOriginal() {
        char[] aa = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' };
        return aa;
    }

    @Override
    protected char[] getReplacement() {
        char[] cc = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
        return cc;
    }
}
