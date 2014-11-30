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
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByAreId", query = "SELECT a FROM Area a WHERE a.areId = :areId"),
    @NamedQuery(name = "Area.findByAreLabel", query = "SELECT a FROM Area a WHERE a.areLabel = :areLabel"),
    @NamedQuery(name = "Area.findByAreRoad", query = "SELECT a FROM Area a WHERE a.areRoad = :areRoad")})
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Are_Id")
    private Integer areId;
    @Basic(optional = false)
    @Column(name = "Are_Label")
    private String areLabel;
    @Column(name = "Are_Road")
    private String areRoad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areId")
    private List<Station> stationList;

    public Area() {
    }

    public Area(Integer areId) {
        this.areId = areId;
    }

    public Area(Integer areId, String areLabel) {
        this.areId = areId;
        this.areLabel = areLabel;
    }

    public Integer getAreId() {
        return areId;
    }

    public void setAreId(Integer areId) {
        this.areId = areId;
    }

    public String getAreLabel() {
        return areLabel;
    }

    public void setAreLabel(String areLabel) {
        this.areLabel = areLabel;
    }

    public String getAreRoad() {
        return areRoad;
    }

    public void setAreRoad(String areRoad) {
        this.areRoad = areRoad;
    }

    @XmlTransient
    @JsonIgnore
    public List<Station> getStationList() {
        return stationList;
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areId != null ? areId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.areId == null && other.areId != null) || (this.areId != null && !this.areId.equals(other.areId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.core.entity.Area[ areId=" + areId + " ]";
    }
    
}
