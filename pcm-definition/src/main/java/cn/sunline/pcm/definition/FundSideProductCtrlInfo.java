package cn.sunline.pcm.definition;
import java.io.Serializable;

import java.util.Date;
import java.util.List;
import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.FundSideBusinessScope;
import cn.sunline.pcm.definition.enums.FundSideCreditCardCode;
import cn.sunline.pcm.definition.enums.FundSideProfessionScope;
/**
 *
 * @author fgy
 * @date 2019年7月28日
 *	资金方产品经营控制
 */
public class FundSideProductCtrlInfo implements Serializable{



	/**
     * 资金方经营控制编码
     */
    @PropertyInfo(name="资金方经营控制编码")
    public  String fundSideCtrlCode ;

    /**
     * 资金方经营控制描述
     */
    @PropertyInfo(name="资金方经营控制描述")
    public String  fundSideCtrlDesc ;
    
    /**
     * 资金方编码
     */
    @PropertyInfo(name="资金方编码")
    public String  fundSideCode ;
	private static final long serialVersionUID = 1L;
    /**
     * 资金方支持展业省份
     */
    @PropertyInfo(name="资金方支持展业省份")
    public String  fundSideProv ;
    
    /**
     * 资金方支持展业城市
     */
    @PropertyInfo(name="资金方支持展业城市")
    public String  fundSideCity ;
    
    /**
     * 资金方申请行业范围
     */
    @PropertyInfo(name="资金方申请行业范围")
    public java.util.List<String>  fundSideBusinessScope ;
    
    /**
     * 资金方申请职业范围
     */
    @PropertyInfo(name="资金方申请职业范围")
    public java.util.List<String>  fundSideProfessionScope ;


    /**
     * 资金方专项资产方
     */
    @PropertyInfo(name="资金方专项资产方")
    public String  fundSideInfo ;
    
    /**
     * 资金方是否支持部分还款
     */
    @PropertyInfo(name="资金方是否支持部分还款")
    public Boolean  fundSidePartRepay ;
    
    /**
     * 资金方支持还款日区间
     */
    @PropertyInfo(name="资金方支持还款日区间")
    public String  fundSideProductDuedayCR ;
    
    /**
     * 资金方产品-工作日支持征信时间段 开始时间
     */
    @PropertyInfo(name="资金方产品-工作日支持征信时间段 开始时间")
    public String  fundSideProductWorkdayCRStart ;
    
    /**
     * 资金方产品-工作日支持征信时间段 开始时间 结束时间
     */
    @PropertyInfo(name="资金方产品-工作日支持征信时间段 开始时间")
    public String  fundSideProductWorkdayCREnd ;
    
    
    /**
     * 资金方产品-节假日支持征信时间段 开始时间
     */
   @PropertyInfo(name="资金方产品-节假日支持征信时间段 开始时间")
   public String  fundSideProductHolidaysCRStart ;
   
   /**
    * 资金方产品-节假日支持征信时间段 结束时间
    */
   @PropertyInfo(name="资金方产品-节假日支持征信时间段 开始时间")
   public String  fundSideProductHolidaysCREnd ;
    
    
    
    /**
     * 资金方产品-工作日支持征信时间段 开始时间
     */
    @PropertyInfo(name="资金方产品-工作日支持授信时间段 开始时间")
    public String  fundSideProductWorkdaySXStart ;
    
    /**
     * 资金方产品-工作日支持征信时间段 结束时间
     */
    @PropertyInfo(name="资金方产品-工作日支持授信时间段 结束时间")
    public String  fundSideProductWorkdaySXEnd ;
    
    
	/**
     * 资金方产品-节假日支持授信时间段 开始时间
     */
    @PropertyInfo(name="资金方产品-节假日支持授信时间段 开始时间")
    public String  fundSideProductHolidaysSXStart ;
    
    /**
     * 资金方产品-节假日支持授信时间段 结束时间
     */
    @PropertyInfo(name="资金方产品-节假日支持授信时间段 开始时间")
    public String  fundSideProductHolidaysSXEnd ;
    
   
    
 
    /**
     * 资金方产品-工作日支持放款时间段 开始时间
     */
    @PropertyInfo(name="资金方产品-工作日支持放款时间段 开始时间")
    public String  fundSideProductWorkdayFKStart ;
    
    /**
     * 资金方产品-工作日支持放款时间段 结束时间
     */
    @PropertyInfo(name="资金方产品-工作日支持放款时间段 开始时间")
    public String  fundSideProductWorkdayFKEnd ;
    
    
    
    /**
     * 资金方产品-节假日支持放款时间段 开始时间
     */
    @PropertyInfo(name="资金方产品-节假日支持放款时间段 开始时间")
    public String  fundSideProductHolidaysFKStart ;
    
