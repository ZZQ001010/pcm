package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.ppy.dictionary.enums.CorpStructure;
import cn.sunline.ppy.dictionary.enums.EmpType;

public class OfficialCardCorpInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3982862992239232932L;

	/**
	 * 单位编号
	 */
	@PropertyInfo(name="单位编号" ,length = 20)
	public String corpNo;
	
	/**
	 * 单位名称
	 */
	@PropertyInfo(name = "单位名称", length = 80)
	public String corpName;
	
	/**
	 * 单位地址
	 */
	@PropertyInfo(name = "单位地址", length = 200)
	public String corpAddress;
	
	/**
	 * 单位电话
	 */
	@PropertyInfo(name = "单位电话", length = 20)
	public String corpPhone;
	
	/**
	 * 单位邮编
	 */
	@PropertyInfo(name= "单位邮编" , length = 10)
	public String corpPostcode;
	
	/**
	 * 公司国家代码
	 */
	@PropertyInfo(name = "公司国家代码", length = 3)
	public String empAddrCtryCd;
	
	/**
	 * 公司所在省
	 */
	@PropertyInfo(name = "公司所在省", length = 40)
	public String empProvince;
	
	/**
	 * 公司所在市
	 */
	@PropertyInfo(name = "公司所在市", length = 40)
	public String empCity;
	
	/**
	 * 公司所在区/县
	 */
	@PropertyInfo(name = "公司所在区/县", length = 40)
	public String empZone;
	
	/**
	 * 行业性质
	 */
	@PropertyInfo(name = "行业性质", length = 1)
	public CorpStructure empStructure;
	
	/**
	 * 行业类别
	 */
	@PropertyInfo(name = "行业类别",length = 1)
	public EmpType empType;
	
	/**
	 * 行政区划编码
	 */
	@PropertyInfo(name = "行政区划编码", length = 10)
	public String executiveCode;
	
	/**
	 * 行政区划名称
	 */
	@PropertyInfo(name = "行政区划名称", length = 80)
	public String executiveName;
}
