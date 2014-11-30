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
@Table(name = "trigger")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trigger.findAll", query = "SELECT t FROM Trigger t"),
    @NamedQuery(name = "Trigger.findByTrgId", query = "SELECT t FROM Trigger t WHERE t.trgId = :trgId"),
    @NamedQuery(name = "Trigger.findByTrgHigh", query = "SELECT t FROM Trigger t WHERE t.trgHigh = :trgHigh"),
    @NamedQuery(name = "Trigger.findByTrgLow", query = "SELECT t FROM Trigger t WHERE t.trgLow = :trgLow"),
    @NamedQuery(name = "Trigger.findByTrgEdge", query = "SELECT t FROM Trigger t WHERE t.trgEdge = :trgEdge")})
public class Trigger implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Trg_Id")
    private Integer trgId;
    @Basic(optional = false)
    @Column(name = "Trg_High")
    private float trgHigh;
    @Basic(optional = false)
    @Column(name = "Trg_Low")
    private float trgLow;
    @Basic(optional = false)
    @Column(name = "Trg_Edge")
    private boolean trgEdge;
    @JoinColumn(name = "Sen_Id", referencedColumnName = "Sen_Id")
    @ManyToOne(optional = false)
    private Sensor senId;
    @JoinColumn(name = "Alr_code", referencedColumnName = "Alr_code")
    @ManyToOne(optional = false)
    private Alert alrcode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trgId")
    private List<Alerthis> alerthisList;

    public Trigger() {
    }

    public Trigger(Integer trgId) {
        this.trgId = trgId;
    }

    public Trigger(Integer trgId, float trgHigh, float trgLow, boolean trgEdge) {
        this.trgId = trgId;
        this.trgHigh = trgHigh;
        this.trgLow = trgLow;
        this.trgEdge = trgEdge;
    }

    public Integer getTrgId() {
        return trgId;
    }

    public void setTrgId(Integer trgId) {
        this.trgId = trgId;
    }

    public float getTrgHigh() {
        return trgHigh;
    }

    public void setTrgHigh(float trgHigh) {
        this.trgHigh = trgHigh;
    }

    public float getTrgLow() {
        return trgLow;
    }

    public void setTrgLow(float trgLow) {
        this.trgLow = trgLow;
    }

    public boolean getTrgEdge() {
        return trgEdge;
    }

    public void setTrgEdge(boolean trgEdge) {
        this.trgEdge = trgEdge;
    }

    public Sensor getSenId() {
        return senId;
    }

    public void setSenId(Sensor senId) {
        this.senId = senId;
    }

    public Alert getAlrcode() {
        return alrcode;
    }

    public void setAlrcode(Alert alrcode) {
        this.alrcode = alrcode;
    }

    @XmlTransient
    @JsonIgnore
    public List<Alerthis> getAlerthisList() {
        return alerthisList;
    }

    public void setAlerthisList(List<Alerthis> alerthisList) {
        this.alerthisList = alerthisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trgId != null ? trgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trigger)) {
            return false;
        }
        Trigger other = (Trigger) object;
        if ((this.trgId == null && other.trgId != null) || (this.trgId != null && !this.trgId.equals(other.trgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.core.entity.Trigger[ trgId=" + trgId + " ]";
    }
    
}
