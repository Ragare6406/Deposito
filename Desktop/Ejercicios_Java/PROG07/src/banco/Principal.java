/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Raquel Gracía
 */
public class Principal {

    public static void main(String[] args) {
        String nombre, apellidos, dni, iban, entidad, info;
        double saldo, tipoIntAnual, comMantenimiento, interesDescubierto, maximoDescubierto, comisionFijaDescubierto, cantidad;
        int opcion, tipoCta;
        Persona cliente;
        CuentaBancaria cuenta = null;
        Banco banco = new Banco();
        String[] lista;

        //Creamos un scanner para recibir datos por teclado
        Scanner tecla = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            try {
                System.out.println("""
                               
                               1. Abrir una nueva cuenta.
                               2. Ver un listado de las cuentas disponibles (c\u00f3digo de cuenta, titular y saldo actual).
                               3. Obtener los datos de una cuenta concreta. 
                               4. Realizar un ingreso en una cuenta. 
                               5. Retirar efectivo de una cuenta. 
                               6. Consultar el saldo actual de una cuenta. 
                               7. Salir de la aplicaci\u00f3n. """);
                opcion = tecla.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Datos:");
                        System.out.print("Nombre: ");
                        nombre = tecla.next();
                        System.out.print("Apellidos: ");
                        apellidos = tecla.next();
                        System.out.print("DNI: ");
                        dni = tecla.next();
                        cliente = new Persona(nombre, apellidos, dni);
                        boolean seguir = false;
                        
                        do {
                            System.out.print("Nuevo IBAN: ");
                            iban = tecla.next();
                            Pattern p = Pattern.compile("ES[0-9]{20}");//creamos un patron usando expresiones regulares 
                            Matcher m = p.matcher(iban);//comprueba el dni introducido con el patron
                            if (m.matches()) {
                                seguir = true;
                            } else {
                                System.out.println("IBAN no valido");
                                seguir = false;
                            }
                        } while (seguir == false);

                        System.out.print("Saldo: ");
                        saldo = tecla.nextDouble();
                        System.out.println("Tipo de cuenta");
                        System.out.println("""
                               1. Cuenta de ahorro
                               2. Cuenta corriente personal
                               3. Cuenta corriente empresa""");
                        tipoCta = tecla.nextInt();

                        switch (tipoCta) {
                            case 1:
                                System.out.println("Tipo de interes anual: ");
                                tipoIntAnual = tecla.nextDouble();
                                cuenta = new CuentaAhorro(tipoIntAnual, cliente, saldo, iban);
                                break;
                            case 2:
                                System.out.println("Entidad autorizada: ");
                                entidad = tecla.next();
                                System.out.println("Comisión de mantenimineto: ");
                                comMantenimiento = tecla.nextDouble();
                                cuenta = new CCPersonal(comMantenimiento, entidad, cliente, saldo, iban);
                                break;
                            case 3:
                                System.out.println("Entidad autorizada: ");
                                entidad = tecla.next();
                                System.out.println("Tipo de interés por decubierto: ");
                                interesDescubierto = tecla.nextDouble();
                                System.out.println("Máximo descubierto permitido: ");
                                maximoDescubierto = tecla.nextDouble();
                                System.out.println("Comisión fija por cada descubierto: ");
                                comisionFijaDescubierto = tecla.nextDouble();
                                cuenta = new CCEmpresa(maximoDescubierto, interesDescubierto, comisionFijaDescubierto, entidad, cliente, saldo, iban);
                                break;
                            default:
                                throw new Exception("Elije un tipo de cuenta");
                        }

                        if (banco.abrirCuenta(cuenta)) {
                            System.out.println("Cuenta creada");
                        } else {
                            System.out.println("Error de apertura de cuenta");
                        }

                        break;

                    case 2:
                        banco.listadoCuentas();
                        break;
                    case 3:
                        System.out.print("Teclee IBAN: ");
                        iban = tecla.next();
                        info = banco.informacionCuenta(iban);
                        System.out.println(info);
                        break;
                    case 4:
                        System.out.print("Teclee IBAN: ");
                        iban = tecla.next();
                        System.out.print("Cantidad a ongresar: ");
                        cantidad = tecla.nextDouble();
                        if (banco.ingresoCuenta(iban, cantidad)) {
                            System.out.println("Cantidad ingresada " + cantidad);
                        } else {
                            System.out.println("Error en la operación realizada");
                        }
                        break;
                    case 5:
                        System.out.print("Teclee IBAN: ");
                        iban = tecla.next();
                        System.out.print("Cantidad a retirar: ");
                        cantidad = tecla.nextDouble();
                        if (banco.retiradaCuenta(iban, cantidad)) {
                            System.out.println("Cantidad retirada " + cantidad);
                        } else {
                            System.out.println("Error en la operación realizada");
                        }
                        break;
                    case 6:
                        System.out.print("Teclee IBAN: ");
                        iban = tecla.next();
                        saldo = banco.obtenerSaldo(iban);
                        if (saldo != -1) {
                            System.out.println("El saldo es: " + saldo);
                        } else {
                            System.out.println("La cuenta no existe");
                        }
                        break;
                    case 7:
                        salir = true;
                        break;
                    /*default:
                        throw new AssertionError();*/
                }
            } catch (Exception e) {
                System.out.println("Seleccione otra opcion");
                opcion = tecla.nextInt();
            }
        }
    }
}
