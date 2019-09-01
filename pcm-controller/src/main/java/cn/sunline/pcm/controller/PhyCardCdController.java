package cn.sunline.pcm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.sunline.common.KC;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.definition.PhyCardCd;
import cn.sunline.pcm.definition.PremiumLatePaymentFee;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.ppy.dictionary.enums.MediaType;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/** 
 * <p>
 * 卡面代码参数 Controller 层
 * </p>
 * @version 1.0 2017-12-02 修改内容:初版
 * @author fuliwen
 */ 
@Controller
@RequestMapping("phyCardCd")
public class PhyCardCdController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * 卡面代码参数 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("phyCardCdQueryPage.in")
	public ModelAndView phyCardCdQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("phyCardCd/phyCardCdQuery");
			view.addObject("phyCardCd", new PhyCardCd());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"phyCardCd.phyCardCdQueryPageFail","加载卡面代码参数列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询卡面代码参数列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryPhyCardCdList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryPhyCardCdList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, PhyCardCd.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"phyCardCd.queryPhyCardCdListFail","查询卡面代码参数列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增卡面代码参数页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("phyCardCdAddPage.in")
	public ModelAndView phyCardCdAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("phyCardCd/phyCardCdAdd");
			view.addObject("mediaType", KC.Enum.getI18nLabelMap(MediaType.class));				
			view.addObject("phyCardCd", new PhyCardCd());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"phyCardCd.phyCardCdAddPageFail","加载新增卡面代码参数页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增卡面代码参数
	 * </p>
	 * @param phyCardCd
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addPhyCardCd.in", method = { RequestMethod.POST })
	public void addPhyCardCd(PhyCardCd phyCardCd) throws FlatException {
		try {
			parameterSurface.addNewParameter(phyCardCd.getPyhCd(), phyCardCd);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "phyCardCd.addPhyCardCdFail", "新增卡面代码参数失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改卡面代码参数页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("phyCardCdEditPage.in")
	public ModelAndView phyCardCdEditPage(String pyhCd, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("phyCardCd/phyCardCdEdit");
			view.addObject("mediaType", KC.Enum.getI18nLabelMap(MediaType.class));				
			PhyCardCd phyCardCd = parameterSurface.getParameterObject(pyhCd, PhyCardCd.class);
			view.addObject("phyCardCd", phyCardCd);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"phyCardCd.phyCardCdEditPageFail","加载修改卡面代码参数页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改卡面代码参数
	 * </p>
	 * @param phyCardCd
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updPhyCardCd.in", method = { RequestMethod.POST })
	public void updPhyCardCd(PhyCardCd phyCardCd) throws FlatException {
		try {
			parameterSurface.updateParameterObject(phyCardCd.getPyhCd(), phyCardCd);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), phyCardCd.getPyhCd());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "phyCardCd.updPhyCardCdFail", "修改卡面代码参数失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除卡面代码参数
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delPhyCardCd.in", method = { RequestMethod.POST })
	public void delPhyCardCds(@RequestBody List<String> pyhCds) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(pyhCds, PhyCardCd.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "phyCardCd.delPhyCardCdFail", "删除卡面代码参数失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载卡面代码参数明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("phyCardCdDetailPage.in")
	public ModelAndView phyCardCdDetailPage(String pyhCd,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("phyCardCd/phyCardCdDetail");
			view.addObject("factory",pyhCd==null);
			PhyCardCd phyCardCd = parameterSurface.getParameterObject(pyhCd==null?code:pyhCd, PhyCardCd.class);
			view.addObject("phyCardCd", phyCardCd);
			view.addObject("mediaType", KC.Enum.getI18nLabel(phyCardCd.getMediaType()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "phyCardCd.phyCardCdDetailPageFail", "加载卡面代码参数详情页面失败");
		}
	}
	
	
	/** 
	 * <p>
	 * 加载卡面代码参数明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 *//*
	@RequestMapping("phyCardCdSmallPage.in")
	public ModelAndView phyCardCdSmallPage(String productCode) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("phyCardCd/phyCardCdSmall");
			PhyCardCd phyCardCd=new PhyCardCd();
			if(KC.string.isNotBlank(productCode)){
				 phyCardCd = parameterSurface.getParameterObject(productCode, PhyCardCd.class);
				 view.addObject("mediaType", KC.Enum.getI18nLabel(phyCardCd.getMediaType()));
			}
			view.addObject("phyCardCd", phyCardCd);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "phyCardCd.phyCardCdDetailPageFail", "加载卡面代码参数详情页面失败");
		}
	}
	
	*//** 
	 * <p>
	 * 加载卡面代码参数明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 *//*
	@RequestMapping("phyCardCdConfigPage.in")
	public ModelAndView phyCardCdConfigPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("phyCardCd/phyCardCdConfig");
			List<PhyCardCd> params = parameterSurface.getParameterObject(PhyCardCd.class);
			view.addObject("phyCardCodes",params);				
			view.addObject("productCode", request.getParameter("productCode"));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "phyCardCd.phyCardCdDetailPageFail", "加载卡面代码参数详情页面失败");
		}
	}
	@RequestMapping("phyCardCdCheckPage.in")
	public ModelAndView phyCardCdCheckPage(String pyhCd) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("phyCardCd/phyCardCdCheck");
			PhyCardCd phyCardCd = parameterSurface.getParameterObject(pyhCd, PhyCardCd.class);
			view.addObject("phyCardCd", phyCardCd);
			view.addObject("mediaType", KC.Enum.getI18nLabel(phyCardCd.getMediaType()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "phyCardCd.phyCardCdDetailPageFail", "加载卡面代码参数详情页面失败");
		}
	}*/
	/**
    *
    * @Description:    TODO(所有组件的简略信息)
    * @param:  @return
    * @param:  @throws FlatException
    * @throws
    */
   @ResponseBody
   @PostMapping(value="/unitConfig.in",produces={"application/json"})
   public Map<String,String> unitConfig() throws FlatException{
           try{
                   HashMap<String, String> resMap = new HashMap<>();
                    parameterSurface.getParameterObject(PhyCardCd.class).forEach(
                                    item->resMap.put(item.getPyhCd(),item.getDescription()));
                   return resMap;
           } catch (ProcessException e) {
                   logger.error(e.getMessage(), e);
                   throw new FlatException(e.getErrorCode(), e.getMessage());
           } catch (Exception e) {
                   logger.error(e.getMessage(), e);
                   throw new FlatException(e, "branch.branchunitConfigFail", "加载数据失败！");
           }

   }
  

   @ResponseBody
   @PostMapping(value="/unitBase.in")
   public List<String> unitBase(@RequestParam("code") String code){
	   PhyCardCd parameterObject = parameterSurface.getParameterObject(code,PhyCardCd.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getPyhCd());
                   list.add(parameterObject.getDescription());
                   return list;
   }
	
}