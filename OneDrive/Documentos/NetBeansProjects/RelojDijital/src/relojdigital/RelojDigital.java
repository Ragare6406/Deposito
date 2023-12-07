package relojdigital;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import java.util.Timer;
import java.util.TimerTask;

public class RelojDigital extends JLabel implements Serializable {

    private SimpleDateFormat fomato24 = new SimpleDateFormat("HH.mm.ss");
    private SimpleDateFormat fomato12 = new SimpleDateFormat("hh.mm.ss a");
    private Alarma alarma;

    public RelojDigital() {
        Timer tiempoReloj = new Timer();
        tiempoReloj.schedule(new TimerTask() {
            @Override
            public void run() {
                Date horaActual = new Date();
                if (formato24) {
                    setText(fomato24.format(horaActual));
                } else {
                    setText(fomato12.format(horaActual));
                }

                if (alarma != null) {
                    System.out.println(horaActual);
                    System.out.println(alarma.getAlarma());
                    if (alarma.isActiva() && horasCoinciden(horaActual, alarma.getAlarma())) {
                        System.out.println("!Alarma sonando¡");
                    }
                }
            }
        }, 0, 1000);//ejecuta el reloj
    }
    //-----------------------------------------------------------------
    private boolean formato24;

    public boolean isFormato24() {
        return formato24;
    }

    public void setFormato(boolean formato24) {
        this.formato24 = formato24;
    }
//-----------------------------------------------------------------------



    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }

//----------------------------------------------------------------------    
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
//------------------------------------------------------------------------    

     private boolean horasCoinciden(Date horaActual, Date horaAlarma) {
        Calendar calendarioActual = Calendar.getInstance();
        Calendar calendarioAlarma = Calendar.getInstance();
        calendarioActual.setTime(horaActual);
        calendarioAlarma.setTime(horaAlarma);

        return calendarioActual.get(Calendar.HOUR_OF_DAY) == calendarioAlarma.get(Calendar.HOUR_OF_DAY)
                && calendarioActual.get(Calendar.MINUTE) == calendarioAlarma.get(Calendar.MINUTE);
    }
}

    //--------------------------------------------------------------------------
