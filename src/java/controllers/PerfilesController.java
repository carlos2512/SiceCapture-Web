package controllers;

import controllers.util.MobilePageController;
import entities.Perfiles;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "perfilesController")
@ViewScoped
public class PerfilesController extends AbstractController<Perfiles> {

    @Inject
    private PerfilesController perfilPadreController;
    @Inject
    private TipoPerfilesController tipoPerfilController;
    @Inject
    private MobilePageController mobilePageController;

    public PerfilesController() {
        // Inform the Abstract parent controller of the concrete Perfiles Entity
        super(Perfiles.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        perfilPadreController.setSelected(null);
        tipoPerfilController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Operaciones entities that
     * are retrieved from Perfiles?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Operaciones page
     */
    public String navigateOperacionesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Operaciones_items", this.getSelected().getOperacionesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/operaciones/index";
    }

    /**
     * Sets the "items" attribute with a collection of Perfiles entities that
     * are retrieved from Perfiles?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Perfiles page
     */
    public String navigatePerfilesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Perfiles_items", this.getSelected().getPerfilesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/perfiles/index";
    }

    /**
     * Sets the "selected" attribute of the Perfiles controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePerfilPadre(ActionEvent event) {
        if (this.getSelected() != null && perfilPadreController.getSelected() == null) {
            perfilPadreController.setSelected(this.getSelected().getPerfilPadre());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoPerfiles controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoPerfil(ActionEvent event) {
        if (this.getSelected() != null && tipoPerfilController.getSelected() == null) {
            tipoPerfilController.setSelected(this.getSelected().getTipoPerfil());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Identidad entities that
     * are retrieved from Perfiles?cap_first and returns the navigation outcome.
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
