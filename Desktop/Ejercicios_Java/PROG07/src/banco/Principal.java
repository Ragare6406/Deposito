/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco;

import java.util.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;

/**
 *
 * @author Raquel Gracía
 */
public class Principal {
/*Añado los atributos que voy a usar*/
    public static void main(String[] args) throws Exception {
        String nombre, apellidos, dni, iban, entidad, info;
        double saldo, tipoIntAnual, comMantenimiento, interesDescubierto, maximoDescubierto, comisionFijaDescubierto, cantidad;
        int opcion, tipoCta;
        Persona cliente;
        CuentaBancaria cuenta = null;
        Banco banco = new Banco();
        String[] lista;

//Creo un scanner para recibir datos por teclado*/
        Scanner tecla = new Scanner(System.in);
        boolean salir = false;
/*mientras no elijamo salir creara un bucle*/
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
                opcion = tecla.nextInt(); /*teclamos la opción deseada de la lista para llamar al programa especifico*/
                switch (opcion) {
                    case 1: /*pedimos los datos de la nueva cuenta a crear*/
                        System.out.println("Datos:");
                        System.out.print("Nombre: ");
                        nombre = tecla.next();/*teclea el nombre*/
                        System.out.print("Apellidos: ");
                        apellidos = tecla.next();/*teclea el apellido*/
                        System.out.print("DNI: ");
                        dni = tecla.next();/*teclea el apellido*/
                        cliente = new Persona(nombre, apellidos, dni);/*los datos los almacena en cliente*/
                        boolean seguir = false;
                        /*pide el IBAN y los compara con el formato de ESNNNNNNNNNNNNNNNNNNNN*/
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
                        saldo = tecla.nextDouble();/*teclea el saldo*/
                        System.out.println("Tipo de cuenta");
                        System.out.println("""
                               1. Cuenta de ahorro
                               2. Cuenta corriente personal
                               3. Cuenta corriente empresa""");
                        tipoCta = tecla.nextInt();

                        switch (tipoCta) {
                            case 1:
                                System.out.println("Tipo de interes anual: ");
                                tipoIntAnual = tecla.nextDouble();/*teclea el tipo de interes*/
                                cuenta = new CuentaAhorro(tipoIntAnual, cliente, saldo, iban);/*los datos se almacenan en CuentaAhorro*/
                                break;
                            case 2:
                               /*Igual que en el caso 1 pero los datos se almacenan en CCPersonal*/
                                System.out.println("Entidad autorizada: ");
                                entidad = tecla.next();
                                System.out.println("Comisión de mantenimineto: ");
                                comMantenimiento = tecla.nextDouble();
                                cuenta = new CCPersonal(comMantenimiento, entidad, cliente, saldo, iban);
                                break;
                            case 3:
                                /*Igual que en los anteriores pero los datos se almacenan en CCEmpresa*/
                                System.out.println("Entidad autorizada: ");
                                entidad = tecla.next();
                                System.out.println("Tipo de interés por decubierto: ");
                                interesDescubierto = tecla.nextDouble();
                                System.out.println("Máximo descubierto permitido: ");
                                maximoDescubierto = tecla.nextDouble();
                                System.out.println("Comisión fija por descubierto: ");
                                comisionFijaDescubierto = tecla.nextDouble();
                                cuenta = new CCEmpresa(maximoDescubierto, interesDescubierto, comisionFijaDescubierto, entidad, cliente, saldo, iban);
                                break;
                            default:
                                throw new Exception("Elije un tipo de cuenta");
                        }

                        if (banco.abrirCuenta(cuenta)) {/*Lanza un mensaje si la cuenta se ha creado correctamente o no*/
                            System.out.println("Cuenta creada");
                        } else {
                            System.out.println("Error de apertura de cuenta");
                        }

                        break;

                    case 2:/*llama al método listadoCuentas para imprimir un listado de todas las cuentas*/
                        banco.listadoCuentas();
                        break;
                    case 3:/*solicita un Iban y llama al método informacionCuenta e imprime los datos de esa cuenta*/
                        System.out.print("Teclee IBAN: ");
                        iban = tecla.next();
                        info = banco.informacionCuenta(iban);
                        System.out.println(info);
                        break;
                    case 4:/*solicita un IBAN y una cantidad a ingresar*/
                        System.out.print("Teclee IBAN: ");
                        iban = tecla.next();
                        System.out.print("Cantidad a 1ngresar: ");
                        cantidad = tecla.nextDouble();
                        if (banco.ingresoCuenta(iban, cantidad)) {/*llama al método ingresoCuenta que comprueba que si IBAN es correcto*/
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
                        saldo = banco.obtenerSaldo(iban);/*llama al método obtenerSaldo*/
                        if (saldo != -1) {
                            System.out.println("El saldo es: " + saldo);
                        } else {
                            System.out.println("La cuenta no existe");
                        }
                        break;
                    case 7:
                        salir = true;
                        break;
                }
            }  catch (InputMismatchException e) {
                tecla.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } 
        }
    }
}
