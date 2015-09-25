package com.xc.xnode.utils;

import java.text.DecimalFormat;

public final class NumberFormatUtils {
	
	private static final String six_format = "######000000";
	
	/**
	 * <p>
	 * 将数字封装成6为数字字符
	 * </p>
	 * 
	 * @param value
	 * @return
	 */
	public static String formatNumber(Integer num){
		if(null == num){
    		return null;
    	}
		DecimalFormat numFormat = new DecimalFormat(six_format);
    	try{
    		return numFormat.format(num);
    	}finally{
    		numFormat = null;
    	}
	}
	
	/**
	 * <p>
	 * 还原数字
	 * </p>
	 * 
	 * @param value
	 * @return
	 */
	public static Integer returnNumber(String str){
		if(null == str){
    		return null;
    	}
		return Integer.parseInt(str);
	}
	
	public static void main(String[] a){
		System.out.println(returnNumber("000010"));
	}
}
