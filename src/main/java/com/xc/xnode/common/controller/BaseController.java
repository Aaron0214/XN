/**
 * 
 */
package com.xc.xnode.common.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xc.xnode.Message;
import com.xc.xnode.common.exception.BaseException;
import com.xc.xnode.template.directive.FlashMessageDirective;
import com.xc.xnode.user.dao.UserMapper;
import com.xc.xnode.user.domain.User;
import com.xc.xnode.utils.StringUtils;

/**
 * @author admin
 *
 */
@Controller
public class BaseController {
	
	/** 错误视图 */
	protected static final String	ERROR_VIEW								= "redirect:/common/error.jhtml";
	
	/** 错误消息 */
	protected static final Message	ERROR_MESSAGE							= Message.error("common.message.error");
	
	/** 错误消息 */
	protected static final Message	LOGIN_ERROR_MESSAGE						= Message.error("common.message.loginfailed");
	
	/** 成功消息 */
	protected static final Message	SUCCESS_MESSAGE							= Message.success("common.message.success");
	
	protected static final String   COUNTRY_CODE 							= "832";
	
	protected static final String   USERNAME                                = "org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY";
	
	@Autowired
	private UserMapper userMapper;
	/**
	 * 添加瞬时消息
	 * 
	 * @param redirectAttributes
	 *            RedirectAttributes
	 * @param message
	 *            消息
	 */
	protected void addFlashMessage(RedirectAttributes redirectAttributes, Message message) {
		if (redirectAttributes != null && message != null) {
			redirectAttributes.addFlashAttribute(FlashMessageDirective.FLASH_MESSAGE_ATTRIBUTE_NAME, message);
		}
	}
	
	/**
	 * 获得当前登陆用户
	 * 
	 * @param session
	 *            
	 */
	protected User getCurrentUser(HttpSession session) throws BaseException{
		if(null != session.getAttribute(USERNAME)){
			String username = session.getAttribute(USERNAME).toString();
			if(StringUtils.isNotEmpty(username)){
				User user = userMapper.selectUserByUserName(username);
				if(null == user){
					throw new BaseException("common.user.notfound");
				}
				return user;
			}else{
				throw new BaseException("common.session.timeout");
			}
		}else{
			throw new BaseException("common.session.timeout");
		}
		
	}

}
