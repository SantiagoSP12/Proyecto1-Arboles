/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learning.arbolesdebusqueda.Arboles;

/**
 *
 * @author Santiago
 */
import java.util.ArrayList;
import java.util.List;

public class NodoMVias <K,V>{
    private List<K> listaDeDatos;
    private List<V> listaDeValores;
    private List<NodoMVias<K,V>> listaDeHijos;

    public static NodoMVias nodoVacio(){ return null; }

    public NodoMVias (int orden ,K primeraClave,V primerValor)
    {this(orden);
        this.listaDeDatos.set(0, primeraClave);
        this.listaDeValores.set(0,primerValor);
    }

    public static Object datoVacio(){ return null; }

    public static boolean esNodoVacio(NodoMVias nodo){ return nodo==NodoMVias.nodoVacio();}

    public NodoMVias(int orden){
        listaDeDatos = new ArrayList<>();
        listaDeValores = new ArrayList<>();
        listaDeHijos = new ArrayList<>();
        for(int i=0;i<orden;i++){
            listaDeDatos.add((K)NodoMVias.datoVacio());
            listaDeValores.add((V)NodoMVias.datoVacio());
            listaDeHijos.add(NodoMVias.nodoVacio());
        }
        listaDeHijos.add(NodoMVias.nodoVacio());
    }

    public K getDato(int posicion){
        return listaDeDatos.get(posicion);
    }

    public void setDato(int posicion,K dato){
        listaDeDatos.set(posicion,dato);
    }
    
    public V getValor(int posicion)
    {
        return listaDeValores.get(posicion);
    }
    public void setValor (int posicion, V Valor)
    {
        this.listaDeValores.set(posicion,Valor);
    }

    public boolean esDatoVacio(int posicion){
        return listaDeDatos.get(posicion)==NodoMVias.datoVacio();
    }

    public NodoMVias<K,V> getHijo(int posicion){
        return listaDeHijos.get(posicion);
    }

    public void setHijo(int posicion, NodoMVias<K,V> hijo){
        listaDeHijos.set(posicion, hijo);
    }

    public boolean esHijoVacio(int posicion){
        return listaDeHijos.get(posicion)==NodoMVias.nodoVacio();
    }

    public boolean esHoja(){
        for(int i=0;i<listaDeHijos.size();i++){
            if(!this.esHijoVacio(i)){
                return false;
            }
        }
        return true;
    }

    public int nroDeDatosNoVacios(){
        int cantidadDeDatos=0;
        for(int i=0;i<listaDeDatos.size();i++){
            if(!this.esDatoVacio(i)){
                cantidadDeDatos++;
            }
        }
        return cantidadDeDatos;
    }

    public boolean estanDatosLlenos(){
        return nroDeDatosNoVacios()==listaDeDatos.size();
    }

    @Override
    public String toString(){
        String representacion=" [";
        for (int i = 0; i <listaDeDatos.size(); i++) {
            if (!this.esDatoVacio(i)) {
                representacion += this.getDato(i);
                if (i < this.nroDeDatosNoVacios() - 1) {
                    representacion += ", ";
                }
            }else {
                representacion += ", null";
            }
        }
        representacion += "]";
        return representacion;
    }
    
    public String toStringValores(){
        String representacion=" [";
        for (int i = 0; i <listaDeDatos.size(); i++) {
            if (!this.esDatoVacio(i)) {
                representacion += "("+this.getDato(i)+") "+this.getValor(i);
                if (i < this.nroDeDatosNoVacios() - 1) {
                    representacion += ", ";
                }
            }else {
                representacion += ", ";
            }
        }
        representacion += "]";
        return representacion;
    }

}
