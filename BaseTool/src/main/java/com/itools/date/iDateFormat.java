package com.itools.date;

import com.itools.string.iStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Vendor：东软
 * <p/>
 * 描述：
 * <p/>
 * Created by Jiang zubing on 2016/4/26.
 * <p/>
 * ***************更新历史*******************
 */
public class iDateFormat {
    /**
     * 格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";
    /**
     * 格式：yyyyMMddHHmmss
     */
    public static final String FORMAT_YYYYMMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 将时间转换成指定的格式
     * @param time 时间
     * @param format 默认：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String format(long time,String format){
        if(iStringUtils.isEmpty(format))
            format = FORMAT_TIME;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(time));
    }

    /**
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date,String format){
        return format(date.getTime(),format);
    }
}
