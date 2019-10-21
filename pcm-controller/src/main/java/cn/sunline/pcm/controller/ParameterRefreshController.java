package cn.sunline.pcm.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.sunline.common.KC;
import cn.sunline.pcm.surface.ParameterRefreshSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/** 
 * <p>
 * 参数刷新
 * </p>
 * @version 1.0 2017年12月12日 yanghm 修改内容:初版
 */ 
@Controller
@RequestMapping("parameterRefresh")
public class ParameterRefreshController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name="parameterRefreshSurfaceImpl")
	private ParameterRefreshSurface refreshSurface;
	
	
	/** 
	 * <p>
	 * 刷新参数页面
	 * </p>
	 * @return
	 */
	@RequestMapping("parameterRefreshPage.in")
	public ModelAndView resourceQueryPage()throws FlatException{
		try {
			// 参数同步的数据携带
//			List<String> list = new ArrayList<String>();
//			list.add("serviceId=ParamConsistentService");
//			list.add("syncBusinessKey=");
//			list.add("autoRefresh=false");
//			return KW.mvc.forwardRealPathView("/sync/syncQueryPage.in?" + KC.string.join(list, "&"));
			// 旧的参数刷新
			ModelAndView view = KW.mvc.forwardView("parameterRefresh/parameterRefresh");
			return view;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "parameterRefresh.parameterRefreshPageFail", "加载参数刷新页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 刷新参数
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="clearParameter.in", method = { RequestMethod.POST })
	public String clearParameter(String key, String paramClazzName) throws FlatException{
		try {
			refreshSurface.refreshParameter(key, paramClazzName);
			return "ok";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"parameterRefresh.clearParameterFail","刷新参数失败");
		}
	}
	
}