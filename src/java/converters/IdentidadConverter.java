package converters;

import entities.Identidad;
import facades.IdentidadFacade;
import controllers.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "identidadConverter")
public class IdentidadConverter implements Converter {

    @Inject
    private IdentidadFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.IdentidadPK getKey(String value) {
        entities.IdentidadPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.IdentidadPK();
        key.setFkPersona(Integer.parseInt(values[0]));
        key.setFkUsuario(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entities.IdentidadPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getFkPersona());
        sb.append(SEPARATOR);
        sb.append(value.getFkUsuario());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Identidad) {
            Identidad o = (Identidad) object;
            return getStringKey(o.getIdentidadPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Identidad.class.getName()});
            return null;
        }
    }

}
