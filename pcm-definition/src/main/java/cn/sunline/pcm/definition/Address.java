package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.util.TreeMap;

import cn.sunline.common.StringUtils;
import cn.sunline.common.address.AddressHelperFacility;

/**
 * 地址
 * @author zzq
 * @date 2019年7月11日
 *
 */
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 国家
	 */
	public String  country ="中国"; 
	
	/**
	 * 省
	 */
	public String province;
	
	/**
	 * 城市
	 */
	public String city;
	
	/**
	 * 区
	 */
	public String microdistrict; 
	
	/**
	 * 具体地址
	 */
	public String specificInformation;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getMicrodistrict() {
		return microdistrict;
	}

	public void setMicrodistrict(String microdistrict) {
		this.microdistrict = microdistrict;
	}

	public String getSpecificInformation() {
		return specificInformation;
	}

	public void setSpecificInformation(String specificInformation) {
		this.specificInformation = specificInformation;
	}

	public String toString(AddressHelperFacility addressHelperFacility) {
		//国家
		String country = this.country;
		String province=""; 
		String city =  "";
		//省
		if (StringUtils.isNotEmpty(this.province)) {
			province = addressHelperFacility.loadProvince().get(this.province);
		}
		if (StringUtils.isNotEmpty(this.city)) {
			//市
			city = addressHelperFacility.loadCity(this.province).get(this.city);
		}
		if (StringUtils.isNotEmpty(this.microdistrict)) {
			microdistrict= addressHelperFacility.loadDistricts(this.city).get(this.microdistrict);
		}
		
		return country+province+city+microdistrict+this.specificInformation;
	}



	
	
	
}
