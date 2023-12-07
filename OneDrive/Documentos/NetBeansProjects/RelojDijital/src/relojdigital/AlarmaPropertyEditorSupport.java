package relojdigital;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

public class AlarmaPropertyEditorSupport extends PropertyEditorSupport {

    private AlarmaPanel alarmaPanel = new AlarmaPanel(); //creamos la instancia de AlarmaPanel

    @Override
    public boolean supportsCustomEditor() {
        return true; //confirmamos con este metodo que hay un editor de propiedades personalizado
    }

    @Override
    public Component getCustomEditor() {
        return alarmaPanel; //pide el panel que hay que insertar en el editor de propiedades
    }

    @Override
    public String getJavaInitializationString() {
        Alarma alarma = (Alarma) getValue();
        if (alarma != null) {
            return "new relojdigital.Alarma(" + alarma.getHora() + "," + alarma.getMinutos() + "," + alarma.isActiva() + ")";
        }
        return null; 
    }

    @Override
    public Object getValue() {
        return alarmaPanel.getSelectValue(); //devuelve los valores recogidos en el panel.
    }

}
