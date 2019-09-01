package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.common.enums.Indicator;
import cn.sunline.pcm.definition.enums.PbocRptType;
import cn.sunline.ppy.dictionary.enums.GraceIntType;

/**
 * 机构属性
 */
public class Organization implements Serializable {
 
	/**
	 * 无任何意义起标识符作用，对应paramKey
	 */
	@PropertyInfo(name = "*(当前机构唯一参数)", length = 20)
	public String oId;
	/**
	 * 支付渠道
	 */
	@PropertyInfo(name = "支付渠道", length = 20)
	public String paymentChannel;

	/**
	 * 征信金融机构
	 */
	@PropertyInfo(name = "征信金融机构", length = 20)
	public String creditInstitutions;

	/**
	 * 人行征信报送类型
	 */
	@PropertyInfo(name = "人行征信报送类型", length = 1)
	public PbocRptType pbocType;

	
	/**
	 * 默认分行号smsToOrg
	 */
	@PropertyInfo(name = "默认分行号", length = 16)
	public String defaultBranchNo;

	/**
	 * 发送短信机构号
	 */
	@PropertyInfo(name = "发送短信机构号", length = 10)
	public String smsToOrg;

	/**
	 * 实时入账标志
	 */
	@PropertyInfo(name = "放款实时入账标志", length = 1)
	public Indicator bookingOnlineFlag;
    /**
     * 实时入账标志
     */
    @PropertyInfo(name = "还款实时入账标志", length = 1)
    public Indicator repayBookingOnlineFlag;
	/**
	 * 基准货币代码
	 */
	@PropertyInfo(name = "基准货币代码", length = 3)
	public String baseCurrCd;

	/**
	 * 最大授信额度
	 */
	@PropertyInfo(name = "最大授信额度", length = 15, precision = 2)
	public BigDecimal maxCreditLimit;

	/**
	 * 超限享受免息期标识
	 */
	@PropertyInfo(name = "超限免息标识", length = 1)
	public GraceIntType overlimitDeferInd;

	/**
	 * 未全额还款享受免息期标志
	 * 如果未对上期账单做全额还款，当期新增交易是否享受免息期
	 */
	@PropertyInfo(name = "未全额还款免息标识", length = 1)
	public GraceIntType nofullpayDeferInd;

	/**
	 * 溢缴款信用计划号
	 */
	@PropertyInfo(name = "溢缴款信用计划号", length = 6)
	public String depositPlanNbr;

	/**
	 * 临额最大有效月数
	 */
	@PropertyInfo(name = "临额最大有效月数", length = 1)
	public Integer tempLimitMaxMths;

	/**
	 * 利息是否按信用计划入账
	 */
	@PropertyInfo(name = "利息按信用计划入账", length = 1)
	public Boolean intPostOnPlan;

	/**
	 * 可调整还款日次数
	 */
	@PropertyInfo(name = "还款日调整区间内可调整次数", length = 1)
	public Integer adjStmtCount;

	/**
	 * 调整还款日间隔（月）
	 */
	@PropertyInfo(name = "还款日调整区间（月）", length = 1)
	public Integer adjStmtMonth;

	private static final long serialVersionUID = 5225965589218240104L;
	public String getBaseCurrCd() {
		return baseCurrCd;
	}

	public void setBaseCurrCd(String baseCurrCd) {
		this.baseCurrCd = baseCurrCd;
	}

	public BigDecimal getMaxCreditLimit() {
		return maxCreditLimit;
	}

	public void setMaxCreditLimit(BigDecimal maxCreditLimit) {
		this.maxCreditLimit = maxCreditLimit;
	}
	public GraceIntType getOverlimitDeferInd() {
		return overlimitDeferInd;
	}

	public void setOverlimitDeferInd(GraceIntType overlimitDeferInd) {
		this.overlimitDeferInd = overlimitDeferInd;
	}

	public GraceIntType getNofullpayDeferInd() {
		return nofullpayDeferInd;
	}

	public void setNofullpayDeferInd(GraceIntType nofullpayDeferInd) {
		this.nofullpayDeferInd = nofullpayDeferInd;
	}

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public String getDepositPlanNbr() {
		return depositPlanNbr;
	}

	public void setDepositPlanNbr(String depositPlanNbr) {
		this.depositPlanNbr = depositPlanNbr;
	}

