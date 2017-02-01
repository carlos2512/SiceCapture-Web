/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entities.Identidad;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author c_rom
 */
@Named(value = "dataSession")
@SessionScoped
public class DataSession implements Serializable {
    
   Identidad identidadActual;  

    public Identidad getIdentidadActual() {
        return identidadActual;
    }

    public void setIdentidadActual(Identidad identidadActual) {
        this.identidadActual = identidadActual;
    }
   
   
    
}
