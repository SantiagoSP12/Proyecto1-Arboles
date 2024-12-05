import arboles.*;
import arboles.Excepciones.ExcepcionOrdenInvalido;
import grafos.excepciones.ExcepcionAristaYaExiste;
import grafos.nopesados.*;
import grafos.pesados.GrafoPesado;

//robertovacapinto@uagrm.edu.bo
//Asunto: Proyecto 1 - INF310 - 202402 - Santiago Contreras Fuentes
public class Main {

    public static void main(String[] args) throws Exception {

        /*Test 1
        Grafo<String> unGrafo=new DiGrafo<>();
        unGrafo.insertarVertice("A");
        unGrafo.insertarVertice("B");
        unGrafo.insertarVertice("C");
        unGrafo.insertarVertice("D");
        unGrafo.insertarVertice("E");
        unGrafo.insertarVertice("F");
        unGrafo.insertarVertice("G");
        unGrafo.insertarVertice("H");
        unGrafo.insertarVertice("I");
        unGrafo.insertarVertice("K");
        //e laugh
        unGrafo.insertarArista("A","B");
        unGrafo.insertarArista("B","D");
        unGrafo.insertarArista("D","E");
        unGrafo.insertarArista("E","B");
        unGrafo.insertarArista("A","C");
        unGrafo.insertarArista("A","G");
        unGrafo.insertarArista("C","E");
        unGrafo.insertarArista("F","G");
        unGrafo.insertarArista("F","D");
        unGrafo.insertarArista("G","E");
        unGrafo.insertarArista("G","H");
        unGrafo.insertarArista("G","I");
        unGrafo.insertarArista("I","F");
        unGrafo.insertarArista("K","G");

        System.out.println(unGrafo.toString());
        DFS recorridoD=new DFS<>(unGrafo,"A");
        System.out.println(recorridoD.getRecorrido());
        BFS recorridoB=new BFS<>(unGrafo,"A");
        System.out.println(recorridoB.getRecorrido());
        */

        //test 2
        GrafoPesado<Integer> unGrafo=new GrafoPesado<>();
        unGrafo.insertarVertice(0);
        unGrafo.insertarVertice(1);
        unGrafo.insertarVertice(2);
        unGrafo.insertarVertice(3);
        unGrafo.insertarVertice(4);

        unGrafo.insertarArista(0,2,20);
        unGrafo.insertarArista(0,3,30);
        unGrafo.insertarArista(1,2,40);
//        unGrafo.insertarArista(2,3,100);
//        unGrafo.insertarArista("B","D");
//        unGrafo.insertarArista("C","B");
//        unGrafo.insertarArista("C","E");
//        unGrafo.insertarArista("D","E");
////        /*unGrafo.insertarArista("B","E");
//        unGrafo.insertarArista("C","C");
//        unGrafo.insertarArista("C","E");*/
        /*unGrafo.insertarArista("D","B");
        unGrafo.insertarArista("E","C");*/

        System.out.println(unGrafo.toString());

        unGrafo.eliminarVertice(1);
        System.out.println(unGrafo.toString());



        /*unGrafo.insertarVertice("Z");
        unGrafo.insertarVertice("Y");
        unGrafo.insertarVertice("X");
        unGrafo.insertarArista("Z","Y");
        unGrafo.insertarArista("Y","X");
        unGrafo.insertarArista("X","Z");*/
    }


    public void arbolesExecute() throws ExcepcionOrdenInvalido{
        AMV<Integer> arbolBusqueda=new AMV<>(4);

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


        /*arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(15);
        arbol.eliminar(15);
        System.out.println(arbol);
        arbol.insertar(1);
        arbol.insertar(22);
        arbol.insertar(25);
        arbol.insertar(40);
        arbol.insertar(32);
        arbol.insertar(90);
        arbol.insertar(12);
        arbol.insertar(2);
        arbol.insertar(3);
        arbol.insertar(95);
        arbol.insertar(50);
        arbol.insertar(6);
        arbol.insertar(77);
        arbol.insertar(58);
        arbol.insertar(88);
        arbol.insertar(19);
        arbol.insertar(92);
        arbol.insertar(49);
        arbol.insertar(33);
        arbol.insertar(65);
        arbol.insertar(74);
        arbol.insertar(89);
        arbol.insertar(98);

        arbol.eliminar(95);
        System.out.println(arbol.toString());


        arbol.eliminar(58);
        System.out.println(arbol.toString());
        arbol.eliminar(19);*/
        //System.out.println(arbolBusqueda.toString());
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
        arbolBusqueda.insertar(313);
        arbolBusqueda.insertar(314);
        arbolBusqueda.insertar(321);
        arbolBusqueda.insertar(322);
        arbolBusqueda.insertar(304);
        arbolBusqueda.insertar(300);
        arbolBusqueda.insertar(301);
        arbolBusqueda.insertar(302);
        arbolBusqueda.insertar(303);
        arbolBusqueda.insertar(305);
        arbolBusqueda.insertar(306);
        arbolBusqueda.insertar(307);
        arbolBusqueda.insertar(308);
        arbolBusqueda.insertar(309);
        arbolBusqueda.insertar(310);

        arbolBusqueda.insertar(318);
        arbolBusqueda.insertar(319);
        arbolBusqueda.insertar(320);
        arbolBusqueda.insertar(323);

        arbolBusqueda.insertar(400);
        arbolBusqueda.insertar(401);
        arbolBusqueda.insertar(402);
        arbolBusqueda.insertar(311);
        arbolBusqueda.insertar(312);

        arbolBusqueda.insertar(315);
        arbolBusqueda.insertar(316);
        arbolBusqueda.insertar(317);
        arbolBusqueda.insertar(403);
        arbolBusqueda.insertar(324);
        arbolBusqueda.insertar(325);
        arbolBusqueda.insertar(326);
        arbolBusqueda.insertar(327);
        arbolBusqueda.insertar(328);

        arbolBusqueda.insertar(404);

        System.out.println(arbolBusqueda.toString());

        System.out.println(arbolBusqueda.buscar(309));

        arbolBusqueda.eliminar(309);
        System.out.println(arbolBusqueda.toString());
        System.out.println(arbolBusqueda.recorridoEnInOrden().toString());
    }

}