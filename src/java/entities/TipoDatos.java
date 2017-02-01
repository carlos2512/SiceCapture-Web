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
@Table(name = "tipo_datos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDatos.findAll", query = "SELECT t FROM TipoDatos t"),
    @NamedQuery(name = "TipoDatos.findByIdTipoDatos", query = "SELECT t FROM TipoDatos t WHERE t.idTipoDatos = :idTipoDatos"),
    @NamedQuery(name = "TipoDatos.findByNombre", query = "SELECT t FROM TipoDatos t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoDatos.findByDescripcion", query = "SELECT t FROM TipoDatos t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoDatos.findByEstado", query = "SELECT t FROM TipoDatos t WHERE t.estado = :estado")})
public class TipoDatos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipo_Datos")
    private Integer idTipoDatos;
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
    @OneToMany(mappedBy = "fkTipodato")
    private Collection<Datos> datosCollection;

    public TipoDatos() {
    }

    public TipoDatos(Integer idTipoDatos) {
        this.idTipoDatos = idTipoDatos;
    }

    public TipoDatos(Integer idTipoDatos, String nombre, String estado) {
        this.idTipoDatos = idTipoDatos;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdTipoDatos() {
        return idTipoDatos;
    }

    public void setIdTipoDatos(Integer idTipoDatos) {
        this.idTipoDatos = idTipoDatos;
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
    public Collection<Datos> getDatosCollection() {
        return datosCollection;
    }

    public void setDatosCollection(Collection<Datos> datosCollection) {
        this.datosCollection = datosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDatos != null ? idTipoDatos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDatos)) {
            return false;
        }
        TipoDatos other = (TipoDatos) object;
        if ((this.idTipoDatos == null && other.idTipoDatos != null) || (this.idTipoDatos != null && !this.idTipoDatos.equals(other.idTipoDatos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoDatos[ idTipoDatos=" + idTipoDatos + " ]";
    }
    
}
