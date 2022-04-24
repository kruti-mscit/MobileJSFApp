/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import beans.MobileBeanLocal;
import entity.Category;
import entity.Mobile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 *
 * @author kruti
 */
@Named(value = "moBean")
@ApplicationScoped
public class MobileBean {

    @EJB
    private MobileBeanLocal mb;
    
    Mobile mobile=new Mobile();

    private Integer mobileid;
    private String company;
    @Pattern(regexp="(m-)[a-z]*")
    private String model;
    @Min(2000)
    private int year;
    @Min(16)
    private int memory;
    private Integer catid;
    Category cat=new Category();
    
    Collection<Category> cats;
    Collection<String> catNames;
    Collection<Integer> memoryArr;

    @PostConstruct
    public void init(){
        cats=mb.getAllCats();
        catNames=new ArrayList<String>();
        memoryArr=new ArrayList<Integer>();
    }

    public Collection<Integer> getMemoryArr() {
        return memoryArr;
    }

    public void setMemoryArr(Collection<Integer> memoryArr) {
        this.memoryArr = memoryArr;
    }
    

    public Collection<String> getCatNames() {
        return catNames;
    }

    public void setCatNames(Collection<String> catNames) {
        this.catNames = catNames;
    }

    public Collection<Category> getCats() {
        return cats;
    }

    public void setCats(Collection<Category> cats) {
        this.cats = cats;
    }
    
    
    public Mobile getMobile() {
        return mobile;
    }

    public void set(Mobile mobile) {
        this.mobile = mobile;
    }

    public Integer getMobileid() {
        return mobileid;
    }

    public void setMobileid(Integer mobileid) {
        this.mobileid = mobileid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }
    
    
    public List<Mobile> findAllMobs(){
        if(!catNames.isEmpty() && !memoryArr.isEmpty()){
            return (List<Mobile>) mb.getAllMobilesByFilter(null, catNames, memoryArr);
        }else if(!catNames.isEmpty()){
            return (List<Mobile>) mb.getAllMobilesByFilter(null, catNames, null);
        }else if(!memoryArr.isEmpty()){
            return (List<Mobile>) mb.getAllMobilesByFilter(null, null, memoryArr);
        }
        
        return (List<Mobile>) mb.getAllMobiles();
    }
    
    public String addMob(){
        mb.addMobile(company, model, year, memory, catid);
        this.company="";
        this.model="";
        this.year=0;
        this.memory=0;
        this.catid=0;
        return "Index";
    }
    
   
    public void deleteMob(Integer mobileid){
        mb.deleteMobile(mobileid);
    }
}
