package cn.sunline.pcm.infrastructure.shared.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPcmPrmObject is a Querydsl query type for PcmPrmObject
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPcmPrmObject extends EntityPathBase<PcmPrmObject> {

    private static final long serialVersionUID = -1212571752L;

    public static final QPcmPrmObject pcmPrmObject = new QPcmPrmObject("pcmPrmObject");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath createUser = createString("createUser");

    public final StringPath id = createString("id");

    public final NumberPath<Integer> jpaVersion = createNumber("jpaVersion", Integer.class);

    public final DateTimePath<java.util.Date> lstUpdTime = createDateTime("lstUpdTime", java.util.Date.class);

    public final StringPath lstUpdUser = createString("lstUpdUser");

    public final StringPath org = createString("org");

    public final StringPath paramClass = createString("paramClass");

    public final StringPath paramKey = createString("paramKey");

    public final StringPath paramObject = createString("paramObject");

    public QPcmPrmObject(String variable) {
        super(PcmPrmObject.class, forVariable(variable));
    }

    public QPcmPrmObject(Path<? extends PcmPrmObject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPcmPrmObject(PathMetadata metadata) {
        super(PcmPrmObject.class, metadata);
    }

}

