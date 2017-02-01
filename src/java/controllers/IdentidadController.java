package controllers;

import controllers.util.MobilePageController;
import entities.Identidad;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "identidadController")
@ViewScoped
public class IdentidadController extends AbstractController<Identidad> {

    @Inject
    private PerfilesController fkPerfilController;
    @Inject
    private PersonaController personaController;
    @Inject
    private UsuarioController usuarioController;
    @Inject
    private MobilePageController mobilePageController;

    public IdentidadController() {
        // Inform the Abstract parent controller of the concrete Identidad Entity
        super(Identidad.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getIdentidadPK().setFkPersona(this.getSelected().getPersona().getIdPersona());
        this.getSelected().getIdentidadPK().setFkUsuario(this.getSelected().getUsuario().getIdUsuario());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setIdentidadPK(new entities.IdentidadPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        fkPerfilController.setSelected(null);
        personaController.setSelected(null);
        usuarioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Perfiles controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFkPerfil(ActionEvent event) {
        if (this.getSelected() != null && fkPerfilController.getSelected() == null) {
            fkPerfilController.setSelected(this.getSelected().getFkPerfil());
        }
    }

    /**
     * Sets the "selected" attribute of the Persona controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePersona(ActionEvent event) {
        if (this.getSelected() != null && personaController.getSelected() == null) {
            personaController.setSelected(this.getSelected().getPersona());
        }
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUsuario(ActionEvent event) {
        if (this.getSelected() != null && usuarioController.getSelected() == null) {
            usuarioController.setSelected(this.getSelected().getUsuario());
        }
    }
}
