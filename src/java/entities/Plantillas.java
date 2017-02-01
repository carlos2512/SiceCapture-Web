/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author intec
 */
@Entity
@Table(name = "plantillas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plantillas.findAll", query = "SELECT p FROM Plantillas p"),
    @NamedQuery(name = "Plantillas.findByIdPlantillas", query = "SELECT p FROM Plantillas p WHERE p.idPlantillas = :idPlantillas"),
    @NamedQuery(name = "Plantillas.findByNombre", query = "SELECT p FROM Plantillas p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Plantillas.findByDescripcion", query = "SELECT p FROM Plantillas p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Plantillas.findByEstado", query = "SELECT p FROM Plantillas p WHERE p.estado = :estado")})
public class Plantillas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlantillas")
    private Integer idPlantillas;
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
    @JoinColumn(name = "fk_categoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private Categorias fkCategoria;

    public Plantillas() {
    }

    public Plantillas(Integer idPlantillas) {
        this.idPlantillas = idPlantillas;
    }

    public Plantillas(Integer idPlantillas, String nombre, String estado) {
        this.idPlantillas = idPlantillas;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdPlantillas() {
        return idPlantillas;
    }

    public void setIdPlantillas(Integer idPlantillas) {
        this.idPlantillas = idPlantillas;
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

    public Categorias getFkCategoria() {
        return fkCategoria;
    }

    public void setFkCategoria(Categorias fkCategoria) {
        this.fkCategoria = fkCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlantillas != null ? idPlantillas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plantillas)) {
            return false;
        }
        Plantillas other = (Plantillas) object;
        if ((this.idPlantillas == null && other.idPlantillas != null) || (this.idPlantillas != null && !this.idPlantillas.equals(other.idPlantillas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Plantillas[ idPlantillas=" + idPlantillas + " ]";
    }
    
}
