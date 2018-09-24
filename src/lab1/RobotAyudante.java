/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import becker.robots.City;
import becker.robots.Direction;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class RobotAyudante extends becker.robots.Robot {
    private static int[][] posiciones = new int[10][2];
    
    private int idNumber;
    private boolean active;
    private Estante[] estantes;
    
    public RobotAyudante(City city, int i, int i1, Direction drctn, int idNumber, Estante[] estantes) {
        super(city, i, i1, drctn);
        this.idNumber = idNumber;
        this.estantes = estantes;
        setPosiciones();
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
    
    private boolean frontClearOfRobots () {
        int[] temp = new int[2];
        temp[0] = this.getStreet();
        temp[1] = this.getAvenue();
        
        Direction dir = this.getDirection();
        switch (dir){
            case NORTH:
                temp[0] -= 1;
                break;
            case SOUTH:
                temp[0] += 1;
                break;
            case EAST:
                temp[1] += 1;
                break;
            case WEST:
                temp[1] -= 1;
        }
            
        for (int i = 0; i < 10; i++){
            if (posiciones[i][0] == temp[0]){
                if (posiciones[i][1] == temp[1]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private void setPosiciones (){
        posiciones[idNumber][0] = this.getStreet();
        posiciones[idNumber][1] = this.getAvenue();
    }
    
    public void mover (int n){
        for (int i = 0; i < n; i++){
            if (frontClearOfRobots() && frontIsClear()){
                this.move();
                setPosiciones();
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RobotAyudante.class.getName()).log(Level.SEVERE, null, ex);
                }
                mover(n);
            }
        }
    }
    
    public void rot (int n){
        for (int i = 0; i < n; i++){
            this.turnLeft();
        }
    }
    
    public void rotUntilDir (Direction dir){
        while (this.getDirection() != dir){
            this.rot(1);
        }
    }
    
    public void moverUntilWall (){
        while (this.frontIsClear()){
            this.mover(1);
        }
    }
    
    public void getEstante (int n){
        if (estantes[n].isActive()){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RobotAyudante.class.getName()).log(Level.SEVERE, null, ex);
            }
            getEstante(n);
        } else {
            this.active = true;
            estantes[n].setActive(true);
            this.mover(1);
            this.rot(1);
            this.moverUntilWall();
            this.rot(3);
            this.mover(Math.abs(this.getStreet() - Estante.getPosiciones()[n].getY()));
            this.rot(3);
            this.mover(Math.abs(this.getAvenue()- Estante.getPosiciones()[n].getX()));
            if (this.canPickThing()){
                this.pickThing();
            }
            this.mover(1);
            this.rot(1);
            this.moverUntilWall();
            this.rot(3);
            this.moverUntilWall();
            this.rot(3);
            while (this.getStreet()< 6){
                this.mover(1);
            }
        }
    }
    
    public void returnEstante (int n){
        this.rotUntilDir(Direction.WEST);
        this.mover(Math.abs(this.getAvenue()- Estante.getPosiciones()[n].getX())-1);
        this.rotUntilDir(Direction.NORTH);
        this.mover(Math.abs(this.getStreet() - Estante.getPosiciones()[n].getY()));
        this.rot(1);
        this.mover(1);
        this.putThing();
        estantes[n].setActive(false);
        this.rot(1);
        this.mover(Math.abs(this.getStreet() - 7));
        this.rot(1);
        this.moverUntilWall();
        this.rot(3);
        this.mover(3);
        this.rot(3);
        this.mover(Math.abs(this.getAvenue() - this.getIdNumber()));
        this.rot(3);
        this.mover(1);
        this.active = false;
    }    
}
