package com.itools.string;

/**
 * 描述：该工具类主要是提供针对string对象的一些常用操作方法
 *
 * Created by Jiang zubing on 2016/4/26.
 *
 * ***************更新历史*******************
 */
public class iStringUtils {

    public static boolean isEmpty(String str){
        if(str == null) return true;
        if(str.length() == 0) return true;
        return false;

    }
}
