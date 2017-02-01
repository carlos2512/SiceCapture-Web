/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

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
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "migee7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Usuario findByLoginClave(String login, String clave) {
        Usuario usuarioTemp = null;
        try {
            EntityManager em = getEntityManager();
            Query query = em.createNamedQuery("Usuario.findByLoginClave", Usuario.class)
                    .setParameter("login", login)
                    .setParameter("clave", clave);
            usuarioTemp = (Usuario) query.getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, e);
        }
        return usuarioTemp;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

}
