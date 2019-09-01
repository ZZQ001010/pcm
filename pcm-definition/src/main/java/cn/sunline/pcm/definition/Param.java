package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;

/**
 * 安全控制参数
 * TODO 主键应为全局取机构级参数的Key
* @author alen
 *
 */
public class Param implements Serializable {

	private static final long serialVersionUID = 2645844455541561043L;

	/**
	 * 密码有效天数
	 */
	@PropertyInfo(name="密码有效天数", length=4)
	public Integer pwdExpireDays;
	
	 /**
     * 首次登陆口令修改提示
     * true-要求修改
     * false-不要求修改
     */
	@PropertyInfo(name="首次登陆强制修改密码", length=1)
	public Boolean pwdFirstLoginChgInd;
	
	/**
	 * 密码允许尝试的次数
	 */
	@PropertyInfo(name="允许尝试的次数", length=1)
	public Integer pwdtries;
	
	 /**
     * 是否强制复杂密码
     * true-强制要求复杂密码
     * false-不强制要求复杂密码
     */
	@PropertyInfo(name="要求复杂密码", length=1)
	public Boolean complexPwdInd;
	
	/**
	 * 密码最短长度
	 */
	@PropertyInfo(name="密码最短长度", length=2)
	public Integer pwdMinLength;
	
	/**
	 *密码最大长度 
	 */
	@PropertyInfo(name="密码最大长度", length=2)
	public Integer pwdMaxLength;
	
	/**
	 * 密码历史循环数
	 */
	@PropertyInfo(name="密码历史循环数", length=2)
	public Integer pwdCycleCnt; 
}
