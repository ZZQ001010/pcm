package cn.sunline.pcm.surface.model;

import java.util.List;

import cn.sunline.pcm.definition.Product;
import cn.sunline.pcm.infrastructure.model.bo.BPcmProductRel;

/**
 * <p>
 * 产品联合体对象定义
 * </p>
 * 
 * @version 1.0 2018年8月31日 Zcoup 修改内容:初版
 */
public class VProductCombination {

	/**
	 * 产品
	 */
	private Product product;

	/**
	 * 产品数据关联表
	 */
	private List<BPcmProductRel> productRels;

	/**
	 * @see cn.sunline.pcm.surface.model.VProductCombination#product
	 * @return product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @see cn.sunline.pcm.surface.model.VProductCombination#product
	 * @param product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @see cn.sunline.pcm.surface.model.VProductCombination#productRels
	 * @return productRels
	 */
	public List<BPcmProductRel> getProductRels() {
		return productRels;
	}

	/**
	 * @see cn.sunline.pcm.surface.model.VProductCombination#productRels
	 * @param productRels
	 */
	public void setProductRels(List<BPcmProductRel> productRels) {
		this.productRels = productRels;
	}

}
