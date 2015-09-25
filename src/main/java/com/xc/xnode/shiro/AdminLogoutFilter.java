package com.xc.xnode.shiro;

import org.apache.shiro.web.filter.authc.LogoutFilter;

/**
 * @author cexu
 *
 */
public class AdminLogoutFilter extends LogoutFilter {
	/* private static final Logger log = LoggerFactory.getLogger(AdminLogoutFilter.class); */

	/*
	 * @Override protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception { Subject subject =
	 * getSubject(request, response); String redirectUrl = getRedirectUrl(request, response, subject); String
	 * userType=request.getParameter("userType"); if(AdminRoleUtil.isSupplierRole(userType)){ redirectUrl="/admin/supplier_login.jsp"; }else
	 * if(AdminRoleUtil.isSuperAdminRole(userType)){ redirectUrl="/admin/login.jsp"; } try { subject.logout(); } catch (SessionException
	 * ise) { log.debug("Encountered session exception during logout.  This can generally safely be ignored.", ise); }
	 * issueRedirect(request, response, redirectUrl); return false; }
	 */

}
