package com.xc.xnode.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String format1 = "yyyy-MM-dd";
    
    public static final String format2 = "yyyy-MM-dd HH:mm:ss";
    
    public static final String format3 = "yyyyMMdd";
    
    private static final String DAY_BEGIN = " 00:00:00";
    
    private static final String DAY_END = " 23:59:59";
    
    /**
	 * <p>
	 * 将时间字符串转化为 yyyy-MM-dd HH:mm:ss 的时间形式
	 * </p>
	 * 
	 * @param date
	 * @return
	 */
    public static Date parseDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(format1);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
        finally{
            sdf = null;
        }
    }

    public static Date parseDate(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
        finally{
            sdf = null;
        }
    }
    
    /**
	 * <p>
	 * 将时间转化为 yyyy-MM-dd 字符串形式
	 * </p>
	 * 
	 * @param date
	 * @return
	 */
    public static String parseDate(Date date) throws ParseException{
    	if(null == date){
    		return null;
    	}
    	DateFormat dateFormat = new SimpleDateFormat(format1);
    	try{
    		return dateFormat.format(date);
    	}finally{
    		dateFormat = null;
    	}
    }
    
    /**
	 * <p>
	 * 将时间转化为 yyyyMMdd 字符串形式
	 * </p>
	 * 
	 * @param date
	 * @return
	 */
    public static String parseDates(Date date) throws ParseException{
    	if(null == date){
    		return null;
    	}
    	DateFormat dateFormat = new SimpleDateFormat(format3);
    	try{
    		return dateFormat.format(date);
    	}finally{
    		dateFormat = null;
    	}
    }
    
    /**
	 * <p>
	 * 将时间转化为 yyyy-MM-dd HH:mm:ss 字符串形式
	 * </p>
	 * 
	 * @param date
	 * @return
	 */
    public static String parseLongDate(Date date) throws ParseException{
    	if(null == date){
    		return null;
    	}
    	DateFormat dateFormat = new SimpleDateFormat(format2);
    	try{
    		return dateFormat.format(date);
    	}finally{
    		dateFormat = null;
    	}
    }
    
    /**
	 * <p>
	 * 获取指定时间的当天开始时间
	 * </p>
	 * 
	 * param date
	 * @return
	 */
    public static Date dateBegin(Date date){
    	if(null == date){
    		return null;
    	}
    	DateFormat dateFormat = new SimpleDateFormat(format1);
    	SimpleDateFormat sdf = new SimpleDateFormat(format2);
    	try {
    		String simple_date = dateFormat.format(date);
    		String datetime = simple_date + DAY_BEGIN;
    		return sdf.parse(datetime);
		} catch(ParseException e){
			return null;
		}finally{
			sdf = null;
			dateFormat = null;
    	}
    }
    
    /**
	 * <p>
	 * 获取指定时间的当天结束时间
	 * </p>
	 * 
	 * param date
	 * @return
	 */
    public static Date dateEnd(Date date){
    	if(null == date){
    		return null;
    	}
    	DateFormat dateFormat = new SimpleDateFormat(format1);
    	SimpleDateFormat sdf = new SimpleDateFormat(format2);
    	try {
    		String simple_date = dateFormat.format(date);
    		String datetime = simple_date + DAY_END;
    		return sdf.parse(datetime);
		} catch(ParseException e){
			return null;
		}finally{
			sdf = null;
			dateFormat = null;
    	}
    }
    
    /**
	 * <p>
	 * 获取今天的开始时间
	 * </p>
	 * 
	 * @return
	 */
    public static Date todayBegin(){
    	DateFormat dateFormat = new SimpleDateFormat(format1);
    	SimpleDateFormat sdf = new SimpleDateFormat(format2);
    	try {
    		String simple_date = dateFormat.format(new Date());
    		String datetime = simple_date + DAY_BEGIN;
    		return sdf.parse(datetime);
		} catch(ParseException e){
			return null;
		}finally{
			sdf = null;
			dateFormat = null;
    	}
    }
    
    /**
	 * <p>
	 * 获取今天的结束时间
	 * </p>
	 * 
	 * @return
	 */
    public static Date todayEnd(){
    	DateFormat dateFormat = new SimpleDateFormat(format1);
    	SimpleDateFormat sdf = new SimpleDateFormat(format2);
    	try {
    		String simple_date = dateFormat.format(new Date());
    		String datetime = simple_date + DAY_END;
    		return sdf.parse(datetime);
		} catch(ParseException e){
			return null;
		}finally{
			sdf = null;
			dateFormat = null;
    	}
    }
}
