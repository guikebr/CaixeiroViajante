import java.util.ArrayList;

public class Problema {

    //Atributos
    private int numeroDeCidades;
    private ArrayList<ArrayList<Integer>> distancias;
    
    //Construtor
    public Problema(int nCidades, ArrayList<ArrayList<Integer>> distancias) {
		setNumeroDeCidades(nCidades);
		setDistancias(distancias);
    }
    
    //retorna informacao do problema em string
    public String toSring() {
		String toString = "";
		toString += "Numero de cidades: " + numeroDeCidades + "\nDistancias: ";
		for(int i = 0; i < distancias.size(); i++) {
			toString += "\n" + (i+1) + ": ";
			for (int j = 0; j < distancias.get(i).size(); j++) {
				toString += (j+1) + "(" + distancias.get(i).get(j) + ") ";
			}
		}
		return toString;
	}
    
	//retorna o numero de cidades
	public int getNumeroDeCidades() {
		int aux = numeroDeCidades;
		return aux;
	}
	
	//numeroDeCidades recebe numero de cidades 
	public void setNumeroDeCidades(int numeroDeCidades) {
		this.numeroDeCidades = numeroDeCidades;
	}
	
	//retorna distancia
	public int getDistancia(int de, int para) {
		return distancias.get(de).get(para);
    }
    
	//distancias recebe distancias
	public void setDistancias(ArrayList<ArrayList<Integer>> distancias) {
		this.distancias = distancias;
	}
}