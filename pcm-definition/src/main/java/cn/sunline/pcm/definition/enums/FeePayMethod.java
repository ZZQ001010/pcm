package cn.sunline.pcm.definition.enums;
import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 保费缴纳方式
 * @author fgy
 * @date 2019年7月24日
 * 趸缴、期缴
 *
 */
@EnumInfo({
        "A|趸缴",
        "B|期缴"
})

public enum FeePayMethod {
    /**
     * 趸缴
     */
    A,

    /**
     * 期缴
     */
    B
}
