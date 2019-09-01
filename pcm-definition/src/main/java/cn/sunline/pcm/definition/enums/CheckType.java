package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

@EnumInfo({
	"OverseasCashSingleLimitUse|境外取现单笔限制启用",
	"OverseasCashAccumulativeLimitUse|境外取现累计限制启用",
	"TerritoryCashAccumulativeLimit|境内取现累计限制",
	"TerritoryExpenseAccumulativeLimit|境内消费累计限制",
	"TerritoryOverdrawForeignCurr|境内不许透支取外币",
	"IsAllReversal|人工进行授权撤销是否全部可冲正",
	"IsSupportIc|是否支持ic卡",
	"IsSupportFallback|是否支持fallback交易",
	"IsSupportInstalment|是否支持分期交易",
	"ElectronSecurityVerify|电子类安全交易验证",
	"FirstTrackFlag|1磁是否检查",
	"SecondTrackFlag|2磁是否检查",
	"ThirdTrackFlag|3磁是否检查",
	"ExpenseUnionpayOverseasCheck|消费银联境外免验标志强制免验启用",
	"UnionpayCardSelfCheck|银联有卡自助强制免验启用",
	"ResortPasswordVerify|凭密消费 强制验密（凭签名消费免验）",
	"VerifyAtc|验证atc",
	"CountryCodeCheckFlag|国家码检查启用标志",
	"CurrencyCodeCheckFlag|币种码检查启用标志",
	"MccCodeCheckFlag|MCC码检查启用标志",
	"CountryCurrencyMccCrossCheckFlag|国家/币种/mcc交叉检查启用标志",
	"MerchantRestrictFlag|商户交易限制启用标志",
	"CheckATMCashLimit|检查累计批准ATM取现金额标志",
	"CheckATMCashNbr|检查累计批准ATM取现笔数标志",
	"CheckCycleLimit|检查周期内交易总金额标志",
	"CheckCycleCashLimit|检查周期内取现总金额标志",
	"CheckCycleNetLimit|检查周期内网银消费总金额标志",
	"IsForceVerifySupportMerchantMotoExpense|是否强制验证支持Moto消费交易",
	"IsForceVerifySupportElectronicCategoryExpense|是否强制验证支持电子类消费交易 ",
	"IsForceVerifySupportInstalment|是否强制验证支持分期消费交易",
	"IsForceVerifySupportBigAmountInstalment|是否强制验证支持大额分期消费交易",
	"RefuseActionFlag|拒绝行动修正标志"
})
public enum CheckType {
	/**
	 * 拒绝行动修正标志
	 */
	RefuseActionFlag,
	/**
	 * 检查累计批准ATM取现金额标志
	 */
	CheckATMCashLimit,
	/**
	 * 检查累计批准ATM取现笔数标志
	 */
	CheckATMCashNbr,
	/**
	 * 检查周期内交易总金额标志
	 */
	CheckCycleLimit,
	/**
	 * 检查周期内取现总金额标志
	 */
	CheckCycleCashLimit,
	/**
	 * 检查周期内网银消费总金额标志
	 */
	CheckCycleNetLimit,
	/**
	 * 境外取现单笔限制启用
	 */
	OverseasCashSingleLimitUse,
	/**
	 * 境外取现累计限制启用
	 */
	OverseasCashAccumulativeLimitUse,
	/**
	 * 境内取现累计限制
	 */
	TerritoryCashAccumulativeLimit,
	/**
	 * 境内消费累计限制
	 */
	TerritoryExpenseAccumulativeLimit,
	/**
	 * 境内不许透支取外币
	 */
	TerritoryOverdrawForeignCurr,
	/**
	 * 人工进行授权撤销是否全部可冲正
	 */
	IsAllReversal,
	/**
	 * 是否支持ic卡
	 */
	IsSupportIc,
	/**
	 * 是否支持fallback交易
	 */
	IsSupportFallback,
	/**
	 * 是否支持分期交易
	 */
	IsSupportInstalment,
	/**
	 * 电子类安全交易验证
	 */
	ElectronSecurityVerify,
	/**
	 * 1磁是否检查
	 */
	FirstTrackFlag,
	/**
	 * 2磁是否检查
	 */
	SecondTrackFlag,
	/**
	 * 3磁是否检查
	 */
	ThirdTrackFlag,
	/**
	 * 消费银联境外免验标志强制免验启用
	 */
	ExpenseUnionpayOverseasCheck,
	/**
	 * 银联有卡自助强制免验启用
	 */
	UnionpayCardSelfCheck,
	/**
	 * 凭密消费 强制验密（凭签名消费免验
	 */
	ResortPasswordVerify,
	/**
	 * 验证atc
	 */
	VerifyAtc,
	/**
	 * 国家码检查启用标志
	 */
	CountryCodeCheckFlag,
	/**
	 * 币种码检查启用标志
	 */
	CurrencyCodeCheckFlag,
	/**
	 * MCC码检查启用标志
	 */
	MccCodeCheckFlag,
	/**
	 * 国家/币种/mcc交叉检查启用标志
	 */
	CountryCurrencyMccCrossCheckFlag,
	/**
	 * 商户交易限制启用标志
	 */
	MerchantRestrictFlag,
	/**
	 * 是否强制验证支持Moto消费交易
	 */
	IsForceVerifySupportMerchantMotoExpense,
	/**
	 * 是否强制验证支持电子类消费交易
	 */
	IsForceVerifySupportElectronicCategoryExpense,
	/**
	 * 是否强制验证支持分期消费交易
	 */
	IsForceVerifySupportInstalment,
	/**
	 * 是否强制验证支持大额分期消费交易
	 */
	IsForceVerifySupportBigAmountInstalment
}
