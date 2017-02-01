/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Perfiles;
import entities.Usuario;
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
public class PerfilesFacade extends AbstractFacade<Perfiles> {

    @PersistenceContext(unitName = "migee7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Perfiles findById(Integer idPerfiles) {
        Perfiles perfil = null;
        try {
            EntityManager em = getEntityManager();
            Query query = em.createNamedQuery("Perfiles.findByIdPerfiles", Perfiles.class)
                    .setParameter("idPerfiles", idPerfiles);
            perfil = (Perfiles) query.getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(Perfiles.class.getName()).log(Level.SEVERE, null, e);
        }
        return perfil;
    }

    public PerfilesFacade() {
        super(Perfiles.class);
    }

}
