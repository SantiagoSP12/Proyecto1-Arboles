/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.learning.arbolesdebusqueda.Arboles;

import java.util.List;

/**
 *
 * @author Santiago
 */
public interface IArbolBusqueda<K extends Comparable<K>,V>{
    public void insertar(K clave,V valor);
    public void eliminar(K clave);
    public V buscar(K clave);
    public boolean contiene(K clave);
    public List<K> recorridoPorNiveles();
    public List<K> recorridoEnPreOrden();
    public List<K> recorridoEnInOrden();
    public List<K> recorridoEnPostOrden();
    public int size();
    public int altura();
    public void vaciar();
    public boolean esArbolVacio();
    public int nivel();

}

