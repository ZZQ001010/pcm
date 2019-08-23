package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 资产方担保方式
 * @author zzq
 * @date 2019年7月10日
 *
 */
@EnumInfo({
	"R|兜底担保标识",
	"L|风险共担标识",
	"O|风险自担标识"
})
public enum AssetSideWarrantWay {

	/**
	 * 兜底担保标识
	 */
	R,
	/**
	 * 风险共担标识
	 */
	L,
	/**
	 * 风险自担标识
	 */
	O
}
