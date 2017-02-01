package controllers;

import controllers.util.MobilePageController;
import entities.TipoOperaciones;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoOperacionesController")
@ViewScoped
public class TipoOperacionesController extends AbstractController<TipoOperaciones> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoOperacionesController() {
        // Inform the Abstract parent controller of the concrete TipoOperaciones Entity
        super(TipoOperaciones.class);
    }

    /**
     * Sets the "items" attribute with a collection of Operaciones entities that
     * are retrieved from TipoOperaciones?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Operaciones page
     */
    public String navigateOperacionesCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Operaciones_items", this.getSelected().getOperacionesCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/operaciones/index";
    }

}
