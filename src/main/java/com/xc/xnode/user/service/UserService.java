package com.xc.xnode.user.service;

import java.util.List;

import com.xc.xnode.codedict.beans.CodeDictBean;
import com.xc.xnode.codedict.beans.DistrictBeanList;
import com.xc.xnode.common.exception.BaseException;
import com.xc.xnode.user.beans.PasswordBean;
import com.xc.xnode.user.beans.UserBean;
import com.xc.xnode.user.beans.UserOperateBean;
import com.xc.xnode.user.beans.UserSearchBean;
import com.xc.xnode.user.beans.UserShowBean;

public interface UserService {
	
	public UserOperateBean selectUserByUserName(String username);
	
	public List<CodeDictBean> getDistrictList(String districtCode);
	
	public void update(UserBean userBean) throws BaseException;
	
	public DistrictBeanList getSelectDistrict(String username);
	
	public void changePassword(PasswordBean passwordBean) throws BaseException;
	
	public List<UserShowBean> selectUserList(UserSearchBean searchBean) throws BaseException;
	
	public void unlock(Integer userId);
}
