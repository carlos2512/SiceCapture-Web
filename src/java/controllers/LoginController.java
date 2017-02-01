/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import bussines.LoginBussines;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author c_rom
 */
@Named(value = "loginController")
@ViewScoped
public class LoginController implements Serializable {

    @Inject
    LoginBussines loginBussines;
    
    private String username;
    private String password;

    public String validateCredentials() {
        if (loginBussines.validateCredentials(username, password)) {
            return "home";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario y/o Clave Incorrectos","Usuario y/o Clave Incorrectos"));
            return "";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
