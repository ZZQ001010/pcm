package cn.sunline.pcm.infrastructure.shared.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPcmProductGroup is a Querydsl query type for PcmProductGroup
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPcmProductGroup extends EntityPathBase<PcmProductGroup> {

    private static final long serialVersionUID = -1210273214L;

    public static final QPcmProductGroup pcmProductGroup = new QPcmProductGroup("pcmProductGroup");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath createUser = createString("createUser");

    public final StringPath groupCode = createString("groupCode");

    public final NumberPath<Integer> groupIndex = createNumber("groupIndex", Integer.class);

    public final StringPath groupName = createString("groupName");

    public final EnumPath<cn.sunline.pcm.definition.enums.Position> groupPosition = createEnum("groupPosition", cn.sunline.pcm.definition.enums.Position.class);

    public final StringPath id = createString("id");

    public final NumberPath<Integer> jpaVersion = createNumber("jpaVersion", Integer.class);

    public final DateTimePath<java.util.Date> lstUpdTime = createDateTime("lstUpdTime", java.util.Date.class);

    public final StringPath lstUpdUser = createString("lstUpdUser");

    public final StringPath name = createString("name");

    public final StringPath org = createString("org");

    public final StringPath productParentId = createString("productParentId");

    public final StringPath productType = createString("productType");

    public QPcmProductGroup(String variable) {
        super(PcmProductGroup.class, forVariable(variable));
    }

    public QPcmProductGroup(Path<? extends PcmProductGroup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPcmProductGroup(PathMetadata metadata) {
        super(PcmProductGroup.class, metadata);
    }

}

