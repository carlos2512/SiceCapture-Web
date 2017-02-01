package controllers;

import controllers.util.MobilePageController;
import entities.Operaciones;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "operacionesController")
@ViewScoped
public class OperacionesController extends AbstractController<Operaciones> {

    @Inject
    private OperacionesController operacionPadreController;
    @Inject
    private TipoOperacionesController tipoOperacionController;
    @Inject
    private MobilePageController mobilePageController;

    public OperacionesController() {
        // Inform the Abstract parent controller of the concrete Operaciones Entity
        super(Operaciones.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        operacionPadreController.setSelected(null);
        tipoOperacionController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Perfiles entities that
     * are retrieved from Operaciones?cap_first and returns the navigation
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

    /**
     * Sets the "items" attribute with a collection of Operaciones entities that
     * are retrieved from Operaciones?cap_first and returns the navigation
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

    /**
     * Sets the "selected" attribute of the Operaciones controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareOperacionPadre(ActionEvent event) {
        if (this.getSelected() != null && operacionPadreController.getSelected() == null) {
            operacionPadreController.setSelected(this.getSelected().getOperacionPadre());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoOperaciones controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoOperacion(ActionEvent event) {
        if (this.getSelected() != null && tipoOperacionController.getSelected() == null) {
            tipoOperacionController.setSelected(this.getSelected().getTipoOperacion());
        }
    }
}
