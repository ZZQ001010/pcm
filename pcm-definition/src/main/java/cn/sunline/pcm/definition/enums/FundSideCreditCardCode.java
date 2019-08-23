package cn.sunline.pcm.definition.enums;
import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 资金方征信评分卡标识
 * @author ww
 * 2019年7月28日
 */
@EnumInfo({
        "A|使用资金方征信评分卡",
        "B|不使用资金方征信评分卡"
})
public enum FundSideCreditCardCode {
	A,B
}
