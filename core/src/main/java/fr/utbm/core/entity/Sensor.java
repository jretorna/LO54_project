/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author java
 */
@Entity
@Table(name = "sensor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sensor.findAll", query = "SELECT s FROM Sensor s"),
    @NamedQuery(name = "Sensor.findBySenId", query = "SELECT s FROM Sensor s WHERE s.senId = :senId"),
    @NamedQuery(name = "Sensor.findBySenLabel", query = "SELECT s FROM Sensor s WHERE s.senLabel = :senLabel")})
public class Sensor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Sen_Id")
    private Integer senId;
    @Basic(optional = false)
    @Column(name = "Sen_Label")
    private String senLabel;
    @JoinColumn(name = "Sta_Id", referencedColumnName = "Sta_Id")
    @ManyToOne(optional = false)
    private Station staId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "senId")
    private List<Trigger> triggerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "senId")
    private List<Temperature> temperatureList;

    public Sensor() {
    }

    public Sensor(Integer senId) {
        this.senId = senId;
    }

    public Sensor(Integer senId, String senLabel) {
        this.senId = senId;
        this.senLabel = senLabel;
    }

    public Integer getSenId() {
        return senId;
    }

    public void setSenId(Integer senId) {
        this.senId = senId;
    }

    public String getSenLabel() {
        return senLabel;
    }

    public void setSenLabel(String senLabel) {
        this.senLabel = senLabel;
    }

    public Station getStaId() {
        return staId;
    }

    public void setStaId(Station staId) {
        this.staId = staId;
    }

    @XmlTransient
    @JsonIgnore
    public List<Trigger> getTriggerList() {
        return triggerList;
    }

    public void setTriggerList(List<Trigger> triggerList) {
        this.triggerList = triggerList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Temperature> getTemperatureList() {
        return temperatureList;
    }

    public void setTemperatureList(List<Temperature> temperatureList) {
        this.temperatureList = temperatureList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (senId != null ? senId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sensor)) {
            return false;
        }
        Sensor other = (Sensor) object;
        if ((this.senId == null && other.senId != null) || (this.senId != null && !this.senId.equals(other.senId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.core.entity.Sensor[ senId=" + senId + " ]";
    }
    
}
