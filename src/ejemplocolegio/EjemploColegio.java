/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocolegio;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class EjemploColegio {

    static ArrayList <Persona> personas = new ArrayList <Persona>();
   
    public static void rellenarDatos(){
        
        Profesor prof;
        ProfesorInterino profin;
        Alumno alum;
                //creo 10 profesores
        for (int i = 0; i < 10; i++) {
            prof = new Profesor();
            prof.setNombre("Profesor "+i);
            prof.setEdad(35+i);
            prof.setEspecialidad("Matemáticas "+1);
            personas.add(prof);
        }
        
                //creo 10 profesores interinos
         for (int i = 0; i < 10; i++) {
            profin = new ProfesorInterino();
            profin.setNombre("Profesor interino "+i);
            profin.setEdad(25+i);
            profin.setEspecialidad("Lengua "+1);
            profin.setPuntos(i*i);
            personas.add(profin);
        }
         
                //creo 10 alumnos
          for (int i = 0; i < 10; i++) {
            alum = new Alumno();
            alum.setNombre("Alumno "+i);
            alum.setEdad(10+i);
            personas.add(alum);
        }
        
    }
    
    
    public static void mostrarProfesorMasViejo(){
        
        int maxEdad = 0;
        Profesor personaEdadMaxima = null;
               //recorro el ArrayList
        for(int i=0; i<personas.size();i++){
                // para decir que solo queremos los profesores dentro de las personas
                // HERENCIA ---- TENGO TIPOS DE PERSONAS, PERO SOLO QUIERO LOS PROFESOR, INTERINOS INCLUIDOS.
                if (personas.get(i) instanceof Profesor) {
                    //comparamos para sacar el más viejo
                    if (maxEdad < personas.get(i).getEdad()){
                        maxEdad = personas.get(i).getEdad();
                        personaEdadMaxima = (Profesor) personas.get(i);
                    }
                }                               
        }
        System.out.println("El profesor de más edad tiene "+ maxEdad + " años");
        System.out.println("Y se llama " +personaEdadMaxima.getNombre());
    }
    

    
    public static void mostrarAlumnoMasJoven(){
        
        int minEdad = 100;
        Alumno personaEdadMinima = null;
        
            for(int i=0; i<personas.size();i++){
                if(personas.get(i) instanceof Alumno){
                    if(minEdad > personas.get(i).getEdad()){
                       minEdad = personas.get(i).getEdad();
                       personaEdadMinima = (Alumno) personas.get(i);
                    }
                }
            }
        System.out.println("El alumno más joven tiene "+minEdad+ " años");
        System.out.println("Y se llama " +personaEdadMinima.getNombre());
    }
    
    
    
    public static void cambiarEspecialidad(Profesor p, String especialidad){
        p.setEspecialidad(especialidad);
    }
    
    
    

    
    
    public static void main(String[] args) {
        rellenarDatos();
        
        //mostrarProfesorMasViejo();

        //mostrarAlumnoMasJoven();
        
        
        
        //--------------Cambiar Especialidad----------------
        Profesor prof = null;
        
        int i = 0;
        int encontrado = 0;
        while ((i<personas.size()) && (encontrado == 0)){
            if (personas.get(i) instanceof Profesor){
                encontrado = 1;
                prof = (Profesor) personas.get(i);
            }
        }
       
        cambiarEspecialidad(prof, "Ciencias Sociales");
    }
    
}
