package com.xc.xnode.user.beans;import com.xc.xnode.common.beans.CommonBean;public class UserBean extends CommonBean{	/**	 * 	 */	private static final long serialVersionUID = 1L;		private Integer id;		private String username;    private String name;    private Integer sex;    private String birth;        private String comments;        //address    private String birProvinceCode;        private String birCityCode;        private String birTownCode;        private String province;        private String city;        private String town;	public Integer getId() {		return id;	}	public void setId(Integer id) {		this.id = id;	}	public String getName() {		return name;	}	public void setName(String name) {		this.name = name;	}	public String getComments() {		return comments;	}	public void setComments(String comments) {		this.comments = comments;	}	public Integer getSex() {		return sex;	}	public void setSex(Integer sex) {		this.sex = sex;	}	public String getBirth() {		return birth;	}	public void setBirth(String birth) {		this.birth = birth;	}	public String getBirProvinceCode() {		return birProvinceCode;	}	public void setBirProvinceCode(String birProvinceCode) {		this.birProvinceCode = birProvinceCode;	}	public String getBirCityCode() {		return birCityCode;	}	public void setBirCityCode(String birCityCode) {		this.birCityCode = birCityCode;	}	public String getBirTownCode() {		return birTownCode;	}	public void setBirTownCode(String birTownCode) {		this.birTownCode = birTownCode;	}	public String getProvince() {		return province;	}	public void setProvince(String province) {		this.province = province;	}	public String getCity() {		return city;	}	public void setCity(String city) {		this.city = city;	}	public String getTown() {		return town;	}	public void setTown(String town) {		this.town = town;	}	public String getUsername() {		return username;	}	public void setUsername(String username) {		this.username = username;	}}