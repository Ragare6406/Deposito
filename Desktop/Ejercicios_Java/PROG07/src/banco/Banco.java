/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author Raquel Garcia
 */
public class Banco {

    private CuentaBancaria[] cuentas;
    private final int MAXCUENTA = 100;
    private int numCuenta;

    public Banco() {
        this.cuentas = new CuentaBancaria[this.MAXCUENTA];
        this.numCuenta = 0;
    }

    public CuentaBancaria buscarCuenta(String iban) {
        CuentaBancaria nuevaCuenta = null;
        for (int i = 0; i < this.numCuenta; i++) {
            nuevaCuenta = this.cuentas[i];
            if (nuevaCuenta.getIban().equals(iban)) {
                return nuevaCuenta;
            }
        }
        return null;
    }

    public boolean abrirCuenta(CuentaBancaria cuenta) {
        CuentaBancaria nuevCuenta = buscarCuenta(cuenta.getIban());
        if (nuevCuenta != cuenta) {
            this.cuentas[this.numCuenta] = cuenta;
            this.numCuenta++;
            return true;
        } else {
            return false;
        }
    }

    public void listadoCuentas() {
        for (int i = 0; i < this.numCuenta; i++) {
            CuentaBancaria cuenta = this.cuentas[i];
            System.out.println(cuenta.devolverInfoString());
        }
    }

    public String informacionCuenta(String iban) {
        for (int i = 0; i < this.numCuenta; i++) {
            CuentaBancaria cuenta = this.buscarCuenta(iban);
            if (cuenta.getIban().equals(iban)) {
                return cuenta.devolverInfoString();
            }
        }
        return null;
    }

    public boolean ingresoCuenta(String iban, double ingreso) {
        CuentaBancaria cuenta = this.buscarCuenta(iban);
        if (cuenta.getIban().equals(iban)) {
            cuenta.setSaldo(cuenta.getSaldo() + ingreso);
            return true;
        }
        return false;
    }

    public boolean retiradaCuenta(String iban, double retirada) {
        CuentaBancaria cuenta = this.buscarCuenta(iban);
        if (cuenta.getIban().equals(iban)) {
            cuenta.setSaldo(cuenta.getSaldo() - retirada);
            return true;
        }
        return false;
    }

    public double obtenerSaldo(String iban) {
        CuentaBancaria cuenta = this.buscarCuenta(iban);
        if (cuenta.getIban().equals(iban)) {
            return cuenta.getSaldo();
        }
        return -1;
    }
}
