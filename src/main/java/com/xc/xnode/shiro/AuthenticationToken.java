/*
 * Project Name: xinyunlian-ecom
 * File Name: AuthenticationToken.java
 * Class Name: AuthenticationToken
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

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 登录令牌
 * 
 * @author Hengtiansoft Team
 * @version 1.0_beta
 */
public class AuthenticationToken extends UsernamePasswordToken {

	private static final long	serialVersionUID	= 5898441540965086534L;

	/** 登陆ip */
	private String				host;

	/**
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param captchaText
	 *            验证码文本
	 * @param captcha
	 *            验证码
	 * @param rememberMe
	 *            记住我
	 * @param host
	 *            IP
	 */
	public AuthenticationToken(String username, String password, boolean rememberMe, String host) {
		super(username, password, rememberMe);
		this.host = host;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.shiro.authc.UsernamePasswordToken#getHost()
	 */
	public String getHost() {
		return host;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.shiro.authc.UsernamePasswordToken#setHost(java.lang.String)
	 */
	public void setHost(String host) {
		this.host = host;
	}

}
