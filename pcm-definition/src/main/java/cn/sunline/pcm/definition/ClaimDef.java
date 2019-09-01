package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;
import cn.sunline.pcm.definition.enums.ClaimCycle;
import cn.sunline.pcm.definition.enums.ClaimCycleType;
import cn.sunline.pcm.definition.enums.ClaimType;

/**
 * 理赔参数定义
 * @author wangyx
 * @version 
 *	@date 创建时间：2018年2月9日  下午1:51:10
 */
public class ClaimDef implements Serializable {

	private static final long serialVersionUID = -1775506664508563628L;

	/**
	 * 理赔参数id
	 */
	@PropertyInfo(name="理赔参数id",length=4)
	public Integer claimId;
	
	/**
	 * 理赔方式
	 */
	@PropertyInfo(name="理赔方式",length=4)
	public ClaimType claimType;
	
	/**
	 * 理赔周期方式
	 */
	@PropertyInfo(name="理赔周期方式",length=10)
	public ClaimCycleType claimCycleType;
	
	/**
	 * 理赔周期
	 */
	@PropertyInfo(name="理赔周期",length=20)
	public ClaimCycle claimCycle;
	
	/**
	 * 理赔起始天数
	 */
	@PropertyInfo(name="理赔起始天数",length=4)
	public Integer claimStartDays;
	
	/**
	 * 理赔截止天数
	 */
	@PropertyInfo(name="理赔截止天数",length=4)
	public Integer claimEndDays;
	
	/**
	 * 固定理赔日，多个以,分割
	 */
	@PropertyInfo(name="固定理赔日(多个以,分割)",length=4)
	public String fixClaimDays;

}
