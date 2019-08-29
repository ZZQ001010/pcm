package cn.sunline.pcm.infrastructure.shared.model;

import cn.sunline.common.shared.DataTypeUtils;
import cn.sunline.common.shared.HasMapping;
import cn.sunline.dbs.shared.PrimaryKey;
import cn.sunline.pcm.infrastructure.model.bo.BPcmOrgParametter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import cn.sunline.common.annotation.LogicalName;

/**
 * @author kite-maven-plugin
 * 机构参数表
 */
@SuppressWarnings("serial")
@Entity
@LogicalName("机构参数表")
@Table(name="PCM_ORG_PARAMETTER")
public class PcmOrgParametter implements PrimaryKey<String>, Serializable, HasMapping {
	
	public static final String TABLE_NAME = "PCM_ORG_PARAMETTER";
		
	@Id
	@LogicalName("机构编码")
	@Column(name="ORG_CODE", nullable=false, length=100)
	private String orgCode;
		
	@LogicalName("机构名称")
	@Column(name="ORG_NAME", nullable=true, length=32)
	private String orgName;
		
	@LogicalName("机构地址")
	@Column(name="ORG_ADDRESS", nullable=true, length=32)
	private String orgAddress;
		
	@LogicalName("机构级别")
	@Column(name="ORG_LEVEL", nullable=true, length=32)
	private String orgLevel;
		
	@LogicalName("上级机构编码")
	@Column(name="PARENT_ORG_CODE", nullable=true, length=32)
	private String parentOrgCode;
		
	@LogicalName("机构联系电话")
	@Column(name="ORG_CONTACT_PHONE", nullable=true, length=32)
	private String orgContactPhone;
		
	public static final String P_ORG_CODE = "orgCode";
	
	public static final String P_ORG_NAME = "orgName";
	
	public static final String P_ORG_ADDRESS = "orgAddress";
	
	public static final String P_ORG_LEVEL = "orgLevel";
	
	public static final String P_PARENT_ORG_CODE = "parentOrgCode";
	
	public static final String P_ORG_CONTACT_PHONE = "orgContactPhone";
	
	public PcmOrgParametter () {};
	
	public PcmOrgParametter (BPcmOrgParametter bPcmOrgParametter) {
		this.fillValueFromBO(bPcmOrgParametter);
	};
	
	
	/**
	 * <p>机构编码</p>
	 */
	public String getOrgCode() {
		return orgCode;
	}
	
	/**
	 * <p>机构编码</p>
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	
	/**
	 * <p>机构名称</p>
	 */
	public String getOrgName() {
		return orgName;
	}
	
	/**
	 * <p>机构名称</p>
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	/**
	 * <p>机构地址</p>
	 */
	public String getOrgAddress() {
		return orgAddress;
	}
	
