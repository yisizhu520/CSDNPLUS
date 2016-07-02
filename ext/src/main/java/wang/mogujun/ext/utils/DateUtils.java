package wang.mogujun.ext.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by WangJun on 2016/4/13.
 */
public class DateUtils {

    private static SimpleDateFormat sTimeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private static SimpleDateFormat sDateFormat = new SimpleDateFormat("MM-dd", Locale.getDefault());
    private static SimpleDateFormat sYearFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private static SimpleDateFormat sDetailFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    public static String getFlexibleDate(String dateStr){
        if (TextUtils.isEmpty(dateStr)) {
            return "神秘时间";
        }
        Date date;
        try {
            date = sDetailFormat.parse(dateStr);
        } catch (ParseException e) {
            return "神秘时间";
        }
        return getFlexibleDate(date);
    }

    public static String getFlexibleDate(long dateMills){
        //MARK 不知道为啥CSDN不直接传正常的时间long
        if(String.valueOf(dateMills).length() <= 10){
            dateMills = dateMills * 1000L;
        }
        return getFlexibleDate(new Date(dateMills));
    }

    public static String getFlexibleDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Calendar now = Calendar.getInstance();
        long interval = (System.currentTimeMillis() - date.getTime()) / 1000;//秒
        if (interval / (5 * 60) == 0) {
            return "刚刚";
        }
        if (interval / (30 * 60) == 0) {
            return "半小时内";
        }
        if (interval / (60 * 60) == 0) {
            return "1小时内";
        }
        if (cal.get(Calendar.YEAR) == now.get(Calendar.YEAR)) {
            if (cal.get(Calendar.DAY_OF_YEAR) == now.get(Calendar.DAY_OF_YEAR)) {
                return "今天 " + sTimeFormat.format(date);
            }
            if (cal.get(Calendar.DAY_OF_YEAR) == now.get(Calendar.DAY_OF_YEAR) - 1) {
                return "昨天 " + sTimeFormat.format(date);
            }
            return sDateFormat.format(date);
        }
        return sYearFormat.format(date);

    }

}
