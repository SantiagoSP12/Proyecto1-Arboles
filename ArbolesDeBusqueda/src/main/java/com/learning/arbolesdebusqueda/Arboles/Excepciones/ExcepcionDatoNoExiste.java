/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learning.arbolesdebusqueda.Arboles.Excepciones;

/**
 *
 * @author Santiago
 */
public class ExcepcionDatoNoExiste extends RuntimeException {
    public ExcepcionDatoNoExiste(){
        super("Dato no existe en el arbol");
    }
    public ExcepcionDatoNoExiste(String message){
        super(message);
    }
}