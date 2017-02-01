/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entities.Identidad;
import entities.Operaciones;
import entities.Perfiles;
import facades.OperacionesFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author c_rom
 */
@Named(value = "accessPolicy")
@RequestScoped
public class AccessPolicy implements Serializable {

    @Inject
    DataSession dataSession;

    @EJB
    OperacionesFacade operacionesFacade;

    public boolean validateComponentView(String codOperacion) {
        boolean validated = false;
        Identidad identidadActual = dataSession.getIdentidadActual();
        if (identidadActual != null) {
            Perfiles perfil = identidadActual.getFkPerfil();
            List<Operaciones> listOperaciones = (List) perfil.getOperacionesCollection();
            Operaciones operacionBuscada = operacionesFacade.findByCodigo(codOperacion);
            if (operacionBuscada != null) {
                if (listOperaciones != null && operacionBuscada.getEstado().equalsIgnoreCase("A") && !listOperaciones.isEmpty() && listOperaciones.contains(operacionBuscada)) {
                    validated = true;
                }
            }
        } else {
            validated = false;
        }
        return validated;
    }
}
