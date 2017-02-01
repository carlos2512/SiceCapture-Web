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
 * @author intec
 */
@Entity
@Table(name = "metaexpedientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Metaexpedientes.findAll", query = "SELECT m FROM Metaexpedientes m"),
    @NamedQuery(name = "Metaexpedientes.findByIdmetaexpediente", query = "SELECT m FROM Metaexpedientes m WHERE m.idmetaexpediente = :idmetaexpediente"),
    @NamedQuery(name = "Metaexpedientes.findByNombre", query = "SELECT m FROM Metaexpedientes m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Metaexpedientes.findByDescripcion", query = "SELECT m FROM Metaexpedientes m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Metaexpedientes.findByEstado", query = "SELECT m FROM Metaexpedientes m WHERE m.estado = :estado"),
    @NamedQuery(name = "Metaexpedientes.findByCodigo", query = "SELECT m FROM Metaexpedientes m WHERE m.codigo = :codigo")})
public class Metaexpedientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmetaexpediente")
    private Integer idmetaexpediente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo")
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkMetaexpediente")
    private Collection<Categorias> categoriasCollection;

    public Metaexpedientes() {
    }

    public Metaexpedientes(Integer idmetaexpediente) {
        this.idmetaexpediente = idmetaexpediente;
    }

    public Metaexpedientes(Integer idmetaexpediente, String nombre, String estado, String codigo) {
        this.idmetaexpediente = idmetaexpediente;
        this.nombre = nombre;
        this.estado = estado;
        this.codigo = codigo;
    }

    public Integer getIdmetaexpediente() {
        return idmetaexpediente;
    }

    public void setIdmetaexpediente(Integer idmetaexpediente) {
        this.idmetaexpediente = idmetaexpediente;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public Collection<Categorias> getCategoriasCollection() {
        return categoriasCollection;
    }

    public void setCategoriasCollection(Collection<Categorias> categoriasCollection) {
        this.categoriasCollection = categoriasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmetaexpediente != null ? idmetaexpediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Metaexpedientes)) {
            return false;
        }
        Metaexpedientes other = (Metaexpedientes) object;
        if ((this.idmetaexpediente == null && other.idmetaexpediente != null) || (this.idmetaexpediente != null && !this.idmetaexpediente.equals(other.idmetaexpediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Metaexpedientes[ idmetaexpediente=" + idmetaexpediente + " ]";
    }
    
}
