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
@Table(name = "tva", catalog = "lavage_auto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tva.findAll", query = "SELECT t FROM Tva t")
    , @NamedQuery(name = "Tva.findByIdTva", query = "SELECT t FROM Tva t WHERE t.idTva = :idTva")
    , @NamedQuery(name = "Tva.findByCssRawColorCode", query = "SELECT t FROM Tva t WHERE t.cssRawColorCode = :cssRawColorCode")
    , @NamedQuery(name = "Tva.findByDatePersistence", query = "SELECT t FROM Tva t WHERE t.datePersistence = :datePersistence")
    , @NamedQuery(name = "Tva.findByUpdatedVersionDate", query = "SELECT t FROM Tva t WHERE t.updatedVersionDate = :updatedVersionDate")
    , @NamedQuery(name = "Tva.findByDateEnVigueur", query = "SELECT t FROM Tva t WHERE t.dateEnVigueur = :dateEnVigueur")
    , @NamedQuery(name = "Tva.findByValeur", query = "SELECT t FROM Tva t WHERE t.valeur = :valeur")})
public class Tva extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tva")
    private Long idTva;
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
    @Column(name = "date_en_vigueur")
    @Temporal(TemporalType.DATE)
    private Date dateEnVigueur;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valeur")
    private BigDecimal valeur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTva")
    private Collection<Facture> factureCollection;

    public Tva() {
    }

    public Tva(Long idTva) {
        this.idTva = idTva;
    }

    public Tva(Long idTva, //String cssRawColorCode, 
            Date dateEnVigueur, BigDecimal valeur) {
        this.idTva = idTva;
//        this.cssRawColorCode = cssRawColorCode;
        this.dateEnVigueur = dateEnVigueur;
        this.valeur = valeur;
    }

    public Long getIdTva() {
        return idTva;
    }

    public void setIdTva(Long idTva) {
        this.idTva = idTva;
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

    public Date getDateEnVigueur() {
        return dateEnVigueur;
    }

    public void setDateEnVigueur(Date dateEnVigueur) {
        this.dateEnVigueur = dateEnVigueur;
    }

    public BigDecimal getValeur() {
        return valeur;
    }

    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }

    @XmlTransient
    public Collection<Facture> getFactureCollection() {
        return factureCollection;
    }

    public void setFactureCollection(Collection<Facture> factureCollection) {
        this.factureCollection = factureCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTva != null ? idTva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tva)) {
            return false;
        }
        Tva other = (Tva) object;
        if ((this.idTva == null && other.idTva != null) || (this.idTva != null && !this.idTva.equals(other.idTva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mgw.domaine_lavage_auto.class_util.Tva[ idTva=" + idTva + " ]";
    }
    
}
