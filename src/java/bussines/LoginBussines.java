/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussines;

import entities.Identidad;
import entities.Usuario;
import facades.IdentidadFacade;
import facades.UsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import utilities.DataSession;

/**
 *
 * @author c_romero
 */
@Named(value = "loginBussines")
@RequestScoped
public class LoginBussines {

    @EJB
    UsuarioFacade usuarioFacade;

    @Inject
    DataSession dataSession;

    @EJB
    IdentidadFacade identidadFacade;

    public boolean validateCredentials(String username, String password) {
        boolean validated;
        Usuario usuario = usuarioFacade.findByLoginClave(username, password);
        if (usuario != null) {
            List<Identidad> identidadList = (List) usuario.getIdentidadCollection();
            Identidad identidad = null;
            if (identidadList != null && !identidadList.isEmpty()) {
                identidad = identidadList.get(0);
            }
            dataSession.setIdentidadActual(identidad);
            validated = identidad != null;
        } else {
            validated = false;
        }
        return validated;
    }

}
