/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author Raquel Gacía
 */
public class CCEmpresa extends CuentaCorriente {

    private double maximoDescubierto;
    private double interesDescubierto;
    private double comisionFijaDescubierto;

    public CCEmpresa(double maximoDescubierto, double interesDescubierto, double comisionFijaDescubierto, String entidades, Persona titular, double saldo, String iban) {
        super(entidades, titular, saldo, iban);
        this.maximoDescubierto = maximoDescubierto;
        this.interesDescubierto = interesDescubierto;
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }

    public double getMaximoDescubierto() {
        return maximoDescubierto;
    }

    public void setMaximoDescubierto(double maximoDescubierto) {
        this.maximoDescubierto = maximoDescubierto;
    }

    public double getInteresDescubierto() {
        return interesDescubierto;
    }

    public void setInteresDescubierto(double interesDescubierto) {
        this.interesDescubierto = interesDescubierto;
    }

    public double getComisionFijaDescubierto() {
        return comisionFijaDescubierto;
    }

    public void setComisionFijaDescubierto(double comisionFijaDescubierto) {
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }

    /*creamos el metodo override denominado "devolverInfoString()" que será llamado desde la 
    inferface Imprimir. Se invoca al metodo toString de la clase padre/abuelo (CuentaCorriente/CuentaBancaria) 
    con super.devolverInfoString()evitando reescribir los datos padre a imprimir*/
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + ", máximo descubierto:" + maximoDescubierto + ", interes descubierto: " + interesDescubierto + ", comision fija descubierto: " + comisionFijaDescubierto + '}';

    }
}
