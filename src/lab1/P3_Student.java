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
public class P3_Student {
    String name;
    ArrayList<P3_Grade> grades;
    ArrayList<P3_Module> takes;

    public P3_Student(String name, ArrayList<P3_Module> takes) {
        this.name = name;
        this.takes = takes;
        grades = new ArrayList<>();
    }
    
    public void addGrade (int mark, P3_Module modulo) {
        P3_Grade grade = new P3_Grade(mark, modulo, this);
        grades.add(grade);
    }
    
}
