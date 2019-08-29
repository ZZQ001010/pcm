package cn.sunline.pcm.infrastructure.shared.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPcmProductData is a Querydsl query type for PcmProductData
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPcmProductData extends EntityPathBase<PcmProductData> {

    private static final long serialVersionUID = 1069232007L;

    public static final QPcmProductData pcmProductData = new QPcmProductData("pcmProductData");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath createUser = createString("createUser");

    public final StringPath id = createString("id");

    public final NumberPath<Integer> jpaVersion = createNumber("jpaVersion", Integer.class);

    public final DateTimePath<java.util.Date> lstUpdTime = createDateTime("lstUpdTime", java.util.Date.class);

    public final StringPath lstUpdUser = createString("lstUpdUser");

    public final StringPath org = createString("org");

    public final StringPath paramClass = createString("paramClass");

    public final StringPath paramKey = createString("paramKey");

    public final StringPath productCode = createString("productCode");

    public final StringPath unitCode = createString("unitCode");

    public QPcmProductData(String variable) {
        super(PcmProductData.class, forVariable(variable));
    }

    public QPcmProductData(Path<? extends PcmProductData> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPcmProductData(PathMetadata metadata) {
        super(PcmProductData.class, metadata);
    }

}

