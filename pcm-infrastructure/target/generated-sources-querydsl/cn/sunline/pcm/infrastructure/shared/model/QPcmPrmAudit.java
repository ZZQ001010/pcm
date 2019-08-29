package cn.sunline.pcm.infrastructure.shared.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPcmPrmAudit is a Querydsl query type for PcmPrmAudit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPcmPrmAudit extends EntityPathBase<PcmPrmAudit> {

    private static final long serialVersionUID = 1611083874L;

    public static final QPcmPrmAudit pcmPrmAudit = new QPcmPrmAudit("pcmPrmAudit");

    public final StringPath id = createString("id");

    public final DateTimePath<java.util.Date> jpaTimestamp = createDateTime("jpaTimestamp", java.util.Date.class);

    public final StringPath mtnUser = createString("mtnUser");

    public final StringPath newObject = createString("newObject");

    public final StringPath oldObject = createString("oldObject");

    public final StringPath org = createString("org");

    public final StringPath paramClass = createString("paramClass");

    public final StringPath paramKey = createString("paramKey");

    public final EnumPath<cn.sunline.pcm.infrastructure.shared.enums.ParamOperationDef> paramOperation = createEnum("paramOperation", cn.sunline.pcm.infrastructure.shared.enums.ParamOperationDef.class);

    public final StringPath updateLog = createString("updateLog");

    public QPcmPrmAudit(String variable) {
        super(PcmPrmAudit.class, forVariable(variable));
    }

    public QPcmPrmAudit(Path<? extends PcmPrmAudit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPcmPrmAudit(PathMetadata metadata) {
        super(PcmPrmAudit.class, metadata);
    }

}

