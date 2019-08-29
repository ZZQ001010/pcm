package cn.sunline.pcm.infrastructure.model.bo;

import cn.sunline.common.enums.Indicator;
import cn.sunline.ppy.dictionary.enums.ProductType;
import java.io.Serializable;
import java.util.Date;
import cn.sunline.common.annotation.LogicalName;

/**
 * @author kite-maven-plugin
 * 产品组件表
 */
@SuppressWarnings("serial")
@LogicalName("产品组件表")
public class BPcmProductUnit implements Serializable {
		
	@LogicalName("ID")
    private String id;
    
	@LogicalName("产品组件所属分组")
    private String productUnitGroup;
    
	@LogicalName("所属机构")
    private String org;
    
	@LogicalName("产品类型")
    private ProductType productType;
    
	@LogicalName("产品组件编码")
    private String unitCode;
    
	@LogicalName("产品组件类型")
    private String unitModule;
    
	@LogicalName("产品组件国际化名称")
    private String unitName;
    
	@LogicalName("产品组件中文名称")
    private String unitNameCn;
    
	@LogicalName("是否允许多选")
    private Indicator multiple;
    
	@LogicalName("产品组件序号")
    private Integer unitIndex;
    
	@LogicalName("关联组件")
    private String unitRelations;
    
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
    
	public static final String P_ID = "id";
	
	public static final String P_PRODUCT_UNIT_GROUP = "productUnitGroup";
	
	public static final String P_ORG = "org";
	
	public static final String P_PRODUCT_TYPE = "productType";
	
	public static final String P_UNIT_CODE = "unitCode";
	
	public static final String P_UNIT_MODULE = "unitModule";
	
	public static final String P_UNIT_NAME = "unitName";
	
	public static final String P_UNIT_NAME_CN = "unitNameCn";
	
	public static final String P_MULTIPLE = "multiple";
	
	public static final String P_UNIT_INDEX = "unitIndex";
	
	public static final String P_UNIT_RELATIONS = "unitRelations";
	
	public static final String P_CREATE_TIME = "createTime";
	
	public static final String P_CREATE_USER = "createUser";
	
	public static final String P_LST_UPD_TIME = "lstUpdTime";
	
	public static final String P_LST_UPD_USER = "lstUpdUser";
	
	public static final String P_JPA_VERSION = "jpaVersion";
	
	
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
	 * <p>产品组件所属分组</p>
	 * <p>产品组件所属分组</p>
	 */
	public String getProductUnitGroup() {
		return productUnitGroup;
	}
	
	/**
	 * <p>产品组件所属分组</p>
	 * <p>产品组件所属分组</p>
	 */
	public void setProductUnitGroup(String productUnitGroup) {
		this.productUnitGroup = productUnitGroup;
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
	 * <p>产品类型</p>
	 */
	public ProductType getProductType() {
		return productType;
	}
	
	/**
	 * <p>产品类型</p>
	 */
	public void setProductType(ProductType productType) {
		this.productType = productType;
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
	 * <p>产品组件类型</p>
	 */
	public String getUnitModule() {
		return unitModule;
	}
	
	/**
	 * <p>产品组件类型</p>
	 */
	public void setUnitModule(String unitModule) {
		this.unitModule = unitModule;
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
	 * <p>是否允许多选</p>
	 */
	public Indicator getMultiple() {
		return multiple;
	}
	
	/**
	 * <p>是否允许多选</p>
	 */
	public void setMultiple(Indicator multiple) {
		this.multiple = multiple;
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
	 * <p>关联组件</p>
	 */
	public String getUnitRelations() {
		return unitRelations;
	}
	
	/**
	 * <p>关联组件</p>
	 */
	public void setUnitRelations(String unitRelations) {
		this.unitRelations = unitRelations;
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
	
}