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
 * @author c_rom
 */
@Embeddable
public class IdentidadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fkPersona")
    private int fkPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fkUsuario")
    private int fkUsuario;

    public IdentidadPK() {
    }

    public IdentidadPK(int fkPersona, int fkUsuario) {
        this.fkPersona = fkPersona;
        this.fkUsuario = fkUsuario;
    }

    public int getFkPersona() {
        return fkPersona;
    }

    public void setFkPersona(int fkPersona) {
        this.fkPersona = fkPersona;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fkPersona;
        hash += (int) fkUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentidadPK)) {
            return false;
        }
        IdentidadPK other = (IdentidadPK) object;
        if (this.fkPersona != other.fkPersona) {
            return false;
        }
        if (this.fkUsuario != other.fkUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.IdentidadPK[ fkPersona=" + fkPersona + ", fkUsuario=" + fkUsuario + " ]";
    }
    
}
