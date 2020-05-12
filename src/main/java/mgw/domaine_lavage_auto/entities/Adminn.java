/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgw.domaine_lavage_auto.entities;

import java.io.Serializable;
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
@Table(name = "adminn", catalog = "lavage_auto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adminn.findAll", query = "SELECT a FROM Adminn a")
    , @NamedQuery(name = "Adminn.findByIdAdminn", query = "SELECT a FROM Adminn a WHERE a.idAdminn = :idAdminn")
    , @NamedQuery(name = "Adminn.findByCssRawColorCode", query = "SELECT a FROM Adminn a WHERE a.cssRawColorCode = :cssRawColorCode")
    , @NamedQuery(name = "Adminn.findByDatePersistence", query = "SELECT a FROM Adminn a WHERE a.datePersistence = :datePersistence")
    , @NamedQuery(name = "Adminn.findByUpdatedVersionDate", query = "SELECT a FROM Adminn a WHERE a.updatedVersionDate = :updatedVersionDate")
    , @NamedQuery(name = "Adminn.findByCodePostale", query = "SELECT a FROM Adminn a WHERE a.codePostale = :codePostale")
    , @NamedQuery(name = "Adminn.findByComplement", query = "SELECT a FROM Adminn a WHERE a.complement = :complement")
    , @NamedQuery(name = "Adminn.findByLoginEmail", query = "SELECT a FROM Adminn a WHERE a.loginEmail = :loginEmail")
    , @NamedQuery(name = "Adminn.findByNom", query = "SELECT a FROM Adminn a WHERE a.nom = :nom")
    , @NamedQuery(name = "Adminn.findByNumVoieTypeVoieLibelleVoie", query = "SELECT a FROM Adminn a WHERE a.numVoieTypeVoieLibelleVoie = :numVoieTypeVoieLibelleVoie")
    , @NamedQuery(name = "Adminn.findByPassword", query = "SELECT a FROM Adminn a WHERE a.password = :password")
    , @NamedQuery(name = "Adminn.findByPays", query = "SELECT a FROM Adminn a WHERE a.pays = :pays")
    , @NamedQuery(name = "Adminn.findByPrenom", query = "SELECT a FROM Adminn a WHERE a.prenom = :prenom")
    , @NamedQuery(name = "Adminn.findByStatut", query = "SELECT a FROM Adminn a WHERE a.statut = :statut")
    , @NamedQuery(name = "Adminn.findByTelFixe", query = "SELECT a FROM Adminn a WHERE a.telFixe = :telFixe")
    , @NamedQuery(name = "Adminn.findByTelMobile", query = "SELECT a FROM Adminn a WHERE a.telMobile = :telMobile")
    , @NamedQuery(name = "Adminn.findByVille", query = "SELECT a FROM Adminn a WHERE a.ville = :ville")})
@NamedNativeQueries({
    @NamedNativeQuery(name = "Adminn.findAdminByLoginEmailAndPassword",
            query = "SELECT * FROM adminn WHERE login_email=:email AND password=:password",
            resultClass = Adminn.class)
})
public class Adminn extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_adminn")
    private Long idAdminn;
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

    public Adminn() {
    }

    public Adminn(Long idAdminn) {
        this.idAdminn = idAdminn;
    }

    public Adminn(Long idAdminn,// String cssRawColorCode, 
            String codePostale, String loginEmail, String nom, String numVoieTypeVoieLibelleVoie, String password, String prenom, String statut, String telMobile, String ville) {
        this.idAdminn = idAdminn;
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

    public Long getIdAdminn() {
        return idAdminn;
    }

    public void setIdAdminn(Long idAdminn) {
        this.idAdminn = idAdminn;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdminn != null ? idAdminn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adminn)) {
            return false;
        }
        Adminn other = (Adminn) object;
        if ((this.idAdminn == null && other.idAdminn != null) || (this.idAdminn != null && !this.idAdminn.equals(other.idAdminn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mgw.domaine_lavage_auto.class_util.Adminn[ idAdminn=" + idAdminn + " ]";
    }
    
}
