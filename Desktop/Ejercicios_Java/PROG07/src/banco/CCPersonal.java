/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author Raquel García
 */
public class CCPersonal extends CuentaCorriente {

    private double comisionMantenimiento;

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

    /*creamos el metodo override denominado "devolverInfoString()" que será llamado desde la 
    inferface Imprimir. Se invoca al metodo toString de la clase padre/abuelo (CuentaCorriente/CuentaBancaria) 
    con super.devolverInfoString()evitando reescribir los datos padre a imprimir*/
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + " Comision de mantenimiento: " + comisionMantenimiento;
    }
}
