/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import becker.robots.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class P1_Sistema {
    private City ciudad;
    private P1_RobotAyudante[] robots;
    private P1_Estante[] estantes;
    private int ganancias;

    public P1_Sistema(City ciudad) {
        this.ciudad = ciudad;
        robots = new P1_RobotAyudante[10];
        estantes = new P1_Estante[20];
        ganancias = 0;
        
        for (int i = 0; i < 10; i++){
            P1_RobotAyudante robot = new P1_RobotAyudante(ciudad, 9, i, Direction.NORTH, i, estantes);
            robots[i] = robot;
        }
        
        for (int i = 0; i < 5; i++){
            P1_Estante e1 = new P1_Estante(ciudad, 1+i, 1, i);
//            for (int j = 0; j < (int)Math.floor(Math.random()*7); j++){
//                Producto p = new Producto((int)Math.floor(Math.random()*2));
//                e1.addProducto(p);
//            }
            e1.addProducto(new P1_Producto(0));
            e1.addProducto(new P1_Producto(0));
            estantes[i] = e1;
            P1_Estante e2 = new P1_Estante(ciudad, 1+i, 3, i+5);
//            for (int j = 0; j < (int)Math.floor(Math.random()*7); j++){
//                Producto p = new Producto((int)Math.floor(Math.random()*2));
//                e2.addProducto(p);
//            }
            e2.addProducto(new P1_Producto(0));
            e2.addProducto(new P1_Producto(0));
            estantes[i+5] = e2;
            P1_Estante e3 = new P1_Estante(ciudad, 1+i, 5, i+10);
//            for (int j = 0; j < (int)Math.floor(Math.random()*7); j++){
//                Producto p = new Producto((int)Math.floor(Math.random()*2));
//                e3.addProducto(p);
//            }
            e3.addProducto(new P1_Producto(0));
            e3.addProducto(new P1_Producto(0));
            estantes[i+10] = e3;
            P1_Estante e4 = new P1_Estante(ciudad, 1+i, 7, i+15);
//            for (int j = 0; j < (int)Math.floor(Math.random()*7); j++){
//                Producto p = new Producto((int)Math.floor(Math.random()*2));
//                e4.addProducto(p);
//            }
            e4.addProducto(new P1_Producto(0));
            e4.addProducto(new P1_Producto(0));
            estantes[i+15] = e4;
        }        
    }
    
    private P1_RobotAyudante getDispRobot (){
        for (int i = 0; i < 10; i++){
            if (!robots[i].isActive()){
                return robots[i];
            }
        }
        return null;
    }
    
    public void almacenar (int estantesId) {
        Thread thread = new Thread () {
            public void run () {
                P1_RobotAyudante temp = getDispRobot();
                getDispRobot().getEstante(estantesId);
                
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(P1_Sistema.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                P1_Producto pro = new P1_Producto(2);
                estantes[estantesId].addProducto(pro);
                temp.returnEstante(estantesId);
                
            }
        };
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(P1_Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean pedido (int cantidad, int tipo) {
        int c = 0;
        for (int i = 0; i < 20; i++){
            c += estantes[i].getListOfProducts()[tipo];
        }
        if (c < cantidad){
            return false;
        }
        
        int c2 = 0;
        for (int i = 0; i < 10 && c2 < cantidad; i++){
            int prodEst = estantes[i].getListOfProducts()[tipo];
            if (prodEst != 0){
                final int index = i;
                if (cantidad - prodEst - c2 >= 0){
                    c2 += prodEst;
                    Thread thread = new Thread () {
                        public void run () {
                            P1_RobotAyudante temp = getDispRobot();
                            temp.getEstante(index);
                            
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(P1_Sistema.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            for (int k = 0; k < prodEst; k++){
                                estantes[index].quitProducto(tipo);
                            }
                            temp.returnEstante(index);

                        }
                    };
                    thread.start();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(P1_Sistema.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    final int kk = cantidad - c2;
                    c2 += prodEst;
                    Thread thread = new Thread () {
                        public void run () {
                            P1_RobotAyudante temp = getDispRobot();
                            temp.getEstante(index);
                            
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(P1_Sistema.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            for (int k = 0; k < kk; k++){
                                estantes[index].quitProducto(tipo);
                            }
                            temp.returnEstante(index);

                        }
                    };
                    thread.start();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(P1_Sistema.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
            
        } 
        
        ganancias += cantidad * P1_Producto.getPrecios()[tipo];
        
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Tipo de producto: tipo " + tipo);
        System.out.println("Precio total: " + (P1_Producto.getPrecios()[tipo]*cantidad) + '\n');
        
        return true;
    }
}
