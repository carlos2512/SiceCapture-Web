/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Identidad;
import entities.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author c_rom
 */
@Stateless
public class IdentidadFacade extends AbstractFacade<Identidad> {

    @PersistenceContext(unitName = "migee7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Identidad> findByUsuario(Usuario fkUsuario) {
        List<Identidad> listaIdentidad = null;
        try {
            EntityManager em = getEntityManager();
            Query query = em.createNamedQuery("Identidad.findByFkUsuario", Identidad.class)
                    .setParameter("fkUsuario", fkUsuario);
            listaIdentidad = (List<Identidad>) query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(Identidad.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaIdentidad;
    }

    public IdentidadFacade() {
        super(Identidad.class);
    }

}
