package com.xc.xnode.user.beans;

import com.xc.xnode.common.beans.CommonBean;

public class UserOperateBean extends CommonBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;

    private String name;

    private String code;
    
    private Integer sex;

    private String birth;
    
    private String username;

    private String createDate;

    private String modifyDate;

    private String comments;
    
    //address
    private String birProvinceCode;
    
    private String birProvinceValue;
    
    private String birCityCode;
    
    private String birCityCodeValue;
    
    private String birTownCode;
    
    private String birTownCodeValue;
    
    private String province;
    
    private String provinceValue;
    
    private String city;
    
    private String cityValue;
    
    private String town;
    
    private String townValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getBirProvinceCode() {
		return birProvinceCode;
	}

	public void setBirProvinceCode(String birProvinceCode) {
		this.birProvinceCode = birProvinceCode;
	}

	public String getBirCityCode() {
		return birCityCode;
	}

	public void setBirCityCode(String birCityCode) {
		this.birCityCode = birCityCode;
	}

	public String getBirTownCode() {
		return birTownCode;
	}

	public void setBirTownCode(String birTownCode) {
		this.birTownCode = birTownCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getBirProvinceValue() {
		return birProvinceValue;
	}

	public void setBirProvinceValue(String birProvinceValue) {
		this.birProvinceValue = birProvinceValue;
	}

	public String getBirCityCodeValue() {
		return birCityCodeValue;
	}

	public void setBirCityCodeValue(String birCityCodeValue) {
		this.birCityCodeValue = birCityCodeValue;
	}

	public String getBirTownCodeValue() {
		return birTownCodeValue;
	}

	public void setBirTownCodeValue(String birTownCodeValue) {
		this.birTownCodeValue = birTownCodeValue;
	}

	public String getProvinceValue() {
		return provinceValue;
	}

	public void setProvinceValue(String provinceValue) {
		this.provinceValue = provinceValue;
	}

	public String getCityValue() {
		return cityValue;
	}

	public void setCityValue(String cityValue) {
		this.cityValue = cityValue;
	}

	public String getTownValue() {
		return townValue;
	}

	public void setTownValue(String townValue) {
		this.townValue = townValue;
	}
}
