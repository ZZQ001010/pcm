package cn.sunline.pcm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.View;

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
import cn.sunline.common.address.AddressHelperFacility;
import cn.sunline.common.exception.ProcessException;
import cn.sunline.common.shared.query.FetchRequest;
import cn.sunline.common.shared.query.FetchResponse;
import cn.sunline.pcm.definition.CurrencyCd;
import cn.sunline.pcm.definition.SafetyMat;
import cn.sunline.pcm.definition.ServerInfo;
import cn.sunline.pcm.definition.Sum;
import cn.sunline.pcm.surface.api.ParameterSurface;
import cn.sunline.web.common.exception.FlatException;
import cn.sunline.web.common.utils.KW;

/** 
 * <p>
 * 服务方基本信息 Controller 层
 * </p>
 * @version 1.0 2019-08-01 修改内容:初版
 */ 
@Controller
@RequestMapping("serverInfo")
public class ServerInfoController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ParameterSurface parameterSurface;
	
	@Autowired
	AddressHelperFacility addressHelperFacility;

	/** 
	 * <p>
	 * 服务方基本信息 列表页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("serverInfoQueryPage.in")
	public ModelAndView serverInfoQueryPage(HttpServletRequest request) throws FlatException{
		try {
			ModelAndView view = KW.mvc.forwardView("serverInfo/serverInfoQuery");
			view.addObject("serverInfo", new ServerInfo());
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"serverInfo.serverInfoQueryPageFail","加载服务方基本信息列表页面失败");
		}
	}
	
	/** 
	 * <p>
	 * 查询服务方基本信息列表
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value="queryServerInfoList.in", method = { RequestMethod.POST })
	public FetchResponse<?> queryServerInfoList(FetchRequest request) throws FlatException{
		try {
			return parameterSurface.getFetchResponse(request, ServerInfo.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"serverInfo.queryServerInfoListFail","查询服务方基本信息列表失败");
		}
	}

	/** 
	 * <p>
	 * 加载新增服务方基本信息页面
	 * </p>
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("serverInfoAddPage.in")
	public ModelAndView serverInfoAddPage(HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("serverInfo/serverInfoAdd");
			view.addObject("serverInfo", new ServerInfo());
			view.addObject("province",addressHelperFacility.loadProvince()); //获取中国所有的省
			//货币类型
			List<CurrencyCd> currencyCds = parameterSurface.getParameterObject(CurrencyCd.class);
			Map<String, String> cur = new HashMap<>();
			currencyCds.forEach(val->{
				cur.put(val.getCurrencyCd(), val.getDescription());
			});
			view.addObject("currencyCds",cur);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"serverInfo.serverInfoAddPageFail","加载新增服务方基本信息页面异常");
		}
	}

	/** 
	 * <p>
	 * 新增服务方基本信息
	 * </p>
	 * @param serverInfo
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "addServerInfo.in", method = { RequestMethod.POST })
	public void addServerInfo(ServerInfo serverInfo) throws FlatException {
		try {
			parameterSurface.addNewParameter(serverInfo.getServerCode(), serverInfo);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "serverInfo.addServerInfoFail", "新增服务方基本信息失败");
		}
	}

	/** 
	 * <p>
	 * 加载修改服务方基本信息页面
	 * </p>
	 * @param id
	 * @param request
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("serverInfoEditPage.in")
	public ModelAndView serverInfoEditPage(String serverCode, HttpServletRequest request) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("serverInfo/serverInfoEdit");
			ServerInfo serverInfo = parameterSurface.getParameterObject(serverCode, ServerInfo.class);
			view.addObject("serverInfo", serverInfo);
			view.addObject("province",addressHelperFacility.loadProvince()); //获取中国所有的省
			view.addObject("city",addressHelperFacility.loadCity(serverInfo.getResidence().getProvince()));
			view.addObject("microdistrict",addressHelperFacility.loadDistricts(serverInfo.getResidence().getCity()));
			//货币类型
			List<CurrencyCd> currencyCds = parameterSurface.getParameterObject(CurrencyCd.class);
			Map<String, String> cur = new HashMap<>();
			currencyCds.forEach(val->{
				cur.put(val.getCurrencyCd(), val.getDescription());
			});
			view.addObject("currencyCds",cur);
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e,"serverInfo.serverInfoEditPageFail","加载修改服务方基本信息页面失败");
		}
	}

	/** 
	 * <p>
	 * 修改服务方基本信息
	 * </p>
	 * @param serverInfo
	 * @throws FlatException
	 */
	@ResponseBody
	@RequestMapping(value = "updServerInfo.in", method = { RequestMethod.POST })
	public void updServerInfo(ServerInfo serverInfo) throws FlatException {
		try {
			parameterSurface.updateParameterObject(serverInfo.getServerCode(), serverInfo);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage(), serverInfo.getServerCode().toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "serverInfo.updServerInfoFail", "修改服务方基本信息失败");
		}
	}
	
	/** 
	 * <p>
	 * 删除服务方基本信息
	 * </p>
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping(value = "delServerInfo.in", method = { RequestMethod.POST })
	public void delServerInfos(@RequestBody List<String> serverCodes) throws FlatException {
		try {
			parameterSurface.deleteParameterObjectList(serverCodes, ServerInfo.class);
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "serverInfo.delServerInfoFail", "删除服务方基本信息失败");
		}
	}
	
	/** 
	 * <p>
	 * 加载服务方基本信息明细页面
	 * </p>
	 * @param id
	 * @return
	 * @throws FlatException
	 */
	@RequestMapping("serverInfoDetailPage.in")
	public ModelAndView serverInfoDetailPage(String serverCode,String code) throws FlatException {
		try {
			ModelAndView view = KW.mvc.forwardView("serverInfo/serverInfoDetail");
			view.addObject("factory",serverCode==null);
			ServerInfo serverInfo = parameterSurface
					.getParameterObject(serverCode==null?code:serverCode, ServerInfo.class);
			view.addObject("serverInfo", serverInfo);
			//实收资本
			Sum paidInCapital = serverInfo.getPaidInCapital();
			String currencyCd = paidInCapital.getCurrencyCd();
			CurrencyCd currency = parameterSurface.getParameterObject(paidInCapital.getCurrencyCd(),CurrencyCd.class);
			
			String paidInCapitalStr = paidInCapital.getSumNum()+" "+currency.getDescription();
			view.addObject("paidInCapital", paidInCapitalStr);
			//注册资本
			Sum registerMoney = serverInfo.getRegisterMoney();
			
			String registerMoneyStr = registerMoney.getSumNum()
						+" "+parameterSurface.getParameterObject(
								registerMoney.getCurrencyCd(),CurrencyCd.class).getDescription(); 
			
			view.addObject("registerMoney",registerMoneyStr);
			//地址
			view.addObject("addr",serverInfo.getResidence().toString(addressHelperFacility));
			view.addObject("companyType", KC.Enum.getI18nLabel(serverInfo.getCompanyType()));
			return view;
		} catch (ProcessException e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new FlatException(e, "serverInfo.serverInfoDetailPageFail", "加载服务方基本信息详情页面失败");
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
                   parameterSurface.getParameterObject(ServerInfo.class).forEach(
                                   item->resMap.put(item.getServerCode(),item.getServerDesc()));
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
	   ServerInfo  serverInfo = parameterSurface.getParameterObject(code,ServerInfo.class);
                  List<String> list = new ArrayList<>();
                  list.add(serverInfo.getServerCode());
                  list.add(serverInfo.getServerDesc());
                  list.add(serverInfo.getPhone());
                  return list;
  }
	
	
	
	
}