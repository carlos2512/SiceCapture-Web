/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.TipoPerfiles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author c_rom
 */
@Stateless
public class TipoPerfilesFacade extends AbstractFacade<TipoPerfiles> {

    @PersistenceContext(unitName = "migee7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPerfilesFacade() {
        super(TipoPerfiles.class);
    }
    
}
