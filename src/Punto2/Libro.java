/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto2;

/**
 * Esta es la clase que representa un libro y guarda la información de un libro.
 * @author Alejandro Alvarado
 * @since 07/10/2018
 * @version 1.0
 */
public class Libro {
    private String nombre;
    private double precio;
    private String autor;
    private String editorial;
    private int[] cantidadDisp;

    /**
     * El constructor requiere saber toda la información del libro, por lo tanto
     * este contiene los parametros necesarios para la creación de un Libro.
     * @param nombre
     * @param precio
     * @param autor
     * @param editorial
     * @param primeraMano
     * @param segundaMano
     */
    public Libro(String nombre, double precio, String autor, String editorial, int primeraMano, int segundaMano) {
        this.nombre = nombre;
        this.precio = precio;
        this.autor = autor;
        this.editorial = editorial;
        this.cantidadDisp = new int[2];
        this.cantidadDisp[0] = primeraMano;
        this.cantidadDisp[1] = segundaMano;
    }

    /**
     * Este metodo returna el nombre del libro en un String.
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este metodo asigna el valor del nombre del libro como String.
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este metodo returna el precio del libro como un double.
     * @return
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Este metodo asigna el precio al libro como un double.
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Este metodo returna el nombre del autor en un String.
     * @return
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Este metodo asigna el nombre del autor como un String.
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Este metodo returna el nombre de la editorial del libro en un String.
     * @return
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Este metodo asigna el nombre de la editorial del libro como un String.
     * @param editorial
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Este metodo returna un arreglo de tamaño 2 el cual contiene la cantidad
     * de libros disponibles, en el primer espacio del arreglo va la cantidad
     * de libros nuevos y en la segunda van la cantidad de libros de segunda
     * mano.
     * @return
     */
    public int[] getCantidadDisp() {
        return cantidadDisp;
    }

    /**
     * Este metodo asigna la cantidad de libros disponibles, en el primer 
     * espacio del arreglo va la cantidad de libros nuevos y en la segunda van 
     * la cantidad de libros de segunda mano.
     * @param cantidadDisp
     */
    public void setCantidadDisp(int[] cantidadDisp) {
        this.cantidadDisp = cantidadDisp;
    }
    
    /**
     * Este metodo muestra en pantalla los valores de cada atributo que tiene
     * el libro.
     */
    public void mostrarInfo (){
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Precio: " + this.precio);
        System.out.println("Autor: " + this.autor);
        System.out.println("Editorial: " + this.editorial);
        System.out.println("Cantidad disponible: " + Integer.toString(cantidadDisp[0]+cantidadDisp[1]));
        System.out.println(" Primera mano: " + cantidadDisp[0]);
        System.out.println(" Segunda mano: " + cantidadDisp[1]);
        
    }
}
