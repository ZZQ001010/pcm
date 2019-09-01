package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


import cn.sunline.common.enums.Indicator;
import cn.sunline.pcm.definition.enums.MulctCollectMethod;
import cn.sunline.pcm.definition.enums.MulctMethod;
import cn.sunline.common.annotation.paramdef.PropertyInfo;

/**
 *罚金利率管理
 * 主键-mulctTableId
 */
@SuppressWarnings("serial")
public class Mulct implements Serializable {

    	
    /**
     * 罚金表id
     */
    @PropertyInfo(name="罚金表id", length=6)
    public String mulctTableId;
    /**
     * 罚金名称
     */
    @PropertyInfo(name="罚金名称", length=50)
    public String mulctName;

    /**
     * 罚金收取方式
     */
    @PropertyInfo(name="罚金收取方式", length=1)
    public MulctMethod mulctMethod;
    /**
     * 罚金计算方式
     */
    @PropertyInfo(name="罚金计算方式", length=1)
    public MulctCollectMethod mulctCalMethod;

    /**
     * 计息基准年
     */
    @PropertyInfo(name="计息基准年", length=3)
    public Integer baseYear;

    /**
     * 描述
     */
    @PropertyInfo(name="描述", length=200)
    public String description;

    /**
     * 罚金列表
     */
    public List<MulctDef> mulctDefs;
    //马上贷新增参数
    /**
     * CPD容差
     */
    @PropertyInfo(name="CPD容差", length=15,precision=2)
    public BigDecimal cpdToleLmt;
    /**
     * DPD容差
     */
    @PropertyInfo(name="DPD容差", length=15,precision=2)
    public BigDecimal dpdToleLmt;
    
    /**
     * 扣款延迟入账是否回溯罚金    原名：延迟扣款是否罚金回溯
     * 修改时间2015.11.05 14：44  chenpy
     */
    @PropertyInfo(name="扣款延迟入账是否回溯罚金", length=1)
    public Indicator isReviewMulct;
    
    /**
     * CPD列表
     */
    public List<CpdDef> cpdDefs;

	public String getMulctTableId() {
		return mulctTableId;
	}

	public void setMulctTableId(String mulctTableId) {
		this.mulctTableId = mulctTableId;
	}

	public String getMulctName() {
		return mulctName;
	}

	public void setMulctName(String mulctName) {
		this.mulctName = mulctName;
	}

	public MulctMethod getMulctMethod() {
		return mulctMethod;
	}

	public void setMulctMethod(MulctMethod mulctMethod) {
		this.mulctMethod = mulctMethod;
	}

	public MulctCollectMethod getMulctCalMethod() {
		return mulctCalMethod;
	}

	public void setMulctCalMethod(MulctCollectMethod mulctCalMethod) {
		this.mulctCalMethod = mulctCalMethod;
	}

	public Integer getBaseYear() {
		return baseYear;
	}

	public void setBaseYear(Integer baseYear) {
		this.baseYear = baseYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MulctDef> getMulctDefs() {
		return mulctDefs;
	}

	public void setMulctDefs(List<MulctDef> mulctDefs) {
		this.mulctDefs = mulctDefs;
	}

	public BigDecimal getCpdToleLmt() {
		return cpdToleLmt;
	}

	public void setCpdToleLmt(BigDecimal cpdToleLmt) {
		this.cpdToleLmt = cpdToleLmt;
	}

	public BigDecimal getDpdToleLmt() {
		return dpdToleLmt;
	}

	public void setDpdToleLmt(BigDecimal dpdToleLmt) {
		this.dpdToleLmt = dpdToleLmt;
	}

	public Indicator getIsReviewMulct() {
		return isReviewMulct;
	}

	public void setIsReviewMulct(Indicator isReviewMulct) {
		this.isReviewMulct = isReviewMulct;
	}

	public List<CpdDef> getCpdDefs() {
		return cpdDefs;
	}

	public void setCpdDefs(List<CpdDef> cpdDefs) {
		this.cpdDefs = cpdDefs;
	}
    
    
}
