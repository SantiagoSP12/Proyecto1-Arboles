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
import com.learning.arbolesdebusqueda.Arboles.Excepciones.ExcepcionOrdenInvalido;
import java.util.Stack;

public class AB <K extends Comparable<K>,V> extends AMV<K,V>{
    private final int nroMaximoDeDatos;
    private final int nroMinimoDeDatos;
    private final int nroMinimoDeHijos;

    public AB(){
        super();//setea ya el orden, o lo que es lo mismo nroMaximoDeHijos en 3
        nroMaximoDeDatos=2;
        nroMinimoDeDatos=1;
        nroMinimoDeHijos=2;
    }

    public AB(int orden) throws ExcepcionOrdenInvalido{
        super(orden);
        nroMaximoDeDatos=super.orden-1;
        nroMinimoDeDatos=nroMaximoDeDatos/2;
        nroMinimoDeHijos=nroMinimoDeDatos+1;//puede que no lo usen
    }

    @Override
    public void insertar(K datoAInsertar,V valorAsociado) {
        if (datoAInsertar==null){
            throw new IllegalArgumentException("Dato a insertar no puede ser nulo");
        }
        if(this.esArbolVacio()){
            this.raiz=new NodoMVias<>(this.orden,datoAInsertar,valorAsociado);
        }else{
            NodoMVias<K,V> nodoAux= this.raiz;
            Stack<NodoMVias<K,V>> pilaDeAncestros=new Stack<>();
            do{
                int posicionDeDatoEnNodo=this.buscarPosicionDeDatoEnNodo(nodoAux,datoAInsertar);
                if(posicionDeDatoEnNodo!=POSICION_INVALIDA){
                    nodoAux.setValor(posicionDeDatoEnNodo, valorAsociado);
                    return;
                }
                //En este punto punto sabemos que el datoAInsertar no está en el nodoAux
                if(nodoAux.esHoja()){
                    this.insertarDatoOrdenadoEnNodo(nodoAux,datoAInsertar,valorAsociado);
                    if(nodoAux.nroDeDatosNoVacios()>this.nroMaximoDeDatos){
                        dividirNodo(nodoAux,pilaDeAncestros);
                    }
                    nodoAux=NodoMVias.nodoVacio();
                }else{
                    //en este punto el nodoAux no es hoja
                    int posicionPorDondeBajar=this.buscarPosicionParaBajar(nodoAux,datoAInsertar);
                    pilaDeAncestros.push(nodoAux);
                    nodoAux=nodoAux.getHijo(posicionPorDondeBajar);
                }
            }while(!NodoMVias.esNodoVacio(nodoAux));
        }//fin else
    }

    private void dividirNodo(NodoMVias<K,V> nodoAux, Stack<NodoMVias<K,V>> pilaDeAncestros) {
        NodoMVias nodoIzquierdo=new NodoMVias<>(this.orden);
        NodoMVias nodoDerecho=new NodoMVias<>(this.orden);
        int division=(orden-1)/2;
        K datoDelMedio=nodoAux.getDato(division);
        V valorDelMedio=nodoAux.getValor(division);
        int contador=0;
        for(int i=0;i<division;i++){
            this.insertarDatoOrdenadoEnNodo(nodoIzquierdo,nodoAux.getDato(i),nodoAux.getValor(i));
            nodoIzquierdo.setHijo(i,nodoAux.getHijo(i));
        }
        nodoIzquierdo.setHijo(division,nodoAux.getHijo(division));
        for(int i=division+1;i<orden;i++){
            this.insertarDatoOrdenadoEnNodo(nodoDerecho,nodoAux.getDato(i),nodoAux.getValor(i));
            nodoDerecho.setHijo(contador,nodoAux.getHijo(i));
            contador++;
        }
        nodoDerecho.setHijo(contador,nodoAux.getHijo(orden));
        if(!pilaDeAncestros.isEmpty()){
            NodoMVias<K,V> nodo=pilaDeAncestros.pop();
            this.insertarDatoOrdenadoEnNodo(nodo,datoDelMedio,valorDelMedio);
            int posicion=this.buscarPosicionDeDatoEnNodo(nodo,datoDelMedio);
            nodo.setHijo(posicion,nodoIzquierdo);
            nodo.setHijo(posicion+1,nodoDerecho);
            if(nodo.nroDeDatosNoVacios()>this.nroMaximoDeDatos){
                dividirNodo(nodo,pilaDeAncestros);
            }
        }else{
            NodoMVias<K,V> nuevaRaiz= new NodoMVias<>(orden,datoDelMedio,valorDelMedio);
            nuevaRaiz.setHijo(0,nodoIzquierdo);
            nuevaRaiz.setHijo(1,nodoDerecho);
            this.raiz=nuevaRaiz;
        }
    }

