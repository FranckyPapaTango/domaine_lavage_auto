/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgw.domaine_lavage_auto.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 *
 * @author BigWave
 */
@Entity
@Table(name = "commande", catalog = "lavage_auto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
    , @NamedQuery(name = "Commande.findByIdCommande", query = "SELECT c FROM Commande c WHERE c.idCommande = :idCommande")
    , @NamedQuery(name = "Commande.findByCssRawColorCode", query = "SELECT c FROM Commande c WHERE c.cssRawColorCode = :cssRawColorCode")
    , @NamedQuery(name = "Commande.findByDatePersistence", query = "SELECT c FROM Commande c WHERE c.datePersistence = :datePersistence")
    , @NamedQuery(name = "Commande.findByUpdatedVersionDate", query = "SELECT c FROM Commande c WHERE c.updatedVersionDate = :updatedVersionDate")
    , @NamedQuery(name = "Commande.findByAdresseStationnement", query = "SELECT c FROM Commande c WHERE c.adresseStationnement = :adresseStationnement")
    , @NamedQuery(name = "Commande.findByCodePostaleSt", query = "SELECT c FROM Commande c WHERE c.codePostaleSt = :codePostaleSt")
    , @NamedQuery(name = "Commande.findByCouleur", query = "SELECT c FROM Commande c WHERE c.couleur = :couleur")
    , @NamedQuery(name = "Commande.findByCreneauHoraireF", query = "SELECT c FROM Commande c WHERE c.creneauHoraireF = :creneauHoraireF")
    , @NamedQuery(name = "Commande.findByCreneauHoraireI", query = "SELECT c FROM Commande c WHERE c.creneauHoraireI = :creneauHoraireI")
    , @NamedQuery(name = "Commande.findByDateLavage", query = "SELECT c FROM Commande c WHERE c.dateLavage = :dateLavage")
    , @NamedQuery(name = "Commande.findByDone", query = "SELECT c FROM Commande c WHERE c.done = :done")
    , @NamedQuery(name = "Commande.findByHandled", query = "SELECT c FROM Commande c WHERE c.handled = :handled")
    , @NamedQuery(name = "Commande.findByImmatriculationVehicule", query = "SELECT c FROM Commande c WHERE c.immatriculationVehicule = :immatriculationVehicule")
    , @NamedQuery(name = "Commande.findByMarqueType", query = "SELECT c FROM Commande c WHERE c.marqueType = :marqueType")
    , @NamedQuery(name = "Commande.findByVilleSt", query = "SELECT c FROM Commande c WHERE c.villeSt = :villeSt")})
