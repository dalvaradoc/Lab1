/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

import becker.robots.City;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class Estante extends becker.robots.Thing {
    
    private static Posicion[] posiciones = new Posicion[20];
    
    private int idNumber;
    private Producto[] productos;
    private boolean active;
    
    public Estante(City city, int i, int i1, int idNumber) {
        super(city, i, i1);
        this.idNumber = idNumber;
        posiciones[idNumber] = new Posicion(i1, i);
        productos = new Producto[10];
        showProductos();
        active = false;
    }
    
    private void showProductos (){
        int c = 0;
        for (int i = 0; i < this.getListOfProducts().length; i++){
            c += this.getListOfProducts()[i];
        }
        this.getIcon().setLabel(Integer.toString(c));
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public boolean addProducto (Producto p){
        for (int i = 0; i < 10; i++){
            if (productos[i] == null){
                productos[i] = p;
                showProductos();
                return true;
            }
        }
        //si no encuentra espacio returna falso
        return false;
    }
    
    public boolean quitProducto (int tipo){
        for (int i = 0; i < 10; i++){
            if (productos[i] != null && productos[i].getIdTipo() == tipo){
                //El empleado saca el producto y se elimina del estante
                productos[i] = null;
                showProductos();
                return true;
            }
        }
        //si no encuentra un producto con el tipo especificado returna falso
        return false;
    }
    
    public int[] getListOfProducts (){
        int[] prodDisp = new int[Producto.getCantidadTipos()];
        for (int i = 0; i < 10; i++){
            if (productos[i] != null){
                prodDisp[productos[i].getIdTipo()]++;
            }
        }
        return prodDisp;
    }

    public static Posicion[] getPosiciones() {
        return posiciones;
    }
}
