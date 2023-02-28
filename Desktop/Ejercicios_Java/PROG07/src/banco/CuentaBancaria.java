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
/*Creo los atributos de clase, incluyendo un  asignación a una variable de tipo "Persona"*/
    private Persona titular;
    private double saldo;
    private String iban;
/*Creo un constructor*/
    public CuentaBancaria(Persona titular, double saldo, String iban) {
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
    }
/*metodos getter y setter*/
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
   /*creo el metodo override denominado "devolverInfoString()" que sera llamado desde la 
    inferface Imprimir.*/
    @Override
    public String devolverInfoString() {
        return "Titular: " + titular.devolverInfoString() + ", saldo: " + saldo + ", IBAN: " + iban;
    }
}
