/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learning.arbolesdebusqueda.Arboles.Excepciones;

/**
 *
 * @author Santiago
 */
public class ExcepcionDatoYaExiste extends RuntimeException{
    public ExcepcionDatoYaExiste(){
        super("Dato ya existe en el arbol");
    }
    public ExcepcionDatoYaExiste(String message){
        super(message);
    }
}