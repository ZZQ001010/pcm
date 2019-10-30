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
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.ppy.dictionary.enums.InputSource;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;
import cn.sunline.pcm.definition.Mcc;
import cn.sunline.pcm.definition.PremiumLatePaymentFee;

/** 
 * <p>
 * MCC参数管理 Controller 层
 * @author fuliwen 
 * </p>
 * @version 1.0 2017-11-11 修改内容:初版
 */ 
@Controller
@RequestMapping("mcc")
public class MccController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	

	/** 
	 * <p>
	 * MCC参数管理 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("mccQueryPage.in")
	public ModelAndView mccQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("mcc/mccQuery");
			view.addObject("mccObj", new Mcc());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"mcc.mccQueryPageFail","加载MCC参数管理列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询MCC参数管理列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryMccList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryMccList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, Mcc.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"mcc.queryMccListFail","查询MCC参数管理列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增MCC参数管理页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("mccAddPage.in")
	public ModelAndView mccAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("mcc/mccAdd");
			view.addObject("inputSource", KC.Enum.getI18nLabelMap(InputSource.class));				
			view.addObject("mcc", new Mcc());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"mcc.mccAddPageFail","加载新增MCC参数管理页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增MCC参数管理
	 * </p>
	 * @param mcc
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addMcc.in", method = { RequestMethod.POST })
	public void addMcc(Mcc mcc) throws FlatException {
		try {
			parameterSurface.addNewParameter(mcc.getMcc() + '|' + mcc.getInputSource().name(), mcc);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "mcc.addMccFail", "新增MCC参数管理失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改MCC参数管理页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("mccEditPage.in")
	public ModelAndView mccEditPage(InputSource inputSource, String mcc, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("mcc/mccEdit");
			view.addObject("inputSource", KC.Enum.getI18nLabelMap(InputSource.class));
			Mcc mcc1 = parameterSurface.getParameterObject(mcc + '|' + inputSource.name(), Mcc.class);
			view.addObject("mcc", mcc1);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"mcc.mccEditPageFail","加载修改MCC参数管理页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改MCC参数管理
	 * </p>
	 * @param mcc
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updMcc.in", method = { RequestMethod.POST })
	public void updMcc(Mcc mcc) throws FlatException {
		try {
			parameterSurface.updateParameterObject(mcc.getMcc() + '|' + mcc.getInputSource().name(), mcc);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), mcc.getInputSource()+ "|" + mcc.getMcc());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "mcc.updMccFail", "修改MCC参数管理失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除MCC参数管理
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delMcc.in", method = { RequestMethod.POST })
	public void delMccs(@RequestBody List<Mcc> mccs) throws FlatException {
		try {
			String [] ids = new String[mccs.size()];
			Mcc mcc = null;
			for(int i=0; i<mccs.size(); i++){
				mcc = mccs.get(i);
				ids[i] =mcc.getMcc()  + '|' + mcc.getInputSource().name();
				parameterSurface.deleteParameterObject(ids[i], Mcc.class);
			}
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "mcc.delMccFail", "删除MCC参数失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载MCC参数管理明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("mccDetailPage.in")
	public ModelAndView mccDetailPage(String mcc,InputSource inputSource,String code,ModelAndView view) throws FlatException {
		try {
			view = KW.mvc.forwardView("mcc/mccDetail");
			view.addObject("factory", mcc == null);
			Mcc mcc1 = parameterSurface.getParameterObject(mcc==null?code+"|"+inputSource:mcc+"|"+inputSource, Mcc.class);
			view.addObject("mcc", mcc1);
			if(mcc1.getInputSource()!=null){
			view.addObject("inputSource", KC.Enum.getI18nLabel(mcc1.getInputSource()));
			}
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "mcc.mccDetailPageFail", "加载MCC参数管理详情页面失败");
		}
	}
	
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
                    parameterSurface.getParameterObject(Mcc.class).forEach(
                                    item->resMap.put(item.getMcc(),item.getDescription()));
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
   Mcc parameterObject = parameterSurface.getParameterObject(code,Mcc.class);
                   List<String> list = new ArrayList<>();
                   list.add(parameterObject.getMcc());
                   list.add(parameterObject.getDescription());
                   return list;
   }

	
}