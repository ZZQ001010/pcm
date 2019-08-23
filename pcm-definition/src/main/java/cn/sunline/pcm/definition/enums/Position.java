package cn.sunline.pcm.definition.enums;

import cn.sunline.common.annotation.enums.EnumInfo;

@EnumInfo({
        "TOP|上",
        "BOTTOM|下",
        "LEFT|左",
        "RIGHT|右",
        "CENTER|中"

})
public enum Position {
    /**
     * 上
     */
    TOP("上"),
    /**
     * 下
     */
    BOTTOM("下"),
    /**
     * 左
     */
    LEFT("左"),
    /**
     * 右
     */
    RIGHT("右"),
    /**
     * 中
     */
    CENTER("中");

    private String remark;

    private Position(String remark){
        this.remark=remark;
    }
    public String getRemark(){return remark;}
}
