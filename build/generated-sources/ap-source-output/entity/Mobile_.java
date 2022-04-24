package entity;

import entity.Category;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-04-24T02:24:45", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Mobile.class)
public class Mobile_ { 

    public static volatile SingularAttribute<Mobile, Integer> memory;
    public static volatile SingularAttribute<Mobile, Integer> mobileid;
    public static volatile SingularAttribute<Mobile, Integer> year;
    public static volatile SingularAttribute<Mobile, Category> cat;
    public static volatile SingularAttribute<Mobile, String> company;
    public static volatile SingularAttribute<Mobile, String> model;

}