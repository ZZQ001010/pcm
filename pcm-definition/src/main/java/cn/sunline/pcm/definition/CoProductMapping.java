package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;

/**
 * 合作方产品映射
 */
public class CoProductMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 合作方ID
	 */
	@PropertyInfo(name="合作方ID",length=10)
	public String cooperatorId ;

    /**
     * 合作方产品CD
     */
    @PropertyInfo(name="合作方产品CD", length=32)
    public String corpProductCd;
    
    /**
     * 产品CD
     */
    @PropertyInfo(name="产品CD", length=32)
    public String productCd;

    /**
     * 还款方式
     */
    @PropertyInfo(name="还款方式", length=10)
    public String repayType ;
    
}
