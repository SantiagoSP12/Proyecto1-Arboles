package grafos.nopesados;

import grafos.excepciones.ExcepcionAristaYaExiste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenamientoTopológico<G extends Comparable<G>> {

    private final List<ParVerticeGrado> listaVerticesGrado;
    private final DiGrafo<G> elDiGrafo;

    private static class ParVerticeGrado implements Comparable<ParVerticeGrado>{
        public int nroVertice;
        public int gradoDeEntrada;


        public ParVerticeGrado(int vertice,int gradoDeEntrada){
            this.nroVertice=vertice;
            this.gradoDeEntrada=gradoDeEntrada;
        }

        public int getGradoDeEntrada(){
            return this.gradoDeEntrada;
        }

        public void setGradoDeEntrada(int gradoDeEntrada){
            this.gradoDeEntrada=gradoDeEntrada;
        }

        @Override
        public int compareTo(ParVerticeGrado o) {
            if(this.nroVertice>o.nroVertice){
                return 1;
            }
            if(this.nroVertice<o.nroVertice){
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "["+nroVertice+":"+gradoDeEntrada+"]";
        }
    }

    public OrdenamientoTopológico(DiGrafo<G> unDiGrafo) throws Exception {
        if(unDiGrafo.hayCiclo()){
            throw new Exception("El grafo tiene que ser acíclico");
        }
        this.listaVerticesGrado=new ArrayList<>();
        this.elDiGrafo=unDiGrafo;
        Iterable<G> vertices= elDiGrafo.listaDeVertices;
        for(G vertice:vertices){
            int gradoDeEntrada=elDiGrafo.gradoDeEntradaDelVertice(vertice);
            ParVerticeGrado nuevoPar=new ParVerticeGrado(elDiGrafo.nroVertice(vertice), gradoDeEntrada);
            listaVerticesGrado.add(nuevoPar);
        }
        Collections.sort(this.listaVerticesGrado);

        System.out.println(this.listaVerticesGrado.toString());
        //ejecutarOT();
    }

    private void ejecutarOT() throws Exception {

    }
}
