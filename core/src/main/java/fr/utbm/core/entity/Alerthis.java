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
@Table(name = "alerthis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alerthis.findAll", query = "SELECT a FROM Alerthis a"),
    @NamedQuery(name = "Alerthis.findByAlhId", query = "SELECT a FROM Alerthis a WHERE a.alhId = :alhId"),
    @NamedQuery(name = "Alerthis.findByAlhDate", query = "SELECT a FROM Alerthis a WHERE a.alhDate = :alhDate"),
    @NamedQuery(name = "Alerthis.findByAlhState", query = "SELECT a FROM Alerthis a WHERE a.alhState = :alhState")})
public class Alerthis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Alh_Id")
    private Integer alhId;
    @Basic(optional = false)
    @Column(name = "Alh_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date alhDate;
    @Basic(optional = false)
    @Column(name = "Alh_State")
    private boolean alhState;
    @JoinColumn(name = "Trg_Id", referencedColumnName = "Trg_Id")
    @ManyToOne(optional = false)
    private Trigger trgId;

    public Alerthis() {
    }

    public Alerthis(Integer alhId) {
        this.alhId = alhId;
    }

    public Alerthis(Integer alhId, Date alhDate, boolean alhState) {
        this.alhId = alhId;
        this.alhDate = alhDate;
        this.alhState = alhState;
    }

    public Integer getAlhId() {
        return alhId;
    }

    public void setAlhId(Integer alhId) {
        this.alhId = alhId;
    }

    public Date getAlhDate() {
        return alhDate;
    }

    public void setAlhDate(Date alhDate) {
        this.alhDate = alhDate;
    }

    public boolean getAlhState() {
        return alhState;
    }

    public void setAlhState(boolean alhState) {
        this.alhState = alhState;
    }

    public Trigger getTrgId() {
        return trgId;
    }

    public void setTrgId(Trigger trgId) {
        this.trgId = trgId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alhId != null ? alhId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alerthis)) {
            return false;
        }
        Alerthis other = (Alerthis) object;
        if ((this.alhId == null && other.alhId != null) || (this.alhId != null && !this.alhId.equals(other.alhId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.utbm.core.entity.Alerthis[ alhId=" + alhId + " ]";
    }
    
}
