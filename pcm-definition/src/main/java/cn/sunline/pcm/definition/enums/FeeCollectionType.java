package cn.sunline.pcm.definition.enums;
import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 费用收取方式
 * @author fgy
 *
 */
@EnumInfo({
        "A|按比例",
        "B|按固定金额"
})
public enum FeeCollectionType {
    A,B
}
