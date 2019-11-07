package cn.sunline.pcm.definition.product.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 标识一个基础参数
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface BasicParam {

    /**
     * 参数国际化名称
     * @return
     */
     String name() ;

    /**
     * 参数中文名称
     */
    String nameCn();



}
