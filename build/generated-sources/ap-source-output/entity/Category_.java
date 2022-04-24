package entity;

import entity.Mobile;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-04-24T02:24:45", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, Integer> catid;
    public static volatile SingularAttribute<Category, String> catname;
    public static volatile CollectionAttribute<Category, Mobile> mobileCollection;

}