    /**
     * 资金方产品-节假日支持放款时间段 结束时间
     */
    @PropertyInfo(name="资金方产品-节假日支持放款时间段 开始时间")
    public String  fundSideProductHolidaysFKEnd ;
    
    
    
    /**
     * 资金方产品-工作日支持还款时间段 开始时间
     */
    @PropertyInfo(name="资金方产品-工作日支持还款时间段 开始时间")
    public String  fundSideProductWorkdayHKStart ;
    
    /**
     * 资金方产品-节假日支持放款时间段 结束时间
     */
    @PropertyInfo(name="资金方产品-工作日支持还款时间段 开始时间")
    public String  fundSideProductWorkdayHKEnd ;
    
    
    
    
    /**
     * 资金方产品-节假日支持还款时间段 开始时间
     */
    @PropertyInfo(name="资金方产品-节假日支持还款时间段 开始时间")
    public String  fundSideProductHolidaysHKStart ;
    
    /**
     * 资金方产品-节假日支持还款时间段 结束时间
     */
    @PropertyInfo(name="资金方产品-节假日支持还款时间段 开始时间")
    public String  fundSideProductHolidaysHKEnd ;
    
  
    
    
    /**
     * 资金方产品-当日还款截止时间
     */
    @PropertyInfo(name="资金方产品-当日还款截止时间")
    public String  fundSideProductDueDayPayOver ;
    
    /**
     * 资金方征信评分卡标识
     */
    @PropertyInfo(name="资金方征信评分卡标识")
    public FundSideCreditCardCode  fundSideCreditCardCode ;
    
    /**
     * 资金方申请年龄范围
     * @return
     */
    @PropertyInfo(name="资金方申请年龄范围")
    public String  applicantsAgeRange ;

    public String getFundSideCtrlCode() {
		return fundSideCtrlCode;
	}

	public void setFundSideCtrlCode(String fundSideCtrlCode) {
		this.fundSideCtrlCode = fundSideCtrlCode;
	}

	public String getFundSideCtrlDesc() {
		return fundSideCtrlDesc;
	}

	public void setFundSideCtrlDesc(String fundSideCtrlDesc) {
		this.fundSideCtrlDesc = fundSideCtrlDesc;
	}

	public String getFundSideCode() {
		return fundSideCode;
	}

	public void setFundSideCode(String fundSideCode) {
		this.fundSideCode = fundSideCode;
	}

	public String getFundSideProv() {
		return fundSideProv;
	}

	public void setFundSideProv(String fundSideProv) {
		this.fundSideProv = fundSideProv;
	}

	public String getFundSideCity() {
		return fundSideCity;
	}

	public void setFundSideCity(String fundSideCity) {
		this.fundSideCity = fundSideCity;
	}
 
	

	public java.util.List<String> getFundSideBusinessScope() {
		return fundSideBusinessScope;
	}

	public void setFundSideBusinessScope(java.util.List<String> fundSideBusinessScope) {
		this.fundSideBusinessScope = fundSideBusinessScope;
	}

	public java.util.List<String> getFundSideProfessionScope() {
		return fundSideProfessionScope;
	}

	public void setFundSideProfessionScope(java.util.List<String> fundSideProfessionScope) {
		this.fundSideProfessionScope = fundSideProfessionScope;
	}

	public String getFundSideInfo() {
		return fundSideInfo;
	}

	public void setFundSideInfo(String fundSideInfo) {
		this.fundSideInfo = fundSideInfo;
	}

	public Boolean getFundSidePartRepay() {
		return fundSidePartRepay;
	}

	public void setFundSidePartRepay(Boolean fundSidePartRepay) {
		this.fundSidePartRepay = fundSidePartRepay;
	}

	public String getFundSideProductDuedayCR() {
		return fundSideProductDuedayCR;
	}

	public void setFundSideProductDuedayCR(String fundSideProductDuedayCR) {
		this.fundSideProductDuedayCR = fundSideProductDuedayCR;
	}

	public String getFundSideProductWorkdayCRStart() {
		return fundSideProductWorkdayCRStart;
	}

	public void setFundSideProductWorkdayCRStart(String fundSideProductWorkdayCRStart) {
		this.fundSideProductWorkdayCRStart = fundSideProductWorkdayCRStart;
	}

	public String getFundSideProductWorkdayCREnd() {
		return fundSideProductWorkdayCREnd;
	}

	public void setFundSideProductWorkdayCREnd(String fundSideProductWorkdayCREnd) {
		this.fundSideProductWorkdayCREnd = fundSideProductWorkdayCREnd;
	}

	public String getFundSideProductHolidaysCRStart() {
		return fundSideProductHolidaysCRStart;
	}

	public void setFundSideProductHolidaysCRStart(String fundSideProductHolidaysCRStart) {
		this.fundSideProductHolidaysCRStart = fundSideProductHolidaysCRStart;
	}

