/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kruti
 */
@Entity
@Table(name = "mobile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mobile.findAll", query = "SELECT m FROM Mobile m"),
    @NamedQuery(name = "Mobile.findByMobileid", query = "SELECT m FROM Mobile m WHERE m.mobileid = :mobileid"),
    @NamedQuery(name = "Mobile.findByCompany", query = "SELECT m FROM Mobile m WHERE m.company = :company"),
    @NamedQuery(name = "Mobile.findByCategory", query = "SELECT m FROM Mobile m WHERE m.cat.catname IN :catNames"),
    @NamedQuery(name = "Mobile.findByMemory", query = "SELECT m FROM Mobile m WHERE m.memory IN :memoryArr"),
    @NamedQuery(name = "Mobile.findByFilter", query = "SELECT m FROM Mobile m WHERE m.cat.catname IN :catNames AND m.memory IN :memoryArr"),
    @NamedQuery(name = "Mobile.findByModel", query = "SELECT m FROM Mobile m WHERE m.model = :model"),
    @NamedQuery(name = "Mobile.findByYear", query = "SELECT m FROM Mobile m WHERE m.year = :year")})
public class Mobile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mobileid")
    private Integer mobileid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Column(name = "year")
    private int year;
    @Basic(optional = false)
    @NotNull
    @Column(name = "memory")
    private int memory;
    @JoinColumn(name = "catid", referencedColumnName = "catid")
    @ManyToOne(optional = false)
    private Category cat;

    public Mobile() {
    }

    public Mobile(Integer mobileid) {
        this.mobileid = mobileid;
    }

    public Mobile(String company, String model, int year, int memory) {
       
        this.company = company;
        this.model = model;
        this.year = year;
        this.memory = memory;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mobileid != null ? mobileid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mobile)) {
            return false;
        }
        Mobile other = (Mobile) object;
        if ((this.mobileid == null && other.mobileid != null) || (this.mobileid != null && !this.mobileid.equals(other.mobileid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mobile[ mobileid=" + mobileid + " ]";
    }
    
}
