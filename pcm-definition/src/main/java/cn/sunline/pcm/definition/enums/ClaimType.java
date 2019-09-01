package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 理赔方式
 * @author myj
 *
 */
@EnumInfo({
	"C|全额理赔",
	"J|期供理赔"
})
public enum ClaimType {
	/**
	 * 全额理赔
	 */
	C,
	
	/**
	 * 期供理赔
	 */
	J;
}
