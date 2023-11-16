/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poop11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author poo08alu21
 */
public class POOP11 {

    /**
     * @param args
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("###### File #####");
        File archivo = new File("archivo.txt");
        System.out.println("Archivo existe: " + archivo.exists());
        if(!archivo.exists()){
            try{
            boolean seCreo = archivo.createNewFile();
                System.out.println("Se creo un archivo: " +seCreo);
                System.out.println("Archivo existe: " +archivo.exists());
            } catch (IOException ex){
                System.out.println("ex.getMessage()");
            }
        } 
        System.out.println("##### FileWriter ######");
        try {
            System.out.println("### Lectura desde teclado ###");
            BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); //desde mi teclado se va a depositar en un buffer
            System.out.println("Escriba el texto para el archivo");
            String texto = br.readLine();
            System.out.println("El usuario escribio: "+ texto);

            System.out.println("### Escritura del archivo ###");
            FileWriter fw = new FileWriter("archivo.txt");
            BufferedWriter bw = new BufferedWriter(fw); // se crea el file writer
            PrintWriter impresoraDeArchivos = new PrintWriter(bw); //se necesita una impresora de archivos
            impresoraDeArchivos.println(texto); //obtiene la cadena que el usuario creo
            impresoraDeArchivos.close();
            
            System.out.println("### Lectura del archivo ###");
            FileReader fr = new FileReader("archivo.txt");
            br = new BufferedReader(fr); 
            System.out.println("El texto del archivo es: ");
            String linea = br.readLine();
            while (linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();

            System.out.println("##### StringTokenizer ######");
            String alumno = "Hector Juan,Jimenez,Maya,423049031,20,8.3";
            System.out.println("Cadena a tokenizar: " + alumno);
            StringTokenizer tokenizador = new StringTokenizer(alumno, ",");
            while(tokenizador.hasMoreTokens()){
                System.out.println(tokenizador.nextToken());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    
    
        System.out.println("##### Actividad extra ####");
        
        // Crear 10 objetos Alumno
            List<Alumno> listaAlumnos = new ArrayList<>();
            listaAlumnos.add(new Alumno("Itzel" , "Hernandez" , "Hernandez" , "423049031",20));
            listaAlumnos.add(new Alumno("Lilian" , "Flores" , "Hernandez" , "323049031",22));
            listaAlumnos.add(new Alumno("Luis" , "Lopez" , "Vera" , "423049032",21));
            listaAlumnos.add(new Alumno("Juan" , "Ruiz" , "Esparza" , "42304865",19));
            listaAlumnos.add(new Alumno("Ivan" , "Lopez" , "Santos" , "32304654",19));
            listaAlumnos.add(new Alumno("Rodrigo" , "Garcia" , "Nuñez" , "42304921",19));
            listaAlumnos.add(new Alumno("Jesus" , "Tapia" , "Aranda" , "32302129",20));
            listaAlumnos.add(new Alumno("Angelica" , "Garcia" , "Esquivel" , "423012149",21));
            listaAlumnos.add(new Alumno("Adriana" , "Santos" , "Osorio" , "32323049",18));
            listaAlumnos.add(new Alumno("Ivan" , "Montoya" , "Muñoz" , "423023249",23));


            

            // Escribir en archivo CSV
            escribirCSV(listaAlumnos, "alumnos.csv");

            // Leer archivo CSV y crear nuevos objetos Alumno
            List<Alumno> nuevosAlumnos = leerCSV("alumnos.csv");

            // Imprimir los nuevos objetos Alumno
            for (Alumno alumno : nuevosAlumnos) {
                System.out.println(alumno.toString());
            }
        }

        // Método para escribir en un archivo CSV
        private static void escribirCSV(List<Alumno> alumnos, String nombreArchivo) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
                for (Alumno alumno : alumnos) {
                    writer.write(alumno.toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Método para leer un archivo CSV y crear objetos Alumno
        private static List<Alumno> leerCSV(String nombreArchivo) {
            List<Alumno> alumnos = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    StringTokenizer tokenizer = new StringTokenizer(linea, ",");
                    String nombre = tokenizer.nextToken();
                    String apPaterno = tokenizer.nextToken();
                    String apMaterno = tokenizer.nextToken();
                    String numCuenta = tokenizer.nextToken();
                    int edad = Integer.parseInt(tokenizer.nextToken());

                    alumnos.add(new Alumno(nombre, apPaterno, apMaterno, numCuenta, edad));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return alumnos;
        }
    }

