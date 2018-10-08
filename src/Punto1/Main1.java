/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

import becker.robots.*;

public class Main1 {
    
    public static void main (String[] args) {
        
        //Se crea la ciudad y el objeto Sistema, el cual controla la informacion
        //de los RobotsAyudantes.
        City ciudad;
        Sistema sistema;
        
        
        //Se crea la bodega, usando Walls y Things.
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

        //Se inicializa el sistema dandole la información de la bodega.
        sistema = new Sistema(ciudad);
        
        
        //Se llama al sistema para que haga un pedido de 11 productos tipo 0, 
        //con lo cual verifica si hay la cantidad en los estantes y luego hace
        //que los robots vayan por los estantes que se necesiten para completar
        //el pedido, llevando así los estantes a la zona donde esta el empleado,
        //el cual "elimina" los productos del estante.
        sistema.pedido(11, 0);
        
        //Se le pide al sistema almacenar en el estante 3, el sistema hace que
        //un robot lleve el estante 3 a la zona donde esta el empleado.
        sistema.almacenar(3);
        
    }
    
}
