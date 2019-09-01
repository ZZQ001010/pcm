package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.SplitMethod;
import cn.sunline.pcm.definition.enums.SplitSort;

/**
 *扣款拆分管理
 * 主键-FineTableId
 */
@SuppressWarnings("serial")
public class Split implements Serializable {
    	
    /**
     * 拆分表id
     */
    @PropertyInfo(name="拆分表id", length=6)
    public String splitTableId;
    
    @PropertyInfo(name="拆分名称", length=6)
    public String splitName;

    /**
     * 拆分方式
     */
    @PropertyInfo(name="拆分方式", length=1)
    public SplitMethod splitMethod;

    /**
     * 拆分比例
     */
    @PropertyInfo(name="拆分比例", length=6,precision=4)
    public BigDecimal splitRate;

    /**
     * 拆份固定金额
     */
    @PropertyInfo(name="拆份固定金额", length=15,precision=2)
    public BigDecimal splitAMT;

    /**
     * 可拆分最小金额
     */
    @PropertyInfo(name="可拆分最小金额", length=15,precision=2)
    public BigDecimal splitMinAMT;

    /**
     * 拆分后金额排序
     */
    @PropertyInfo(name="拆分后金额排序", length=20)
    public SplitSort splitAmtSort;

	public String getSplitTableId() {
		return splitTableId;
	}

	public void setSplitTableId(String splitTableId) {
		this.splitTableId = splitTableId;
	}

	public String getSplitName() {
		return splitName;
	}

	public void setSplitName(String splitName) {
		this.splitName = splitName;
	}

	public SplitMethod getSplitMethod() {
		return splitMethod;
	}

	public void setSplitMethod(SplitMethod splitMethod) {
		this.splitMethod = splitMethod;
	}

	public BigDecimal getSplitRate() {
		return splitRate;
	}

	public void setSplitRate(BigDecimal splitRate) {
		this.splitRate = splitRate;
	}

	public BigDecimal getSplitAMT() {
		return splitAMT;
	}

	public void setSplitAMT(BigDecimal splitAMT) {
		this.splitAMT = splitAMT;
	}

	public BigDecimal getSplitMinAMT() {
		return splitMinAMT;
	}

	public void setSplitMinAMT(BigDecimal splitMinAMT) {
		this.splitMinAMT = splitMinAMT;
	}

	public SplitSort getSplitAmtSort() {
		return splitAmtSort;
	}

	public void setSplitAmtSort(SplitSort splitAmtSort) {
		this.splitAmtSort = splitAmtSort;
	}


    
 
}