	/**
	 * <p>机构地址</p>
	 */
	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}
	
	/**
	 * <p>机构级别</p>
	 */
	public String getOrgLevel() {
		return orgLevel;
	}
	
	/**
	 * <p>机构级别</p>
	 */
	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}
	
	/**
	 * <p>上级机构编码</p>
	 */
	public String getParentOrgCode() {
		return parentOrgCode;
	}
	
	/**
	 * <p>上级机构编码</p>
	 */
	public void setParentOrgCode(String parentOrgCode) {
		this.parentOrgCode = parentOrgCode;
	}
	
	/**
	 * <p>机构联系电话</p>
	 */
	public String getOrgContactPhone() {
		return orgContactPhone;
	}
	
	/**
	 * <p>机构联系电话</p>
	 */
	public void setOrgContactPhone(String orgContactPhone) {
		this.orgContactPhone = orgContactPhone;
	}
	
	/**
	 * <p>将当前实体对象转化为map返回</p>
	 */
	public Map<String, Serializable> convertToMap() {
		HashMap<String, Serializable> map = new HashMap<String, Serializable>();
		map.put(P_ORG_CODE, orgCode);
		map.put(P_ORG_NAME, orgName);
		map.put(P_ORG_ADDRESS, orgAddress);
		map.put(P_ORG_LEVEL, orgLevel);
		map.put(P_PARENT_ORG_CODE, parentOrgCode);
		map.put(P_ORG_CONTACT_PHONE, orgContactPhone);
		return map;
	}

	/**
	 * <p>从map更新当前实体对象</p>
	 */
	public void updateFromMap(Map<String, Serializable> map) {
		if (map.containsKey(P_ORG_CODE)) { this.setOrgCode(DataTypeUtils.getStringValue(map.get(P_ORG_CODE))); }
		if (map.containsKey(P_ORG_NAME)) { this.setOrgName(DataTypeUtils.getStringValue(map.get(P_ORG_NAME))); }
		if (map.containsKey(P_ORG_ADDRESS)) { this.setOrgAddress(DataTypeUtils.getStringValue(map.get(P_ORG_ADDRESS))); }
		if (map.containsKey(P_ORG_LEVEL)) { this.setOrgLevel(DataTypeUtils.getStringValue(map.get(P_ORG_LEVEL))); }
		if (map.containsKey(P_PARENT_ORG_CODE)) { this.setParentOrgCode(DataTypeUtils.getStringValue(map.get(P_PARENT_ORG_CODE))); }
		if (map.containsKey(P_ORG_CONTACT_PHONE)) { this.setOrgContactPhone(DataTypeUtils.getStringValue(map.get(P_ORG_CONTACT_PHONE))); }
	}

	/**
	 * <p>为当前实体对象除了主键字段之外的值为空的成员变量赋予默认值，字符串=""，数字类型字段=0</p>
	 */
	public void fillDefaultValues() {
		if (orgCode == null) { orgCode = ""; }
		if (orgName == null) { orgName = ""; }
		if (orgAddress == null) { orgAddress = ""; }
		if (orgLevel == null) { orgLevel = ""; }
		if (parentOrgCode == null) { parentOrgCode = ""; }
		if (orgContactPhone == null) { orgContactPhone = ""; }
	}
	
	/**
	 * <p>将当前实体对象转换为对应的BO输出</p>
	 */
	public BPcmOrgParametter toBO() {
		BPcmOrgParametter bPcmOrgParametter = new BPcmOrgParametter();
		bPcmOrgParametter.setOrgCode(this.getOrgCode());
		bPcmOrgParametter.setOrgName(this.getOrgName());
		bPcmOrgParametter.setOrgAddress(this.getOrgAddress());
		bPcmOrgParametter.setOrgLevel(this.getOrgLevel());
		bPcmOrgParametter.setParentOrgCode(this.getParentOrgCode());
		bPcmOrgParametter.setOrgContactPhone(this.getOrgContactPhone());
		return bPcmOrgParametter;
	}
	
	/**
	 * <p>根据BO更新当前实体对象的值</p>
	 */
	public PcmOrgParametter fillValueFromBO(BPcmOrgParametter bPcmOrgParametter) {
		this.setOrgCode(bPcmOrgParametter.getOrgCode());
		this.setOrgName(bPcmOrgParametter.getOrgName());
		this.setOrgAddress(bPcmOrgParametter.getOrgAddress());
		this.setOrgLevel(bPcmOrgParametter.getOrgLevel());
		this.setParentOrgCode(bPcmOrgParametter.getParentOrgCode());
		this.setOrgContactPhone(bPcmOrgParametter.getOrgContactPhone());
		return this;
	}
	
	/**
	 * <p>根据BO更新当前实体对象的值</p>
	 * <p>如果BO属性值为空，不修改对应的entity属性值</p>
	 * <p>已排除由hibernate或底层架构自动更新值的属性(主键、jpaversion、创建时间/人、///@seq:、///@kiteseq、///@uuidseq)</p>
	 */
	public PcmOrgParametter updateValueFromBO(BPcmOrgParametter bPcmOrgParametter) {
		if(bPcmOrgParametter.getOrgCode() != null){
			this.setOrgCode(bPcmOrgParametter.getOrgCode());
		}
		if(bPcmOrgParametter.getOrgName() != null){
			this.setOrgName(bPcmOrgParametter.getOrgName());
		}
		if(bPcmOrgParametter.getOrgAddress() != null){
			this.setOrgAddress(bPcmOrgParametter.getOrgAddress());
		}
		if(bPcmOrgParametter.getOrgLevel() != null){
			this.setOrgLevel(bPcmOrgParametter.getOrgLevel());
		}
		if(bPcmOrgParametter.getParentOrgCode() != null){
			this.setParentOrgCode(bPcmOrgParametter.getParentOrgCode());
		}
		if(bPcmOrgParametter.getOrgContactPhone() != null){
			this.setOrgContactPhone(bPcmOrgParametter.getOrgContactPhone());
		}
		return this;
	}
	
	/**
	 * <p>将实体对象的List转换为BO对象List返回</p>
	 */
	public static List<BPcmOrgParametter> convertToBOList(Iterable<PcmOrgParametter> pcmOrgParametterList) {
		if (pcmOrgParametterList != null) {
			List<BPcmOrgParametter> boList = new ArrayList<BPcmOrgParametter>();
			for (PcmOrgParametter pcmOrgParametter : pcmOrgParametterList) {
				boList.add(pcmOrgParametter.toBO());
			}
			return boList;
		} else {
			return null;
		}
	}
	
	/**
	 * <p>将BO对象的List转换为实体对象List返回</p>
	 */
	public static List<PcmOrgParametter> convertToEntityList(Iterable<BPcmOrgParametter> bPcmOrgParametterList) {
		if (bPcmOrgParametterList != null) {
			List<PcmOrgParametter> pcmOrgParametterList = new ArrayList<PcmOrgParametter>();
			for (BPcmOrgParametter bPcmOrgParametter : bPcmOrgParametterList) {
				pcmOrgParametterList.add(new PcmOrgParametter(bPcmOrgParametter));
			}
			return pcmOrgParametterList;
		} else {
			return null;
		}
	}

	public String pk() {
		return orgCode;
	}
}