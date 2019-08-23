package cn.sunline.pcm.service.consistent;

import org.springframework.stereotype.Service;

import cn.sunline.common.distributed.IConsistentProducer;

/**
 * <p>
 * 参数同步生产者
 * </p>
 * 
 * @version 1.0 2017年6月19日 linxiaocheng 修改内容:初版
 */
@Service
public class ParamConsistentProducer implements IConsistentProducer {

//	Logger logger = LoggerFactory.getLogger(getClass());
//
//	@PersistenceContext(unitName = "default")
//	private EntityManager em;
//
//	@Value("#{env['consistentPath']}")
//	private String consistentPath;
//
//	private QPcmPrmObject qTmPrmObject = QPcmPrmObject.pcmPrmObject;

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.distributed.sdk.consistent.IConsistentProducer#serviceId()
	 */
	@Override
	public String serviceId() {
		return "ParamConsistentService";
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.distributed.sdk.consistent.IConsistentProducer#createConsistant(java.lang.String)
	 */
	@Override
	public String createConsistant(String businessKey) {
		return "通知没有消息传递";
//		final JPAQuery<PcmPrmObject> prmQuery = new JPAQueryFactory(em).select(qTmPrmObject).from(qTmPrmObject)
//				.where(qTmPrmObject.org.eq(KC.threadLocal.getCurrentOrg()));
//		String fileDir = consistentPath + File.separator + serviceId();
//		String fileName = KC.date.format(new Date(), "yyyyMMddHHmmss");
//		if (KC.string.isNotBlank(businessKey)) {
//			fileName = fileName + "." + businessKey.toLowerCase();
//		}
//		fileName = fileName + ".param";
//		String filePath = JsonWriter.write(fileDir, fileName, new DbWriteDataSource(){
//
//			@Override
//			public List<?> loadNextDataList(long offset, long pageSize) {
//				return prmQuery.offset(offset).limit(pageSize).fetch();
//			}
//		});
//		return filePath;
////		logger.info("创建参数同步任务，准备生成参数文件");
////		File dir = new File(consistentPath);
////		if (!dir.exists()) {
////			dir.mkdirs();
////		}
////		String filename = consistentPath + File.separator + KC.date.format(new Date(), "yyyyMMddHHmmss");
////		if (KC.string.isNotBlank(businessKey)) {
////			filename = filename + "." + businessKey.toLowerCase();
////		}
////		filename = filename + ".param";
////		logger.info("文件生成路径：{}", filename);
////		File outPutFile = new File(filename);
////		try {
////			if (outPutFile.exists()) {
////				throw new ProcessException("文件已存在");
////			} else {
////				outPutFile.createNewFile();
////			}
////		} catch (IOException e) {
////			logger.error("创建参数文件异常", e);
////			throw new ProcessException("创建参数文件异常", e);
////		}
////		FileWriter writer = null;
////		try {
////			JPAQuery<TmPrmObject> prmQuery = new JPAQueryFactory(em).select(qTmPrmObject).from(qTmPrmObject).where(qTmPrmObject.org.eq(KC.threadLocal.getCurrentOrg()));
////			if (KC.string.isNotBlank(businessKey)) {
////				prmQuery.where(qTmPrmObject.paramClass.like("cn.sunline." + businessKey + "%"));
////			}
////			long count = prmQuery.fetchCount();
////			logger.info("查询到需要同步的参数条数[{}]", count);
////			long index = 0;
////			int size = 1000;
////			writer = new FileWriter(outPutFile);
////			while (count > index) {
////				prmQuery.offset(index).limit(size);
////				List<TmPrmObject> prmObjectList = prmQuery.fetch();
////				for (TmPrmObject prmObject : prmObjectList) {
////					writer.write(KC.json.serializerNoType(prmObject) + System.getProperty("line.separator", "\n"));
////				}
////				logger.info("已导出[{}]条参数", index + prmObjectList.size());
////				index += size;
////			}
////			writer.flush();
////			logger.info("参数同步文件导出完成！");
////		} catch (IOException e) {
////			logger.error("生成参数文件读写异常", e);
////			throw new ProcessException("生成参数文件读写异常", e);
////		} catch (Exception e) {
////			logger.error("生成参数文件异常", e);
////			throw new ProcessException("生成参数文件异常");
////		} finally {
////			if (writer != null) {
////				try {
////					writer.close();
////				} catch (IOException e) {
////					logger.warn("生成参数文件，关闭时发生异常");
////				}
////			}
////		}
////		return filename;
	}
}
