/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author Raquel García
 */
public class Persona implements Imprimible {
/*Creo los atributos de clase*/     
    private String nombre, apellidos, dni;

/*Creo un constructor*/
    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

 /*Creo metodos setter y getter*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
   /*creo el metodo override denominado "devolverInfoString()" que sera llamado desde la 
    inferface Imprimir.*/
    @Override
    public String devolverInfoString() {
        return "Nombre:" + nombre + ", apellidos: " + apellidos + ", dni: " + dni;
}

}
