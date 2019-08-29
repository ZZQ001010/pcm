package cn.sunline.pcm.infrastructure.shared.model;

import cn.sunline.common.shared.DataTypeUtils;
import cn.sunline.common.shared.HasMapping;
import cn.sunline.dbs.shared.PrimaryKey;
import cn.sunline.pcm.infrastructure.model.bo.BPcmPrmControl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import cn.sunline.common.annotation.LogicalName;

/**
 * @author kite-maven-plugin
 * 参数范围控制表
 */
@SuppressWarnings("serial")
@Entity
@LogicalName("参数范围控制表")
@Table(name="PCM_PRM_CONTROL")
public class PcmPrmControl implements PrimaryKey<String>, Serializable, HasMapping {
	
	public static final String TABLE_NAME = "PCM_PRM_CONTROL";
		
	@Id
	@GeneratedValue(generator = "idGeneratorPcmPrmControl")
	@GenericGenerator(name = "idGeneratorPcmPrmControl", strategy = "cn.sunline.dbs.generator.HbIdUuidGenerator", parameters = {@Parameter(name = "tableName", value = "PCM_PRM_CONTROL")})
	@LogicalName("ID")
	@Column(name="ID", nullable=false, length=32)
	private String id;
		
	@LogicalName("受控参数")
	@Column(name="PARAM_CLASS", nullable=false, length=200)
	private String paramClass;
		
	@LogicalName("参数名称")
	@Column(name="PARAM_CLASS_LABEL", nullable=true, length=100)
	private String paramClassLabel;
		
	@LogicalName("参数属性")
	@Column(name="PARAM_FIELD", nullable=false, length=50)
	private String paramField;
		
	@LogicalName("属性名称")
	@Column(name="PARAM_FIELD_LABEL", nullable=true, length=100)
	private String paramFieldLabel;
		
	@LogicalName("最小值")
	@Column(name="MIN_VALUE", nullable=true, length=20)
	private String minValue;
		
	@LogicalName("最大值")
	@Column(name="MAX_VALUE", nullable=true, length=20)
	private String maxValue;
		
	@LogicalName("JPA_VERSION")
	@Column(name="JPA_VERSION", nullable=true)
	@Version
	private Integer jpaVersion;
		
	public static final String P_ID = "id";
	
	public static final String P_PARAM_CLASS = "paramClass";
	
	public static final String P_PARAM_CLASS_LABEL = "paramClassLabel";
	
	public static final String P_PARAM_FIELD = "paramField";
	
	public static final String P_PARAM_FIELD_LABEL = "paramFieldLabel";
	
	public static final String P_MIN_VALUE = "minValue";
	
	public static final String P_MAX_VALUE = "maxValue";
	
	public static final String P_JPA_VERSION = "jpaVersion";
	
	public PcmPrmControl () {};
	
	public PcmPrmControl (BPcmPrmControl bPcmPrmControl) {
		this.fillValueFromBO(bPcmPrmControl);
	};
	
	@PrePersist
	protected void onCreate() {
		this.jpaVersion = 0;
	}
	
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
	 * <p>受控参数</p>
	 */
	public String getParamClass() {
		return paramClass;
	}
	
	/**
	 * <p>受控参数</p>
	 */
	public void setParamClass(String paramClass) {
		this.paramClass = paramClass;
	}
	
	/**
	 * <p>参数名称</p>
	 */
	public String getParamClassLabel() {
		return paramClassLabel;
	}
	
	/**
	 * <p>参数名称</p>
	 */
	public void setParamClassLabel(String paramClassLabel) {
		this.paramClassLabel = paramClassLabel;
	}
	
	/**
	 * <p>参数属性</p>
	 */
	public String getParamField() {
		return paramField;
	}
	
	/**
	 * <p>参数属性</p>
	 */
	public void setParamField(String paramField) {
		this.paramField = paramField;
	}
	
	/**
	 * <p>属性名称</p>
	 */
	public String getParamFieldLabel() {
		return paramFieldLabel;
	}
	
	/**
	 * <p>属性名称</p>
	 */
	public void setParamFieldLabel(String paramFieldLabel) {
		this.paramFieldLabel = paramFieldLabel;
	}
	
	/**
	 * <p>最小值</p>
	 */
	public String getMinValue() {
		return minValue;
	}
	
	/**
	 * <p>最小值</p>
	 */
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	
	/**
	 * <p>最大值</p>
	 */
	public String getMaxValue() {
		return maxValue;
	}
	
	/**
	 * <p>最大值</p>
	 */
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
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
	 * <p>将当前实体对象转化为map返回</p>
	 */
	public Map<String, Serializable> convertToMap() {
		HashMap<String, Serializable> map = new HashMap<String, Serializable>();
		map.put(P_ID, id);
		map.put(P_PARAM_CLASS, paramClass);
		map.put(P_PARAM_CLASS_LABEL, paramClassLabel);
		map.put(P_PARAM_FIELD, paramField);
		map.put(P_PARAM_FIELD_LABEL, paramFieldLabel);
		map.put(P_MIN_VALUE, minValue);
		map.put(P_MAX_VALUE, maxValue);
		map.put(P_JPA_VERSION, jpaVersion);
		return map;
	}

