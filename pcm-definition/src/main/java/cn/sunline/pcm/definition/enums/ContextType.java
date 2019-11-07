package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

/**
 * 存储文本格式
 */
@EnumInfo({
        "JSON|存储json数据格式",
        "XML|xml格式存储",
})
public enum  ContextType { JSON,  XML, }
