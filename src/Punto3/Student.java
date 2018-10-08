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
public class Student {
    String name;
    ArrayList<Grade> grades;
    ArrayList<Module> takes;

    public Student(String name, ArrayList<Module> takes) {
        this.name = name;
        this.takes = takes;
        grades = new ArrayList<>();
    }
    
    public void addGrade (int mark, Module modulo) {
        Grade grade = new Grade(mark, modulo, this);
        grades.add(grade);
    }
    
}
