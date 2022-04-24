/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Category;
import entity.Mobile;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author kruti
 */
@Local
public interface MobileBeanLocal {
    void addCat(String catname);
    void deleteCat(Integer catid);
    Collection<Category> getAllCats();
    
    void addMobile(String company, String model, int year, int memory,Integer catid);
    void deleteMobile(Integer mobileid);
    Collection<Mobile> getAllMobiles();
    
    Collection<Mobile> getAllMobilesByFilter(Collection<String> company,Collection<String> category,Collection<Integer> memory);
    
    
    
}
