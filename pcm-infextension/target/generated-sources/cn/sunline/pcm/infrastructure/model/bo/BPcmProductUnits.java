package cn.sunline.pcm.infrastructure.model.bo;

import cn.sunline.common.enums.Indicator;
import cn.sunline.pcm.definition.enums.ProductUnitsURL;
import cn.sunline.pcm.definition.enums.WinSize;
import java.io.Serializable;
import java.util.Date;
import cn.sunline.common.annotation.LogicalName;

/**
 * @author kite-maven-plugin
 * 产品页面组件表
 */
@SuppressWarnings("serial")
@LogicalName("产品页面组件表")
public class BPcmProductUnits implements Serializable {
		
	@LogicalName("ID")
    private String id;
    
	@LogicalName("所属机构")
    private String org;
    
	@LogicalName("产品组件编码")
    private String unitCode;
    
	@LogicalName("分组编码")
    private String groupCode;
    
	@LogicalName("产品组件国际化名称")
    private String unitName;
    
	@LogicalName("产品组件中文名称")
    private String unitNameCn;
    
	@LogicalName("产品组件序号")
    private Integer unitIndex;
    
	@LogicalName("必配组件")
    private Indicator unitRequired;
    
	@LogicalName("产品组件")
    private ProductUnitsURL unitModule;
    
	@LogicalName("关联组件")
    private String updateUnits;
    
	@LogicalName("创建时间")
    private Date createTime;
    
	@LogicalName("创建人")
    private String createUser;
    
	@LogicalName("最后修改时间")
    private Date lstUpdTime;
    
	@LogicalName("最后修改人")
    private String lstUpdUser;
    
	@LogicalName("JPA_VERSION")
    private Integer jpaVersion;
    
	@LogicalName("二级组件")
    private String subUnit;
    
	@LogicalName("组件配置窗口")
    private WinSize unitConfig;
    
	public static final String P_ID = "id";
	
	public static final String P_ORG = "org";
	
	public static final String P_UNIT_CODE = "unitCode";
	
	public static final String P_GROUP_CODE = "groupCode";
	
	public static final String P_UNIT_NAME = "unitName";
	
	public static final String P_UNIT_NAME_CN = "unitNameCn";
	
	public static final String P_UNIT_INDEX = "unitIndex";
	
	public static final String P_UNIT_REQUIRED = "unitRequired";
	
	public static final String P_UNIT_MODULE = "unitModule";
	
	public static final String P_UPDATE_UNITS = "updateUnits";
	
	public static final String P_CREATE_TIME = "createTime";
	
	public static final String P_CREATE_USER = "createUser";
	
	public static final String P_LST_UPD_TIME = "lstUpdTime";
	
	public static final String P_LST_UPD_USER = "lstUpdUser";
	
	public static final String P_JPA_VERSION = "jpaVersion";
	
	public static final String P_SUB_UNIT = "subUnit";
	
	public static final String P_UNIT_CONFIG = "unitConfig";
	
	
	/**
	 * <p>ID</p>
	 * <p>///@UuidSeq</p>
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * <p>ID</p>
	 * <p>///@UuidSeq</p>
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * <p>所属机构</p>
	 */
	public String getOrg() {
		return org;
	}
	
	/**
	 * <p>所属机构</p>
	 */
	public void setOrg(String org) {
		this.org = org;
	}
	
	/**
	 * <p>产品组件编码</p>
	 */
	public String getUnitCode() {
		return unitCode;
	}
	
	/**
	 * <p>产品组件编码</p>
	 */
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	
	/**
	 * <p>分组编码</p>
	 */
	public String getGroupCode() {
		return groupCode;
	}
	
	/**
	 * <p>分组编码</p>
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	/**
	 * <p>产品组件国际化名称</p>
	 */
	public String getUnitName() {
		return unitName;
	}
	
	/**
	 * <p>产品组件国际化名称</p>
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	/**
	 * <p>产品组件中文名称</p>
	 */
	public String getUnitNameCn() {
		return unitNameCn;
	}
	
	/**
	 * <p>产品组件中文名称</p>
	 */
	public void setUnitNameCn(String unitNameCn) {
		this.unitNameCn = unitNameCn;
	}
	
	/**
	 * <p>产品组件序号</p>
	 */
	public Integer getUnitIndex() {
		return unitIndex;
	}
	
	/**
	 * <p>产品组件序号</p>
	 */
	public void setUnitIndex(Integer unitIndex) {
		this.unitIndex = unitIndex;
	}
	
	/**
	 * <p>必配组件</p>
	 */
	public Indicator getUnitRequired() {
		return unitRequired;
	}
	
	/**
	 * <p>必配组件</p>
	 */
	public void setUnitRequired(Indicator unitRequired) {
		this.unitRequired = unitRequired;
	}
	
	/**
	 * <p>产品组件</p>
	 */
	public ProductUnitsURL getUnitModule() {
		return unitModule;
	}
	
	/**
	 * <p>产品组件</p>
	 */
	public void setUnitModule(ProductUnitsURL unitModule) {
		this.unitModule = unitModule;
	}
	
	/**
	 * <p>关联组件</p>
	 */
	public String getUpdateUnits() {
		return updateUnits;
	}
	
	/**
	 * <p>关联组件</p>
	 */
	public void setUpdateUnits(String updateUnits) {
		this.updateUnits = updateUnits;
	}
	
	/**
	 * <p>创建时间</p>
	 * <p>///@create</p>
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * <p>创建时间</p>
	 * <p>///@create</p>
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * <p>创建人</p>
	 */
	public String getCreateUser() {
		return createUser;
	}
	
	/**
	 * <p>创建人</p>
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	/**
	 * <p>最后修改时间</p>
	 * <p>///@update</p>
	 */
	public Date getLstUpdTime() {
		return lstUpdTime;
	}
	
	/**
	 * <p>最后修改时间</p>
	 * <p>///@update</p>
	 */
	public void setLstUpdTime(Date lstUpdTime) {
		this.lstUpdTime = lstUpdTime;
	}
	
	/**
	 * <p>最后修改人</p>
	 */
	public String getLstUpdUser() {
		return lstUpdUser;
	}
	
	/**
	 * <p>最后修改人</p>
	 */
	public void setLstUpdUser(String lstUpdUser) {
		this.lstUpdUser = lstUpdUser;
	}
	
	/**
	 * <p>JPA_VERSION</p>
	 */
	public Integer getJpaVersion() {
		return jpaVersion;
	}
	
	/**
	 * <p>JPA_VERSION</p>
	 */
	public void setJpaVersion(Integer jpaVersion) {
		this.jpaVersion = jpaVersion;
	}
	
	/**
	 * <p>二级组件</p>
	 */
	public String getSubUnit() {
		return subUnit;
	}
	
	/**
	 * <p>二级组件</p>
	 */
	public void setSubUnit(String subUnit) {
		this.subUnit = subUnit;
	}
	
	/**
	 * <p>组件配置窗口</p>
	 */
	public WinSize getUnitConfig() {
		return unitConfig;
	}
	
	/**
	 * <p>组件配置窗口</p>
	 */
	public void setUnitConfig(WinSize unitConfig) {
		this.unitConfig = unitConfig;
	}
	
}