package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 
 * @author zzq
 * @date 2019年7月12日
 *	理赔方式
 */
@EnumInfo({
	"A|按期理赔",
	"C|全期理赔",
	"R|按期/全期混合模式理赔"
})
public enum SettlementMethod {
/**
 * 按期理赔
 */
	A,
/**
 * 全期理赔
 */
	C,
/**
 * 按期/全期混合模式理赔
 */
	R
}
