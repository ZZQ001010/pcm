package cn.sunline.pcm.service.consistent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunline.common.distributed.IConsistentConsumer;
import cn.sunline.pcm.service.sdk.UnifiedParameterFacility;

/**
 * <p>
 * 参数同步处理消费者
 * </p>
 * 
 * @version 1.0 2017年6月19日 linxiaocheng 修改内容:初版
 */
@Service
public class ParamConsistentConsumer implements IConsistentConsumer {

//	Logger logger = LoggerFactory.getLogger(getClass());

//	@PersistenceContext(unitName = "default")
//	private EntityManager em;

	@Autowired
	private UnifiedParameterFacility refreshFAcility;

//	@Autowired
//	private RPcmPrmObject rPcmPrmObject;

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.distributed.sdk.consistent.IConsistentConsumer#serviceId()
	 */
	@Override
	public String serviceId() {
		return "ParamConsistentService";
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.distributed.sdk.consistent.IConsistentConsumer#dataCsttHandler(java.lang.String)
	 */
	@Override
	public void dataCsttHandler(String msg) {
//		if (msg == null) {
//			throw new ProcessException("文件路径为null");
//		}
//		JsonReader.read(msg, new JsonLinePersist(){
//			
//			@Override
//			public void persist(String json) {
//				PcmPrmObject prmObject = KC.json.reSerializerNoType(json, PcmPrmObject.class);
//				if (prmObject == null) {
//					return;
//				}
//				PcmPrmObject prmObjectO =
//						rPcmPrmObject.findByOrgAndParamClassAndParamKey(	prmObject.getOrg(), prmObject.getParamClass(),
//																		prmObject.getParamKey());
//				if (prmObjectO != null) {
//					if (prmObject.getDelStatus() == DelFlag.D) {
//						rPcmPrmObject.delete(prmObjectO);
//						return;
//					} else {
//						prmObjectO.setParamObject(prmObject.getParamObject());
//						prmObjectO.setUpdateTime(prmObject.getUpdateTime());
//						prmObjectO.setUpdateUser(prmObject.getUpdateUser());
//						prmObjectO.setCreateTime(prmObject.getCreateTime());
//						prmObjectO.setCreateUser(prmObject.getCreateUser());
//						rPcmPrmObject.save(prmObjectO);
//					}
//				} else {
//					prmObject.setId(null);
//					prmObject.setJpaVersion(null);
//					rPcmPrmObject.save(prmObject);
//				}
//			}
//		});
////		File inputFile = new File(msg);
////		if (!inputFile.exists()) {
////			throw new ProcessException(String.format("%s文件路径不存在", msg));
////		}
////		LineNumberReader reader = null;
////		try {
////			logger.info("参数同步开始");
////			FileReader fileReader = new FileReader(inputFile);
////			logger.info("读取参数文件");
////			reader = new LineNumberReader(fileReader);
////			String line = null;
////			int count = 0;
////			line = reader.readLine();
////			while (line != null) {
////				PcmPrmObject prmObject = KC.json.reSerializerNoType(line, PcmPrmObject.class);
////				if (prmObject == null) {
////					continue;
////				}
////				PcmPrmObject prmObjectO =
////						rPcmPrmObject.findByOrgAndParamClassAndParamKey(	prmObject.getOrg(), prmObject.getParamClass(),
////																		prmObject.getParamKey());
////				if (prmObjectO != null) {
////					if (prmObject.getDelStatus() == DelFlag.D) {
////						rPcmPrmObject.delete(prmObjectO);
////						continue;
////					} else {
////						prmObjectO.setParamObject(prmObject.getParamObject());
////						prmObjectO.setUpdateTime(prmObject.getUpdateTime());
////						prmObjectO.setUpdateUser(prmObject.getUpdateUser());
////						prmObjectO.setCreateTime(prmObject.getCreateTime());
////						prmObjectO.setCreateUser(prmObject.getCreateUser());
////						rPcmPrmObject.save(prmObjectO);
////					}
////				} else {
////					prmObject.setId(null);
////					prmObject.setJpaVersion(null);
////					rPcmPrmObject.save(prmObject);
////				}
////				count++;
////				if (count % 100 == 0) {
////					logger.info("参数正在同步中，已同步[{}]条", count);
////				}
////				line = reader.readLine();
////			}
////			logger.info("同步完成，总同步条数[{}]", count);
////		} catch (FileNotFoundException e) {
////			throw new ProcessException(String.format("%s文件不存在", msg), e);
////		} catch (IOException e) {
////			logger.error("导入参数，读取文件异常", e);
////			throw new ProcessException("导入参数，读取文件异常", e);
////		} catch (Exception e ) {
////			logger.error("导入参数发生异常", e);
////			throw e;
////		} finally {
////			if (reader != null) {
////				try {
////					reader.close();
////				} catch (IOException e) {
////					logger.warn("导入参数，关闭reader时异常");
////				}
////			}
////		}
	}

	/*
	 * (non-Javadoc)
	 * @see cn.sunline.distributed.sdk.consistent.IConsistentConsumer#noticeCsttHandler(java.lang.String)
	 */
	@Override
	public void noticeCsttHandler(String msg) {
		refreshFAcility.clearAll();
	}
}
