package com.xc.xnode.common.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/common")
public class CommonController {
	
	/**
	 * 权限错误
	 * @throws IOException 
	 */
	@RequestMapping("/unauthorized")
	public String unauthorized(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && "XMLHttpRequest".equalsIgnoreCase(requestType)) {
			response.addHeader("loginStatus", "unauthorized");
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		return "/common/unauthorized";
	}
	
	/**
	 * 主页
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(HttpServletRequest request,ModelMap model) {
		return "/common/main";
	}
	
	/**
	 * 主页
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request,ModelMap model) {
		
		return "/common/index";
	}
	
	@RequestMapping(value="error",method = RequestMethod.GET)
	public String error(Model model){
		return "common/error";
	}
	
}
