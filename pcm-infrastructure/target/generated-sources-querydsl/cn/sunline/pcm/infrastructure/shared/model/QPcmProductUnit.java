package cn.sunline.pcm.infrastructure.shared.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPcmProductUnit is a Querydsl query type for PcmProductUnit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPcmProductUnit extends EntityPathBase<PcmProductUnit> {

    private static final long serialVersionUID = 1069750625L;

    public static final QPcmProductUnit pcmProductUnit = new QPcmProductUnit("pcmProductUnit");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath createUser = createString("createUser");

    public final StringPath id = createString("id");

    public final NumberPath<Integer> jpaVersion = createNumber("jpaVersion", Integer.class);

    public final DateTimePath<java.util.Date> lstUpdTime = createDateTime("lstUpdTime", java.util.Date.class);

    public final StringPath lstUpdUser = createString("lstUpdUser");

    public final EnumPath<cn.sunline.common.enums.Indicator> multiple = createEnum("multiple", cn.sunline.common.enums.Indicator.class);

    public final StringPath org = createString("org");

    public final EnumPath<cn.sunline.ppy.dictionary.enums.ProductType> productType = createEnum("productType", cn.sunline.ppy.dictionary.enums.ProductType.class);

    public final StringPath productUnitGroup = createString("productUnitGroup");

    public final StringPath unitCode = createString("unitCode");

    public final NumberPath<Integer> unitIndex = createNumber("unitIndex", Integer.class);

    public final StringPath unitModule = createString("unitModule");

    public final StringPath unitName = createString("unitName");

    public final StringPath unitNameCn = createString("unitNameCn");

    public final StringPath unitRelations = createString("unitRelations");

    public QPcmProductUnit(String variable) {
        super(PcmProductUnit.class, forVariable(variable));
    }

    public QPcmProductUnit(Path<? extends PcmProductUnit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPcmProductUnit(PathMetadata metadata) {
        super(PcmProductUnit.class, metadata);
    }

}

