/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import beans.MobileBeanLocal;
import entity.Category;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author kruti
 */
@Named(value = "catBean")
@ApplicationScoped
public class CategoryBean {

    @EJB
    private MobileBeanLocal mb;

    Category c=new Category();
    private Integer catid;
    private String catname;
    
    
    public Category getC() {
        return c;
    }

    public void setC(Category c) {
        this.c = c;
    }

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }
    
    public List<Category> findAllCats(){
        return (List<Category>) mb.getAllCats();
    }
    
    public String addCat(){
        mb.addCat(catname);
        catname="";
        return "Index";
    }
    
   
    public void deleteCat(Integer catid){
        mb.deleteCat(catid);
    }
    
    
}
