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
public class P3_University {
    ArrayList<P3_Student> students;
    ArrayList<P3_Module> modules;

    public P3_University() {
        students = new ArrayList<>();
        modules = new ArrayList<>();
    }
    
    public void addStudent (String nombre) {
       P3_Student student = new P3_Student(nombre, modules);
       students.add(student);
    }
    
    public void addModule (String lecturer, String nombre) {
       P3_Module modulo = new P3_Module(lecturer, nombre);
       modules.add(modulo);
    }
}
