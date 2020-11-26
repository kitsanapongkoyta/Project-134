/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "DVDCAT1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dvdcat1.findAll", query = "SELECT d FROM Dvdcat1 d"),
    @NamedQuery(name = "Dvdcat1.findByDvdnames", query = "SELECT d FROM Dvdcat1 d WHERE d.dvdnames = :dvdnames"),
    @NamedQuery(name = "Dvdcat1.findByRate", query = "SELECT d FROM Dvdcat1 d WHERE d.rate = :rate"),
    @NamedQuery(name = "Dvdcat1.findByYears", query = "SELECT d FROM Dvdcat1 d WHERE d.years = :years"),
    @NamedQuery(name = "Dvdcat1.findByPrice", query = "SELECT d FROM Dvdcat1 d WHERE d.price = :price")})
public class Dvdcat1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "DVDNAMES")
    private String dvdnames;
    @Size(max = 10)
    @Column(name = "RATE")
    private String rate;
    @Column(name = "YEARS")
    private Integer years;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;

    public Dvdcat1() {
    }

    public Dvdcat1(String dvdnames) {
        this.dvdnames = dvdnames;
    }

    public String getDvdnames() {
        return dvdnames;
    }

    public void setDvdnames(String dvdnames) {
        this.dvdnames = dvdnames;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dvdnames != null ? dvdnames.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dvdcat1)) {
            return false;
        }
        Dvdcat1 other = (Dvdcat1) object;
        if ((this.dvdnames == null && other.dvdnames != null) || (this.dvdnames != null && !this.dvdnames.equals(other.dvdnames))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dvdcat1[ dvdnames=" + dvdnames + " ]";
    }
    
}
