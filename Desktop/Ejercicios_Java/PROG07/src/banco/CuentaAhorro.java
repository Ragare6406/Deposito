/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author Raquel García
 */
/*La Cuenta de Ahorro heredará atributos de la Cuenta Bancaria 
por lo que se indica la palabra reservada "extends" e implementamos la interfaz "Imprimir"*/
public class CuentaAhorro extends CuentaBancaria implements Imprimible{

    private double tipoInteresAnual;
/*Creo un constructor invocando con la palabra "super" al constructor padre "CuentaBancaria" añadiendo asi 
    los paramentros de la clae padre. Incluyo el especifico de la clase hija*/
    public CuentaAhorro(double tipoInteresAnual, Persona titular, double saldo, String iban) {
        super(titular, saldo, iban);
        this.tipoInteresAnual = tipoInteresAnual;
    }
/*Metodo getter y setter*/
    public double getTipoInteresAnual() {
        return tipoInteresAnual;
    }

    public void setTipoInteresAnual(double tipoInteresAnual) {
        this.tipoInteresAnual = tipoInteresAnual;
    }
/*creo el metodo override denominado "devolverInfoString()" que será llamado desde la 
    inferface Imprimir. Se invoca al metodo toString de la clase padre (CuentaBancaria) con 
    super.devolverInfoString()evitando reescribir los datos padre a imprimir*/
    @Override
    public String devolverInfoString() {
       return super.devolverInfoString()+ ", tipo de interes anual: " + tipoInteresAnual;
    }
  }
