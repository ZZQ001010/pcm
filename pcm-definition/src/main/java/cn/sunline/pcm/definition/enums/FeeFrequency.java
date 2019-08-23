package cn.sunline.pcm.definition.enums;
import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 费用收取频次
 * @author fgy
 *
 */
@EnumInfo({
        "A|一次性",
        "B|按天累计"
})
public enum FeeFrequency {
    A,B
}
