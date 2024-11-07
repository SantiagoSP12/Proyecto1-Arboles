/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.learning.arbolesdebusqueda;
import com.learning.arbolesdebusqueda.Arboles.*;
import com.learning.arbolesdebusqueda.Arboles.Excepciones.*;
/**
 *
 * @author Santiago
 */
public class ArbolesDeBusqueda {

    
    public static void main(String args[]) throws ExcepcionOrdenInvalido {
        IArbolBusqueda<Integer,String> arbol=new AB<>(4);
         

        /*test run Insertar como en el Documento del inge
        NodoMVias<Integer> nodoAct=new NodoMVias<>(4);
        nodoAct.setDato(0,90);
        nodoAct.setDato(1,850);

        NodoMVias<Integer> hijo0=new NodoMVias<>(4);
        NodoMVias<Integer> hijo1=new NodoMVias<>(4);
        NodoMVias<Integer> hijo2=new NodoMVias<>(4);
        NodoMVias<Integer> hijo0hijo0=new NodoMVias<>(4);
        NodoMVias<Integer> hijo0hijo1=new NodoMVias<>(4);
        NodoMVias<Integer> hijo1hijo0=new NodoMVias<>(4);
        NodoMVias<Integer> hijo1hijo1=new NodoMVias<>(4);
        NodoMVias<Integer> hijo1hijo2=new NodoMVias<>(4);
        NodoMVias<Integer> hijo2hijo0=new NodoMVias<>(4);
        NodoMVias<Integer> hijo2hijo1=new NodoMVias<>(4);
        NodoMVias<Integer> hijo2hijo2=new NodoMVias<>(4);

        hijo0.setDato(0,70);
        hijo0hijo0.setDato(0,50);
        hijo0hijo1.setDato(0,75);

        hijo0.setHijo(0,hijo0hijo0);
        hijo0.setHijo(1,hijo0hijo1);
        nodoAct.setHijo(0,hijo0);


        hijo1.setDato(0,100);
        hijo1.setDato(1,400);
        hijo1hijo0.setDato(0,91);
        hijo1hijo0.setDato(1,99);
        hijo1hijo1.setDato(0,300);
        hijo1hijo2.setDato(0,500);
        hijo1hijo2.setDato(1,800);

        hijo1.setHijo(0,hijo1hijo0);
        hijo1.setHijo(1,hijo1hijo1);
        hijo1.setHijo(2,hijo1hijo2);
        nodoAct.setHijo(1,hijo1);


        hijo2.setDato(0,870);
        hijo2.setDato(1,920);
        hijo2hijo0.setDato(0,855);
        hijo2hijo0.setDato(1,862);
        hijo2hijo0.setDato(2,868);
        hijo2hijo1.setDato(0,890);
        hijo2hijo2.setDato(0,950);
        hijo2hijo2.setDato(1,960);

        hijo2.setHijo(0,hijo2hijo0);
        hijo2.setHijo(1,hijo2hijo1);
        hijo2.setHijo(2,hijo2hijo2);
        nodoAct.setHijo(2,hijo2);

        arbol.testRun(nodoAct);*/


        arbol.insertar(10,"e");
        arbol.insertar(20,"e");
        arbol.insertar(15,"e");
        arbol.eliminar(15);
        System.out.println(arbol);
        arbol.insertar(1,"e");
        arbol.insertar(22,"e");
        arbol.insertar(25,"e");
        arbol.insertar(40,"e");
        arbol.insertar(32,"e");
        arbol.insertar(90,"e");
        arbol.insertar(12,"e");
        arbol.insertar(2,"e");
        arbol.insertar(3,"e");
        arbol.insertar(95,"e");
        arbol.insertar(50,"e");
        arbol.insertar(6,"e");
        arbol.insertar(77,"e");
        arbol.insertar(58,"e");
        arbol.insertar(88,"e");
        arbol.insertar(19,"e");
        arbol.insertar(92,"e");
        arbol.insertar(49,"e");
        arbol.insertar(33,"e");
        arbol.insertar(65,"e");
        arbol.insertar(74,"e");
        arbol.insertar(89,"e");
        arbol.insertar(98,"e");

        arbol.eliminar(95);
        System.out.println(arbol.toString());


        arbol.eliminar(58);
        System.out.println(arbol.toString());
        arbol.eliminar(19);
        System.out.println(arbol.toString());
        /*test run eliminar como en el Documento del inge
        arbol.eliminar(862);
        System.out.println(arbol.toString());
        arbol.eliminar(300);
        System.out.println(arbol.toString());
        arbol.eliminar(400);
        System.out.println(arbol.toString());
        arbol.eliminar(91);
        System.out.println(arbol.toString());
        arbol.eliminar(870);
        System.out.println(arbol.toString());
        arbol.eliminar(70);
        System.out.println(arbol.toString());*/
        System.out.println(arbol.recorridoEnInOrden().toString());
    }
}
