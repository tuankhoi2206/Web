package com.nitsoft.ecommerce.database.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "user_addresses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAddress.findAll", query = "SELECT a FROM UserAddress a"),
    @NamedQuery(name = "UserAddress.findByAdressId", query = "SELECT a FROM UserAddress a WHERE a.adressId = :adressId"),
    @NamedQuery(name = "UserAddress.findByUserId", query = "SELECT a FROM UserAddress a WHERE a.userId = :userId"),
    @NamedQuery(name = "UserAddress.findByAdress", query = "SELECT a FROM UserAddress a WHERE a.adress = :adress"),
    @NamedQuery(name = "UserAddress.findByCity", query = "SELECT a FROM UserAddress a WHERE a.city = :city"),
    @NamedQuery(name = "UserAddress.findByCountry", query = "SELECT a FROM UserAddress a WHERE a.country = :country")})
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adress_id")
    private Integer adressId;
    
    @Basic(optional = false)
    @Column(name = "user_id")
    private String userId;
    
    @Basic(optional = false)
    @Column(name = "adress")
    private String adress;
    
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    
    @Basic(optional = false)
    @Column(name = "fax")
    private String fax;
    
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    
    @Basic(optional = false)
    @Column(name = "country")
    private String country;

    public UserAddress() {
    }

    public UserAddress(Integer adressId) {
        this.adressId = adressId;
    }

    public UserAddress(Integer adressId, String userId, String adress, String phone, String fax, String city, String country) {
        this.adressId = adressId;
        this.userId = userId;
        this.adress = adress;
        this.phone = phone;
        this.fax = fax;
        this.city = city;
        this.country = country;
    }

    public Integer getAdressId() {
        return adressId;
    }

    public void setAdressId(Integer adressId) {
        this.adressId = adressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adressId != null ? adressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAddress)) {
            return false;
        }
        UserAddress other = (UserAddress) object;
        if ((this.adressId == null && other.adressId != null) || (this.adressId != null && !this.adressId.equals(other.adressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nitsoft.ecommerce.model.Address[ adressId=" + adressId + " ]";
    }

}
