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
/*creo un array de la clase padre (CuentaBancaria) donde se almacenara todas  cuentas (de todos los tipos) que se abran*/
    private CuentaBancaria[] cuentas;
    private final int MAXCUENTA = 100;
    private int numCuenta;

    public Banco() {
        this.cuentas = new CuentaBancaria[this.MAXCUENTA];
        this.numCuenta = 0;
    }
/*creo el metodo "buscarCuenta" que comprueba si el iban introducido está ya creado*/
    public CuentaBancaria buscarCuenta(String iban) {
        CuentaBancaria existCuenta = null;
        for (int i = 0; i < this.numCuenta; i++) {/*recorre hasta el numCuenta*/
            existCuenta = this.cuentas[i];
            if (existCuenta.getIban().equals(iban)) {/*compara el iban dado con los que existen*/
                return existCuenta;
            }
        }
        return null; /*si no lo encuentra devuelve nulo*/
    }
/*Método que comprueba si existe la cuenta y si no exite la cres*/
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        CuentaBancaria existCuenta = buscarCuenta(cuenta.getIban()); /*Buscamos, llamando al método buscarCuenta, si la cuenta que introduzcamos existe*/
        if (existCuenta == null) { /*no exixte si el resultado de la busqueda es null*/
            this.cuentas[this.numCuenta] = cuenta; /*llamamos a numCuenta para posicionar la nueva cuenta en el siguiente espacio vacío*/
            this.numCuenta++;/*añadimos el espacio para la siguiente cuenta a ingresar*/
            return true;
        } else {
            return false;
        }
    }
  /*Metodo que recorre las cuentas creadas y las imprime*/
    public void listadoCuentas() {
        for (int i = 0; i < this.numCuenta; i++) {
            CuentaBancaria cuenta = this.cuentas[i];
            System.out.println(cuenta.devolverInfoString());
        }
    }
/*metodo busca una cuenta y la imprime*/
    public String informacionCuenta(String iban) {
        for (int i = 0; i < this.numCuenta; i++) {/*recorre las cuentas creadas*/
            CuentaBancaria cuenta = this.buscarCuenta(iban); /*busca la cuenta*/
            if (cuenta.getIban().equals(iban)) {
                return cuenta.devolverInfoString();/*llamamos al metodo imprimible para que nos devuelva los datos de la cuenta*/
            }
        }
        return null;
    }

    public boolean ingresoCuenta(String iban, double ingreso) {
        CuentaBancaria cuenta = this.buscarCuenta(iban);/*busca la cuenta*/
        if (cuenta.getIban().equals(iban)) {
            cuenta.setSaldo(cuenta.getSaldo() + ingreso);/*la formula rescoge el saldo actual y le suma lo imgresado*/
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
/*Con el metodo obtenerSaldo busca la cuenta y devuelve el saldo actual*/
    public double obtenerSaldo(String iban) {
        CuentaBancaria cuenta = this.buscarCuenta(iban);
        if (cuenta.getIban().equals(iban)) {
            return cuenta.getSaldo();
        }
        return -1;
    }
}
