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
@Table(name = "imagenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagenes.findAll", query = "SELECT i FROM Imagenes i"),
    @NamedQuery(name = "Imagenes.findByIdImagen", query = "SELECT i FROM Imagenes i WHERE i.idImagen = :idImagen"),
    @NamedQuery(name = "Imagenes.findByNombre", query = "SELECT i FROM Imagenes i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Imagenes.findByRuta", query = "SELECT i FROM Imagenes i WHERE i.ruta = :ruta"),
    @NamedQuery(name = "Imagenes.findByFormato", query = "SELECT i FROM Imagenes i WHERE i.formato = :formato"),
    @NamedQuery(name = "Imagenes.findByTama\u00f1o", query = "SELECT i FROM Imagenes i WHERE i.tama\u00f1o = :tama\u00f1o")})
public class Imagenes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idImagen")
    private Integer idImagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ruta")
    private String ruta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "formato")
    private String formato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tama\u00f1o")
    private String tamaño;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imagenes")
    private Collection<Capturas> capturasCollection;

    public Imagenes() {
    }

    public Imagenes(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public Imagenes(Integer idImagen, String nombre, String ruta, String formato, String tamaño) {
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.ruta = ruta;
        this.formato = formato;
        this.tamaño = tamaño;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
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
        hash += (idImagen != null ? idImagen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagenes)) {
            return false;
        }
        Imagenes other = (Imagenes) object;
        if ((this.idImagen == null && other.idImagen != null) || (this.idImagen != null && !this.idImagen.equals(other.idImagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Imagenes[ idImagen=" + idImagen + " ]";
    }
    
}
