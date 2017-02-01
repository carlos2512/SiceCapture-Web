/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author c_rom
 */
@Entity
@Table(name = "perfiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfiles.findAll", query = "SELECT p FROM Perfiles p")
    , @NamedQuery(name = "Perfiles.findByIdPerfiles", query = "SELECT p FROM Perfiles p WHERE p.idPerfiles = :idPerfiles")
    , @NamedQuery(name = "Perfiles.findByNombre", query = "SELECT p FROM Perfiles p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Perfiles.findByEstado", query = "SELECT p FROM Perfiles p WHERE p.estado = :estado")
    , @NamedQuery(name = "Perfiles.findByIdioma", query = "SELECT p FROM Perfiles p WHERE p.idioma = :idioma")
    , @NamedQuery(name = "Perfiles.findByEstilo", query = "SELECT p FROM Perfiles p WHERE p.estilo = :estilo")})
public class Perfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPerfiles")
    private Integer idPerfiles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idioma")
    private String idioma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estilo")
    private String estilo;
    @ManyToMany(mappedBy = "perfilesCollection",fetch = FetchType.EAGER)
    private Collection<Operaciones> operacionesCollection;
    @OneToMany(mappedBy = "perfilPadre")
    private Collection<Perfiles> perfilesCollection;
    @JoinColumn(name = "perfil_padre", referencedColumnName = "idPerfiles")
    @ManyToOne
    private Perfiles perfilPadre;
    @JoinColumn(name = "tipo_perfil", referencedColumnName = "idTipo_Perfiles")
    @ManyToOne(optional = false)
    private TipoPerfiles tipoPerfil;
    @OneToMany(mappedBy = "fkPerfil")
    private Collection<Identidad> identidadCollection;

    public Perfiles() {
    }

    public Perfiles(Integer idPerfiles) {
        this.idPerfiles = idPerfiles;
    }

    public Perfiles(Integer idPerfiles, String nombre, String estado, String idioma, String estilo) {
        this.idPerfiles = idPerfiles;
        this.nombre = nombre;
        this.estado = estado;
        this.idioma = idioma;
        this.estilo = estilo;
    }

    public Integer getIdPerfiles() {
        return idPerfiles;
    }

    public void setIdPerfiles(Integer idPerfiles) {
        this.idPerfiles = idPerfiles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    @XmlTransient
    public Collection<Operaciones> getOperacionesCollection() {
        return operacionesCollection;
    }

    public void setOperacionesCollection(Collection<Operaciones> operacionesCollection) {
        this.operacionesCollection = operacionesCollection;
    }

    @XmlTransient
    public Collection<Perfiles> getPerfilesCollection() {
        return perfilesCollection;
    }

    public void setPerfilesCollection(Collection<Perfiles> perfilesCollection) {
        this.perfilesCollection = perfilesCollection;
    }

    public Perfiles getPerfilPadre() {
        return perfilPadre;
    }

    public void setPerfilPadre(Perfiles perfilPadre) {
        this.perfilPadre = perfilPadre;
    }

    public TipoPerfiles getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfiles tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    @XmlTransient
    public Collection<Identidad> getIdentidadCollection() {
        return identidadCollection;
    }

    public void setIdentidadCollection(Collection<Identidad> identidadCollection) {
        this.identidadCollection = identidadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfiles != null ? idPerfiles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfiles)) {
            return false;
        }
        Perfiles other = (Perfiles) object;
        if ((this.idPerfiles == null && other.idPerfiles != null) || (this.idPerfiles != null && !this.idPerfiles.equals(other.idPerfiles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Perfiles[ idPerfiles=" + idPerfiles + " ]";
    }
    
}
