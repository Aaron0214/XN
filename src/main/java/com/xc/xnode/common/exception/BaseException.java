/**
 * 
 */
package com.xc.xnode.common.exception;

import java.io.Serializable;
import java.util.Arrays;

import com.xc.xnode.utils.SpringUtils;

/**
 * @author cexu
 *
 */
public class BaseException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 变量名:errorCode
     * 描述:  错误代码
     * 取值含义:不同代码对应不用的异常
     */

    private String            errorCode;

    private Object[]          args;

    /**
     * NFSQException构造函数
     *
     * @param exceptionMsg
     * @param errorCode
     */
    public BaseException(String exceptionMsg, String errorCode) {
        super(exceptionMsg);
        this.errorCode = errorCode;
    }

    /**
     * NFSQException构造函数
     *
     * @param errorCode
     */
    public BaseException(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * NFSQException构造函数.
     * 
     * @param exceptionMsg
     * @param errorCode
     * @param args
     *            填充errormessage中的参数数组
     */
    public BaseException(String exceptionMsg, String errorCode, Object[] inputArgs) {
        super(exceptionMsg);
        this.errorCode = errorCode;
        if (args == null) {
            this.args = new Object[0];
        } else {
            this.args = Arrays.copyOf(inputArgs, inputArgs.length);
        }
    }

    /**
     * NFSQException构造函数.
     * 
     * @param exceptionMsg
     * @param errorCode
     * @param args
     *            填充errormessage中的参数数组
     * @param exception
     */
    public BaseException(String exceptionMsg, String errorCode, Object[] inputArgs, Exception exception) {
        super(exceptionMsg, exception);
        this.errorCode = errorCode;
        if (args == null) {
            this.args = new Object[0];
        } else {
            this.args = Arrays.copyOf(inputArgs, inputArgs.length);
        }
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
     *            the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the args
     */
    public Object[] getArgs() {
        return args;
    }

    /**
     * @param args
     *            the args to set
     */
    public void setArgs(final Object[] inputArgs) {
        if (args == null) {
            this.args = new Object[0];
        } else {
            this.args = Arrays.copyOf(inputArgs, inputArgs.length);
        }
    }
    
    @Override
	public String toString() {
		return SpringUtils.getMessage(errorCode);
	}

}
