/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author Raquel García
 */
public class CuentaCorriente extends CuentaBancaria implements Imprimible{

    private String entidades;

    public CuentaCorriente(String entidades, Persona titular, double saldo, String iban) {
        super(titular, saldo, iban);
        this.entidades = entidades;
    }

    public String getEntidades() {
        return entidades;
    }

    public void setEntidades(String entidades) {
        this.entidades = entidades;
    }

    /*creamos el metodo override denominado "devolverInfoString()" que será llamado desde la 
    inferface Imprimir. Se invoca al metodo toString de la clase padre (CuentaBancaria) con 
    super.devolverInfoString()evitando reescribir los datos padre a imprimir*/
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + ", entidades:" + entidades;
    }
}
