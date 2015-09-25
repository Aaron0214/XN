package com.xc.xnode.user.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xc.xnode.codedict.beans.CodeDictBean;
import com.xc.xnode.codedict.beans.DistrictBeanList;
import com.xc.xnode.codedict.dao.CodeDictMapper;
import com.xc.xnode.codedict.domain.CodeDict;
import com.xc.xnode.common.exception.BaseException;
import com.xc.xnode.login.dao.LoginInfoMapper;
import com.xc.xnode.login.domain.LoginInfo;
import com.xc.xnode.user.beans.PasswordBean;
import com.xc.xnode.user.beans.UserBean;
import com.xc.xnode.user.beans.UserOperateBean;
import com.xc.xnode.user.beans.UserSearchBean;
import com.xc.xnode.user.beans.UserShowBean;
import com.xc.xnode.user.dao.AddressMapper;
import com.xc.xnode.user.dao.UserMapper;
import com.xc.xnode.user.domain.Address;
import com.xc.xnode.user.domain.User;
import com.xc.xnode.user.domain.UserEnty;
import com.xc.xnode.user.domain.UserInfo;
import com.xc.xnode.user.domain.UserShow;
import com.xc.xnode.user.enums.AddressTpeEnum;
import com.xc.xnode.user.enums.UserSexEnum;
import com.xc.xnode.user.enums.UserStatusEnum;
import com.xc.xnode.user.service.UserService;
import com.xc.xnode.utils.DateUtils;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private CodeDictMapper codeDictMapper;
	
	@Autowired
	private AddressMapper addressMapper;
	
	@Autowired
	private LoginInfoMapper loginInfoMapper;
	
	protected static final String   COUNTRY_CODE 							= "832";

	@Override
	public UserOperateBean selectUserByUserName(String username) {
		return bulidUserOperateBean(userMapper.selectUserInfoByUserName(username));
	}
	
	private UserOperateBean bulidUserOperateBean(UserInfo user){
		UserOperateBean userOperateBean = new UserOperateBean();
		try {
			userOperateBean.setId(user.getId());
			userOperateBean.setCode(user.getCode());
			userOperateBean.setName(user.getName());
			userOperateBean.setSex(user.getSex());
			userOperateBean.setBirth(DateUtils.parseDate(user.getBirth()));
			userOperateBean.setCreateDate(DateUtils.parseLongDate(user.getCreateDate()));
			userOperateBean.setModifyDate(DateUtils.parseLongDate(user.getModifyDate()));
			userOperateBean.setUsername(user.getUsername());
			userOperateBean.setComments(user.getComments());
			userOperateBean.setBirProvinceCode(user.getBirProvinceCode());
			userOperateBean.setBirProvinceValue(user.getBirProvinceValue());
			userOperateBean.setBirCityCode(user.getBirCityCode());
			userOperateBean.setBirCityCodeValue(user.getBirCityCodeValue());
			userOperateBean.setBirTownCode(user.getBirTownCode());
			userOperateBean.setBirTownCodeValue(user.getBirTownCodeValue());
			userOperateBean.setProvince(user.getProvince());
			userOperateBean.setProvinceValue(user.getProvinceValue());
			userOperateBean.setCity(user.getCity());
			userOperateBean.setCityValue(user.getCityValue());
			userOperateBean.setTown(user.getTown());
			userOperateBean.setTownValue(user.getTownValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return userOperateBean;
	}

	@Override
	public List<CodeDictBean> getDistrictList(String districtCode) {
		List<CodeDictBean> codeBeanList = new ArrayList<CodeDictBean>();
		List<CodeDict> districtList = codeDictMapper.selectDistictList(districtCode);
		for(CodeDict codeDict:districtList){
			CodeDictBean codeDictBean = bulidCodeDictBean(codeDict);
			codeBeanList.add(codeDictBean);
		}
		return codeBeanList;
	}

	@Override
	public void update(UserBean userBean) throws BaseException {
		try{
			//更新用户信息
			User user = userMapper.selectByPrimaryKey(userBean.getId());
			user.setBirth(DateUtils.parseDate(userBean.getBirth(),DateUtils.format1));
			user.setModifyDate(new Date());
			user.setName(userBean.getName());
			user.setSex(userBean.getSex());
			user.setComments(userBean.getComments());
			
			//插入或更新出生地址
			Address bir_address = addressMapper.selectByPrimaryKey(user.getBirthPlace());
			if(null == bir_address){
				bir_address = new Address();
				bir_address.setCountryId(1);
				bir_address.setProvinceId(codeDictMapper.getIdByCode(userBean.getBirProvinceCode()));
				bir_address.setCityId(codeDictMapper.getIdByCode(userBean.getBirCityCode()));
				bir_address.setTownId(codeDictMapper.getIdByCode(userBean.getBirTownCode()));
				bir_address.setType(AddressTpeEnum.Bir_address.getKey());
				addressMapper.insertSelective(bir_address);
				user.setBirthPlace(addressMapper.selectMaxId());
			}else{
				bir_address.setCountryId(1);
				bir_address.setProvinceId(codeDictMapper.getIdByCode(userBean.getBirProvinceCode()));
				bir_address.setCityId(codeDictMapper.getIdByCode(userBean.getBirCityCode()));
				bir_address.setTownId(codeDictMapper.getIdByCode(userBean.getBirTownCode()) == null ? -1:codeDictMapper.getIdByCode(userBean.getBirTownCode()));
				bir_address.setType(AddressTpeEnum.Bir_address.getKey());
				addressMapper.updateByPrimaryKeySelective(bir_address);
			}
			
			//插入现住址
			Address address = addressMapper.selectByPrimaryKey(user.getAddress());
			if(null == address){
				address = new Address();
				address.setCountryId(1);
				address.setProvinceId(codeDictMapper.getIdByCode(userBean.getProvince()));
				address.setCityId(codeDictMapper.getIdByCode(userBean.getCity()));
				address.setTownId(codeDictMapper.getIdByCode(userBean.getTown()));
				address.setType(AddressTpeEnum.now_address.getKey());
				addressMapper.insertSelective(address);
				user.setAddress(addressMapper.selectMaxId());
			}else{
				address.setCountryId(1);
				address.setProvinceId(codeDictMapper.getIdByCode(userBean.getProvince()));
				address.setCityId(codeDictMapper.getIdByCode(userBean.getCity()));
				address.setTownId(codeDictMapper.getIdByCode(userBean.getTown()) == null ? -1:codeDictMapper.getIdByCode(userBean.getTown()));
				address.setType(AddressTpeEnum.now_address.getKey());
				addressMapper.updateByPrimaryKey(address);
			}
			userMapper.updateByPrimaryKeySelective(user);
		}catch(Exception e){
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public DistrictBeanList getSelectDistrict(String username) {
		DistrictBeanList districtBeanList = new DistrictBeanList();
		List<CodeDictBean> birCityList = new ArrayList<CodeDictBean>();
		List<CodeDictBean> birTownList = new ArrayList<CodeDictBean>();
		List<CodeDictBean> cityList = new ArrayList<CodeDictBean>();
		List<CodeDictBean> townList = new ArrayList<CodeDictBean>();
		List<CodeDictBean> proviences = getDistrictList(COUNTRY_CODE);
		
		UserEnty user = userMapper.getUserAddress(username);
		if(null != user.getBirthaddress()){
			Integer birProvinceId = user.getBirthaddress().getProvinceId();
			Integer birCityId = user.getBirthaddress().getCityId();
			if(null != birProvinceId){
				birCityList = getDistrictBeanList(birProvinceId);
			}
			if(null != birCityId){
				birTownList = getDistrictBeanList(birCityId);
			}
		}
		if(null != user.getNowaddress()){
			Integer provinceId = user.getNowaddress().getProvinceId();
			Integer cityId = user.getNowaddress().getCityId();
			if(null != provinceId){
				cityList = getDistrictBeanList(provinceId);
			}
			if(null != cityId){
				townList = getDistrictBeanList(cityId);
			}
		}
		districtBeanList.setBirProvinceList(proviences);
		districtBeanList.setBirCityList(birCityList);
		districtBeanList.setBirTownList(birTownList);
		districtBeanList.setProvinceList(proviences);
		districtBeanList.setCityList(cityList);
		districtBeanList.setTownList(townList);
		return districtBeanList;
	}
	
	private List<CodeDictBean> getDistrictBeanList(Integer id){
		List<CodeDictBean> list = new ArrayList<CodeDictBean>();
		List<CodeDict> codeDictList = codeDictMapper.selectDistictListByPid(id);
		if(CollectionUtils.isNotEmpty(codeDictList)){
			for(CodeDict codeDict : codeDictList){
				list.add(bulidCodeDictBean(codeDict));
			}
		}
		return list;
	}
	
	private CodeDictBean bulidCodeDictBean(CodeDict codeDict){
		CodeDictBean codeDictBean = new CodeDictBean();
		codeDictBean.setCode(codeDict.getCode());
		codeDictBean.setValue(codeDict.getValue());
		return codeDictBean;
	}

	@Override
	public void changePassword(PasswordBean passwordBean) throws BaseException {
			User user = userMapper.selectUserByUserName(passwordBean.getUsername());
			if(passwordBean.getOpassword().equals(user.getPassword())){
				user.setPassword(passwordBean.getNpassword());
				try{
					userMapper.updateByPrimaryKeySelective(user);
				}catch(Exception e){
					throw new BaseException("common.update.error");
				}
			}else{
				throw new BaseException("common.message.changeError");
			}
		
	}

	@Override
	public List<UserShowBean> selectUserList(UserSearchBean searchBean) throws BaseException {
		List<UserShowBean> userBeanList = new ArrayList<UserShowBean>();
		List<UserShow> userlist = userMapper.selectUserListByparams(prepareParams(searchBean));
		if(CollectionUtils.isNotEmpty(userlist)){
			Integer index = 1;
			for(UserShow user : userlist){
				UserShowBean userBean = buildUserBean(user);
				userBean.setIndex(index++);
				userBeanList.add(userBean);
			}
		}
		return userBeanList;
	}
	
	private Map<String,Object> prepareParams(UserSearchBean searchBean){
		Map<String,Object> params = new HashMap<String,Object>();
		if(null != searchBean.getId()){
			params.put("id", searchBean.getId());
		}
		if(null != searchBean.getStatus()){
			params.put("status", searchBean.getStatus());
		}
		if(StringUtils.isNotEmpty(searchBean.getUsername())){
			params.put("username", searchBean.getUsername());
		}
		if(StringUtils.isNotEmpty(searchBean.getStartDate())){
			params.put("startDate", searchBean.getStartDate());
		}
		if(StringUtils.isNotEmpty(searchBean.getEndDate())){
			params.put("endDate", searchBean.getEndDate());
		}
		return params;
	}
	
	private UserShowBean buildUserBean(UserShow user) throws BaseException{
		UserShowBean userBean = new UserShowBean();
		userBean.setId(user.getId());
		userBean.setCode(user.getCode());
		userBean.setUsername(user.getUsername());
		userBean.setName(user.getName());
		try {
			userBean.setCreateDate(DateUtils.parseDate(user.getCreateDate()));
			userBean.setModifyDate(DateUtils.parseDate(user.getModifyDate()));
		} catch (ParseException e) {
			throw new BaseException("common.parse.error");
		}
		userBean.setDistrict(null);
		userBean.setNodeNum(user.getNodeNum() == null ? 0 : user.getNodeNum());
		userBean.setSex(user.getSex());
		userBean.setSexValue(UserSexEnum.getValueByKey(user.getSex()));
		userBean.setStatus(user.getStatus());
		userBean.setStatusValue(UserStatusEnum.getValueByKey(user.getStatus()));
		userBean.setWishNum(user.getWishNum() == null ? 0 : user.getWishNum());
		return userBean;
	}

	@Override
	public void unlock(Integer userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		//更新登陆信息表
		LoginInfo loginInfo = loginInfoMapper.selectByUserName(user.getUsername());
		loginInfo.setFailedNum(0);
		loginInfoMapper.updateByPrimaryKeySelective(loginInfo);
		//修改用户状态
		user.setStatus(UserStatusEnum.NORMAL.getKey());
		user.setModifyDate(new Date());
		userMapper.updateByPrimaryKeySelective(user);
	}

}
