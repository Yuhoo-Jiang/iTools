package com.itools.date;

import com.itools.string.iStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Vendor：东软
 * 描述：
 * Created by Jiang zubing on 2016/4/26.
 * ***************更新历史*******************
 * 20160505:增加按时间跨度获取时间串方法getDateStr()
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
     * 将Date转换成指定的日期格式
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date,String format){
        return format(date.getTime(),format);
    }

    /**
     * 根据传入的时间跨度及格式，返回对应的日期（时间)串;
     * 如：timeSpan = 604800000 表示返回7天后的时间（以当前时间为基准）
     * @param timeSpan 时间跨度，为0时表示取当前时间；为负数时表示向前推移，正数表示向后推移
     * @param format 时间串格式
     * @return
     */
    public static String getDateStr(long timeSpan,String format){
        long time = System.currentTimeMillis();
        time += timeSpan;
        return format(time,format);
    }
}
