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
@Table(name = "client", catalog = "lavage_auto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient")
    , @NamedQuery(name = "Client.findByCssRawColorCode", query = "SELECT c FROM Client c WHERE c.cssRawColorCode = :cssRawColorCode")
    , @NamedQuery(name = "Client.findByDatePersistence", query = "SELECT c FROM Client c WHERE c.datePersistence = :datePersistence")
    , @NamedQuery(name = "Client.findByUpdatedVersionDate", query = "SELECT c FROM Client c WHERE c.updatedVersionDate = :updatedVersionDate")
    , @NamedQuery(name = "Client.findByCodePostale", query = "SELECT c FROM Client c WHERE c.codePostale = :codePostale")
    , @NamedQuery(name = "Client.findByComplement", query = "SELECT c FROM Client c WHERE c.complement = :complement")
    , @NamedQuery(name = "Client.findByLoginEmail", query = "SELECT c FROM Client c WHERE c.loginEmail = :loginEmail")
    , @NamedQuery(name = "Client.findByNom", query = "SELECT c FROM Client c WHERE c.nom = :nom")
    , @NamedQuery(name = "Client.findByNumVoieTypeVoieLibelleVoie", query = "SELECT c FROM Client c WHERE c.numVoieTypeVoieLibelleVoie = :numVoieTypeVoieLibelleVoie")
    , @NamedQuery(name = "Client.findByPassword", query = "SELECT c FROM Client c WHERE c.password = :password")
    , @NamedQuery(name = "Client.findByPays", query = "SELECT c FROM Client c WHERE c.pays = :pays")
    , @NamedQuery(name = "Client.findByPrenom", query = "SELECT c FROM Client c WHERE c.prenom = :prenom")
    , @NamedQuery(name = "Client.findByStatut", query = "SELECT c FROM Client c WHERE c.statut = :statut")
    , @NamedQuery(name = "Client.findByTelFixe", query = "SELECT c FROM Client c WHERE c.telFixe = :telFixe")
    , @NamedQuery(name = "Client.findByTelMobile", query = "SELECT c FROM Client c WHERE c.telMobile = :telMobile")
    , @NamedQuery(name = "Client.findByVille", query = "SELECT c FROM Client c WHERE c.ville = :ville")})
@NamedNativeQueries({
    @NamedNativeQuery(name = "Client.findClientByLoginEmailAndPassword",
            query = "SELECT * FROM client WHERE login_email=:email AND password=:password",
            resultClass = Client.class)
})
public class Client extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_client")
    private Long idClient;
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
    @Column(name = "code_postale")
    private String codePostale;
    @Size(max = 255)
    @Column(name = "complement")
    private String complement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "login_email")
    private String loginEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "num_voie_type_voie_libelle_voie")
    private String numVoieTypeVoieLibelleVoie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "pays")
    private String pays;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "statut")
    private String statut;
    @Size(max = 255)
    @Column(name = "tel_fixe")
    private String telFixe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tel_mobile")
    private String telMobile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ville")
    private String ville;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private Collection<Commande> commandeCollection;

    public Client() {
    }

    public Client(Long idClient) {
        this.idClient = idClient;
    }

    public Client(Long idClient,// String cssRawColorCode, 
            String codePostale, String loginEmail, String nom, String numVoieTypeVoieLibelleVoie, String password, String pays, String prenom, String statut, String telMobile, String ville) {
        this.idClient = idClient;
//        this.cssRawColorCode = cssRawColorCode;
        this.codePostale = codePostale;
        this.loginEmail = loginEmail;
        this.nom = nom;
        this.numVoieTypeVoieLibelleVoie = numVoieTypeVoieLibelleVoie;
        this.password = password;
        this.pays = pays;
        this.prenom = prenom;
        this.statut = statut;
        this.telMobile = telMobile;
        this.ville = ville;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
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
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idClient;// REDEFINI APRES GENERATION
    }
    
}
