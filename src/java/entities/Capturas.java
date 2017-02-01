/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author intec
 */
@Entity
@Table(name = "capturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capturas.findAll", query = "SELECT c FROM Capturas c"),
    @NamedQuery(name = "Capturas.findByFkPersona", query = "SELECT c FROM Capturas c WHERE c.capturasPK.fkPersona = :fkPersona"),
    @NamedQuery(name = "Capturas.findByFkImagen", query = "SELECT c FROM Capturas c WHERE c.capturasPK.fkImagen = :fkImagen"),
    @NamedQuery(name = "Capturas.findByValor", query = "SELECT c FROM Capturas c WHERE c.valor = :valor")})
public class Capturas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapturasPK capturasPK;
    @Size(max = 45)
    @Column(name = "valor")
    private String valor;
    @JoinColumn(name = "fk_imagen", referencedColumnName = "idImagen", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Imagenes imagenes;
    @JoinColumn(name = "fk_documento", referencedColumnName = "idDocumentos")
    @ManyToOne(optional = false)
    private Documentos fkDocumento;
    @JoinColumn(name = "fk_dato", referencedColumnName = "idDatos")
    @ManyToOne
    private Datos fkDato;
    @JoinColumn(name = "fk_persona", referencedColumnName = "idPersona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    public Capturas() {
    }

    public Capturas(CapturasPK capturasPK) {
        this.capturasPK = capturasPK;
    }

    public Capturas(int fkPersona, int fkImagen) {
        this.capturasPK = new CapturasPK(fkPersona, fkImagen);
    }

    public CapturasPK getCapturasPK() {
        return capturasPK;
    }

    public void setCapturasPK(CapturasPK capturasPK) {
        this.capturasPK = capturasPK;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Imagenes getImagenes() {
        return imagenes;
    }

    public void setImagenes(Imagenes imagenes) {
        this.imagenes = imagenes;
    }

    public Documentos getFkDocumento() {
        return fkDocumento;
    }

    public void setFkDocumento(Documentos fkDocumento) {
        this.fkDocumento = fkDocumento;
    }

    public Datos getFkDato() {
        return fkDato;
    }

    public void setFkDato(Datos fkDato) {
        this.fkDato = fkDato;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capturasPK != null ? capturasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capturas)) {
            return false;
        }
        Capturas other = (Capturas) object;
        if ((this.capturasPK == null && other.capturasPK != null) || (this.capturasPK != null && !this.capturasPK.equals(other.capturasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Capturas[ capturasPK=" + capturasPK + " ]";
    }
    
}
