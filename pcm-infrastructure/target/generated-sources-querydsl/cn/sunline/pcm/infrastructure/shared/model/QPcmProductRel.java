package cn.sunline.pcm.infrastructure.shared.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPcmProductRel is a Querydsl query type for PcmProductRel
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPcmProductRel extends EntityPathBase<PcmProductRel> {

    private static final long serialVersionUID = -2043705060L;

    public static final QPcmProductRel pcmProductRel = new QPcmProductRel("pcmProductRel");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath createUser = createString("createUser");

    public final StringPath id = createString("id");

    public final NumberPath<Integer> jpaVersion = createNumber("jpaVersion", Integer.class);

    public final DateTimePath<java.util.Date> lstUpdTime = createDateTime("lstUpdTime", java.util.Date.class);

    public final StringPath lstUpdUser = createString("lstUpdUser");

    public final StringPath org = createString("org");

    public final StringPath paramClass = createString("paramClass");

    public final StringPath paramKey = createString("paramKey");

    public final StringPath parentId = createString("parentId");

    public final StringPath parentParamClass = createString("parentParamClass");

    public final StringPath parentParamKey = createString("parentParamKey");

    public final StringPath productCode = createString("productCode");

    public final StringPath unitCode = createString("unitCode");

    public QPcmProductRel(String variable) {
        super(PcmProductRel.class, forVariable(variable));
    }

    public QPcmProductRel(Path<? extends PcmProductRel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPcmProductRel(PathMetadata metadata) {
        super(PcmProductRel.class, metadata);
    }

}

