package controllers;

import controllers.util.MobilePageController;
import entities.Usuario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    @Inject
    private MobilePageController mobilePageController;

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario Entity
        super(Usuario.class);
    }

    /**
     * Sets the "items" attribute with a collection of Identidad entities that
     * are retrieved from Usuario?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Identidad page
     */
    public String navigateIdentidadCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Identidad_items", this.getSelected().getIdentidadCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/identidad/index";
    }

}
