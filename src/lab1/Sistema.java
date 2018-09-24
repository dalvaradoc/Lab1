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
public class Sistema {
    private City ciudad;
    private RobotAyudante[] robots;
    private Estante[] estantes;
    private int ganancias;

    public Sistema(City ciudad) {
        this.ciudad = ciudad;
        robots = new RobotAyudante[10];
        estantes = new Estante[20];
        ganancias = 0;
        
        for (int i = 0; i < 10; i++){
            RobotAyudante robot = new RobotAyudante(ciudad, 9, i, Direction.NORTH, i, estantes);
            robots[i] = robot;
        }
        
        for (int i = 0; i < 5; i++){
            Estante e1 = new Estante(ciudad, 1+i, 1, i);
//            for (int j = 0; j < (int)Math.floor(Math.random()*7); j++){
//                Producto p = new Producto((int)Math.floor(Math.random()*2));
//                e1.addProducto(p);
//            }
            e1.addProducto(new Producto(0));
            e1.addProducto(new Producto(0));
            estantes[i] = e1;
            Estante e2 = new Estante(ciudad, 1+i, 3, i+5);
//            for (int j = 0; j < (int)Math.floor(Math.random()*7); j++){
//                Producto p = new Producto((int)Math.floor(Math.random()*2));
//                e2.addProducto(p);
//            }
            e2.addProducto(new Producto(0));
            e2.addProducto(new Producto(0));
            estantes[i+5] = e2;
            Estante e3 = new Estante(ciudad, 1+i, 5, i+10);
//            for (int j = 0; j < (int)Math.floor(Math.random()*7); j++){
//                Producto p = new Producto((int)Math.floor(Math.random()*2));
//                e3.addProducto(p);
//            }
            e3.addProducto(new Producto(0));
            e3.addProducto(new Producto(0));
            estantes[i+10] = e3;
            Estante e4 = new Estante(ciudad, 1+i, 7, i+15);
//            for (int j = 0; j < (int)Math.floor(Math.random()*7); j++){
//                Producto p = new Producto((int)Math.floor(Math.random()*2));
//                e4.addProducto(p);
//            }
            e4.addProducto(new Producto(0));
            e4.addProducto(new Producto(0));
            estantes[i+15] = e4;
        }        
    }
    
    private RobotAyudante getDispRobot (){
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
                RobotAyudante temp = getDispRobot();
                getDispRobot().getEstante(estantesId);
                
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Producto pro = new Producto(2);
                estantes[estantesId].addProducto(pro);
                temp.returnEstante(estantesId);
                
            }
        };
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
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
                            RobotAyudante temp = getDispRobot();
                            temp.getEstante(index);
                            
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    final int kk = cantidad - c2;
                    c2 += prodEst;
                    Thread thread = new Thread () {
                        public void run () {
                            RobotAyudante temp = getDispRobot();
                            temp.getEstante(index);
                            
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
            
        } 
        
        ganancias += cantidad * Producto.getPrecios()[tipo];
        
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Tipo de producto: tipo " + tipo);
        System.out.println("Precio total: " + (Producto.getPrecios()[tipo]*cantidad) + '\n');
        
        return true;
    }
}
