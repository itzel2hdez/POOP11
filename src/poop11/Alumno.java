/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop11;

/**
 *
 * @author itzel
 */
public class Alumno {
    String nombre;
    String apPaterno;
    String apMaterno;
    String numCuenta;
    int edad;
    

    public Alumno(String nombre, String apPaterno, String apMaterno, String numCuenta1, int edad) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.numCuenta = numCuenta1;
        this.edad = edad;
    }
    @Override
    public String toString() {
        return nombre + "," + apPaterno + "," + apMaterno + "," + numCuenta + "," + edad;
    }
}
