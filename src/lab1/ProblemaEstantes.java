/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import becker.robots.*;

/**
 *
 * @author Alejandro
 */
public class ProblemaEstantes {
    
    private City ciudad;
    private Sistema sistema;

    public ProblemaEstantes() {
        ciudad = new City(13, 20);
        for (int i = 0; i < 12; i++){
            Wall wall = new Wall(ciudad, 0, i, Direction.NORTH);
            if (i < 11) {
                Wall wall2 = new Wall(ciudad, i, 0, Direction.WEST);  
                if (i != 6){
                    Wall wall4 = new Wall(ciudad, i, 11, Direction.EAST);
                }
            }
            Wall wall3 = new Wall(ciudad, 10, i, Direction.SOUTH);
        }

        sistema = new Sistema(ciudad);
        
        sistema.pedido(11, 0);
        
        
        sistema.almacenar(3);
        
//        for (int i = 0; i < 10; i++){
//            sistema.almacenar(i);
//        }
    }
    
}
