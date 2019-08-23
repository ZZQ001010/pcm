package cn.sunline.pcm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * <p>
 * 合作机构管理 Controller 层
 * </p>
 * @version 1.0 2017-11-23 xiongyuanyuan 修改内容:初版
 */ 
@Controller
@RequestMapping("financialOrgProduct")
public class FinancialOrgProductController {
//
//	Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	private ParameterSurface parameterSurface;
//	
////	@Autowired
////	private CodeService codeService;
//
//	/** 
//	 * <p>
//	 * 合作机构管理 列表页面
//	 * </p>
//	 * @param request
//	 * @return
//	 * @throws FlatException
//	 */
//	@RequestMapping("financialOrgProductQueryPage.in")
//	public ModelAndView financialOrgProductQueryPage(HttpServletRequest request) throws FlatException{
//		try {
//			ModelAndView view = KW.mvc.forwardView("financialOrgProduct/financialOrgProductQuery");
//			//从合作机构管理中取数据
//			Map<String, String> financeOrgNo=new LinkedHashMap<String, String>();
//			List<FinancialOrg> financeOrgNos = parameterSurface.getParameterObject(FinancialOrg.class);
//			for (FinancialOrg financialOrg : financeOrgNos) {
//				financeOrgNo.put(financialOrg.getFinancialOrgNO(), financialOrg.getFinancialOrgName());
//			}
//			view.addObject("financeOrgNoJson", KC.json.serializerNoType(financeOrgNo));				
//			view.addObject("financeOrgNo", financeOrgNo);				
//			view.addObject("circleAbleJson", KC.Enum.getI18nLabelMapJson(Indicator.class));
//			view.addObject("financialOrgParam", new FinancialOrg());
//			return view;
//		} catch (ProcessException e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e.getErrorCode(), e.getMessage());
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e,"financialOrgProduct.financialOrgProductQueryPageFail","加载合作机构管理列表页面失败");
//		}
//	}
//	
//	/** 
//	 * <p>
//	 * 查询合作机构管理列表
//	 * </p>
//	 * @param request
//	 * @return
//	 * @throws FlatException
//	 */
//	@ResponseBody
//	@RequestMapping(value="queryFinancialOrgProductList.in", method = { RequestMethod.POST })
//	public FetchResponse<?> queryFinancialOrgProductList(FetchRequest request) throws FlatException{
//		try {
//			return parameterSurface.getFetchResponse(request, FinancialOrg.class);
//		} catch (ProcessException e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e.getErrorCode(), e.getMessage());
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e,"financialOrgProduct.queryFinancialOrgProductListFail","查询合作机构管理列表失败");
//		}
//	}
//
//	/** 
//	 * <p>
//	 * 加载新增合作机构管理页面
//	 * </p>
//	 * @param request
//	 * @return
//	 * @throws FlatException
//	 */
//	@RequestMapping("financialOrgProductAddPage.in")
//	public ModelAndView financialOrgProductAddPage(HttpServletRequest request) throws FlatException {
//		try {
//			ModelAndView view = KW.mvc.forwardView("financialOrgProduct/financialOrgProductAdd");
//			Map<String, String> financeOrgNo=new LinkedHashMap<String, String>();
//			//从合作机构管理中取数据
//			List<FinancialOrg> financeOrgNos = parameterSurface.getParameterObject(FinancialOrg.class);
//			for (FinancialOrg financialOrg : financeOrgNos) {
//				financeOrgNo.put(financialOrg.getFinancialOrgNO(), financialOrg.getFinancialOrgName());
//			}
//			view.addObject("financeOrgNo", financeOrgNo);			
//			view.addObject("circleAble", KC.Enum.getI18nLabelMap(Indicator.class));				
//			view.addObject("financialOrgParam", new FinancialOrg());
//			return view;
//		} catch (ProcessException e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e.getErrorCode(), e.getMessage());
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e,"financialOrgProduct.financialOrgProductAddPageFail","加载新增合作机构管理页面异常");
//		}
//	}
//
//	/** 
//	 * <p>
//	 * 加载修改合作机构管理页面
//	 * </p>
//	 * @param id
//	 * @param request
//	 * @return
//	 * @throws FlatException
//	 */
//	@RequestMapping("financialOrgProductEditPage.in")
//	public ModelAndView financialOrgProductEditPage(String productCode, HttpServletRequest request) throws FlatException {
//		try {
//			ModelAndView view = KW.mvc.forwardView("financialOrgProduct/financialOrgProductEdit");
//			Map<String, String> financeOrgNo=new LinkedHashMap<String, String>();
//			//从合作机构管理中取数据
//			List<FinancialOrg> financeOrgNos = parameterSurface.getParameterObject(FinancialOrg.class);
//			for (FinancialOrg financialOrg : financeOrgNos) {
//				financeOrgNo.put(financialOrg.getFinancialOrgNO(), financialOrg.getFinancialOrgName());
//			}
//			view.addObject("financeOrgNo", financeOrgNo);					
//			view.addObject("circleAble", KC.Enum.getI18nLabelMap(Indicator.class));				
//			FinancialOrg financialOrgParam = parameterSurface.getParameterObject(productCode, FinancialOrg.class);
//			view.addObject("financialOrgParam", financialOrgParam);
//			return view;
//		} catch (ProcessException e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e.getErrorCode(), e.getMessage());
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e,"financialOrgProduct.financialOrgProductEditPageFail","加载修改合作机构管理页面失败");
//		}
//	}
//
//	
//	/** 
//	 * <p>
//	 * 删除合作机构管理
//	 * </p>
//	 * @param ids
//	 */
//	@ResponseBody
//	@RequestMapping(value = "delFinancialOrgProduct.in", method = { RequestMethod.POST })
//	public void delFinancialOrgProducts(@RequestBody List<String> productCodes) throws FlatException {
//		try {
//			parameterSurface.deleteParameterObjectList(productCodes, FinancialOrg.class);
//		} catch (ProcessException e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e.getErrorCode(), e.getMessage());
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e, "financialOrgProduct.delFinancialOrgProductFail", "删除合作机构管理失败");
//		}
//	}
//	
//	/** 
//	 * <p>
//	 * 加载合作机构管理明细页面
//	 * </p>
//	 * @param id
//	 * @return
//	 * @throws FlatException
//	 */
//	@RequestMapping("financialOrgProductDetailPage.in")
//	public ModelAndView financialOrgProductDetailPage(String productCode) throws FlatException {
//		try {
//			ModelAndView view = KW.mvc.forwardView("financialOrgProduct/financialOrgProductDetail");
//			FinancialOrg financialOrgParam = parameterSurface.getParameterObject(productCode, FinancialOrg.class);
//			view.addObject("financialOrgParam", financialOrgParam);
//			Map<String, String> financeOrgNo=new LinkedHashMap<String, String>();
//			//从合作机构管理中取数据
//			List<FinancialOrg> financeOrgNos = parameterSurface.getParameterObject(FinancialOrg.class);
//			for (FinancialOrg financialOrg : financeOrgNos) {
//				financeOrgNo.put(financialOrg.getFinancialOrgNO(), financialOrg.getFinancialOrgName());
//			}
//			view.addObject("financeOrgNo", financeOrgNo.get(financialOrgParam.financialOrgNO));				
//			return view;
//		} catch (ProcessException e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e.getErrorCode(), e.getMessage());
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw new FlatException(e, "financialOrgProduct.financialOrgProductDetailPageFail", "加载合作机构管理详情页面失败");
//		}
//	}
//	
}