@NamedNativeQueries({
    @NamedNativeQuery(name = "Commande.findCommandeByKeyWord",
            query = "SELECT * FROM commande WHERE ADRESSE_STATIONNEMENT like CONCAT('%', :search, '%') OR code_postale_st like CONCAT('%', :search, '%') "
            + "OR ville_st like CONCAT('%', :search, '%') ",
            resultClass = Commande.class)
    ,
    @NamedNativeQuery(name = "Commande.findCommandeOfLaveurByKeyWord",
            query = "SELECT * FROM commande WHERE (ID_LAVEUR = :id OR HANDLED =0) AND (ADRESSE_STATIONNEMENT like CONCAT('%', :search, '%') OR code_postale_st like CONCAT('%', :search, '%') "
            + "OR ville_st like CONCAT('%', :search, '%') )",
            resultClass = Commande.class)
    ,
    @NamedNativeQuery(name = "Commande.findAllCommandeOfLaveur",
            query = "SELECT * FROM commande WHERE ID_LAVEUR = :id OR HANDLED =0",
            resultClass = Commande.class)
})
public class Commande extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_commande")
    private Long idCommande;
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
    @Size(min = 1, max = 50)
    @Column(name = "adresse_stationnement")
    private String adresseStationnement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "code_postale_st")
    private String codePostaleSt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "couleur")
    private String couleur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creneau_horaire_f")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "HH:mm", iso = ISO.DATE)// AJOUT APRES GENERATION
    private Date creneauHoraireF;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creneau_horaire_i")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "HH:mm", iso = ISO.DATE)// AJOUT APRES GENERATION
    private Date creneauHoraireI;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_lavage")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = ISO.DATE)// AJOUT APRES GENERATION
    private Date dateLavage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "done")
    private boolean done;
    @Basic(optional = false)
    @NotNull
    @Column(name = "handled")
    private boolean handled;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "immatriculation_vehicule")
    private String immatriculationVehicule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "marque_type")
    private String marqueType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "ville_st")
    private String villeSt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCommande")
    private Collection<Facture> factureCollection;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne(optional = false)
    private Client idClient;
    @JoinColumn(name = "id_laveur", referencedColumnName = "id_laveur")
    @ManyToOne
    private Laveur idLaveur;
    @JoinColumn(name = "id_prestation", referencedColumnName = "id_prestation")
    @ManyToOne(optional = false)
    private Prestation idPrestation;

    public Commande() {
    }

    public Commande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Commande(Long idCommande, //String cssRawColorCode, 
            String adresseStationnement, String codePostaleSt, String couleur, Date creneauHoraireF, Date creneauHoraireI, Date dateLavage, boolean done, boolean handled, String immatriculationVehicule, String marqueType, String villeSt) {
        this.idCommande = idCommande;
//        this.cssRawColorCode = cssRawColorCode;
        this.adresseStationnement = adresseStationnement;
        this.codePostaleSt = codePostaleSt;
        this.couleur = couleur;
        this.creneauHoraireF = creneauHoraireF;
        this.creneauHoraireI = creneauHoraireI;
        this.dateLavage = dateLavage;
        this.done = done;
        this.handled = handled;
        this.immatriculationVehicule = immatriculationVehicule;
        this.marqueType = marqueType;
        this.villeSt = villeSt;
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
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

    public String getAdresseStationnement() {
        return adresseStationnement;
    }

    public void setAdresseStationnement(String adresseStationnement) {
        this.adresseStationnement = adresseStationnement;
    }

    public String getCodePostaleSt() {
        return codePostaleSt;
    }

    public void setCodePostaleSt(String codePostaleSt) {
        this.codePostaleSt = codePostaleSt;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Date getCreneauHoraireF() {
        return creneauHoraireF;
    }

    public void setCreneauHoraireF(Date creneauHoraireF) {
        this.creneauHoraireF = creneauHoraireF;
    }

    public Date getCreneauHoraireI() {
        return creneauHoraireI;
    }

    public void setCreneauHoraireI(Date creneauHoraireI) {
        this.creneauHoraireI = creneauHoraireI;
    }

    public Date getDateLavage() {
        return dateLavage;
    }

    public void setDateLavage(Date dateLavage) {
        this.dateLavage = dateLavage;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean getHandled() {
        return handled;
    }

    public void setHandled(boolean handled) {
        this.handled = handled;
    }

    public String getImmatriculationVehicule() {
        return immatriculationVehicule;
    }

    public void setImmatriculationVehicule(String immatriculationVehicule) {
        this.immatriculationVehicule = immatriculationVehicule;
    }

    public String getMarqueType() {
        return marqueType;
    }

    public void setMarqueType(String marqueType) {
        this.marqueType = marqueType;
    }

    public String getVilleSt() {
        return villeSt;
    }

    public void setVilleSt(String villeSt) {
        this.villeSt = villeSt;
    }

    @XmlTransient
    public Collection<Facture> getFactureCollection() {
        return factureCollection;
    }

    public void setFactureCollection(Collection<Facture> factureCollection) {
        this.factureCollection = factureCollection;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Laveur getIdLaveur() {
        return idLaveur;
    }

    public void setIdLaveur(Laveur idLaveur) {
        this.idLaveur = idLaveur;
    }

    public Prestation getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(Prestation idPrestation) {
        this.idPrestation = idPrestation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommande != null ? idCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idCommande == null && other.idCommande != null) || (this.idCommande != null && !this.idCommande.equals(other.idCommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mgw.domaine_lavage_auto.class_util.Commande[ idCommande=" + idCommande + " ]";
    }
    
}
