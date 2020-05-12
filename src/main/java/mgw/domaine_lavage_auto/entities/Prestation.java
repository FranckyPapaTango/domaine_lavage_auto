/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgw.domaine_lavage_auto.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BigWave
 */
@Entity
@Table(name = "prestation", catalog = "lavage_auto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestation.findAll", query = "SELECT p FROM Prestation p")
    , @NamedQuery(name = "Prestation.findByIdPrestation", query = "SELECT p FROM Prestation p WHERE p.idPrestation = :idPrestation")
    , @NamedQuery(name = "Prestation.findByCssRawColorCode", query = "SELECT p FROM Prestation p WHERE p.cssRawColorCode = :cssRawColorCode")
    , @NamedQuery(name = "Prestation.findByDatePersistence", query = "SELECT p FROM Prestation p WHERE p.datePersistence = :datePersistence")
    , @NamedQuery(name = "Prestation.findByUpdatedVersionDate", query = "SELECT p FROM Prestation p WHERE p.updatedVersionDate = :updatedVersionDate")
    , @NamedQuery(name = "Prestation.findByDetailPrestation", query = "SELECT p FROM Prestation p WHERE p.detailPrestation = :detailPrestation")
    , @NamedQuery(name = "Prestation.findByLibellePrestation", query = "SELECT p FROM Prestation p WHERE p.libellePrestation = :libellePrestation")
    , @NamedQuery(name = "Prestation.findByPaypalId", query = "SELECT p FROM Prestation p WHERE p.paypalId = :paypalId")
    , @NamedQuery(name = "Prestation.findByPrixPrestation", query = "SELECT p FROM Prestation p WHERE p.prixPrestation = :prixPrestation")})
public class Prestation extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prestation")
    private Long idPrestation;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 255)
//    @Column(name = "css_raw_color_code")
//    private String cssRawColorCode;
    @Column(name = "date_persistence")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePersistence;
    @Column(name = "updated_version_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedVersionDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "detail_prestation")
    private String detailPrestation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "libelle_prestation")
    private String libellePrestation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "paypal_id")
    private String paypalId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix_prestation")
    private BigDecimal prixPrestation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrestation")
    private Collection<Commande> commandeCollection;

    public Prestation() {
    }

    public Prestation(Long idPrestation) {
        this.idPrestation = idPrestation;
    }

    public Prestation(Long idPrestation,// String cssRawColorCode, 
            String detailPrestation, String libellePrestation, String paypalId, BigDecimal prixPrestation) {
        this.idPrestation = idPrestation;
//        this.cssRawColorCode = cssRawColorCode;
        this.detailPrestation = detailPrestation;
        this.libellePrestation = libellePrestation;
        this.paypalId = paypalId;
        this.prixPrestation = prixPrestation;
    }

    public Long getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(Long idPrestation) {
        this.idPrestation = idPrestation;
    }

//    public String getCssRawColorCode() {
//        return cssRawColorCode;
//    }
//
//    public void setCssRawColorCode(String cssRawColorCode) {
//        this.cssRawColorCode = cssRawColorCode;
//    }

    public Date getDatePersistence() {
        return datePersistence;
    }

    public void setDatePersistence(Date datePersistence) {
        this.datePersistence = datePersistence;
    }

    public Date getUpdatedVersionDate() {
        return updatedVersionDate;
    }

    public void setUpdatedVersionDate(Date updatedVersionDate) {
        this.updatedVersionDate = updatedVersionDate;
    }

    public String getDetailPrestation() {
        return detailPrestation;
    }

    public void setDetailPrestation(String detailPrestation) {
        this.detailPrestation = detailPrestation;
    }

    public String getLibellePrestation() {
        return libellePrestation;
    }

    public void setLibellePrestation(String libellePrestation) {
        this.libellePrestation = libellePrestation;
    }

    public String getPaypalId() {
        return paypalId;
    }

    public void setPaypalId(String paypalId) {
        this.paypalId = paypalId;
    }

    public BigDecimal getPrixPrestation() {
        return prixPrestation;
    }

    public void setPrixPrestation(BigDecimal prixPrestation) {
        this.prixPrestation = prixPrestation;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestation != null ? idPrestation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestation)) {
            return false;
        }
        Prestation other = (Prestation) object;
        if ((this.idPrestation == null && other.idPrestation != null) || (this.idPrestation != null && !this.idPrestation.equals(other.idPrestation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idPrestation + ":"+this.libellePrestation+"("+this.prixPrestation+")"; // REDEFINI APRES GENERATION
    }
    
}
