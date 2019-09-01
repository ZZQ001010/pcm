package cn.sunline.pcm.definition;
import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
/**
 * @author fgy
 * 2019年8月1日
 * 参数管理
 */
@SuppressWarnings("serial")
public class PrmManage implements Serializable{

    /**
     * 参数编码
     */
    @PropertyInfo(name="参数编码", length=32)
    public String  id ;
    /**
     * 参数名称
     */
    @PropertyInfo(name="参数名称", length=32)
    public String  name ;
    /**
     * 参数描述
     */
    @PropertyInfo(name="参数描述", length=32)
    public String  desc ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
