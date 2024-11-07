/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learning.arbolesdebusqueda.Arboles;

/**
 *
 * @author Santiago
 */
import com.learning.arbolesdebusqueda.Arboles.Excepciones.ExcepcionDatoNoExiste;
import com.learning.arbolesdebusqueda.Arboles.Excepciones.ExcepcionDatoYaExiste;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ABB<K extends Comparable<K>,V>
        implements IArbolBusqueda<K,V> {
    protected NodoBinario<K,V> raiz;

    public ABB(){}

    public ABB reconstruirConPreOrden(List<K> listaEnPreOrden, List<K> listaEnInOrden){return null;}

    public ABB reconstruirConPostOrden(List<K> listaEnPreOrden, List<K> listaEnInOrden){return null;}

    @Override
    public void insertar(K clave,V valor) {
        if(this.esArbolVacio()){
            this.raiz=new NodoBinario<>(clave,valor);
        }else{
            NodoBinario<K,V> nodoAux=this.raiz;
            NodoBinario<K,V> nodoAnterior=NodoBinario.nodoVacio();
            do{
                K datoDelNodoAux= nodoAux.getDato();
                nodoAnterior=nodoAux;
                if(clave.compareTo(datoDelNodoAux)<0){
                    nodoAux=nodoAux.getHijoIzquierdo();
                }else if(clave.compareTo(datoDelNodoAux)>0){
                    nodoAux=nodoAux.getHijoDerecho();
                }else{
                    nodoAux.setValor(valor);
                    return;
                }
            }while(!NodoBinario.esNodoVacio(nodoAux));
            NodoBinario<K,V> nuevoNodo=new NodoBinario<>(clave,valor);
            if(clave.compareTo(nodoAnterior.getDato())<0){
                nodoAnterior.setHijoIzquierdo(nuevoNodo);
            }else{
                nodoAnterior.setHijoDerecho(nuevoNodo);
            }
        }
    }

    public void eliminarI(K datoAEliminar) {
        if(datoAEliminar==null){
            throw new RuntimeException("Dato no puede ser nulo");
        }
        if(!this.esArbolVacio()){
            NodoBinario<K,V> nodoAux=this.raiz;
            NodoBinario<K,V> nodoAnterior=NodoBinario.nodoVacio();
            do{
                nodoAnterior=nodoAux;
                if(datoAEliminar.compareTo(nodoAux.getDato())<0){
                    nodoAux=nodoAux.getHijoIzquierdo();
                }else if(datoAEliminar.compareTo(nodoAux.getDato())>0){
                    nodoAux=nodoAux.getHijoDerecho();
                }
            }while(datoAEliminar.compareTo(nodoAux.getDato())!=0);

        }
    }

    @Override
    public void eliminar(K datoAEliminar){
        this.raiz=eliminarR(this.raiz,datoAEliminar);
    }

    protected NodoBinario<K,V> eliminarR(NodoBinario<K,V> nodoActual, K datoAEliminar){
        if(NodoBinario.esNodoVacio(nodoActual)){
            throw new ExcepcionDatoNoExiste();
        }
        K datoActual=nodoActual.getDato();
        if(datoAEliminar.compareTo(datoActual) < 0){
            nodoActual.setHijoIzquierdo(eliminarR(nodoActual.getHijoIzquierdo(),datoAEliminar));
            return nodoActual;
        }
        if (datoAEliminar.compareTo(datoActual) > 0) {
            nodoActual.setHijoDerecho(eliminarR(nodoActual.getHijoDerecho(),datoAEliminar));
            return nodoActual;
        }
        //caso 1: nodoActual es hoja
        if(nodoActual.esHoja()){
            return NodoBinario.nodoVacio();
        }
        //caso 2: nodoActual tiene al menos un hijo
        //caso 2.1: nodoActual tiene hijo izquierdo
        if(!nodoActual.esVacioHijoIzquierdo()&& nodoActual.esVacioHijoDerecho()){
            return nodoActual.getHijoIzquierdo();
        }
        //caso 2.2: nodoActual tiene hijo derecho
        if(nodoActual.esVacioHijoIzquierdo()&&!nodoActual.esVacioHijoDerecho()){
            return nodoActual.getHijoDerecho();
        }
        //caso 3: nodoActual tiene ambos hijos
        K reemplazo=obtenerSucesorInOrden(nodoActual.getHijoDerecho());
        V reem=this.buscar(reemplazo);
        NodoBinario<K,V> supuestoHD=eliminarR(nodoActual.getHijoDerecho(),reemplazo);
        nodoActual.setHijoDerecho(supuestoHD);
        nodoActual.setDato(reemplazo);
        nodoActual.setValor(reem);
        return nodoActual;
    }

    protected K obtenerSucesorInOrden(NodoBinario<K,V> hijoDerecho) {
        NodoBinario<K,V> nodoActual=hijoDerecho;
        while(!nodoActual.esVacioHijoIzquierdo()){
            nodoActual=nodoActual.getHijoIzquierdo();
        }
        return nodoActual.getDato();
    }

    @Override
    public V buscar(K dato) {
        if (dato == null) {
            throw new IllegalArgumentException("El dato no puede ser nulo");
        }
        if (this.esArbolVacio()) {
            return null;
        }
        NodoBinario<K,V> nodoActual = this.raiz;
        do {
            K datoActual = nodoActual.getDato();
            int comparacion = dato.compareTo(datoActual);
            if (comparacion < 0) {
                nodoActual = nodoActual.getHijoIzquierdo();
            } else if (comparacion > 0) {
                nodoActual = nodoActual.getHijoDerecho();
            } else {
                return nodoActual.getValor();
            }
        } while (!NodoBinario.esNodoVacio(nodoActual));
        return null;
    }

    @Override
    public boolean contiene(K dato) {
        return this.buscar(dato)!=null;
    }

    @Override
    public List<K> recorridoPorNiveles() {
        List<K> listaDeDatos=new LinkedList<>();
        if(!this.esArbolVacio()){
            Queue<NodoBinario<K,V>> colaDeNodos=new LinkedList<>();
            colaDeNodos.offer(this.raiz);
            NodoBinario<K,V> nodoQueTocaSacar;
            do{
                nodoQueTocaSacar=colaDeNodos.poll();
                listaDeDatos.add(nodoQueTocaSacar.getDato());
                if(!nodoQueTocaSacar.esVacioHijoIzquierdo()){
                    colaDeNodos.offer(nodoQueTocaSacar.getHijoIzquierdo());
                }
                if(!nodoQueTocaSacar.esVacioHijoDerecho()){
                    colaDeNodos.offer(nodoQueTocaSacar.getHijoDerecho());
                }
            }while(!colaDeNodos.isEmpty());
        }
        return listaDeDatos;
    }

    @Override
    public List<K> recorridoEnPreOrden() {
        List<K> listaDeDatos=new LinkedList<>();
        if(!this.esArbolVacio()){
            Stack<NodoBinario<K,V>> pilaDeNodos=new Stack<>();
            pilaDeNodos.push(this.raiz);
            NodoBinario<K,V> nodoQueTocaSacar;
            do{
                nodoQueTocaSacar=pilaDeNodos.pop();
                listaDeDatos.add(nodoQueTocaSacar.getDato());
                if(!nodoQueTocaSacar.esVacioHijoDerecho()){
                    pilaDeNodos.push(nodoQueTocaSacar.getHijoDerecho());
                }
                if(!nodoQueTocaSacar.esVacioHijoIzquierdo()){
                    pilaDeNodos.push(nodoQueTocaSacar.getHijoIzquierdo());
                }
            }while(!pilaDeNodos.isEmpty());
        }
        return listaDeDatos;
    }

    @Override
    public List<K> recorridoEnInOrden() {
        List<K> listaDeDatos = new LinkedList<>();
        if(!this.esArbolVacio()){
            Stack<NodoBinario<K,V>> pilaDeNodos = new Stack<>();
            NodoBinario<K,V> nodoAux=this.raiz;
            meterEnLaPilaParaInOrden(nodoAux,pilaDeNodos);
            do{
                nodoAux=pilaDeNodos.pop();
                listaDeDatos.add(nodoAux.getDato());
                if (!nodoAux.esVacioHijoDerecho()){
                    meterEnLaPilaParaInOrden(nodoAux.getHijoDerecho(),pilaDeNodos);
                }
            }while(!pilaDeNodos.isEmpty());
        }
        return listaDeDatos;
    }

    private void meterEnLaPilaParaInOrden(NodoBinario<K,V> nodoAux, Stack<NodoBinario<K,V>> pilaDeNodos) {
        while(!NodoBinario.esNodoVacio(nodoAux)){
            pilaDeNodos.push(nodoAux);
            if(!nodoAux.esVacioHijoIzquierdo()){
                nodoAux=nodoAux.getHijoIzquierdo();
            }
        }
    }

    public List<K> recorridoEnInOrdenR(){
        List<K> recorrido=new LinkedList<>();
        recorridoEnInOrdenR(this.raiz,recorrido);
        return recorrido;
    }

    private void recorridoEnInOrdenR(NodoBinario<K,V> nodoActual, List<K> recorrido) {
        if(NodoBinario.esNodoVacio(nodoActual)){
            return;
        }
        recorridoEnInOrdenR(nodoActual.getHijoIzquierdo(),recorrido);
        recorrido.add(nodoActual.getDato());
        recorridoEnInOrdenR(nodoActual.getHijoDerecho(),recorrido);
    }

    @Override
    public List<K> recorridoEnPostOrden() {
        List<K> listaDeDatos=new LinkedList<>();
        if(!this.esArbolVacio()){
            Stack<NodoBinario<K,V>> pilaDeNodos=new Stack<>();
            NodoBinario<K,V> nodoAux=this.raiz;
            meterEnLaPilaParaPostOrden(nodoAux,pilaDeNodos);
            do{
                nodoAux=pilaDeNodos.pop();
                listaDeDatos.add(nodoAux.getDato());
                if(!pilaDeNodos.isEmpty()) {
                    NodoBinario<K,V> nodoTope=pilaDeNodos.peek();
                    if(!nodoTope.esVacioHijoDerecho()
                        && nodoAux != nodoTope.getHijoDerecho()){
                        nodoAux = nodoTope.getHijoDerecho();
                        meterEnLaPilaParaPostOrden(nodoAux,pilaDeNodos);
                    }
                }
            }while(!pilaDeNodos.isEmpty());
        }
        return listaDeDatos;
    }

    private void meterEnLaPilaParaPostOrden(NodoBinario<K,V> nodoAux,
                                            Stack<NodoBinario<K,V>> pilaDeNodos) {
        while(!NodoBinario.esNodoVacio(nodoAux)){
            pilaDeNodos.push(nodoAux);
            if(!nodoAux.esVacioHijoIzquierdo()){
                nodoAux=nodoAux.getHijoIzquierdo();
            }else{
                nodoAux=nodoAux.getHijoDerecho();
            }
        }
    }

    @Override
    public int size() {
        int cantidadNodos=0;
        if(!this.esArbolVacio()){
            Stack<NodoBinario<K,V>> pilaDeNodos=new Stack<>();
            pilaDeNodos.push(this.raiz);
            do{
                NodoBinario<K,V> nodoAux=pilaDeNodos.pop();
                cantidadNodos++;
                if(!nodoAux.esVacioHijoDerecho()){
                    pilaDeNodos.push(nodoAux.getHijoDerecho());
                }
                if(!nodoAux.esVacioHijoIzquierdo()){
                    pilaDeNodos.push(nodoAux.getHijoIzquierdo());
                }
            }while(!pilaDeNodos.isEmpty());
        }
        return cantidadNodos;
    }

    public int sizeR() {
        return sizeR(this.raiz);
    }

    //el método amigo siempre lleva al menos un parámetro
    private int sizeR(NodoBinario<K,V> nodoActual) {
        if(NodoBinario.esNodoVacio(nodoActual)){
            return 0;
        }
        int sizePorIzquierda=sizeR(nodoActual.getHijoIzquierdo());
        int sizePorDerecha=sizeR(nodoActual.getHijoDerecho());
        return sizePorIzquierda+sizePorDerecha+1;
    }

    @Override
    public int altura() {
        int altura=0;
        if(!this.esArbolVacio()){
            Queue<NodoBinario<K,V>> colaDeNodos=new LinkedList<>();
            Queue<NodoBinario<K,V>> colaDeNodosTemp=new LinkedList<>();
            colaDeNodos.offer(this.raiz);
            NodoBinario<K,V> nodoAux;
            do{
                nodoAux=colaDeNodos.poll();
                if(!nodoAux.esVacioHijoIzquierdo()){
                    colaDeNodosTemp.offer(nodoAux.getHijoIzquierdo());
                }
                if(!nodoAux.esVacioHijoDerecho()){
                    colaDeNodosTemp.offer(nodoAux.getHijoDerecho());
                }
                if(colaDeNodos.isEmpty()){
                    altura++;
                    while(!colaDeNodosTemp.isEmpty()){
                        colaDeNodos.offer(colaDeNodosTemp.poll());
                    }
                }
            }while(!colaDeNodos.isEmpty());
        }
        return altura;
    }

    public int alturaR(){
        return alturaR(this.raiz);
    }

    protected int alturaR(NodoBinario<K,V> nodoActual){
        if(NodoBinario.esNodoVacio(nodoActual)){
            return 0;
        }
        int alturaPorIzquierda=alturaR(nodoActual.getHijoIzquierdo());
        int alturaPorDerecha=alturaR(nodoActual.getHijoDerecho());
        return alturaPorIzquierda>alturaPorDerecha?alturaPorIzquierda+1:alturaPorDerecha+1;
    }

    @Override
    public void vaciar() {
        this.raiz=NodoBinario.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(this.raiz);
    }

    @Override
    public int nivel() {
        return 0;
    }

    // nodos con un solo hijo en determinado nivel
    private int nodosConUnSoloHijoEnNivel(NodoBinario<K,V> nodo, int nivelObjetivo, int nivelActual){
        if(NodoBinario.esNodoVacio(nodo)){
            return 0;
        }

        if(nivelObjetivo==nivelActual){
            if((nodo.esVacioHijoIzquierdo()&&!nodo.esVacioHijoDerecho())
                    || (!nodo.esVacioHijoIzquierdo()&&nodo.esVacioHijoDerecho())){
                return 1;
            }
            return 0;
        }

        int nodosConUnHijoALaIzq=nodosConUnSoloHijoEnNivel(nodo.getHijoIzquierdo(),nivelObjetivo,
                nivelActual+1);
        int nodosConUnHijoALaDerecha=nodosConUnSoloHijoEnNivel(nodo.getHijoDerecho(),nivelObjetivo,
                nivelActual+1);
        return nodosConUnHijoALaIzq+nodosConUnHijoALaDerecha;
    }

    @Override
    public String toString() {
        return crearRepresentacion(raiz, "", "", "R");
    }

    private String crearRepresentacion(NodoBinario<K,V> nodo, String representacion, String prefijo, String tipo) {
        if (nodo == null) {
            return representacion + prefijo + (tipo.equals("I") ? "|-- " : (tipo.equals("D") ? "'-- " : "")) + "null\n";
        }

        representacion += prefijo + (tipo.equals("R") ? "" : (tipo.equals("D") ? "'-- " : "|-- ")) + "(" + tipo + ") " + nodo.getDato() + "\n";

        String nuevoPrefijo = prefijo + (tipo.equals("R") ? " " : (tipo.equals("I") ? "|    " : "     "));
        representacion = crearRepresentacion(nodo.getHijoIzquierdo(), representacion, nuevoPrefijo, "I");
        representacion = crearRepresentacion(nodo.getHijoDerecho(), representacion, nuevoPrefijo, "D");

        return representacion;
    }
    
    @Override
    public String toStringValor() {
        return crearRepresentacionValor(raiz, "", "", "R");
    }

    private String crearRepresentacionValor(NodoBinario<K,V> nodo, String representacion, String prefijo, String tipo) {
        if (nodo == null) {
            return representacion + prefijo + (tipo.equals("I") ? "|-- " : (tipo.equals("D") ? "'-- " : "")) + "\n";
        }

        representacion += prefijo + (tipo.equals("R") ? "" : (tipo.equals("D") ? "'-- " : "|-- ")) + "(" + tipo + ") " + nodo.getValor() + "\n";

        String nuevoPrefijo = prefijo + (tipo.equals("R") ? " " : (tipo.equals("I") ? "|    " : "     "));
        representacion = crearRepresentacionValor(nodo.getHijoIzquierdo(), representacion, nuevoPrefijo, "I");
        representacion = crearRepresentacionValor(nodo.getHijoDerecho(), representacion, nuevoPrefijo, "D");

        return representacion;
    }
}