/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.TipoOperaciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author c_rom
 */
@Stateless
public class TipoOperacionesFacade extends AbstractFacade<TipoOperaciones> {

    @PersistenceContext(unitName = "migee7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoOperacionesFacade() {
        super(TipoOperaciones.class);
    }
    
}
