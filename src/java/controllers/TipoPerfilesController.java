package controllers;

import controllers.util.MobilePageController;
import entities.TipoPerfiles;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoPerfilesController")
@ViewScoped
public class TipoPerfilesController extends AbstractController<TipoPerfiles> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoPerfilesController() {
        // Inform the Abstract parent controller of the concrete TipoPerfiles Entity
        super(TipoPerfiles.class);
    }

    /**
     * Sets the "items" attribute with a collection of Perfiles entities that
     * are retrieved from TipoPerfiles?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Perfiles page
     */
    public String navigatePerfilesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Perfiles_items", this.getSelected().getPerfilesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/perfiles/index";
    }

}
