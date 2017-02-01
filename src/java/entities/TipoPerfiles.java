/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author c_rom
 */
@Entity
@Table(name = "tipo_perfiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPerfiles.findAll", query = "SELECT t FROM TipoPerfiles t")
    , @NamedQuery(name = "TipoPerfiles.findByIdTipoPerfiles", query = "SELECT t FROM TipoPerfiles t WHERE t.idTipoPerfiles = :idTipoPerfiles")
    , @NamedQuery(name = "TipoPerfiles.findByNombre", query = "SELECT t FROM TipoPerfiles t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoPerfiles.findByDescripcion", query = "SELECT t FROM TipoPerfiles t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TipoPerfiles.findByCodigo", query = "SELECT t FROM TipoPerfiles t WHERE t.codigo = :codigo")})
public class TipoPerfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipo_Perfiles")
    private Integer idTipoPerfiles;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo")
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPerfil")
    private Collection<Perfiles> perfilesCollection;

    public TipoPerfiles() {
    }

    public TipoPerfiles(Integer idTipoPerfiles) {
        this.idTipoPerfiles = idTipoPerfiles;
    }

    public TipoPerfiles(Integer idTipoPerfiles, String codigo) {
        this.idTipoPerfiles = idTipoPerfiles;
        this.codigo = codigo;
    }

    public Integer getIdTipoPerfiles() {
        return idTipoPerfiles;
    }

    public void setIdTipoPerfiles(Integer idTipoPerfiles) {
        this.idTipoPerfiles = idTipoPerfiles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public Collection<Perfiles> getPerfilesCollection() {
        return perfilesCollection;
    }

    public void setPerfilesCollection(Collection<Perfiles> perfilesCollection) {
        this.perfilesCollection = perfilesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPerfiles != null ? idTipoPerfiles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPerfiles)) {
            return false;
        }
        TipoPerfiles other = (TipoPerfiles) object;
        if ((this.idTipoPerfiles == null && other.idTipoPerfiles != null) || (this.idTipoPerfiles != null && !this.idTipoPerfiles.equals(other.idTipoPerfiles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoPerfiles[ idTipoPerfiles=" + idTipoPerfiles + " ]";
    }
    
}
