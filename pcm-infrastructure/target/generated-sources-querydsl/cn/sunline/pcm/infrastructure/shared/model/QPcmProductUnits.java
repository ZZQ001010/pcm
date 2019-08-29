package cn.sunline.pcm.infrastructure.shared.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPcmProductUnits is a Querydsl query type for PcmProductUnits
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPcmProductUnits extends EntityPathBase<PcmProductUnits> {

    private static final long serialVersionUID = -1197468878L;

    public static final QPcmProductUnits pcmProductUnits = new QPcmProductUnits("pcmProductUnits");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath createUser = createString("createUser");

    public final StringPath groupCode = createString("groupCode");

    public final StringPath id = createString("id");

    public final NumberPath<Integer> jpaVersion = createNumber("jpaVersion", Integer.class);

    public final DateTimePath<java.util.Date> lstUpdTime = createDateTime("lstUpdTime", java.util.Date.class);

    public final StringPath lstUpdUser = createString("lstUpdUser");

    public final StringPath org = createString("org");

    public final StringPath subUnit = createString("subUnit");

    public final StringPath unitCode = createString("unitCode");

    public final EnumPath<cn.sunline.pcm.definition.enums.WinSize> unitConfig = createEnum("unitConfig", cn.sunline.pcm.definition.enums.WinSize.class);

    public final NumberPath<Integer> unitIndex = createNumber("unitIndex", Integer.class);

    public final EnumPath<cn.sunline.pcm.definition.enums.ProductUnitsURL> unitModule = createEnum("unitModule", cn.sunline.pcm.definition.enums.ProductUnitsURL.class);

    public final StringPath unitName = createString("unitName");

    public final StringPath unitNameCn = createString("unitNameCn");

    public final EnumPath<cn.sunline.common.enums.Indicator> unitRequired = createEnum("unitRequired", cn.sunline.common.enums.Indicator.class);

    public final StringPath updateUnits = createString("updateUnits");

    public QPcmProductUnits(String variable) {
        super(PcmProductUnits.class, forVariable(variable));
    }

    public QPcmProductUnits(Path<? extends PcmProductUnits> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPcmProductUnits(PathMetadata metadata) {
        super(PcmProductUnits.class, metadata);
    }

}