    @Override
    public void eliminar(K datoAEliminar){
        if(datoAEliminar==null){
            throw new IllegalArgumentException("Dato a eliminar no puede ser nulo");
        }
        NodoMVias<K,V> nodoAux=this.raiz;
        NodoMVias<K,V> nodoDelDatoAEliminar=NodoMVias.nodoVacio();
        Stack<NodoMVias<K,V>> pilaDeAncestros=new Stack<>();
        int posicionDeDatoAEliminar=POSICION_INVALIDA;
        do{
            posicionDeDatoAEliminar=this.buscarPosicionDeDatoEnNodo(nodoAux,datoAEliminar);
            if(posicionDeDatoAEliminar!=POSICION_INVALIDA){
                nodoDelDatoAEliminar=nodoAux;
                nodoAux=NodoMVias.nodoVacio();
            }else{
                int posicionPorDondeBajar=buscarPosicionParaBajar(nodoAux,datoAEliminar);
                pilaDeAncestros.push(nodoAux);
                nodoAux=nodoAux.getHijo(posicionPorDondeBajar);
            }
        }while(!NodoMVias.esNodoVacio(nodoAux));
        if(NodoMVias.esNodoVacio(nodoDelDatoAEliminar)){
            throw new ExcepcionDatoNoExiste();
        }
        if(nodoDelDatoAEliminar.esHoja()){
            super.eliminarElDatoDelNodo(nodoDelDatoAEliminar,posicionDeDatoAEliminar);
            if(nodoDelDatoAEliminar.nroDeDatosNoVacios()<nroMinimoDeDatos){
                prestarseOFusionar(nodoDelDatoAEliminar,pilaDeAncestros);
            }
        }else{ // el dato a eliminar no está en una hoja
            // entonces buscamos el predecesor inOrden
            pilaDeAncestros.push(nodoDelDatoAEliminar);
            NodoMVias<K,V> nodoDelPredecesor=buscarNodoDelPredecesor(
                    nodoDelDatoAEliminar.getHijo(posicionDeDatoAEliminar),pilaDeAncestros);
            int posicionDelReempazo=nodoDelPredecesor.nroDeDatosNoVacios()-1;
            K datoDeReemplazo=nodoDelPredecesor.getDato(posicionDelReempazo);
            V valorDeReemplazo=nodoDelPredecesor.getValor(posicionDelReempazo);
            nodoDelPredecesor.setDato(posicionDelReempazo,(K)NodoMVias.datoVacio());
            nodoDelPredecesor.setValor(posicionDelReempazo, (V)NodoMVias.datoVacio());
            nodoDelDatoAEliminar.setDato(posicionDeDatoAEliminar,datoDeReemplazo);
            nodoDelDatoAEliminar.setValor(posicionDeDatoAEliminar, valorDeReemplazo);
            if(nodoDelPredecesor.nroDeDatosNoVacios()<this.nroMinimoDeDatos){
                prestarseOFusionar(nodoDelPredecesor,pilaDeAncestros);
            }
        }

    }

    private void prestarseOFusionar(NodoMVias<K,V> nodoDelDatoAEliminar, Stack<NodoMVias<K,V>> pilaDeAncestros) {
        if(!pilaDeAncestros.isEmpty()){
            NodoMVias<K,V> padre = pilaDeAncestros.pop();
            int posicionRelativa = getPosicionDeHijo(padre,nodoDelDatoAEliminar);
            if (!NodoMVias.esNodoVacio(padre.getHijo(posicionRelativa+1))){
                if(padre.getHijo(posicionRelativa+1).nroDeDatosNoVacios()>nroMinimoDeDatos){
                    prestarDerecho(nodoDelDatoAEliminar, padre, posicionRelativa);
                }else if(posicionRelativa>0 && padre.getHijo(posicionRelativa-1).nroDeDatosNoVacios()>nroMinimoDeDatos){
                    prestarIzquierdo(nodoDelDatoAEliminar, padre, posicionRelativa);
                }else{
                    fusionar(padre.getHijo(posicionRelativa+1),padre,posicionRelativa);
                    if(padre.nroDeDatosNoVacios()<nroMinimoDeDatos){
                        prestarseOFusionar(padre,pilaDeAncestros);
                    }
                }
            } else if (posicionRelativa>0) {
                if(padre.getHijo(posicionRelativa-1).nroDeDatosNoVacios()>nroMinimoDeDatos){
                    prestarIzquierdo(nodoDelDatoAEliminar, padre, posicionRelativa);
                }else{
                    fusionar(padre.getHijo(posicionRelativa),padre,posicionRelativa-1);
                    if(padre.nroDeDatosNoVacios()<nroMinimoDeDatos){
                        prestarseOFusionar(padre,pilaDeAncestros);
                    }
                }
            }
        }else{
            if(raiz.nroDeDatosNoVacios()<1) {
                raiz = nodoDelDatoAEliminar.getHijo(0);
            }
        }
    }

