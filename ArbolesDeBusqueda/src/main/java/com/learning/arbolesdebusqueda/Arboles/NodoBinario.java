/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learning.arbolesdebusqueda.Arboles;

/**
 *
 * @author Santiago
 */
public class NodoBinario<K,V> {
    private K dato;
    private V valor;
    private NodoBinario<K,V> hijoDerecho;
    private NodoBinario<K,V> hijoIzquierdo;

    public NodoBinario(){};
    
    public NodoBinario(K clave,V valor){ this.dato=clave; this.valor=valor; }

    public NodoBinario(K dato){ this.dato=dato; }

    public K getDato() { return dato; }

    public void setDato(K dato) { this.dato = dato; }
    
    public V getValor() { return valor; }

    public void setValor(V valor) { this.valor = valor; }

    public NodoBinario<K,V> getHijoIzquierdo() { return hijoIzquierdo; }

    public void setHijoIzquierdo(NodoBinario<K,V> hijoIzquierdo) { this.hijoIzquierdo = hijoIzquierdo; }

    public NodoBinario<K,V> getHijoDerecho() { return hijoDerecho; }

    public void setHijoDerecho(NodoBinario<K,V> hijoDerecho) { this.hijoDerecho = hijoDerecho; }

    public static NodoBinario nodoVacio(){ return null;}

    public boolean esVacioHijoIzquierdo(){ return this.hijoIzquierdo==nodoVacio(); }

    public boolean esVacioHijoDerecho(){ return this.hijoDerecho==nodoVacio(); }

    public boolean esHoja(){ return this.esVacioHijoDerecho()&&this.esVacioHijoIzquierdo(); }

    public static boolean esNodoVacio(NodoBinario nodo){ return nodo==NodoBinario.nodoVacio();}


}