	public Integer getTempLimitMaxMths() {
		return tempLimitMaxMths;
	}

	public void setTempLimitMaxMths(Integer tempLimitMaxMths) {
		this.tempLimitMaxMths = tempLimitMaxMths;
	}

	public Boolean getIntPostOnPlan() {
		return intPostOnPlan;
	}

	public void setIntPostOnPlan(Boolean intPostOnPlan) {
		this.intPostOnPlan = intPostOnPlan;
	}

	public Integer getAdjStmtCount() {
		return adjStmtCount;
	}

	public void setAdjStmtCount(Integer adjStmtCount) {
		this.adjStmtCount = adjStmtCount;
	}

	public Integer getAdjStmtMonth() {
		return adjStmtMonth;
	}

	public void setAdjStmtMonth(Integer adjStmtMonth) {
		this.adjStmtMonth = adjStmtMonth;
	}

	public String getPaymentChannel() {
		return paymentChannel;
	}

	public void setPaymentChannel(String paymentChannel) {
		this.paymentChannel = paymentChannel;
	}

	public String getCreditInstitutions() {
		return creditInstitutions;
	}

	public void setCreditInstitutions(String creditInstitutions) {
		this.creditInstitutions = creditInstitutions;
	}

	public PbocRptType getPbocType() {
		return pbocType;
	}

	public void setPbocType(PbocRptType pbocType) {
		this.pbocType = pbocType;
	}

	public String getDefaultBranchNo() {
		return defaultBranchNo;
	}

	public void setDefaultBranchNo(String defaultBranchNo) {
		this.defaultBranchNo = defaultBranchNo;
	}

	public String getSmsToOrg() {
		return smsToOrg;
	}

	public void setSmsToOrg(String smsToOrg) {
		this.smsToOrg = smsToOrg;
	}

	public Indicator getBookingOnlineFlag() {
		return bookingOnlineFlag;
	}

	public void setBookingOnlineFlag(Indicator bookingOnlineFlag) {
		this.bookingOnlineFlag = bookingOnlineFlag;
	}

    public Indicator getRepayBookingOnlineFlag() {
        return repayBookingOnlineFlag;
    }

