package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
* @author myj
 *	人行征信报送方式
 */
@EnumInfo({
	"D|按日报送",
	"M|按月报送"
})
public enum PbocRptType {
	/**
	 * 按日报送
	 */
	D,
	/**
	 * 按月报送
	 */
	M
}
