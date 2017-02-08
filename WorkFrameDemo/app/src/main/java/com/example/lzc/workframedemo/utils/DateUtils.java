package com.example.lzc.workframedemo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 类描述：时间格式化工具
 * 创建人：zz
 * 创建时间：2016/11/24 17:32
 */
public class DateUtils {

    public static String getNowDate() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        return df.format(date);
    }
    public static String getNowDate2() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }
    public  static String getDateFormat(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
    public  static String getDateFormatM(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        return format.format(date);
    }
    public  static String getDateFormatM(long date) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        return format.format(date * 1000L);
    }
    public  static Date getDateFormat(String dateS) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public  static Date getDateFormat2(String dateS) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = format.parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public  static String getDateFormat2(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        return format.format(date);
    }
    public static String FormatSecond(long duration) {
        int minute = (int)duration / 60;
        int second = (int)duration % 60;
        String result = "";
        if(minute < 10){
            result = "0" + minute + ":";
        }else{
            result = minute + ":";
        }
        if(second < 10){
            result += "0" + second;
        }else{
            result += second;
        }
        return result;

    }


    public static String getDateFormat(long time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        return df.format(time * 1000L);
    }

    public static String getDateFormatChina(long time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(time * 1000L);
    }



    public static int getAge(long time) {
        int age = 0;
        Date now = new Date();
        Date birthdayDate = new Date(time);
        SimpleDateFormat formatY= new SimpleDateFormat("yyyy");
        SimpleDateFormat formatM = new SimpleDateFormat("MM");

        String birthYear = formatY.format(birthdayDate);
        String thisYear = formatY.format(now);

        String birth_month = formatM.format(birthdayDate);
        String this_month = formatM.format(now);
        age = Integer.parseInt(thisYear) - Integer.parseInt(birthYear);
        if (this_month.compareTo(birth_month) < 0){
            age -= 1;
        }
        if (age < 0){
            age = 0;
        }
        return age;
    }

    public static String getBirthday(int age){
        Calendar calendar = Calendar.getInstance();
        int yearNow = calendar.get(Calendar.YEAR);
        calendar.set(Calendar.YEAR,yearNow-age);
        Date date =(Date) calendar.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date.getTime());
    }

    public static Date getSpecifiedDayAfter() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, day + 1);
        return calendar.getTime();
    }

    public static Date getSpecifiedDay() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, day);
        return calendar.getTime();
    }

    public static Date getSpecifiedDay(int age) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        Date date = new Date();
        calendar.setTime(date);
        if((year-age) > 0){
            calendar.set(Calendar.YEAR, year-age);
        }else{
            calendar.set(Calendar.YEAR, year);
        }
        return calendar.getTime();
    }

    public static long getTodayZero() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        //cal.setTimeZone(TimeZone.getTimeZone(UTC + 8));
        cal.setTime(date);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    public static String getDetailTime(){
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }
}
