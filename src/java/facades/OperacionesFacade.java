/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Operaciones;
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
public class OperacionesFacade extends AbstractFacade<Operaciones> {

    @PersistenceContext(unitName = "migee7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperacionesFacade() {
        super(Operaciones.class);
    }

    public Operaciones findByCodigo(String codigo) {
        Operaciones operacion = null;
        try {
            EntityManager em = getEntityManager();
            Query query = em.createNamedQuery("Operaciones.findByCodigo", Operaciones.class)
                    .setParameter("codigo", codigo);
            operacion = (Operaciones) query.getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;
    }

}
