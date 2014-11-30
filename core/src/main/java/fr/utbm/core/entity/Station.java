/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author java
 */
@Entity
@Table(name = "station")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Station.findAll", query = "SELECT s FROM Station s"),
    @NamedQuery(name = "Station.findByStaId", query = "SELECT s FROM Station s WHERE s.staId = :staId"),
    @NamedQuery(name = "Station.findByStaLabel", query = "SELECT s FROM Station s WHERE s.staLabel = :staLabel"),
    @NamedQuery(name = "Station.findByStaLastCom", query = "SELECT s FROM Station s WHERE s.staLastCom = :staLastCom"),
    @NamedQuery(name = "Station.findByStaValid", query = "SELECT s FROM Station s WHERE s.staValid = :staValid")})
public class Station implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Sta_Id")
    private Integer staId;
    @Basic(optional = false)
    @Column(name = "Sta_Label")
    private String staLabel;
    @Column(name = "Sta_LastCom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date staLastCom;
    @Basic(optional = false)
    @Column(name = "Sta_Valid")
    private boolean staValid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staId")
    private List<Sensor> sensorList;
    @JoinColumn(name = "Are_Id", referencedColumnName = "Are_Id")
    @ManyToOne(optional = false)
    private Area areId;

    public Station() {
    }

    public Station(Integer staId) {
        this.staId = staId;
    }

    public Station(Integer staId, String staLabel, boolean staValid) {
        this.staId = staId;
        this.staLabel = staLabel;
        this.staValid = staValid;
    }

    public Integer getStaId() {
        return staId;
    }

    public void setStaId(Integer staId) {
        this.staId = staId;
    }

    public String getStaLabel() {
        return staLabel;
    }

    public void setStaLabel(String staLabel) {
        this.staLabel = staLabel;
    }

    public Date getStaLastCom() {
        return staLastCom;
    }

    public void setStaLastCom(Date staLastCom) {
        this.staLastCom = staLastCom;
    }

    public boolean getStaValid() {
        return staValid;
    }

    public void setStaValid(boolean staValid) {
        this.staValid = staValid;
    }

    @XmlTransient
    @JsonIgnore
    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(List<Sensor> sensorList) {
        this.sensorList = sensorList;
    }

    public Area getAreId() {
        return areId;
    }

    public void setAreId(Area areId) {
        this.areId = areId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staId != null ? staId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Station)) {
            return false;
        }
        Station other = (Station) object;
        if ((this.staId == null && other.staId != null) || (this.staId != null && !this.staId.equals(other.staId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.core.entity.Station[ staId=" + staId + " ]";
    }
    
}
