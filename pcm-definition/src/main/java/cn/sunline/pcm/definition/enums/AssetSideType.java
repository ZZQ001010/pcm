package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 资产方类型
 * @author zzq
 * @date 2019年7月10日
 *
 */
@EnumInfo({
	"A|资产类",
	"S|服务费",
	"Q|引流类"
})
public enum AssetSideType {
	/**
	 * 资产类
	 */
	A,
	
	/**
	 * 服务费
	 */
	S,
	
	/**
	 * 引流类
	 */
	Q,
}
