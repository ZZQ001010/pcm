package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;

/**
 * null
 */
@SuppressWarnings("serial")
public class IdType implements Serializable {
    /**
     * IDTYPE
     */
    @PropertyInfo(name="IDTYPE", length=1)
    public String idType;

    /**
     * DESCRIPTION
     */
    @PropertyInfo(name="DESCRIPTION", length=40)
    public String description;
}
