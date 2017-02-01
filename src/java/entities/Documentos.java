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
@Table(name = "documentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentos.findAll", query = "SELECT d FROM Documentos d"),
    @NamedQuery(name = "Documentos.findByIdDocumentos", query = "SELECT d FROM Documentos d WHERE d.idDocumentos = :idDocumentos"),
    @NamedQuery(name = "Documentos.findByNombre", query = "SELECT d FROM Documentos d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Documentos.findByDescripcion", query = "SELECT d FROM Documentos d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Documentos.findByEstado", query = "SELECT d FROM Documentos d WHERE d.estado = :estado")})
public class Documentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDocumentos")
    private Integer idDocumentos;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkDocumento")
    private Collection<Capturas> capturasCollection;

    public Documentos() {
    }

    public Documentos(Integer idDocumentos) {
        this.idDocumentos = idDocumentos;
    }

    public Documentos(Integer idDocumentos, String nombre, String estado) {
        this.idDocumentos = idDocumentos;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdDocumentos() {
        return idDocumentos;
    }

    public void setIdDocumentos(Integer idDocumentos) {
        this.idDocumentos = idDocumentos;
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

    @XmlTransient
    public Collection<Capturas> getCapturasCollection() {
        return capturasCollection;
    }

    public void setCapturasCollection(Collection<Capturas> capturasCollection) {
        this.capturasCollection = capturasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumentos != null ? idDocumentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentos)) {
            return false;
        }
        Documentos other = (Documentos) object;
        if ((this.idDocumentos == null && other.idDocumentos != null) || (this.idDocumentos != null && !this.idDocumentos.equals(other.idDocumentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Documentos[ idDocumentos=" + idDocumentos + " ]";
    }
    
}
