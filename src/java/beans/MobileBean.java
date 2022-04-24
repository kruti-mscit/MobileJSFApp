/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Category;
import entity.Mobile;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kruti
 */
@Stateless
public class MobileBean implements MobileBeanLocal {

    @PersistenceContext(unitName="MobileAppPU")
    EntityManager em;
    
    @Override
    public void addCat(String catname) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Category cat=new Category(catname);
        em.persist(cat);
    }

    @Override
    public void deleteCat(Integer catid) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Category cat=(Category) em.find(Category.class, catid);
        em.remove(cat);
    }

    @Override
    public Collection<Category> getAllCats() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        return em.createNamedQuery("Category.findAll").getResultList();
    }

    @Override
    public void addMobile(String company, String model, int year, int memory, Integer catid) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Category cat=(Category) em.find(Category.class, catid);
        Collection<Mobile> mCol=cat.getMobileCollection();
        
        Mobile m=new Mobile(company,model,year,memory);
        m.setCat(cat);
        
        mCol.add(m);
        cat.setMobileCollection(mCol);   //IMPORTANT
        em.persist(m);
        em.merge(cat);
    }

    @Override
    public void deleteMobile(Integer mobileid) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Mobile m=(Mobile) em.find(Mobile.class,mobileid);
        Category cat=(Category) em.find(Category.class, m.getCat().getCatid());
        Collection<Mobile> mCol=cat.getMobileCollection();
        
        if(mCol.contains(m)){
            mCol.remove(m);
            cat.setMobileCollection(mCol);   //IMPORTANT
            em.remove(m);
            em.merge(cat);
        }
        
    }

    @Override
    public Collection<Mobile> getAllMobiles() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        return em.createNamedQuery("Mobile.findAll").getResultList();
    }

    @Override
    public Collection<Mobile> getAllMobilesByFilter(Collection<String> company, Collection<String> category, Collection<Integer> memory) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<Mobile> mbCol=null;
        if(category!=null && !category.isEmpty() && memory!=null && !memory.isEmpty()){
            mbCol=em.createNamedQuery("Mobile.findByFilter").setParameter("catNames", category).setParameter("memoryArr", memory).getResultList();
        
        }else if(category!=null && !category.isEmpty()){
            mbCol=em.createNamedQuery("Mobile.findByCategory").setParameter("catNames", category).getResultList();
        
        }else if(memory!=null && !memory.isEmpty()){
            mbCol=em.createNamedQuery("Mobile.findByMemory").setParameter("memoryArr", memory).getResultList();
        }
        
        return mbCol;
    }

}
