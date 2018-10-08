/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto3;

import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class Module {
    String lecturer;
    String name;
    ArrayList<Grade> grades;

    public Module(String lecturer, String name) {
        this.lecturer = lecturer;
        this.name = name;
    }

    public Module(String lecturer, String name, ArrayList<Grade> grades) {
        this.lecturer = lecturer;
        this.name = name;
        this.grades = grades;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }
}
