/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author java
 */
@Entity
@Table(name = "temperature")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temperature.findAll", query = "SELECT t FROM Temperature t"),
    @NamedQuery(name = "Temperature.findByTmpId", query = "SELECT t FROM Temperature t WHERE t.tmpId = :tmpId"),
    @NamedQuery(name = "Temperature.findByTmpValue", query = "SELECT t FROM Temperature t WHERE t.tmpValue = :tmpValue"),
    @NamedQuery(name = "Temperature.findByTmpDate", query = "SELECT t FROM Temperature t WHERE t.tmpDate = :tmpDate")})
public class Temperature implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Tmp_Id")
    private Integer tmpId;
    @Basic(optional = false)
    @Column(name = "Tmp_Value")
    private float tmpValue;
    @Basic(optional = false)
    @Column(name = "Tmp_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmpDate;
    @JoinColumn(name = "Sen_Id", referencedColumnName = "Sen_Id")
    @ManyToOne(optional = false)
    private Sensor senId;

    public Temperature() {
    }

    public Temperature(Integer tmpId) {
        this.tmpId = tmpId;
    }

    public Temperature(Integer tmpId, float tmpValue, Date tmpDate) {
        this.tmpId = tmpId;
        this.tmpValue = tmpValue;
        this.tmpDate = tmpDate;
    }

    public Integer getTmpId() {
        return tmpId;
    }

    public void setTmpId(Integer tmpId) {
        this.tmpId = tmpId;
    }

    public float getTmpValue() {
        return tmpValue;
    }

    public void setTmpValue(float tmpValue) {
        this.tmpValue = tmpValue;
    }

    public Date getTmpDate() {
        return tmpDate;
    }

    public void setTmpDate(Date tmpDate) {
        this.tmpDate = tmpDate;
    }

    public Sensor getSenId() {
        return senId;
    }

    public void setSenId(Sensor senId) {
        this.senId = senId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tmpId != null ? tmpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temperature)) {
            return false;
        }
        Temperature other = (Temperature) object;
        if ((this.tmpId == null && other.tmpId != null) || (this.tmpId != null && !this.tmpId.equals(other.tmpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.core.entity.Temperature[ tmpId=" + tmpId + " ]";
    }
    
}
