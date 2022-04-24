/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import beans.MobileBeanLocal;
import client.MobileClient;
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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author kruti
 */
@Named(value = "mrBean")
@ApplicationScoped
public class MobileRestBean {

    @EJB
    private MobileBeanLocal mb;
    
    MobileClient mc;
    Response res;
    
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
    GenericType<List<Mobile>> gmobiles;
    GenericType<Collection<Category>> gcats;

    @PostConstruct
    public void init(){
        mc=new MobileClient();
        gmobiles=new GenericType<List<Mobile>>(){};
        gcats=new GenericType<Collection<Category>>(){};
        res=mc.getAllCats(Response.class);
        cats=res.readEntity(gcats);
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
            //return (List<Mobile>) mb.getAllMobilesByFilter(null, catNames, memoryArr);
            res=mc.getAllMobilesByFilter(catNames,Response.class);
            return (List<Mobile>) res.readEntity(gmobiles);
            
        }else if(!catNames.isEmpty()){
            //return (List<Mobile>) mb.getAllMobilesByFilter(null, catNames, null);
            res=mc.getAllMobilesByFilter(catNames, Response.class);
            return (List<Mobile>) res.readEntity(gmobiles);
            
        }else if(!memoryArr.isEmpty()){
            //return (List<Mobile>) mb.getAllMobilesByFilter(null, null, memoryArr);
            res=mc.getAllMobilesByFilter(null, Response.class);
            return (List<Mobile>) res.readEntity(gmobiles);
            
        }
        res=mc.getAllMobiles(Response.class);
        return (List<Mobile>) res.readEntity(gmobiles);
    }
    
    public String addMob(){
        //System.out.println(company+"    "+model+"   "+year+"    "+memory+"      "+catid);
        
        mc.addMobile(company, model, String.valueOf(year), String.valueOf(memory),String.valueOf(catid));
        this.company="";
        this.model="";
        this.year=0;
        this.memory=0;
        this.catid=0;
        return "Index";
    }
    
   
    public void deleteMob(Integer mobileid){
        mc.deleteMobile(String.valueOf(mobileid));
    }
    
}
