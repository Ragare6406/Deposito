
package relojdigital;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Alarma implements Serializable{
    private int hora;
    private int minutos;
    private boolean activa;

    public Alarma(int hora, int minutos, boolean activa) {
        this.hora = hora;
        this.minutos = minutos;
        this.activa = activa;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    public Date getAlarma() {
        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.HOUR_OF_DAY, hora);
        calendario.set(Calendar.MINUTE, minutos);
        return calendario.getTime();
    }
    
    public interface AlarmaListener{
        public void suenaAlarma();
}
    
}
