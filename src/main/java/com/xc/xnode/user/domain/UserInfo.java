package com.xc.xnode.user.domain;

import java.util.Date;

public class UserInfo {
	
	private Integer id;

    private Integer status;

    private String name;

    private String code;

    private Integer sex;

    private Date birth;

    private Integer address;

    private Integer birthPlace;

    private String username;

    private String password;

    private Date createDate;

    private Date modifyDate;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Integer getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Integer birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

	public String getBirProvinceCode() {
		return birProvinceCode;
	}

	public void setBirProvinceCode(String birProvinceCode) {
		this.birProvinceCode = birProvinceCode;
	}

	public String getBirProvinceValue() {
		return birProvinceValue;
	}

	public void setBirProvinceValue(String birProvinceValue) {
		this.birProvinceValue = birProvinceValue;
	}

	public String getBirCityCode() {
		return birCityCode;
	}

	public void setBirCityCode(String birCityCode) {
		this.birCityCode = birCityCode;
	}

	public String getBirCityCodeValue() {
		return birCityCodeValue;
	}

	public void setBirCityCodeValue(String birCityCodeValue) {
		this.birCityCodeValue = birCityCodeValue;
	}

	public String getBirTownCode() {
		return birTownCode;
	}

	public void setBirTownCode(String birTownCode) {
		this.birTownCode = birTownCode;
	}

	public String getBirTownCodeValue() {
		return birTownCodeValue;
	}

	public void setBirTownCodeValue(String birTownCodeValue) {
		this.birTownCodeValue = birTownCodeValue;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvinceValue() {
		return provinceValue;
	}

	public void setProvinceValue(String provinceValue) {
		this.provinceValue = provinceValue;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityValue() {
		return cityValue;
	}

	public void setCityValue(String cityValue) {
		this.cityValue = cityValue;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getTownValue() {
		return townValue;
	}

	public void setTownValue(String townValue) {
		this.townValue = townValue;
	}
}