    public void setRepayBookingOnlineFlag(Indicator repayBookingOnlineFlag) {
        this.repayBookingOnlineFlag = repayBookingOnlineFlag;
    }
//	@PropertyInfo(name="机构名称", length=40)
//	public String name;
//    
//    /**
//     * 描述
//     */
//    @PropertyInfo(name="描述", length=80)
//    public String description;
//
//    /**
//     * 地址
//     */
//    @PropertyInfo(name="地址", length=200)
//    public String address;
//
//    /**
//     * 城市
//     */
//    @PropertyInfo(name="城市", length=40)
//    public String city;
//
//    /**
//     * 省份
//     */
//    @PropertyInfo(name="省份", length=40)
//    public String state;
//
//	/**
//	 * 国家代码
//	 */
//	@PropertyInfo(name = "国家代码", length = 3)
//	public String countryCode;
//
//    /**
//     * 联系电话1
//     */
//    @PropertyInfo(name="联系电话1", length=20)
//    public String phone1;
//
//    /**
//     * 联系电话2
//     */
//    @PropertyInfo(name="联系电话2", length=20)
//    public String phone2;
//
//    /**
//     * 客服电话
//     */
//    @PropertyInfo(name="客服电话", length=20)
//    public String cssPhone;
//    
//    /**
//     * 传真
//     */
//    @PropertyInfo(name="传真", length=20)
//    public String fax;
//
//    /**
//     * 电子邮箱
//     */
//    @PropertyInfo(name="电子邮箱", length=40)
//    public String email;
//
//    /**
//     * 基准货币
//     */
//    @PropertyInfo(name="基准货币", length=3)
//    public String baseCurrencyCode;
//    /**
//     * 基准货币小数位
//     */
//    @PropertyInfo(name="基准货币小数位", length=1)
//    public Integer baseCurrencyExponent;
//    
//    /**
//     * 信息发送接口的控制
//     */
//    @PropertyInfo(name="信息发送接口开关")
//    public MessageSendingWaySwitch messageSendingWaySwitch;
//    
//    @PropertyInfo(name="是否开通银联渠道")
//    public Boolean CUP_ENABLE_IND;
//    
//    @PropertyInfo(name="银联清算机构号1", length=20)
//    public String CUP_CLEARING_ORG1;
//    
//    @PropertyInfo(name="银联清算机构号2", length=20)
//    public String CUP_CLEARING_ORG2;
//    
//    @PropertyInfo(name="是否开通VISA渠道")
//    public Boolean VISA_ENABLE_IND;
//    
//    @PropertyInfo(name="银联清算机构号", length=20)
//    public String VISA_CLEARING_ORG;
//    
//    @PropertyInfo(name="是否开通MC渠道")
//    public Boolean MC_ENABLE_IND;
//    
//    @PropertyInfo(name="银联清算机构号", length=20)
//    public String MC_CLEARING_ORG;
//    
//    @PropertyInfo(name="是否开通JCB渠道")
//    public Boolean JCB_ENABLE_IND;
//    
//    @PropertyInfo(name="银联清算机构号", length=20)
//    public String JCB_CLEARING_ORG;
//    
//    /**
//     * 是否IC系统验证
//     */
//    @PropertyInfo(name="是否外部IC系统验证",length=1)
//    public Indicator arqcCheck;
//    
//    /**
//     * 机构支持的产品
//     */
//    @PropertyInfo(name="机构支持的产品", length=1)
//    public List<ProductType> orgSupportProduct;
//    
//    @PropertyInfo(name="全量数据出仓输出时间")
//    public Date dataSoloution;
//    
//    @PropertyInfo(name="全量催收文件输出时间")
//    public Date ermasData;
//    
//    @PropertyInfo(name="全量监管上送输出时间")
//    public Date superviseData;
//    
//    /**
//     * 机构层总额度控制
//     */
//    @PropertyInfo(name="机构层总额度",length=15,precision=2)
//    public BigDecimal orgMaxAmount;
//    
//    /**
//     * 参数复核开关
//     */
//    @PropertyInfo(name="参数复核开关")
//    public Boolean paramCheckInd;
//    
//	public String getName() {
//		return name;
//	}
//
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	
//	public String getDescription() {
//		return description;
//	}
//
//	
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	
//	public String getAddress() {
//		return address;
//	}
//
//	
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	
//	public String getCity() {
//		return city;
//	}
//
//	
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	
//	public String getState() {
//		return state;
//	}
//
//	
//	public void setState(String state) {
//		this.state = state;
//	}
//
//
//	public String getCountryCode() {
//		return countryCode;
//	}
//
//	public void setCountryCode(String countryCode) {
//		this.countryCode = countryCode;
//	}
//
//	public String getPhone1() {
//		return phone1;
//	}
//
//	
//	public void setPhone1(String phone1) {
//		this.phone1 = phone1;
//	}
//
//	
//	public String getPhone2() {
//		return phone2;
//	}
//
//	
//	public void setPhone2(String phone2) {
//		this.phone2 = phone2;
//	}
//
//	
//	public String getCssPhone() {
//		return cssPhone;
//	}
//
//	
//	public void setCssPhone(String cssPhone) {
//		this.cssPhone = cssPhone;
//	}
//
//	
//	public String getFax() {
//		return fax;
//	}
//
//	
//	public void setFax(String fax) {
//		this.fax = fax;
//	}
//
//	
//	public String getEmail() {
//		return email;
//	}
//
//	
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	
//	public String getBaseCurrencyCode() {
//		return baseCurrencyCode;
//	}
//
//	
//	public void setBaseCurrencyCode(String baseCurrencyCode) {
//		this.baseCurrencyCode = baseCurrencyCode;
//	}
//
//	
//	public Integer getBaseCurrencyExponent() {
//		return baseCurrencyExponent;
//	}
//
//	
//	public void setBaseCurrencyExponent(Integer baseCurrencyExponent) {
//		this.baseCurrencyExponent = baseCurrencyExponent;
//	}
//
//	
//	public MessageSendingWaySwitch getMessageSendingWaySwitch() {
//		return messageSendingWaySwitch;
//	}
//
//	
//	public void setMessageSendingWaySwitch(MessageSendingWaySwitch messageSendingWaySwitch) {
//		this.messageSendingWaySwitch = messageSendingWaySwitch;
//	}
//
//	
//	public Boolean getCUP_ENABLE_IND() {
//		return CUP_ENABLE_IND;
//	}
//
//	
//	public void setCUP_ENABLE_IND(Boolean cUP_ENABLE_IND) {
//		CUP_ENABLE_IND = cUP_ENABLE_IND;
//	}
//
//	
//	public String getCUP_CLEARING_ORG1() {
//		return CUP_CLEARING_ORG1;
//	}
//
//	
//	public void setCUP_CLEARING_ORG1(String cUP_CLEARING_ORG1) {
//		CUP_CLEARING_ORG1 = cUP_CLEARING_ORG1;
//	}
//
//	
//	public String getCUP_CLEARING_ORG2() {
//		return CUP_CLEARING_ORG2;
//	}
//
//	
//	public void setCUP_CLEARING_ORG2(String cUP_CLEARING_ORG2) {
//		CUP_CLEARING_ORG2 = cUP_CLEARING_ORG2;
//	}
//
//	
//	public Boolean getVISA_ENABLE_IND() {
//		return VISA_ENABLE_IND;
//	}
//
//	
//	public void setVISA_ENABLE_IND(Boolean vISA_ENABLE_IND) {
//		VISA_ENABLE_IND = vISA_ENABLE_IND;
//	}
//
//	
//	public String getVISA_CLEARING_ORG() {
//		return VISA_CLEARING_ORG;
//	}
//
//	
//	public void setVISA_CLEARING_ORG(String vISA_CLEARING_ORG) {
//		VISA_CLEARING_ORG = vISA_CLEARING_ORG;
//	}
//
//	
//	public Boolean getMC_ENABLE_IND() {
//		return MC_ENABLE_IND;
//	}
//
//	
//	public void setMC_ENABLE_IND(Boolean mC_ENABLE_IND) {
//		MC_ENABLE_IND = mC_ENABLE_IND;
//	}
//
//	
//	public String getMC_CLEARING_ORG() {
//		return MC_CLEARING_ORG;
//	}
//
//	
//	public void setMC_CLEARING_ORG(String mC_CLEARING_ORG) {
//		MC_CLEARING_ORG = mC_CLEARING_ORG;
//	}
//
//	
//	public Boolean getJCB_ENABLE_IND() {
//		return JCB_ENABLE_IND;
//	}
//
//	
//	public void setJCB_ENABLE_IND(Boolean jCB_ENABLE_IND) {
//		JCB_ENABLE_IND = jCB_ENABLE_IND;
//	}
//
//	
//	public String getJCB_CLEARING_ORG() {
//		return JCB_CLEARING_ORG;
//	}
//
//	
//	public void setJCB_CLEARING_ORG(String jCB_CLEARING_ORG) {
//		JCB_CLEARING_ORG = jCB_CLEARING_ORG;
//	}
//
//	
//	public Indicator getArqcCheck() {
//		return arqcCheck;
//	}
//
//	
//	public void setArqcCheck(Indicator arqcCheck) {
//		this.arqcCheck = arqcCheck;
//	}
//
//	
//	public List<ProductType> getOrgSupportProduct() {
//		return orgSupportProduct;
//	}
//
//	
//	public void setOrgSupportProduct(List<ProductType> orgSupportProduct) {
//		this.orgSupportProduct = orgSupportProduct;
//	}
//
//	
//	public Date getDataSoloution() {
//		return dataSoloution;
//	}
//
//	
//	public void setDataSoloution(Date dataSoloution) {
//		this.dataSoloution = dataSoloution;
//	}
//
//	
//	public Date getErmasData() {
//		return ermasData;
//	}
//
//	
//	public void setErmasData(Date ermasData) {
//		this.ermasData = ermasData;
//	}
//
//	
//	public Date getSuperviseData() {
//		return superviseData;
//	}
//
//	
//	public void setSuperviseData(Date superviseData) {
//		this.superviseData = superviseData;
//	}
//
//	
//	public BigDecimal getOrgMaxAmount() {
//		return orgMaxAmount;
//	}
//
//	
//	public void setOrgMaxAmount(BigDecimal orgMaxAmount) {
//		this.orgMaxAmount = orgMaxAmount;
//	}
//
//	
//	public Boolean getParamCheckInd() {
//		return paramCheckInd;
//	}
//
//	
//	public void setParamCheckInd(Boolean paramCheckInd) {
//		this.paramCheckInd = paramCheckInd;
//	}
//
}
