package cn.sunline.pcm.definition;

import java.io.Serializable;
import java.util.List;

import cn.sunline.common.annotation.paramdef.PropertyInfo;

/**
 * 角色所能访问的机构实例
* @author alen
 *
 */
public class RoleOrgInst implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3756725150714369356L;


	@PropertyInfo(name="角色ID", length=4)
	public Integer roleId;
	
	
	@PropertyInfo(name="机构实例列表", length=4)
	public List<Integer> orgInst;
}
