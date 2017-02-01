/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author intec
 */
@Embeddable
public class CapturasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_persona")
    private int fkPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_imagen")
    private int fkImagen;

    public CapturasPK() {
    }

    public CapturasPK(int fkPersona, int fkImagen) {
        this.fkPersona = fkPersona;
        this.fkImagen = fkImagen;
    }

    public int getFkPersona() {
        return fkPersona;
    }

    public void setFkPersona(int fkPersona) {
        this.fkPersona = fkPersona;
    }

    public int getFkImagen() {
        return fkImagen;
    }

    public void setFkImagen(int fkImagen) {
        this.fkImagen = fkImagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fkPersona;
        hash += (int) fkImagen;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapturasPK)) {
            return false;
        }
        CapturasPK other = (CapturasPK) object;
        if (this.fkPersona != other.fkPersona) {
            return false;
        }
        if (this.fkImagen != other.fkImagen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CapturasPK[ fkPersona=" + fkPersona + ", fkImagen=" + fkImagen + " ]";
    }
    
}