	/**
	 * <p>从map更新当前实体对象</p>
	 */
	public void updateFromMap(Map<String, Serializable> map) {
		if (map.containsKey(P_ID)) { this.setId(DataTypeUtils.getStringValue(map.get(P_ID))); }
		if (map.containsKey(P_PARAM_CLASS)) { this.setParamClass(DataTypeUtils.getStringValue(map.get(P_PARAM_CLASS))); }
		if (map.containsKey(P_PARAM_CLASS_LABEL)) { this.setParamClassLabel(DataTypeUtils.getStringValue(map.get(P_PARAM_CLASS_LABEL))); }
		if (map.containsKey(P_PARAM_FIELD)) { this.setParamField(DataTypeUtils.getStringValue(map.get(P_PARAM_FIELD))); }
		if (map.containsKey(P_PARAM_FIELD_LABEL)) { this.setParamFieldLabel(DataTypeUtils.getStringValue(map.get(P_PARAM_FIELD_LABEL))); }
		if (map.containsKey(P_MIN_VALUE)) { this.setMinValue(DataTypeUtils.getStringValue(map.get(P_MIN_VALUE))); }
		if (map.containsKey(P_MAX_VALUE)) { this.setMaxValue(DataTypeUtils.getStringValue(map.get(P_MAX_VALUE))); }
		if (map.containsKey(P_JPA_VERSION)) { this.setJpaVersion(DataTypeUtils.getIntegerValue(map.get(P_JPA_VERSION))); }
	}

	/**
	 * <p>为当前实体对象除了主键字段之外的值为空的成员变量赋予默认值，字符串=""，数字类型字段=0</p>
	 */
	public void fillDefaultValues() {
		if (id == null) { id = ""; }
		if (paramClass == null) { paramClass = ""; }
		if (paramClassLabel == null) { paramClassLabel = ""; }
		if (paramField == null) { paramField = ""; }
		if (paramFieldLabel == null) { paramFieldLabel = ""; }
		if (minValue == null) { minValue = ""; }
		if (maxValue == null) { maxValue = ""; }
		if (jpaVersion == null) { jpaVersion = 0; }
	}
	
	/**
	 * <p>将当前实体对象转换为对应的BO输出</p>
	 */
	public BPcmPrmControl toBO() {
		BPcmPrmControl bPcmPrmControl = new BPcmPrmControl();
		bPcmPrmControl.setId(this.getId());
		bPcmPrmControl.setParamClass(this.getParamClass());
		bPcmPrmControl.setParamClassLabel(this.getParamClassLabel());
		bPcmPrmControl.setParamField(this.getParamField());
		bPcmPrmControl.setParamFieldLabel(this.getParamFieldLabel());
		bPcmPrmControl.setMinValue(this.getMinValue());
		bPcmPrmControl.setMaxValue(this.getMaxValue());
		bPcmPrmControl.setJpaVersion(this.getJpaVersion());
		return bPcmPrmControl;
	}
	
	/**
	 * <p>根据BO更新当前实体对象的值</p>
	 */
	public PcmPrmControl fillValueFromBO(BPcmPrmControl bPcmPrmControl) {
		this.setId(bPcmPrmControl.getId());
		this.setParamClass(bPcmPrmControl.getParamClass());
		this.setParamClassLabel(bPcmPrmControl.getParamClassLabel());
		this.setParamField(bPcmPrmControl.getParamField());
		this.setParamFieldLabel(bPcmPrmControl.getParamFieldLabel());
		this.setMinValue(bPcmPrmControl.getMinValue());
		this.setMaxValue(bPcmPrmControl.getMaxValue());
		this.setJpaVersion(bPcmPrmControl.getJpaVersion());
		return this;
	}
	
	/**
	 * <p>根据BO更新当前实体对象的值</p>
	 * <p>如果BO属性值为空，不修改对应的entity属性值</p>
	 * <p>已排除由hibernate或底层架构自动更新值的属性(主键、jpaversion、创建时间/人、///@seq:、///@kiteseq、///@uuidseq)</p>
	 */
	public PcmPrmControl updateValueFromBO(BPcmPrmControl bPcmPrmControl) {
		if(bPcmPrmControl.getParamClass() != null){
			this.setParamClass(bPcmPrmControl.getParamClass());
		}
		if(bPcmPrmControl.getParamClassLabel() != null){
			this.setParamClassLabel(bPcmPrmControl.getParamClassLabel());
		}
		if(bPcmPrmControl.getParamField() != null){
			this.setParamField(bPcmPrmControl.getParamField());
		}
		if(bPcmPrmControl.getParamFieldLabel() != null){
			this.setParamFieldLabel(bPcmPrmControl.getParamFieldLabel());
		}
		if(bPcmPrmControl.getMinValue() != null){
			this.setMinValue(bPcmPrmControl.getMinValue());
		}
		if(bPcmPrmControl.getMaxValue() != null){
			this.setMaxValue(bPcmPrmControl.getMaxValue());
		}
		return this;
	}
	
	/**
	 * <p>将实体对象的List转换为BO对象List返回</p>
	 */
	public static List<BPcmPrmControl> convertToBOList(Iterable<PcmPrmControl> pcmPrmControlList) {
		if (pcmPrmControlList != null) {
			List<BPcmPrmControl> boList = new ArrayList<BPcmPrmControl>();
			for (PcmPrmControl pcmPrmControl : pcmPrmControlList) {
				boList.add(pcmPrmControl.toBO());
			}
			return boList;
		} else {
			return null;
		}
	}
	
	/**
	 * <p>将BO对象的List转换为实体对象List返回</p>
	 */
	public static List<PcmPrmControl> convertToEntityList(Iterable<BPcmPrmControl> bPcmPrmControlList) {
		if (bPcmPrmControlList != null) {
			List<PcmPrmControl> pcmPrmControlList = new ArrayList<PcmPrmControl>();
			for (BPcmPrmControl bPcmPrmControl : bPcmPrmControlList) {
				pcmPrmControlList.add(new PcmPrmControl(bPcmPrmControl));
			}
			return pcmPrmControlList;
		} else {
			return null;
		}
	}

	public String pk() {
		return id;
	}
}