package controllers;

import controllers.util.MobilePageController;
import entities.Persona;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "personaController")
@ViewScoped
public class PersonaController extends AbstractController<Persona> {

    @Inject
    private MobilePageController mobilePageController;

    public PersonaController() {
        // Inform the Abstract parent controller of the concrete Persona Entity
        super(Persona.class);
    }

    /**
     * Sets the "items" attribute with a collection of Identidad entities that
     * are retrieved from Persona?cap_first and returns the navigation outcome.
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
