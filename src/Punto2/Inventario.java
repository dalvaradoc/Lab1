/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto2;

import java.util.ArrayList;

/**
 * Esta clase almacena la informacion de los libros, es la que crea los libros
 * o los elimina. Además, contiene los metodos para buscar un libro en el
 * inventario.
 * @author Alejandro Alvarado
 * @since 07/10/2018
 * @version 1.0
 */
public class Inventario {
    ArrayList<Libro> libros;

    /**
     * Consctructor de la clase, no contiene ningun valor a asignar.
     */
    public Inventario() {
        libros = new ArrayList<>();
    }
    
    /**
     * Este metodo crea y asigna un objeto tipo Libro al inventario. Ya que
     * crea el objeto necesita todos los parametros necesarios en el constructor
     * de un objeto tipo libro.
     * @param nombre
     * @param precio
     * @param autor
     * @param editorial
     * @param primeraMano
     * @param segundaMano
     * @return
     */
    public boolean addLibro (String nombre, double precio, String autor, String editorial, int primeraMano, int segundaMano){
        Libro libro = new Libro(nombre, precio, autor, editorial, primeraMano, segundaMano);
        return libros.add(libro);
    }
    
    /**
     * Este metodo elimina un Libro del inventario, usando su nombre como valor
     * de busqueda.
     * @param nombre
     * @return
     */
    public boolean deleteLibro (String nombre){
        for (Libro l : libros){
            if (l.getNombre() == nombre){
                return libros.remove(l);
            }
        }
        return false;
    }
    
    /**
     * Este metodo busca un libro por su nombre en el inventario, si se encuentra
     * se mostrara su información en la consola, si no se encuentra se mostrara
     * en la consola que no se encontro. (El nombre debe estar escrito exactamente
     * igual a como esta guardado)
     * @param nombre
     */
    public void buscarPorNombre (String nombre){
        for (Libro l : libros){
            if (l.getNombre() == nombre){
                l.mostrarInfo();
                System.out.println("\n");
                return;
            }
        }
        System.out.println("No se encontro el libro.\n");
    }
    
    /**
     * Este metodo busca un libro usando una palabra clave. Si hay algun libro
     * que tenga esta palabra en su titulo, autor o editorial entonces se 
     * mostrara su informacion en la consola, si no se encuentra nignuno se 
     * mostrara en la consola que no se encontro.
     * @param palabra
     */
    public void buscarPorPalabras (String palabra){
        ArrayList<Libro> temp = new ArrayList<>();
        for (Libro l : libros){
            if (l.getNombre().contains(palabra) || l.getAutor().contains(palabra) || l.getEditorial().contains(palabra)){
                temp.add(l);
            }
        }
        if (!temp.isEmpty()){
            mostrarInfoCadaLibro(temp);
        } else {
            System.out.println("No se encontro ningun libro.");
        }
    }
    
    /**
     * Este metodo busca un libro por su autor en el inventario, si se encuentra
     * se mostrara su información en la consola, si no se encuentra se mostrara
     * en la consola que no se encontro. (El autor debe estar escrito exactamente
     * igual a como esta guardado)
     * @param autor
     */
    public void buscarPorAutor (String autor){
        ArrayList<Libro> temp = new ArrayList<>();
        for (Libro l : libros){
            if (l.getAutor() == autor){
                temp.add(l);
            }
        }
        if (!temp.isEmpty()){
            mostrarInfoCadaLibro(temp);
        } else {
            System.out.println("No se encontro ningun libro.");
        }
    }
    
    /**
     * Este metodo busca un libro por su editorial en el inventario, si se encuentra
     * se mostrara su información en la consola, si no se encuentra se mostrara
     * en la consola que no se encontro. (La editorial debe estar escrita exactamente
     * igual a como esta guardado)
     * @param editorial
     */
    public void buscarPorEditorial (String editorial){
        ArrayList<Libro> temp = new ArrayList<>();
        for (int i = 0; i < libros.size(); i++){
            if (libros.get(i).getEditorial() == editorial){
                temp.add(libros.get(i));
            }
        }
        if (!temp.isEmpty()){
            mostrarInfoCadaLibro(temp);
        } else {
            System.out.println("No se encontro ningun libro.");
        }
    }
    
    /**
     * Este metodo mostrara en pantalla la informacion de cada libro que este
     * en un ArrayList de libros.
     * @param temp
     */
    public void mostrarInfoCadaLibro (ArrayList<Libro> temp){
        for (Libro l : temp){
            l.mostrarInfo();
            System.out.println("\n");
        }
    }
    
    /**
     * Este metodo mostrara en la consola el nombre de cada Libro que haya en el
     * inventario.
     */
    public void mostrarInfoInventario (){
        System.out.println("Cantidad de libros: " + libros.size());
        for (Libro l : libros){
            System.out.println("- " + l.getNombre());
        }
        System.out.println("\n");
    }
}
