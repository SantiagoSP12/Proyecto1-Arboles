/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learning.arbolesdebusqueda.Arboles;

import com.learning.arbolesdebusqueda.Arboles.Excepciones.ExcepcionDatoNoExiste;
import com.learning.arbolesdebusqueda.Arboles.Excepciones.ExcepcionDatoYaExiste;

/**
 *
 * @author Santiago
 * @param K
 * @param V
 */
public class AVL<K extends Comparable<K>,V> extends ABB<K,V>{
    private static final int RANGO_INFERIOR=-1;
    private static final int RANGO_SUPERIOR=1;

    @Override
    public void insertar(K datoAInsertar,V valorAsociado){
        this.raiz=insertar(this.raiz,datoAInsertar,valorAsociado);
    }

    private NodoBinario<K,V> insertar(NodoBinario<K,V> nodoActual, K datoAInsertar,V valorAsociado){
        if(NodoBinario.esNodoVacio(nodoActual)){
            return new NodoBinario<>(datoAInsertar, valorAsociado);
        }
        K datoActual= nodoActual.getDato();
        if(datoAInsertar.compareTo(datoActual)<0){
            NodoBinario<K,V> supuestoNuevoHI=insertar(nodoActual.getHijoIzquierdo(),datoAInsertar,valorAsociado);
            nodoActual.setHijoIzquierdo(supuestoNuevoHI);
            return balancear(nodoActual);
        }
        if(datoAInsertar.compareTo(datoActual)>0){
            NodoBinario<K,V> supuestoNuevoHD=insertar(nodoActual.getHijoDerecho(),datoAInsertar, valorAsociado);
            nodoActual.setHijoDerecho(supuestoNuevoHD);
            return balancear(nodoActual);
        }
        throw new ExcepcionDatoYaExiste();
    }

    private NodoBinario<K,V> balancear(NodoBinario<K,V> nodo) {
        int alturaIzq=super.alturaR(nodo.getHijoIzquierdo());
        int alturaDer=super.alturaR(nodo.getHijoDerecho());
        int diferencia=alturaIzq-alturaDer;
        if(diferencia>RANGO_SUPERIOR){
            NodoBinario<K,V> nodoActHI=nodo.getHijoIzquierdo();
            alturaIzq=super.alturaR(nodoActHI.getHijoIzquierdo());
            alturaDer=super.alturaR(nodoActHI.getHijoDerecho());
            if(alturaDer>alturaIzq) {
                return rotacionDoblePorDerecha(nodo);
            }
            return rotacionSimplePorDerecha(nodo);
        }
        if(diferencia<RANGO_INFERIOR){
            NodoBinario<K,V> nodoActHD=nodo.getHijoDerecho();
            alturaIzq=super.alturaR(nodoActHD.getHijoIzquierdo());
            alturaDer=super.alturaR(nodoActHD.getHijoDerecho());
            if(alturaIzq>alturaDer){
                return rotacionDoblePorIzquierda(nodo);
            }
            return rotacionSimplePorIzquierda(nodo);
        }
        return nodo;
    }

    private NodoBinario<K,V> rotacionDoblePorIzquierda(NodoBinario<K,V> nodo) {
        NodoBinario<K,V> nodoPadre=rotacionSimplePorDerecha(nodo.getHijoDerecho());
        nodo.setHijoDerecho(nodoPadre);
        return rotacionSimplePorIzquierda(nodo);
    }

    private NodoBinario<K,V> rotacionDoblePorDerecha(NodoBinario<K,V> nodo) {
        NodoBinario<K,V> nodoPadre=rotacionSimplePorIzquierda(nodo.getHijoIzquierdo());
        nodo.setHijoIzquierdo(nodoPadre);
        return rotacionSimplePorDerecha(nodo);
    }

    private NodoBinario<K,V> rotacionSimplePorIzquierda(NodoBinario<K,V> nodo){
        NodoBinario<K,V> nodoPadre=nodo.getHijoDerecho();
        nodo.setHijoDerecho(nodoPadre.getHijoIzquierdo());
        nodoPadre.setHijoIzquierdo(nodo);
        return nodoPadre;
    }

    private NodoBinario<K,V> rotacionSimplePorDerecha(NodoBinario<K,V> nodo){
        NodoBinario<K,V> nodoPadre=nodo.getHijoIzquierdo();
        nodo.setHijoIzquierdo(nodoPadre.getHijoDerecho());
        nodoPadre.setHijoDerecho(nodo);
        return nodoPadre;
    }

    @Override
    public void eliminar(K datoAEliminar) {
        //no es asi de simple//copie y pegue, en casi todo return poner el balancear
        this.raiz=eliminar(this.raiz,datoAEliminar);
    }

    private NodoBinario<K,V> eliminar(NodoBinario<K,V> nodo, K datoAEliminar) {
        if(NodoBinario.esNodoVacio(nodo)){
            throw new ExcepcionDatoNoExiste();
        }
        K datoActual=nodo.getDato();
        if(datoAEliminar.compareTo(datoActual) < 0){
            nodo.setHijoIzquierdo(eliminar(nodo.getHijoIzquierdo(),datoAEliminar));
            return balancear(nodo);
        }
        if (datoAEliminar.compareTo(datoActual) > 0) {
            nodo.setHijoDerecho(eliminar(nodo.getHijoDerecho(),datoAEliminar));
            return balancear(nodo);
        }
        //caso 1: nodoActual es hoja
        if(nodo.esHoja()){
            return NodoBinario.nodoVacio();
        }
        //caso 2: nodoActual tiene al menos un hijo
        //caso 2.1: nodoActual tiene hijo izquierdo
        if(!nodo.esVacioHijoIzquierdo()&& nodo.esVacioHijoDerecho()){
            return balancear(nodo.getHijoIzquierdo());
        }
        //caso 2.2: nodoActual tiene hijo derecho
        if(nodo.esVacioHijoIzquierdo()&&!nodo.esVacioHijoDerecho()){
            return balancear(nodo.getHijoDerecho());
        }
        //caso 3: nodoActual tiene ambos hijos
        K reemplazo=super.obtenerSucesorInOrden(nodo.getHijoDerecho());
        V reemp=super.buscar(reemplazo);
        NodoBinario<K,V> supuestoHD=eliminar(nodo.getHijoDerecho(),reemplazo);
        nodo.setHijoDerecho(supuestoHD);
        nodo.setDato(reemplazo);
        nodo.setValor(reemp);
        return balancear(nodo);
    }

}