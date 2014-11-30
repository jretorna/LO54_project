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
import javax.persistence.Lob;
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
@Table(name = "alert")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alert.findAll", query = "SELECT a FROM Alert a"),
    @NamedQuery(name = "Alert.findByAlrcode", query = "SELECT a FROM Alert a WHERE a.alrcode = :alrcode"),
    @NamedQuery(name = "Alert.findByAlrLabel", query = "SELECT a FROM Alert a WHERE a.alrLabel = :alrLabel")})
public class Alert implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Alr_code")
    private String alrcode;
    @Basic(optional = false)
    @Column(name = "Alr_Label")
    private String alrLabel;
    @Basic(optional = false)
    @Lob
    @Column(name = "Alr_Description")
    private String alrDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alrcode")
    private List<Trigger> triggerList;

    public Alert() {
    }

    public Alert(String alrcode) {
        this.alrcode = alrcode;
    }

    public Alert(String alrcode, String alrLabel, String alrDescription) {
        this.alrcode = alrcode;
        this.alrLabel = alrLabel;
        this.alrDescription = alrDescription;
    }

    public String getAlrcode() {
        return alrcode;
    }

    public void setAlrcode(String alrcode) {
        this.alrcode = alrcode;
    }

    public String getAlrLabel() {
        return alrLabel;
    }

    public void setAlrLabel(String alrLabel) {
        this.alrLabel = alrLabel;
    }

    public String getAlrDescription() {
        return alrDescription;
    }

    public void setAlrDescription(String alrDescription) {
        this.alrDescription = alrDescription;
    }

    @XmlTransient
    @JsonIgnore
    public List<Trigger> getTriggerList() {
        return triggerList;
    }

    public void setTriggerList(List<Trigger> triggerList) {
        this.triggerList = triggerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alrcode != null ? alrcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alert)) {
            return false;
        }
        Alert other = (Alert) object;
        if ((this.alrcode == null && other.alrcode != null) || (this.alrcode != null && !this.alrcode.equals(other.alrcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.core.entity.Alert[ alrcode=" + alrcode + " ]";
    }
    
}
