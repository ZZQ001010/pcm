package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 保证金基数
 * @author zzq
 *
 */
@EnumInfo({
	"C|放款额",
	"B|余额"
})
public enum MarginBase {
	/**
	 * 保证金
	 */
	C,
	/**
	 * 安全垫
	 */
	B;
}
