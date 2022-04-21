package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("tipoConverter")
public class TipConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String tipo = "";
        if (value!=null){
            tipo =(String) value;
            switch (tipo){
                case "C": tipo = "Cliente"; break;
                case "A": tipo = "Afiliado"; break;
            }
        }
        return tipo;
    }
    
}

