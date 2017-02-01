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
 * @author intec
 */
@Entity
@Table(name = "datos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datos.findAll", query = "SELECT d FROM Datos d"),
    @NamedQuery(name = "Datos.findByIdDatos", query = "SELECT d FROM Datos d WHERE d.idDatos = :idDatos"),
    @NamedQuery(name = "Datos.findByNombre", query = "SELECT d FROM Datos d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Datos.findByDescripcion", query = "SELECT d FROM Datos d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Datos.findByEstado", query = "SELECT d FROM Datos d WHERE d.estado = :estado")})
public class Datos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDatos")
    private Integer idDatos;
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
    @OneToMany(mappedBy = "fkDato")
    private Collection<Capturas> capturasCollection;
    @JoinColumn(name = "fk_tipodato", referencedColumnName = "idTipo_Datos")
    @ManyToOne
    private TipoDatos fkTipodato;

    public Datos() {
    }

    public Datos(Integer idDatos) {
        this.idDatos = idDatos;
    }

    public Datos(Integer idDatos, String nombre, String estado) {
        this.idDatos = idDatos;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdDatos() {
        return idDatos;
    }

    public void setIdDatos(Integer idDatos) {
        this.idDatos = idDatos;
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

    public TipoDatos getFkTipodato() {
        return fkTipodato;
    }

    public void setFkTipodato(TipoDatos fkTipodato) {
        this.fkTipodato = fkTipodato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDatos != null ? idDatos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datos)) {
            return false;
        }
        Datos other = (Datos) object;
        if ((this.idDatos == null && other.idDatos != null) || (this.idDatos != null && !this.idDatos.equals(other.idDatos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Datos[ idDatos=" + idDatos + " ]";
    }
    
}
