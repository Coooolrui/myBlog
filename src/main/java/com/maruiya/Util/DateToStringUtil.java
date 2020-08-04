package com.maruiya.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author MaRuiYa
 */
public class DateToStringUtil {
    public static String getDateString(){
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String blogId = format.format(date);
        return blogId;
    }
}
