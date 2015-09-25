/*
 * Project Name: xinyunlian-ecom
 * File Name: AuthenticationFilter.java
 * Class Name: AuthenticationFilter
 *
 * Copyright 2014 Hengtian Software Inc
 *
 * Licensed under the Hengtiansoft
 *
 * http://www.hengtiansoft.com
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xc.xnode.shiro;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.google.code.kaptcha.Constants;

/**
 * Filter - 权限认证
 * 
 * @author Hengtiansoft Team
 * @version 1.0_beta
 */

public class AuthenticationFilter extends FormAuthenticationFilter {

	
	/** 默认"加密密码"参数名称 */
	private static final String	DEFAULT_EN_PASSWORD_PARAM	= "password";

	/** 默认"验证码"参数名称 */
	private static final String	DEFAULT_CAPTCHA_PARAM		= "captcha";

	/** 默认"用户类型"参数名称 */
	private static final String	DEFAULT_USERTYPE_PARAM		= "userType";


	@Override
	protected org.apache.shiro.authc.AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) {
		String username = getUsername(servletRequest);
		String password = getPassword(servletRequest);
		boolean rememberMe = isRememberMe(servletRequest);
		String host = getHost(servletRequest);
		return new AuthenticationToken(username, password, rememberMe, host);
	}

	@Override
	protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && "XMLHttpRequest".equalsIgnoreCase(requestType) && request.getHeader("login") == null) {
			response.addHeader("loginStatus", "accessDenied");
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		}
		return super.onAccessDenied(request, response);
	}

	@Override
	protected boolean onLoginSuccess(org.apache.shiro.authc.AuthenticationToken token, Subject subject, ServletRequest servletRequest,
			ServletResponse servletResponse) throws Exception {
		Session session = subject.getSession();
		Map<Object, Object> attributes = new HashMap<Object, Object>();
		Collection<Object> keys = session.getAttributeKeys();
		for (Object key : keys) {
			attributes.put(key, session.getAttribute(key));
		}
		session.stop();
		session = subject.getSession();
		for (Entry<Object, Object> entry : attributes.entrySet()) {
			session.setAttribute(entry.getKey(), entry.getValue());
		}
//		WebUtils.issueRedirect(servletRequest, servletResponse, getSuccessUrl(), null, true);
//		return false;
		return super.onLoginSuccess(token, subject, servletRequest, servletResponse);
	}

	@Override
	protected String getPassword(ServletRequest servletRequest) {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String password = request.getParameter(DEFAULT_EN_PASSWORD_PARAM);
		return password;
	}

	@Override
	protected boolean onLoginFailure(org.apache.shiro.authc.AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		if (token instanceof AuthenticationToken) {
			AuthenticationToken authenticationToken = (AuthenticationToken) token;
			request.setAttribute("userName", authenticationToken.getUsername());
		}
		return super.onLoginFailure(token, e, request, response);
	}

	/**
	 * 获取验证文本
	 * 
	 * @param servletRequest
	 *            ServletRequest
	 * @return 验证文本
	 */
	protected String getCaptchaText(ServletRequest servletRequest) {
		return (String) ((HttpServletRequest) servletRequest).getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
	}

	/**
	 * 获取验证码
	 * 
	 * @param servletRequest
	 *            ServletRequest
	 * @return 验证码
	 */
	protected String getCaptcha(ServletRequest servletRequest) {
		return WebUtils.getCleanParam(servletRequest, DEFAULT_CAPTCHA_PARAM);
	}

	/**
	 * @param servletRequest
	 * @return
	 */
	public String getUserTypeParam(ServletRequest servletRequest) {
		return WebUtils.getCleanParam(servletRequest, DEFAULT_USERTYPE_PARAM);
	}

}
