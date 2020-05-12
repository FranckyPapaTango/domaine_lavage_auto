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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

/**
 *
 * @author BigWave
 */
@Entity
@Table(name = "laveur", catalog = "lavage_auto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laveur.findAll", query = "SELECT l FROM Laveur l")
    , @NamedQuery(name = "Laveur.findByIdLaveur", query = "SELECT l FROM Laveur l WHERE l.idLaveur = :idLaveur")
    , @NamedQuery(name = "Laveur.findByCssRawColorCode", query = "SELECT l FROM Laveur l WHERE l.cssRawColorCode = :cssRawColorCode")
    , @NamedQuery(name = "Laveur.findByDatePersistence", query = "SELECT l FROM Laveur l WHERE l.datePersistence = :datePersistence")
    , @NamedQuery(name = "Laveur.findByUpdatedVersionDate", query = "SELECT l FROM Laveur l WHERE l.updatedVersionDate = :updatedVersionDate")
    , @NamedQuery(name = "Laveur.findByCodePostale", query = "SELECT l FROM Laveur l WHERE l.codePostale = :codePostale")
    , @NamedQuery(name = "Laveur.findByComplement", query = "SELECT l FROM Laveur l WHERE l.complement = :complement")
    , @NamedQuery(name = "Laveur.findByLoginEmail", query = "SELECT l FROM Laveur l WHERE l.loginEmail = :loginEmail")
    , @NamedQuery(name = "Laveur.findByNom", query = "SELECT l FROM Laveur l WHERE l.nom = :nom")
    , @NamedQuery(name = "Laveur.findByNumVoieTypeVoieLibelleVoie", query = "SELECT l FROM Laveur l WHERE l.numVoieTypeVoieLibelleVoie = :numVoieTypeVoieLibelleVoie")
    , @NamedQuery(name = "Laveur.findByPassword", query = "SELECT l FROM Laveur l WHERE l.password = :password")
    , @NamedQuery(name = "Laveur.findByPays", query = "SELECT l FROM Laveur l WHERE l.pays = :pays")
    , @NamedQuery(name = "Laveur.findByPrenom", query = "SELECT l FROM Laveur l WHERE l.prenom = :prenom")
    , @NamedQuery(name = "Laveur.findByStatut", query = "SELECT l FROM Laveur l WHERE l.statut = :statut")
    , @NamedQuery(name = "Laveur.findByTelFixe", query = "SELECT l FROM Laveur l WHERE l.telFixe = :telFixe")
    , @NamedQuery(name = "Laveur.findByTelMobile", query = "SELECT l FROM Laveur l WHERE l.telMobile = :telMobile")
    , @NamedQuery(name = "Laveur.findByVille", query = "SELECT l FROM Laveur l WHERE l.ville = :ville")})
@NamedNativeQueries({
    @NamedNativeQuery(name = "Laveur.findLaveurByLoginEmailAndPassword",
            query = "SELECT * FROM laveur WHERE login_email=:email AND password=:password",
            resultClass = Laveur.class)
})
public class Laveur extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_laveur")
    private Long idLaveur;
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
    @Size(min = 1, max = 20)
    @Column(name = "code_postale")
    private String codePostale;
    @Size(max = 100)
    @Column(name = "complement")
    private String complement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "login_email")
    private String loginEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "num_voie_type_voie_libelle_voie")
    private String numVoieTypeVoieLibelleVoie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "password")
    private String password;
    @Size(max = 20)
    @Column(name = "pays")
    private String pays;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "statut")
    private String statut;
    @Size(max = 30)
    @Column(name = "tel_fixe")
    private String telFixe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tel_mobile")
    private String telMobile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "ville")
    private String ville;
    @OneToMany(mappedBy = "idLaveur")
    private Collection<Commande> commandeCollection;

    public Laveur() {
    }

    public Laveur(Long idLaveur) {
        this.idLaveur = idLaveur;
    }

    public Laveur(Long idLaveur,// String cssRawColorCode, 
            String codePostale, String loginEmail, String nom, String numVoieTypeVoieLibelleVoie, String password, String prenom, String statut, String telMobile, String ville) {
        this.idLaveur = idLaveur;
//        this.cssRawColorCode = cssRawColorCode;
        this.codePostale = codePostale;
        this.loginEmail = loginEmail;
        this.nom = nom;
        this.numVoieTypeVoieLibelleVoie = numVoieTypeVoieLibelleVoie;
        this.password = password;
        this.prenom = prenom;
        this.statut = statut;
        this.telMobile = telMobile;
        this.ville = ville;
    }

    public Long getIdLaveur() {
        return idLaveur;
    }

    public void setIdLaveur(Long idLaveur) {
        this.idLaveur = idLaveur;
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

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumVoieTypeVoieLibelleVoie() {
        return numVoieTypeVoieLibelleVoie;
    }

    public void setNumVoieTypeVoieLibelleVoie(String numVoieTypeVoieLibelleVoie) {
        this.numVoieTypeVoieLibelleVoie = numVoieTypeVoieLibelleVoie;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getTelFixe() {
        return telFixe;
    }

    public void setTelFixe(String telFixe) {
        this.telFixe = telFixe;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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
        hash += (idLaveur != null ? idLaveur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laveur)) {
            return false;
        }
        Laveur other = (Laveur) object;
        if ((this.idLaveur == null && other.idLaveur != null) || (this.idLaveur != null && !this.idLaveur.equals(other.idLaveur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mgw.domaine_lavage_auto.class_util.Laveur[ idLaveur=" + idLaveur + " ]";
    }
    
}
