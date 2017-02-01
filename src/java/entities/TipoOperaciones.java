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
@Table(name = "tipo_operaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoOperaciones.findAll", query = "SELECT t FROM TipoOperaciones t")
    , @NamedQuery(name = "TipoOperaciones.findByIdTipooperacion", query = "SELECT t FROM TipoOperaciones t WHERE t.idTipooperacion = :idTipooperacion")
    , @NamedQuery(name = "TipoOperaciones.findByNombre", query = "SELECT t FROM TipoOperaciones t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoOperaciones.findByDescripcion", query = "SELECT t FROM TipoOperaciones t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TipoOperaciones.findByCodigo", query = "SELECT t FROM TipoOperaciones t WHERE t.codigo = :codigo")})
public class TipoOperaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipo_operacion")
    private Integer idTipooperacion;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo")
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoOperacion")
    private Collection<Operaciones> operacionesCollection;

    public TipoOperaciones() {
    }

    public TipoOperaciones(Integer idTipooperacion) {
        this.idTipooperacion = idTipooperacion;
    }

    public TipoOperaciones(Integer idTipooperacion, String codigo) {
        this.idTipooperacion = idTipooperacion;
        this.codigo = codigo;
    }

    public Integer getIdTipooperacion() {
        return idTipooperacion;
    }

    public void setIdTipooperacion(Integer idTipooperacion) {
        this.idTipooperacion = idTipooperacion;
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
    public Collection<Operaciones> getOperacionesCollection() {
        return operacionesCollection;
    }

    public void setOperacionesCollection(Collection<Operaciones> operacionesCollection) {
        this.operacionesCollection = operacionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipooperacion != null ? idTipooperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoOperaciones)) {
            return false;
        }
        TipoOperaciones other = (TipoOperaciones) object;
        if ((this.idTipooperacion == null && other.idTipooperacion != null) || (this.idTipooperacion != null && !this.idTipooperacion.equals(other.idTipooperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoOperaciones[ idTipooperacion=" + idTipooperacion + " ]";
    }
    
}
