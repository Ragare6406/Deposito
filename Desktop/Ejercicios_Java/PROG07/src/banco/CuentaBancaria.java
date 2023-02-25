/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author Raquel García
 */
public abstract class CuentaBancaria implements Imprimible {

    private Persona titular;
    private double saldo;
    private String iban;

    public CuentaBancaria(Persona titular, double saldo, String iban) {
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
   /*creamos el metodo override denominado "devolverInfoString()" que sera llamado desde la 
    inferface Imprimir.*/
    @Override
    public String devolverInfoString() {
        return "Titular: " + titular.devolverInfoString() + ", saldo: " + saldo + ", IBAN: " + iban;
    }
}
