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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author intec
 */
@Entity
@Table(name = "estructuras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estructuras.findAll", query = "SELECT e FROM Estructuras e"),
    @NamedQuery(name = "Estructuras.findByFkPlantilla", query = "SELECT e FROM Estructuras e WHERE e.fkPlantilla = :fkPlantilla"),
    @NamedQuery(name = "Estructuras.findByFkDocumento", query = "SELECT e FROM Estructuras e WHERE e.fkDocumento = :fkDocumento"),
    @NamedQuery(name = "Estructuras.findByFkDatos", query = "SELECT e FROM Estructuras e WHERE e.fkDatos = :fkDatos"),
    @NamedQuery(name = "Estructuras.findByIdEstructura", query = "SELECT e FROM Estructuras e WHERE e.idEstructura = :idEstructura")})
public class Estructuras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_plantilla")
    private int fkPlantilla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_documento")
    private int fkDocumento;
    @Column(name = "fk_datos")
    private Integer fkDatos;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstructura")
    private Integer idEstructura;

    public Estructuras() {
    }

    public Estructuras(Integer idEstructura) {
        this.idEstructura = idEstructura;
    }

    public Estructuras(Integer idEstructura, int fkPlantilla, int fkDocumento) {
        this.idEstructura = idEstructura;
        this.fkPlantilla = fkPlantilla;
        this.fkDocumento = fkDocumento;
    }

    public int getFkPlantilla() {
        return fkPlantilla;
    }

    public void setFkPlantilla(int fkPlantilla) {
        this.fkPlantilla = fkPlantilla;
    }

    public int getFkDocumento() {
        return fkDocumento;
    }

    public void setFkDocumento(int fkDocumento) {
        this.fkDocumento = fkDocumento;
    }

    public Integer getFkDatos() {
        return fkDatos;
    }

    public void setFkDatos(Integer fkDatos) {
        this.fkDatos = fkDatos;
    }

    public Integer getIdEstructura() {
        return idEstructura;
    }

    public void setIdEstructura(Integer idEstructura) {
        this.idEstructura = idEstructura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstructura != null ? idEstructura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estructuras)) {
            return false;
        }
        Estructuras other = (Estructuras) object;
        if ((this.idEstructura == null && other.idEstructura != null) || (this.idEstructura != null && !this.idEstructura.equals(other.idEstructura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Estructuras[ idEstructura=" + idEstructura + " ]";
    }
    
}
