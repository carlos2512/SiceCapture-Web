/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author c_rom
 */
@Entity
@Table(name = "identidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Identidad.findAll", query = "SELECT i FROM Identidad i")
    , @NamedQuery(name = "Identidad.findByFkPersona", query = "SELECT i FROM Identidad i WHERE i.identidadPK.fkPersona = :fkPersona")
    , @NamedQuery(name = "Identidad.findByFkUsuario", query = "SELECT i FROM Identidad i WHERE i.identidadPK.fkUsuario = :fkUsuario")})
public class Identidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IdentidadPK identidadPK;
    @JoinColumn(name = "fkPerfil", referencedColumnName = "idPerfiles")
    @ManyToOne
    private Perfiles fkPerfil;
    @JoinColumn(name = "fkPersona", referencedColumnName = "idPersona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "fkUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Identidad() {
    }

    public Identidad(IdentidadPK identidadPK) {
        this.identidadPK = identidadPK;
    }

    public Identidad(int fkPersona, int fkUsuario) {
        this.identidadPK = new IdentidadPK(fkPersona, fkUsuario);
    }

    public IdentidadPK getIdentidadPK() {
        return identidadPK;
    }

    public void setIdentidadPK(IdentidadPK identidadPK) {
        this.identidadPK = identidadPK;
    }

    public Perfiles getFkPerfil() {
        return fkPerfil;
    }

    public void setFkPerfil(Perfiles fkPerfil) {
        this.fkPerfil = fkPerfil;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identidadPK != null ? identidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Identidad)) {
            return false;
        }
        Identidad other = (Identidad) object;
        if ((this.identidadPK == null && other.identidadPK != null) || (this.identidadPK != null && !this.identidadPK.equals(other.identidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Identidad[ identidadPK=" + identidadPK + " ]";
    }
    
}
