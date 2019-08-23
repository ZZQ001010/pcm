package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 资产方放款管控
 * @author zzq
 * @date 2019年7月10日
 *
 */
@EnumInfo({
	"G|有效",
	"S|无效"
})
public enum AssetSideLoanCtrl {
	/**
	 * 有效
	 */
	G,
	/**
	 * 无效
	 */
	S
}
