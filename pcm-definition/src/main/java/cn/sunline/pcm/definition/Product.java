package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.util.List;


import cn.sunline.common.enums.Indicator;
import cn.sunline.ppy.dictionary.enums.Brand;
import cn.sunline.ppy.dictionary.enums.CardClass;
import cn.sunline.ppy.dictionary.enums.ProductType;
import cn.sunline.common.annotation.paramdef.PropertyInfo;

/**
 * 产品定义
 * 主键是产品代码，同一机构下产品代码不允许重复
 * 业务主键：卡品牌 + 产品类型 + 卡等级 + 联名卡代码
 * 公务卡的实现采用定义专有的联名卡代码与标准卡进行区分
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 9132406689211709311L;

	/**
	 * ty加的
	 */
	public String currency;
	

	
	
	/**
     * 产品代码
     */
    @PropertyInfo(name="产品代码", length=6)
    public String productCode;

    /**
     * 产品描述
     */
    @PropertyInfo(name="产品描述", length=40)
    public String description;

    /**
     * 卡品牌
     */
    @PropertyInfo(name="卡品牌", length=1)
    public Brand brand;

    /**
     * 产品类型
     */
    @PropertyInfo(name="产品类型", length=1)
    public ProductType productType;
    
    
    /**
     * 产品类型分组 @author zzq
     */
    @PropertyInfo(name="产品类型分组",length=50)
    public String groupType; 

    /**
     * 卡等级：
     */
    @PropertyInfo(name="卡等级", length=1)
    public CardClass cardClass;

    /**
     * 联名卡代码
     */
    @PropertyInfo(name="联名卡代码", length=10)
    public String jointCode;

    /**
     * 联名卡描述
     */
    @PropertyInfo(name="联名卡描述", length=100)
    public String jointDescription;
    
    /**
     * BIN
     */
    @PropertyInfo(name="BIN", length=6)
    public String bin;

    
    /**
     * 卡号长度（最大值19）
     */
    @PropertyInfo(name="卡号长度", length=2)
    public Integer cardnoLen;

    /**
     * 卡号段上限
     */
    @PropertyInfo(name="卡号段上限", length=12)
    public String cardnoRangeCeil;

    /**
     * 卡号段下限
     */
    @PropertyInfo(name="卡号段下限", length=12)
    public String cardnoRangeFlr;

    /**
     * 新卡有效期（年）
     */
    @PropertyInfo(name="新卡有效期（年）", length=2)
    public Integer newCardValidPeriod;

    /**
     * 续卡有效期（年）
     */
    @PropertyInfo(name="续卡有效期（年）", length=2)
    public Integer renewValidPeriod;

    /**
     * 物理卡面列表
     * key - 物理卡面编号， PhyCardCd的主键
     */
    @PropertyInfo(name="物理卡面列表", length=10)
    public List<String> phyCardCdList;
    
    /**
     * 是否支持客户利率浮动
     */
    @PropertyInfo(name="是否支持客户利率浮动",length=1)
    public Indicator rateFloanInd;
    
    @PropertyInfo(name="是否生产制卡文件",length=1)
    public Indicator fabricationInd;
    
    /**
     * 短信或信函的配置
     */
//    @PropertyInfo(name="信息配置")
//    public Map<MessageCategory, String> messageTemplates;
    /**
     * 所属产品组
     */
    @PropertyInfo(name = "所属产品组", length = 8)
    public String productGroup;
    
    /**
     * 人行记录是否合并
     */
    @PropertyInfo(name = "人行记录是否合并", length = 8)
    public Indicator isPbocInfoMerged;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public CardClass getCardClass() {
		return cardClass;
	}

	public void setCardClass(CardClass cardClass) {
		this.cardClass = cardClass;
	}

	public String getJointCode() {
		return jointCode;
	}

	public void setJointCode(String jointCode) {
		this.jointCode = jointCode;
	}

	public String getJointDescription() {
		return jointDescription;
	}

	public void setJointDescription(String jointDescription) {
		this.jointDescription = jointDescription;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public Integer getCardnoLen() {
		return cardnoLen;
	}

	public void setCardnoLen(Integer cardnoLen) {
		this.cardnoLen = cardnoLen;
	}

	public String getCardnoRangeCeil() {
		return cardnoRangeCeil;
	}

	public void setCardnoRangeCeil(String cardnoRangeCeil) {
		this.cardnoRangeCeil = cardnoRangeCeil;
	}

	public String getCardnoRangeFlr() {
		return cardnoRangeFlr;
	}

	public void setCardnoRangeFlr(String cardnoRangeFlr) {
		this.cardnoRangeFlr = cardnoRangeFlr;
	}

	public Integer getNewCardValidPeriod() {
		return newCardValidPeriod;
	}

	public void setNewCardValidPeriod(Integer newCardValidPeriod) {
		this.newCardValidPeriod = newCardValidPeriod;
	}

	public Integer getRenewValidPeriod() {
		return renewValidPeriod;
	}

	public void setRenewValidPeriod(Integer renewValidPeriod) {
		this.renewValidPeriod = renewValidPeriod;
	}

	public List<String> getPhyCardCdList() {
		return phyCardCdList;
	}

	public void setPhyCardCdList(List<String> phyCardCdList) {
		this.phyCardCdList = phyCardCdList;
	}

	public Indicator getRateFloanInd() {
		return rateFloanInd;
	}

	public void setRateFloanInd(Indicator rateFloanInd) {
		this.rateFloanInd = rateFloanInd;
	}

	public Indicator getFabricationInd() {
		return fabricationInd;
	}

	public void setFabricationInd(Indicator fabricationInd) {
		this.fabricationInd = fabricationInd;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public Indicator getIsPbocInfoMerged() {
		return isPbocInfoMerged;
	}

	public void setIsPbocInfoMerged(Indicator isPbocInfoMerged) {
		this.isPbocInfoMerged = isPbocInfoMerged;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
    
    
}
