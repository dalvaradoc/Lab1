/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto2;

/**
 *
 * Esta es la clase main que crea un Inventario, luego le agrega cinco objetos
 * de la clase Libro para luego probar los distintos tipos de busqueda de libros
 * del inventario. (En netbeans, para probar la solucion hay que usar "Shift + F6"
 * ya que el main principal lo usa el primer problema)
 * @author Alejandro Alvarado
 * @since 07/10/2018
 * @version 1.0
 */

public class Main2 {
    public static void main (String[] args){
        //Se crea el inventario
        Inventario inventario = new Inventario();
        
        //Se agregan los 5 libros de prueba
        inventario.addLibro("Somos polvo de estrellas", 60.455, "Jose Maria Maza ", "Planeta", 13, 0);
        inventario.addLibro("Manual De Terapia Sistemica Breve", 107.273, "Felipe E. Garcia", "Mediterraneo", 4, 7);
        inventario.addLibro("Física para la ciencia y la tecnología, Vol. 2: Electricidad y magnetismo/ Luz", 148.636, "Paul Allen Tipler", "Reverte", 5, 0);
        inventario.addLibro("La cuarta revolución industrial", 60.773, "Klaus Schwab", "Debate", 0, 15);
        inventario.addLibro("Fundamentos De Ingenieria Geotecnica", 109.318, "Braja m. das", "Cengage learning editores, s.a. de c.v.", 5, 3);
        
        //Se mostraran los nombres de todos los libros del inventario.
        inventario.mostrarInfoInventario();
        
        //Se prueban las diferentes busquedas
        inventario.buscarPorNombre("Somos polvo de estrellas");
        
        inventario.buscarPorAutor("Klaus Schwab");
        
        inventario.buscarPorEditorial("Reverte");
        
        inventario.buscarPorNombre("Geotecnica");
        
        inventario.buscarPorPalabras("Geotecnica");
        
    }
}
