 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author Raquel García
 */
/*La Cuenta Corriente Personal heredará atributos de la Cuenta Corriente 
por lo que se indica la palabra reservada "extends" e implementamos la interfaz "Imprimir"*/
public class CCPersonal extends CuentaCorriente {

    private double comisionMantenimiento;
/*Creo un constructor invocando con la palabra "super" al constructor padre "CuentaCorriente" añadiendo asi 
    los paramentros de la clae padre y abuelo. Incluyo el especifico de la clase hija*/
    public CCPersonal(double comisionMantenimiento, String entidades, Persona titular, double saldo, String iban) {
        super(entidades, titular, saldo, iban);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }

/*creo el metodo override denominado "devolverInfoString()" que será llamado desde la 
    inferface Imprimir. Se invoca al metodo toString de la clase padre/abuelo (CuentaCorriente/CuentaBancaria) 
    con super.devolverInfoString()evitando reescribir los datos padre a imprimir*/
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + " Comision de mantenimiento: " + comisionMantenimiento;
    }
}
