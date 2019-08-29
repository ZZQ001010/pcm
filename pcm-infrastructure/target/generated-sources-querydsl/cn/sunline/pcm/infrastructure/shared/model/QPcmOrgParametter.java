package cn.sunline.pcm.infrastructure.shared.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPcmOrgParametter is a Querydsl query type for PcmOrgParametter
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPcmOrgParametter extends EntityPathBase<PcmOrgParametter> {

    private static final long serialVersionUID = 1815734647L;

    public static final QPcmOrgParametter pcmOrgParametter = new QPcmOrgParametter("pcmOrgParametter");

    public final StringPath orgAddress = createString("orgAddress");

    public final StringPath orgCode = createString("orgCode");

    public final StringPath orgContactPhone = createString("orgContactPhone");

    public final StringPath orgLevel = createString("orgLevel");

    public final StringPath orgName = createString("orgName");

    public final StringPath parentOrgCode = createString("parentOrgCode");

    public QPcmOrgParametter(String variable) {
        super(PcmOrgParametter.class, forVariable(variable));
    }

    public QPcmOrgParametter(Path<? extends PcmOrgParametter> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPcmOrgParametter(PathMetadata metadata) {
        super(PcmOrgParametter.class, metadata);
    }

}

