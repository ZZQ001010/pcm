package cn.sunline.pcm.infrastructure.shared.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPcmPrmControl is a Querydsl query type for PcmPrmControl
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPcmPrmControl extends EntityPathBase<PcmPrmControl> {

    private static final long serialVersionUID = -618793948L;

    public static final QPcmPrmControl pcmPrmControl = new QPcmPrmControl("pcmPrmControl");

    public final StringPath id = createString("id");

    public final NumberPath<Integer> jpaVersion = createNumber("jpaVersion", Integer.class);

    public final StringPath maxValue = createString("maxValue");

    public final StringPath minValue = createString("minValue");

    public final StringPath paramClass = createString("paramClass");

    public final StringPath paramClassLabel = createString("paramClassLabel");

    public final StringPath paramField = createString("paramField");

    public final StringPath paramFieldLabel = createString("paramFieldLabel");

    public QPcmPrmControl(String variable) {
        super(PcmPrmControl.class, forVariable(variable));
    }

    public QPcmPrmControl(Path<? extends PcmPrmControl> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPcmPrmControl(PathMetadata metadata) {
        super(PcmPrmControl.class, metadata);
    }

}

