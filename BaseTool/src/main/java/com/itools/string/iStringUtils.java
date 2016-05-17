package com.itools.string;

import java.math.BigDecimal;

/**
 * 描述：该工具类主要是提供针对string对象的一些常用操作方法
 *
 * Created by Jiang zubing on 2016/4/26.
 *
 * ***************更新历史*******************
 */
public class iStringUtils {
    /**
     * 判断String串是否为空
     * @param str
     * @return 空(true),非空（false）
     */
    public static boolean isEmpty(String str){
        if(str == null) return true;
        if(str.length() == 0) return true;
        return false;

    }

    /**
     * String转int
     * @param value
     * @param def 默认值
     * @return
     */
    public static int string2Int(String value,int def){
        try {
            return Integer.parseInt(value);
        }catch (Exception e){
            return def;
        }
    }

    /**
     * 将金额保留n位小数,整数将会转换成N.00,小数位不足时用0补位
     * @param money
     * @param scale 小数位
     * @return
     */
    private static String formatMoney(double money,int scale){
        String format = "%." + scale + "f";
        return String.format(format,money);

    }
}
