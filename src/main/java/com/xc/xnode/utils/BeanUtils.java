package com.xc.xnode.utils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import org.dozer.DozerBeanMapper;

import com.google.common.collect.Lists;

/**
 * 
 */
public class BeanUtils {

    private static final DozerBeanMapper DOZER = new DozerBeanMapper();

    /**
     * @param source
     * @param destinationClass
     * @return
     */
    public static <T> T map(Object source, Class<T> destinationClass) {
        return DOZER.map(source, destinationClass);
    }

    /**
     * @param sourceList
     * @param destinationClass
     * @return
     */
    public static <T> List<T> mapList(Collection<?> sourceList, Class<T> destinationClass) {
        List<T> destinationList = Lists.newArrayList();
        for (Object sourceObject : sourceList) {
            T destinationObject = DOZER.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    /**
     * @param source
     * @param destinationObject
     */
    public static void copy(Object source, Object destinationObject) {
        DOZER.map(source, destinationObject);
    }
    
    /**
     * 判断一个对象是否为空,其本身是否为null,或其每一个属性是否都为null或是""
     * @param obj
     */
    public static boolean isEmpty(Object obj){
	    try {
	    	if(null == obj){
	    		return true;
	    	}
	    	boolean flag = false;
	    	for (Field f : obj.getClass().getDeclaredFields()) {
	    	    f.setAccessible(true);
	    	    //判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
				if (f.get(obj) == null || f.get(obj) == "") { 
					flag = true;
				}else{
					flag = false;
				}
	    	}
	    	if(flag){
	    		return true;
	    	}else{
	    		return false;
	    	}
		} catch (IllegalArgumentException e) {
			return false;
		} catch (IllegalAccessException e) {
			return false;
		}
    }
    
    /**
     * 判断一个对象是否不为空
     * @param obj
     */
    public static boolean isNotEmpty(Object obj){
    	return !isEmpty(obj);
    }
}