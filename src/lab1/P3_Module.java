/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class P3_Module {
    String lecturer;
    String name;
    ArrayList<P3_Grade> grades;

    public P3_Module(String lecturer, String name) {
        this.lecturer = lecturer;
        this.name = name;
    }

    public P3_Module(String lecturer, String name, ArrayList<P3_Grade> grades) {
        this.lecturer = lecturer;
        this.name = name;
        this.grades = grades;
    }

    public ArrayList<P3_Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<P3_Grade> grades) {
        this.grades = grades;
    }
}
