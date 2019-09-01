package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 公司类型
 * @author zzq
 * @date 2019年7月10日
 *
 */
@EnumInfo({
	"A|有限责任公司",
	"B|股份制公司",
	"C|集团公司",
	"D|一人制公司"
})
public enum CompanyType {

	/**
	 * 有限责任公司
	 */
	A,
	/**
	 * 股份制公司
	 */
	B,
	/**
	 * 集团公司
	 */
	C,
	/**
	 * 一人制公司
	 */
	D
}
