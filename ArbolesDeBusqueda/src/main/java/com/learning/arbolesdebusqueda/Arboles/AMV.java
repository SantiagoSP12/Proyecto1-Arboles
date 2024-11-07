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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AMV <K extends Comparable<K>,V>
    implements IArbolBusqueda<K,V>{

    protected NodoMVias<K,V> raiz;
    protected int orden;
    private static final byte ORDEN_MINIMO=3;
    protected static final byte POSICION_INVALIDA=-1;

    public AMV(){
        this.orden=ORDEN_MINIMO;
    }

    public AMV(int orden) throws ExcepcionOrdenInvalido{
        if(orden<ORDEN_MINIMO){
            throw new ExcepcionOrdenInvalido();
        }
        this.orden=orden;
    }

    @Override
    public void insertar(K datoAInsertar,V valor) {
        if (datoAInsertar==null){
            throw new IllegalArgumentException("Dato a insertar no puede ser nulo");
        }
        if(this.esArbolVacio()){
            this.raiz=new NodoMVias<>(this.orden,datoAInsertar,valor);
        }else{
            NodoMVias<K,V> nodoAux= this.raiz;
            do{
                int posicionDeDatoEnNodo=this.buscarPosicionDeDatoEnNodo(nodoAux,datoAInsertar);
                if(posicionDeDatoEnNodo!=POSICION_INVALIDA){
                    throw new ExcepcionDatoYaExiste();
                }
                //En este punto punto sabemos que el datoAInsertar no está en el nodoAux
                if(nodoAux.esHoja()){
                    if(nodoAux.estanDatosLlenos()){
                        int posicionPorDondeBajar=this.buscarPosicionParaBajar(nodoAux,datoAInsertar);
                        NodoMVias<K,V> nuevoNodo= new NodoMVias<>(this.orden,datoAInsertar,valor);
                        nodoAux.setHijo(posicionPorDondeBajar,nuevoNodo);
                    }else{
                        this.insertarDatoOrdenadoEnNodo(nodoAux,datoAInsertar,valor);
                    }
                    nodoAux=NodoMVias.nodoVacio();
                }else{
                    //en este punto el nodoAux no es hoja
                    int posicionPorDondeBajar=this.buscarPosicionParaBajar(nodoAux,datoAInsertar);
                    if(nodoAux.esHijoVacio(posicionPorDondeBajar)){
                        NodoMVias<K,V> nuevoNodo= new NodoMVias<>(this.orden,datoAInsertar,valor);
                        nodoAux.setHijo(posicionPorDondeBajar,nuevoNodo);
                        nodoAux=NodoMVias.nodoVacio();
                    }else{
                        nodoAux=nodoAux.getHijo(posicionPorDondeBajar);
                    }
                }
            }while(!NodoMVias.esNodoVacio(nodoAux));
        }
    }

    protected void insertarDatoOrdenadoEnNodo(NodoMVias<K,V> nodoAux, K datoAInsertar,V valorAsociado) {
        K datoACambiar=datoAInsertar;
        V valorACambiar=valorAsociado;
        int i=0;
        NodoMVias<K,V> nodoASalvar;
        NodoMVias<K,V> nodoSalvado=nodoAux.getHijo(i);
        while(i<nodoAux.nroDeDatosNoVacios()){
            if(datoACambiar.compareTo(nodoAux.getDato(i))<0){
                nodoASalvar=nodoAux.getHijo(i+1);
                K datoSalvar=nodoAux.getDato(i);
                V valorSalvar=nodoAux.getValor(i);
                nodoAux.setHijo(i+1,nodoSalvado);
                nodoSalvado=nodoASalvar;
                nodoAux.setDato(i,datoACambiar);
                nodoAux.setValor(i, valorACambiar);
                datoACambiar=datoSalvar;
                valorACambiar=valorSalvar;
            }else{
                nodoSalvado=nodoAux.getHijo(i+1);
            }
            i++;
        }
        nodoAux.setDato(i,datoACambiar);
        nodoAux.setValor(i, valorACambiar);
        nodoAux.setHijo(i+1,nodoSalvado);
    }

    protected int buscarPosicionParaBajar(NodoMVias<K,V> nodoAux, K datoAInsertar) {
        for(int i=0;i<nodoAux.nroDeDatosNoVacios();i++){
            if(datoAInsertar.compareTo(nodoAux.getDato(i))<0){
                return i;
            }
        }
        return nodoAux.nroDeDatosNoVacios();
    }

    protected int buscarPosicionDeDatoEnNodo(NodoMVias<K,V> nodoAux, K datoAInsertar) {
        for(int i = 0; i<nodoAux.nroDeDatosNoVacios(); i++){
            if(nodoAux.getDato(i).compareTo(datoAInsertar)==0){
                return i;
            }
        }
        return POSICION_INVALIDA;
    }

    @Override
    public void eliminar(K datoAEliminar) {
        if (datoAEliminar==null){
            throw new IllegalArgumentException("Dato a insertar no puede ser nulo");
        }
        this.raiz=eliminar(this.raiz,datoAEliminar);
    }

    private NodoMVias<K,V> eliminar(NodoMVias<K,V> nodoActual, K datoAEliminar) {
        //caso base
        if(NodoMVias.esNodoVacio(nodoActual)){
            throw new ExcepcionDatoNoExiste();
        }
        int posicionDeDatoEnNodo=this.buscarPosicionDeDatoEnNodo(nodoActual,datoAEliminar);
        if(posicionDeDatoEnNodo!=POSICION_INVALIDA){
            if(nodoActual.esHoja()){
                this.eliminarElDatoDelNodo(nodoActual,posicionDeDatoEnNodo);
                if(nodoActual.nroDeDatosNoVacios()==0){
                    return NodoMVias.nodoVacio();
                }
                return nodoActual;
            }
            //nodoActual no es hoja, pero el dato está ahí, entonces
            //debo buscar un reemplazo y eliminar antes de usarlo
            K datoDeRemplazo;
            V valorDeReemplazo;
            if(hayHijoEnNodoDelanteDePosicion(nodoActual,posicionDeDatoEnNodo)){
                datoDeRemplazo=this.obtenerDatoSucesorInOrden(nodoActual,posicionDeDatoEnNodo+1);
                valorDeReemplazo=this.buscar(datoDeRemplazo);
            }else{
                datoDeRemplazo=this.obtenerDatoPredecesorInOrden(nodoActual,posicionDeDatoEnNodo);
                valorDeReemplazo=this.buscar(datoDeRemplazo);
            }
            nodoActual=eliminar(nodoActual,datoDeRemplazo);
            nodoActual.setDato(posicionDeDatoEnNodo,datoDeRemplazo);
            nodoActual.setValor(posicionDeDatoEnNodo, valorDeReemplazo);
            return nodoActual;
        }
        //en este punto, el datoAEliminar no está en el nodoActual
        int posicionPorDondeBajar= buscarPosicionParaBajar(nodoActual,datoAEliminar);
        NodoMVias<K,V> supuestoNuevoHijo=eliminar(
                nodoActual.getHijo(posicionPorDondeBajar),datoAEliminar);
        nodoActual.setHijo(posicionPorDondeBajar,supuestoNuevoHijo);
        return nodoActual;
    }

    protected K obtenerDatoPredecesorInOrden(NodoMVias<K,V> nodoActual, int posicionDatoPosible) {
        if(nodoActual.esHijoVacio(posicionDatoPosible)){
            return nodoActual.getDato(posicionDatoPosible-1);
        }
        NodoMVias<K,V> hijoPredecesor=nodoActual.getHijo(posicionDatoPosible);
        return obtenerDatoSucesorInOrden(hijoPredecesor,hijoPredecesor.nroDeDatosNoVacios()-1);
    }

    protected K obtenerDatoSucesorInOrden(NodoMVias<K,V> nodoActual, int posicionDatoPosible) {
        if(nodoActual.esHijoVacio(posicionDatoPosible)){
            return nodoActual.getDato(posicionDatoPosible);
        }
        return obtenerDatoSucesorInOrden(nodoActual.getHijo(posicionDatoPosible),0);
    }

    private boolean hayHijoEnNodoDelanteDePosicion(NodoMVias<K,V> nodoActual, int posicionDeDatoEnNodo) {
        for(int i=posicionDeDatoEnNodo+1;i<=nodoActual.nroDeDatosNoVacios();i++){
            if(!nodoActual.esHijoVacio(i)){
                return true;
            }
        }
        return false;
    }

    protected void eliminarElDatoDelNodo(NodoMVias<K,V> nodoActual, int posicionDeDatoEnNodo) {
        int i=posicionDeDatoEnNodo;
        while(i<nodoActual.nroDeDatosNoVacios()-1){
            nodoActual.setDato(i,nodoActual.getDato(i+1));
            nodoActual.setValor(i, nodoActual.getValor(i+1));
            nodoActual.setHijo(i,nodoActual.getHijo(i+1));
            i++;
        }
        nodoActual.setDato(i,(K)NodoMVias.datoVacio());
        nodoActual.setValor(i,(V)NodoMVias.datoVacio());
        nodoActual.setHijo(i,nodoActual.getHijo(i+1));
        nodoActual.setHijo(i+1,NodoMVias.nodoVacio());
    }

    @Override
    public V buscar(K dato) {
        if (dato == null) {
            throw new IllegalArgumentException("Dato a buscar no puede ser nulo");
        }
        NodoMVias<K,V> nodoAux = this.raiz;
        while(!NodoMVias.esNodoVacio(nodoAux)){
            boolean cambioElNodo= false;
            for(int i = 0; i<nodoAux.nroDeDatosNoVacios()&&!cambioElNodo; i++) {
                K datoDelNodoAux = nodoAux.getDato(i);
                V valorDelNodoAux = nodoAux.getValor(i);
                if(dato.compareTo(datoDelNodoAux)==0) {
                    return valorDelNodoAux;
                }
                if(dato.compareTo(datoDelNodoAux)<0){
                    nodoAux=nodoAux.getHijo(i);
                    cambioElNodo=true;
                }
            }//end for
            if(!cambioElNodo){
                nodoAux=nodoAux.getHijo(nodoAux.nroDeDatosNoVacios());
            }
        }//end while
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
            Queue<NodoMVias<K,V>> colaDeNodos = new LinkedList<>();
            colaDeNodos.offer(this.raiz);
            NodoMVias<K,V> nodoQueTocaSacar;
            do {
                nodoQueTocaSacar=colaDeNodos.poll();
                for(int i=0;i<nodoQueTocaSacar.nroDeDatosNoVacios();i++){
                    listaDeDatos.add(nodoQueTocaSacar.getDato(i));
                    if(!nodoQueTocaSacar.esHijoVacio(i)){
                        colaDeNodos.offer(nodoQueTocaSacar.getHijo(i));
                    }
                }
                if(!nodoQueTocaSacar.esHijoVacio(nodoQueTocaSacar.nroDeDatosNoVacios())){
                    colaDeNodos.offer(nodoQueTocaSacar.getHijo(nodoQueTocaSacar.nroDeDatosNoVacios()));
                }
            }while(!colaDeNodos.isEmpty());
        }
        return listaDeDatos;
    }

    @Override
    public List<K> recorridoEnPreOrden() {
        List<K> listaRecorrido=new ArrayList<>();
        this.recorridoEnPreOrden(this.raiz,listaRecorrido);
        return listaRecorrido;
    }

    private void recorridoEnPreOrden(NodoMVias<K,V> nodoActual, List<K> listaRecorrido) {
        if(NodoMVias.esNodoVacio(nodoActual)){
            return;
        }
        for(int i=0;i<nodoActual.nroDeDatosNoVacios();i++){

            listaRecorrido.add(nodoActual.getDato(i));
            recorridoEnPreOrden(nodoActual.getHijo(i),listaRecorrido);
        }
        recorridoEnPreOrden(nodoActual.getHijo(nodoActual.nroDeDatosNoVacios()),listaRecorrido);
    }

    @Override
    public List<K> recorridoEnInOrden() {
        List<K> listaRecorrido=new ArrayList<>();
        this.recorridoEnInOrden(this.raiz,listaRecorrido);
        return listaRecorrido;
    }

    private void recorridoEnInOrden(NodoMVias<K,V> nodoActual, List<K> listaRecorrido) {
        if(NodoMVias.esNodoVacio(nodoActual)){
            return;
        }
        for(int i=0;i<nodoActual.nroDeDatosNoVacios();i++){
            recorridoEnInOrden(nodoActual.getHijo(i),listaRecorrido);
            listaRecorrido.add(nodoActual.getDato(i));
        }
        recorridoEnInOrden(nodoActual.getHijo(nodoActual.nroDeDatosNoVacios()),listaRecorrido);
    }

    @Override
    public List<K> recorridoEnPostOrden() {
        List<K> listaRecorrido=new ArrayList<>();
        this.recorridoEnPostOrden(this.raiz,listaRecorrido);
        return listaRecorrido;
    }

    private void recorridoEnPostOrden(NodoMVias<K,V> nodoActual, List<K> listaRecorrido) {
        if(NodoMVias.esNodoVacio(nodoActual)){
            return;
        }
        recorridoEnPostOrden(nodoActual.getHijo(0),listaRecorrido);
        for(int i=0;i<nodoActual.nroDeDatosNoVacios();i++){
            recorridoEnPostOrden(nodoActual.getHijo(i+1),listaRecorrido);
            listaRecorrido.add(nodoActual.getDato(i));
        }
    }

    @Override
    public int size() {
        return size(this.raiz);
    }

    private int size(NodoMVias<K,V> nodoActual) {
        if(NodoMVias.esNodoVacio(nodoActual)){
            return 0;
        }
        int sizeTotal=0;
        for(int i=0;i<=nodoActual.nroDeDatosNoVacios();i++){
            int sizeHijoEnTurno=size(nodoActual.getHijo(i));
            sizeTotal+=sizeHijoEnTurno;
        }
        return sizeTotal+1;
    }

    @Override
    public int altura() {
        return altura(this.raiz);
    }

    private int altura(NodoMVias<K,V> nodoActual) {
        if(NodoMVias.esNodoVacio(nodoActual)){
            return 0;
        }
        int alturaMayor=0;
        for(int i=0;i<=nodoActual.nroDeDatosNoVacios();i++){
            int alturaHijoEnTurno=altura(nodoActual.getHijo(i));
            if(alturaHijoEnTurno>alturaMayor){
                alturaMayor=alturaHijoEnTurno;
            }
        }
        return alturaMayor+1;
    }

    @Override
    public void vaciar() {
        this.raiz=NodoMVias.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoMVias.esNodoVacio(raiz);
    }

    @Override
    public int nivel() {
        return 0;
    }

    //cuantos nodos tienen k hijos, a partir del nivel n
    public int ejercicio1(int n, int k){
        if(!this.esArbolVacio()) {
            int nivel=0;
            int cantidadDeNodos = 0;
            int cantidadDeHijos;
            Queue<NodoMVias<K,V>> colaDeNodos= new LinkedList<>();
            Queue<NodoMVias<K,V>> colaDeNodosTemp= new LinkedList<>();
            colaDeNodos.offer(this.raiz);
            NodoMVias<K,V> nodoAux;
            do{
                nodoAux=colaDeNodos.poll();
                cantidadDeHijos=0;
                for(int i=0;i<=nodoAux.nroDeDatosNoVacios();i++){
                    if(!nodoAux.esHijoVacio(i)){
                        colaDeNodosTemp.offer(nodoAux.getHijo(i));
                        cantidadDeHijos++;
                    }
                }
                if(nivel>=n){
                    if(cantidadDeHijos>=k){
                        cantidadDeNodos++;
                    }
                }
                if(colaDeNodos.isEmpty()){
                    nivel++;
                    while(!colaDeNodosTemp.isEmpty()){
                        colaDeNodos.offer(colaDeNodosTemp.poll());
                    }
                }
            }while(!colaDeNodos.isEmpty());
            return cantidadDeNodos;
        }
        return 0;
    }

    //hacerlo con una sola cola
    public int ejercicio1_2(int n, int k){
        if(!this.esArbolVacio()) {
            int nivel=0;
            int cantidadDeNodos = 0;
            int cantidadDeHijos;
            Queue<NodoMVias<K,V>> colaDeNodos= new LinkedList<>();
            Queue<NodoMVias<K,V>> colaDeNodosTemp= new LinkedList<>();
            colaDeNodos.offer(this.raiz);
            NodoMVias<K,V> nodoAux;
            do{
                nodoAux=colaDeNodos.poll();
                cantidadDeHijos=0;
                for(int i=0;i<=nodoAux.nroDeDatosNoVacios();i++){
                    if(!nodoAux.esHijoVacio(i)){
                        colaDeNodosTemp.offer(nodoAux.getHijo(i));
                        cantidadDeHijos++;
                    }
                }
                if(nivel>=n){
                    if(cantidadDeHijos>=k){
                        cantidadDeNodos++;
                    }
                }
                if(colaDeNodos.isEmpty()){
                    nivel++;
                    while(!colaDeNodosTemp.isEmpty()){
                        colaDeNodos.offer(colaDeNodosTemp.poll());
                    }
                }
            }while(!colaDeNodos.isEmpty());
            return cantidadDeNodos;
        }
        return 0;
    }

    public int ejercicio1R(int n, int k){
        return ejercicio1R(this.raiz, n,k);
    }

    private int ejercicio1R(NodoMVias<K,V> nodoActual, int n, int k) {
        if(NodoMVias.esNodoVacio(nodoActual)){
            return 0;
        }
        int cantidadDeNodos=0;
        int cantidadDeHijos=0;
        for(int i=0;i<=nodoActual.nroDeDatosNoVacios();i++){
            cantidadDeNodos=cantidadDeNodos+ejercicio1R(nodoActual.getHijo(i),n-1,k);
            if(!nodoActual.esHijoVacio(i)){
                cantidadDeHijos++;
            };
        }
        if(n<=0 && cantidadDeHijos>=k){
            return cantidadDeNodos+1;
        }
        return cantidadDeNodos;
    }

    @Override
    public String toString() {
        return crearRepresentacion(raiz, "", "", -1);
    }

    private String crearRepresentacion(NodoMVias<K,V> nodo, String representacion, String prefijo, int indice) {
        if (nodo == null) {
            return representacion + prefijo + ((indice<orden&&indice>=0) ? "|-- " : (indice==orden ? "'-- " : "")) + "null\n";
        }

        representacion += prefijo +  (indice==-1 ? "" : ((indice==orden) ? "'-- ":"|-- " ))  + "(" + (indice>=0?indice:"R") + ")" + nodo.toString() + "\n";

        String nuevoPrefijo = prefijo + (indice==-1? " " : ((indice<orden&&indice>=0) ? "|    " : "     "));
        for(int i=0;i<=this.orden;i++){
            representacion = crearRepresentacion(nodo.getHijo(i), representacion, nuevoPrefijo, i);
        }

        return representacion;
    }
    
    @Override
    public String toStringValor() {
        return crearRepresentacionValor(raiz, "", "", -1);
    }

    private String crearRepresentacionValor(NodoMVias<K,V> nodo, String representacion, String prefijo, int indice) {
        if (nodo == null) {
            return representacion + prefijo + ((indice<orden&&indice>=0) ? "|-- " : (indice==orden ? "'-- " : "")) + "null\n";
        }

        representacion += prefijo +  (indice==-1 ? "" : ((indice==orden) ? "'-- ":"|-- " ))  + "(" + (indice>=0?indice:"R") + ")" + nodo.toStringValores() + "\n";

        String nuevoPrefijo = prefijo + (indice==-1? " " : ((indice<orden&&indice>=0) ? "|    " : "     "));
        for(int i=0;i<=this.orden;i++){
            representacion = crearRepresentacionValor(nodo.getHijo(i), representacion, nuevoPrefijo, i);
        }

        return representacion;
    }
}