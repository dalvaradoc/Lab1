/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto3;

/**
 *
 * @author Alejandro
 */
public class Grade {
    int mark;
    Module module;
    Student student;

    public Grade(int mark, Module module, Student student) {
        this.mark = mark;
        this.module = module;
        this.student = student;
    }
    
}
