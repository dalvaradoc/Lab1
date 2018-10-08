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
public class University {
    ArrayList<Student> students;
    ArrayList<Module> modules;

    public University() {
        students = new ArrayList<>();
        modules = new ArrayList<>();
    }
    
    public void addStudent (String nombre) {
       Student student = new Student(nombre, modules);
       students.add(student);
    }
    
    public void addModule (String lecturer, String nombre) {
       Module modulo = new Module(lecturer, nombre);
       modules.add(modulo);
    }
}