	public String getFundSideProductHolidaysCREnd() {
		return fundSideProductHolidaysCREnd;
	}

	public void setFundSideProductHolidaysCREnd(String fundSideProductHolidaysCREnd) {
		this.fundSideProductHolidaysCREnd = fundSideProductHolidaysCREnd;
	}

	public String getFundSideProductWorkdaySXStart() {
		return fundSideProductWorkdaySXStart;
	}

	public void setFundSideProductWorkdaySXStart(String fundSideProductWorkdaySXStart) {
		this.fundSideProductWorkdaySXStart = fundSideProductWorkdaySXStart;
	}

	public String getFundSideProductWorkdaySXEnd() {
		return fundSideProductWorkdaySXEnd;
	}

	public void setFundSideProductWorkdaySXEnd(String fundSideProductWorkdaySXEnd) {
		this.fundSideProductWorkdaySXEnd = fundSideProductWorkdaySXEnd;
	}

	public String getFundSideProductHolidaysSXStart() {
		return fundSideProductHolidaysSXStart;
	}

	public void setFundSideProductHolidaysSXStart(String fundSideProductHolidaysSXStart) {
		this.fundSideProductHolidaysSXStart = fundSideProductHolidaysSXStart;
	}

	public String getFundSideProductHolidaysSXEnd() {
		return fundSideProductHolidaysSXEnd;
	}

	public void setFundSideProductHolidaysSXEnd(String fundSideProductHolidaysSXEnd) {
		this.fundSideProductHolidaysSXEnd = fundSideProductHolidaysSXEnd;
	}

	public String getFundSideProductWorkdayFKStart() {
		return fundSideProductWorkdayFKStart;
	}

	public void setFundSideProductWorkdayFKStart(String fundSideProductWorkdayFKStart) {
		this.fundSideProductWorkdayFKStart = fundSideProductWorkdayFKStart;
	}

	public String getFundSideProductWorkdayFKEnd() {
		return fundSideProductWorkdayFKEnd;
	}

	public void setFundSideProductWorkdayFKEnd(String fundSideProductWorkdayFKEnd) {
		this.fundSideProductWorkdayFKEnd = fundSideProductWorkdayFKEnd;
	}

	public String getFundSideProductHolidaysFKStart() {
		return fundSideProductHolidaysFKStart;
	}

	public void setFundSideProductHolidaysFKStart(String fundSideProductHolidaysFKStart) {
		this.fundSideProductHolidaysFKStart = fundSideProductHolidaysFKStart;
	}

	public String getFundSideProductHolidaysFKEnd() {
		return fundSideProductHolidaysFKEnd;
	}

	public void setFundSideProductHolidaysFKEnd(String fundSideProductHolidaysFKEnd) {
		this.fundSideProductHolidaysFKEnd = fundSideProductHolidaysFKEnd;
	}

	public String getFundSideProductWorkdayHKStart() {
		return fundSideProductWorkdayHKStart;
	}

	public void setFundSideProductWorkdayHKStart(String fundSideProductWorkdayHKStart) {
		this.fundSideProductWorkdayHKStart = fundSideProductWorkdayHKStart;
	}

	public String getFundSideProductWorkdayHKEnd() {
		return fundSideProductWorkdayHKEnd;
	}

	public void setFundSideProductWorkdayHKEnd(String fundSideProductWorkdayHKEnd) {
		this.fundSideProductWorkdayHKEnd = fundSideProductWorkdayHKEnd;
	}

	public String getFundSideProductHolidaysHKStart() {
		return fundSideProductHolidaysHKStart;
	}

	public void setFundSideProductHolidaysHKStart(String fundSideProductHolidaysHKStart) {
		this.fundSideProductHolidaysHKStart = fundSideProductHolidaysHKStart;
	}

	public String getFundSideProductHolidaysHKEnd() {
		return fundSideProductHolidaysHKEnd;
	}

	public void setFundSideProductHolidaysHKEnd(String fundSideProductHolidaysHKEnd) {
		this.fundSideProductHolidaysHKEnd = fundSideProductHolidaysHKEnd;
	}

	public String getFundSideProductDueDayPayOver() {
		return fundSideProductDueDayPayOver;
	}

	public void setFundSideProductDueDayPayOver(String fundSideProductDueDayPayOver) {
		this.fundSideProductDueDayPayOver = fundSideProductDueDayPayOver;
	}

	public FundSideCreditCardCode getFundSideCreditCardCode() {
		return fundSideCreditCardCode;
	}

	public void setFundSideCreditCardCode(FundSideCreditCardCode fundSideCreditCardCode) {
		this.fundSideCreditCardCode = fundSideCreditCardCode;
	}

	public String getApplicantsAgeRange() {
		return applicantsAgeRange;
	}

	public void setApplicantsAgeRange(String applicantsAgeRange) {
		this.applicantsAgeRange = applicantsAgeRange;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

    

    
}
