package grafos.pesados;

public class AdyacenteConPeso implements Comparable<AdyacenteConPeso>{

    private int nroVertice;
    private double peso;

    public AdyacenteConPeso(int nroVertice){
        this.nroVertice=nroVertice;
    }

    public AdyacenteConPeso(int nroVertice,double peso){
        this.nroVertice=nroVertice;
        this.peso=peso;
    }

    public int getNroVertice(){
        return this.nroVertice;
    }

    public void setNroVertice(int nroVertice){
        this.nroVertice=nroVertice;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public int compareTo(AdyacenteConPeso o) {
        if(this.nroVertice>o.nroVertice){
            return 1;
        }
        if(this.nroVertice<o.nroVertice){
            return -1;
        }
        return 0;
    }

}
