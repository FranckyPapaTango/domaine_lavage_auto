/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgw.domaine_lavage_auto.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BigWave
 */
@Entity
@Table(name = "facture", catalog = "lavage_auto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facture.findAll", query = "SELECT f FROM Facture f")
    , @NamedQuery(name = "Facture.findByIdFacture", query = "SELECT f FROM Facture f WHERE f.idFacture = :idFacture")
    , @NamedQuery(name = "Facture.findByCssRawColorCode", query = "SELECT f FROM Facture f WHERE f.cssRawColorCode = :cssRawColorCode")
    , @NamedQuery(name = "Facture.findByDatePersistence", query = "SELECT f FROM Facture f WHERE f.datePersistence = :datePersistence")
    , @NamedQuery(name = "Facture.findByUpdatedVersionDate", query = "SELECT f FROM Facture f WHERE f.updatedVersionDate = :updatedVersionDate")
    , @NamedQuery(name = "Facture.findByAdresseFacturation", query = "SELECT f FROM Facture f WHERE f.adresseFacturation = :adresseFacturation")
    , @NamedQuery(name = "Facture.findByCommissionAdmin", query = "SELECT f FROM Facture f WHERE f.commissionAdmin = :commissionAdmin")
    , @NamedQuery(name = "Facture.findByCommissionMicroentrepreneur", query = "SELECT f FROM Facture f WHERE f.commissionMicroentrepreneur = :commissionMicroentrepreneur")})
public class Facture extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_facture")
    private Long idFacture;
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
    @Size(max = 50)
    @Column(name = "adresse_facturation")
    private String adresseFacturation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "commission_admin")
    private BigDecimal commissionAdmin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "commission_microentrepreneur")
    private BigDecimal commissionMicroentrepreneur;
    @JoinColumn(name = "id_commande", referencedColumnName = "id_commande")
    @ManyToOne(optional = false)
    private Commande idCommande;
    @JoinColumn(name = "id_tva", referencedColumnName = "id_tva")
    @ManyToOne(optional = false)
    private Tva idTva;

    public Facture() {
    }

    public Facture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public Facture(Long idFacture,// String cssRawColorCode, 
            BigDecimal commissionAdmin, BigDecimal commissionMicroentrepreneur) {
        this.idFacture = idFacture;
//        this.cssRawColorCode = cssRawColorCode;
        this.commissionAdmin = commissionAdmin;
        this.commissionMicroentrepreneur = commissionMicroentrepreneur;
    }

    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
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

    public String getAdresseFacturation() {
        return adresseFacturation;
    }

    public void setAdresseFacturation(String adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }

    public BigDecimal getCommissionAdmin() {
        return commissionAdmin;
    }

    public void setCommissionAdmin(BigDecimal commissionAdmin) {
        this.commissionAdmin = commissionAdmin;
    }

    public BigDecimal getCommissionMicroentrepreneur() {
        return commissionMicroentrepreneur;
    }

    public void setCommissionMicroentrepreneur(BigDecimal commissionMicroentrepreneur) {
        this.commissionMicroentrepreneur = commissionMicroentrepreneur;
    }

    public Commande getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Commande idCommande) {
        this.idCommande = idCommande;
    }

    public Tva getIdTva() {
        return idTva;
    }

    public void setIdTva(Tva idTva) {
        this.idTva = idTva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacture != null ? idFacture.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facture)) {
            return false;
        }
        Facture other = (Facture) object;
        if ((this.idFacture == null && other.idFacture != null) || (this.idFacture != null && !this.idFacture.equals(other.idFacture))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mgw.domaine_lavage_auto.class_util.Facture[ idFacture=" + idFacture + " ]";
    }
    
}
