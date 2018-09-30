/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Alejandro
 */
public class P1_Producto {
    private static int cantidadTipos = 3;
    private static double[] precios = new double[3];
    
    private double precio;
    private int idTipo;

    public P1_Producto(int idTipo) {        
        precios[0] = 10.5;
        precios[1] = 12.5;
        precios[2] = 3.0;
        
        this.idTipo = idTipo;
        precio = precios[idTipo];
    }
    
    public static int getCantidadTipos() {
        return cantidadTipos;
    }

    public static double[] getPrecios() {
        return precios;
    }

    public double getPrecio() {
        return precio;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public static void setCantidadTipos(int cantidadTipos) {
        P1_Producto.cantidadTipos = cantidadTipos;
    }

    public static void setPrecios(double[] precios) {
        P1_Producto.precios = precios;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    
}
