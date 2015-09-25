package com.xc.xnode.codedict.beans;

import java.util.ArrayList;
import java.util.List;

import com.xc.xnode.common.beans.CommonBean;

public class DistrictBeanList extends CommonBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<CodeDictBean> birCountryList = new ArrayList<CodeDictBean>();
	
	private List<CodeDictBean> birProvinceList = new ArrayList<CodeDictBean>();
	
	private List<CodeDictBean> birCityList = new ArrayList<CodeDictBean>();
	
	private List<CodeDictBean> birTownList = new ArrayList<CodeDictBean>();
	
	private List<CodeDictBean> countryList = new ArrayList<CodeDictBean>();
	
	private List<CodeDictBean> provinceList = new ArrayList<CodeDictBean>();
	
	private List<CodeDictBean> cityList = new ArrayList<CodeDictBean>();
	
	private List<CodeDictBean> townList = new ArrayList<CodeDictBean>();

	public List<CodeDictBean> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<CodeDictBean> countryList) {
		this.countryList = countryList;
	}

	public List<CodeDictBean> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<CodeDictBean> provinceList) {
		this.provinceList = provinceList;
	}

	public List<CodeDictBean> getCityList() {
		return cityList;
	}

	public void setCityList(List<CodeDictBean> cityList) {
		this.cityList = cityList;
	}

	public List<CodeDictBean> getTownList() {
		return townList;
	}

	public void setTownList(List<CodeDictBean> townList) {
		this.townList = townList;
	}

	public List<CodeDictBean> getBirCountryList() {
		return birCountryList;
	}

	public void setBirCountryList(List<CodeDictBean> birCountryList) {
		this.birCountryList = birCountryList;
	}

	public List<CodeDictBean> getBirProvinceList() {
		return birProvinceList;
	}

	public void setBirProvinceList(List<CodeDictBean> birProvinceList) {
		this.birProvinceList = birProvinceList;
	}

	public List<CodeDictBean> getBirCityList() {
		return birCityList;
	}

	public void setBirCityList(List<CodeDictBean> birCityList) {
		this.birCityList = birCityList;
	}

	public List<CodeDictBean> getBirTownList() {
		return birTownList;
	}

	public void setBirTownList(List<CodeDictBean> birTownList) {
		this.birTownList = birTownList;
	}
	
}