    private int getPosicionDeHijo(NodoMVias<K,V> padre, NodoMVias<K,V> hijo){
        int i=0;
        while(i<padre.nroDeDatosNoVacios()){
            if(padre.getHijo(i)==hijo){
                return i;
            }
            i++;
        }
        return i;
    }

    private void fusionar(NodoMVias<K,V> nodoDerecho, NodoMVias<K,V> padre, int posicionHermanoIzquierdo) {
        K datoPadre=padre.getDato(posicionHermanoIzquierdo);
        V valorPadre=padre.getValor(posicionHermanoIzquierdo);
        NodoMVias<K,V> nodoIzquierdo=padre.getHijo(posicionHermanoIzquierdo);
        int i=0;
        while(i<nodoIzquierdo.nroDeDatosNoVacios()){
            insertarDatoOrdenadoEnNodo(nodoDerecho,nodoIzquierdo.getDato(i),nodoIzquierdo.getValor(i));
            nodoDerecho.setHijo(i,nodoIzquierdo.getHijo(i));
            i++;
        }

        insertarDatoOrdenadoEnNodo(nodoDerecho,datoPadre,valorPadre);
        nodoDerecho.setHijo(i,nodoIzquierdo.getHijo(i));
        eliminarElDatoDelNodo(padre,posicionHermanoIzquierdo);
    }

    private void prestarIzquierdo(NodoMVias<K,V> nodoDelDatoAEliminar, NodoMVias<K,V> padre, int posicionRelativa) {
        NodoMVias<K,V> hermano = padre.getHijo(posicionRelativa - 1);
        K datoDelHermano = hermano.getDato(hermano.nroDeDatosNoVacios() - 1);
        V valorDelHermano = hermano.getValor(hermano.nroDeDatosNoVacios()-1);
        NodoMVias<K,V> hijoAPerder =hermano.getHijo(hermano.nroDeDatosNoVacios());
        eliminarElDatoDelNodo(hermano, hermano.nroDeDatosNoVacios() - 1);
        K datoDelPadre = padre.getDato(posicionRelativa - 1);
        V valorDelPadre = padre.getValor(posicionRelativa-1);
        padre.setDato(posicionRelativa - 1, datoDelHermano);
        padre.setValor(posicionRelativa-1, valorDelHermano);
        insertarDatoOrdenadoEnNodo(nodoDelDatoAEliminar, datoDelPadre,valorDelPadre);
        nodoDelDatoAEliminar.setHijo(0,hijoAPerder);
    }

    private void prestarDerecho(NodoMVias<K,V> nodoDelDatoAEliminar, NodoMVias<K,V> padre, int posicionRelativa) {
        NodoMVias<K,V> hermano= padre.getHijo(posicionRelativa +1);
        K datoDelHermano=hermano.getDato(0);
        V valorDelHermano = hermano.getValor(0);
        NodoMVias<K,V> hijoAPerder=hermano.getHijo(0);
        eliminarElDatoDelNodo(hermano,0);
        K datoDelPadre= padre.getDato(posicionRelativa);
        V valorDelPadre= padre.getValor(posicionRelativa);
        padre.setDato(posicionRelativa,datoDelHermano);
        padre.setValor(posicionRelativa,valorDelHermano);
        insertarDatoOrdenadoEnNodo(nodoDelDatoAEliminar,datoDelPadre,valorDelPadre);
        nodoDelDatoAEliminar.setHijo(nodoDelDatoAEliminar.nroDeDatosNoVacios(),hijoAPerder);
    }


    private NodoMVias<K,V> buscarNodoDelPredecesor(NodoMVias<K,V> hijo,Stack<NodoMVias<K,V>> pilaDeAncestros) {
        if(hijo.esHoja()){
            return hijo;
        }
        pilaDeAncestros.push(hijo);
        return buscarNodoDelPredecesor(hijo.getHijo(hijo.nroDeDatosNoVacios()),pilaDeAncestros);
    }

    public void testRun(NodoMVias<K,V> raizNueva){
        this.raiz=raizNueva;
    }

}