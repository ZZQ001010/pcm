package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 
 * @author zzq
 *
 * 风管方式
 */
@EnumInfo({
	"B|保证金",
	"A|安全垫"
})
public enum RiskCtrlWay {
	/**
	 * 保证金
	 */
	B,
	/**
	 * 安全垫
	 */
	A;
	

}
