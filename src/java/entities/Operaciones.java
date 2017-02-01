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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "operaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operaciones.findAll", query = "SELECT o FROM Operaciones o")
    , @NamedQuery(name = "Operaciones.findByIdOperaciones", query = "SELECT o FROM Operaciones o WHERE o.idOperaciones = :idOperaciones")
    , @NamedQuery(name = "Operaciones.findByNombre", query = "SELECT o FROM Operaciones o WHERE o.nombre = :nombre")
    , @NamedQuery(name = "Operaciones.findByDescripcion", query = "SELECT o FROM Operaciones o WHERE o.descripcion = :descripcion")
    , @NamedQuery(name = "Operaciones.findByCodigo", query = "SELECT o FROM Operaciones o WHERE o.codigo = :codigo")
    , @NamedQuery(name = "Operaciones.findByUrl", query = "SELECT o FROM Operaciones o WHERE o.url = :url")
    , @NamedQuery(name = "Operaciones.findByEstado", query = "SELECT o FROM Operaciones o WHERE o.estado = :estado")})
public class Operaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOperaciones")
    private Integer idOperaciones;
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
    @Size(max = 45)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @JoinTable(name = "perfiles_operaciones", joinColumns = {
        @JoinColumn(name = "fk_operaciones", referencedColumnName = "idOperaciones")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_perfiles", referencedColumnName = "idPerfiles")})
    @ManyToMany
    private Collection<Perfiles> perfilesCollection;
    @OneToMany(mappedBy = "operacionPadre")
    private Collection<Operaciones> operacionesCollection;
    @JoinColumn(name = "operacion_padre", referencedColumnName = "idOperaciones")
    @ManyToOne
    private Operaciones operacionPadre;
    @JoinColumn(name = "tipo_operacion", referencedColumnName = "idTipo_operacion")
    @ManyToOne(optional = false)
    private TipoOperaciones tipoOperacion;

    public Operaciones() {
    }

    public Operaciones(Integer idOperaciones) {
        this.idOperaciones = idOperaciones;
    }

    public Operaciones(Integer idOperaciones, String codigo, String estado) {
        this.idOperaciones = idOperaciones;
        this.codigo = codigo;
        this.estado = estado;
    }

    public Integer getIdOperaciones() {
        return idOperaciones;
    }

    public void setIdOperaciones(Integer idOperaciones) {
        this.idOperaciones = idOperaciones;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Perfiles> getPerfilesCollection() {
        return perfilesCollection;
    }

    public void setPerfilesCollection(Collection<Perfiles> perfilesCollection) {
        this.perfilesCollection = perfilesCollection;
    }

    @XmlTransient
    public Collection<Operaciones> getOperacionesCollection() {
        return operacionesCollection;
    }

    public void setOperacionesCollection(Collection<Operaciones> operacionesCollection) {
        this.operacionesCollection = operacionesCollection;
    }

    public Operaciones getOperacionPadre() {
        return operacionPadre;
    }

    public void setOperacionPadre(Operaciones operacionPadre) {
        this.operacionPadre = operacionPadre;
    }

    public TipoOperaciones getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(TipoOperaciones tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperaciones != null ? idOperaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operaciones)) {
            return false;
        }
        Operaciones other = (Operaciones) object;
        if ((this.idOperaciones == null && other.idOperaciones != null) || (this.idOperaciones != null && !this.idOperaciones.equals(other.idOperaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Operaciones[ idOperaciones=" + idOperaciones + " ]";
    }
    
}
