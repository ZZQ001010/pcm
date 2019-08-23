package cn.sunline.pcm.definition.enums;
import cn.sunline.common.annotation.enums.EnumInfo;
/**
 * 加收N期保费
 * @author fgy
 * @date 2019年7月25日
 *
 */
@EnumInfo({
        "A|年",
        "B|月",
        "C|季度"

})

public enum AdditionalNPremiums {
    A,B,C
}
