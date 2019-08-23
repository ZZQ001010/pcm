package cn.sunline.pcm.definition;

import java.io.Serializable;

import cn.sunline.common.annotation.paramdef.PropertyInfo;

/**
 * 密钥
 * 主键-rsaId
 */
public class RsaKeyPair implements Serializable {
	private static final long serialVersionUID = 1L;


    /**
     * 金融机构编码
     */
    @PropertyInfo(name="密钥id", length=36)
    public String rsaId;

    /**
     *  public key
     */
    @PropertyInfo(name="公钥", length=4000)
    public String publicKey;

    /**
     *  private key
     */
    @PropertyInfo(name="私钥", length=4000)
    public String privateKey;
}
