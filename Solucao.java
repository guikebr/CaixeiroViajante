import java.util.ArrayList;

public class Solucao {
    //Atributos
    private int distanciaMinima;
    private ArrayList<Integer> caminho;
    

    //Construtor default
    public Solucao() {
		setDistanciaMinima(0);
		setCaminho(new ArrayList<Integer>());
    }
    
    //Construtor Solucao
    public Solucao(ArrayList<Integer> caminho, int distanciaMinima) {
		setDistanciaMinima(distanciaMinima);
		setCaminho(caminho);
    }
    
    //Solucao do caminho em string
    public String toS() {
		String toS = "";
		toS += "Distancia Minima: " + distanciaMinima;
		toS += "\nCaminho: ";
		for(int i = 0; i < caminho.size(); i++) {
			if(i < caminho.size()-1)
				toS += (caminho.get(i) + 1) + " -> "; 
			else
				toS += (caminho.get(i) + 1);
		}
		return toS;
    }

    //incrementa distancia
    public void incrementarDistancia(int distancia) {
		distanciaMinima += distancia;
    }
    
	//getTamanhoCaminho
	public int getTamanhoCaminho() {
		return caminho.size();
    }
    
	//getUltimaCidade
	public int getUltimaCidade() {
		return caminho.get(caminho.size()-1);
	}

	//addCidadeNoCaminho
	public void addCidadeNoCaminho(int cidade) {
		caminho.add(cidade);
    }
    
	//getCaminho
	public ArrayList<Integer> getCaminho() {
		return (ArrayList<Integer>) caminho.clone();
    }
    
	//getDistanciaMinima
	public int getDistanciaMinima() {
		int aux = distanciaMinima;
		return aux;
	}

    //distanciaMinima recebe distancia minima
    public void setDistanciaMinima(int distanciaMinima) {
		this.distanciaMinima = distanciaMinima;
    }

    //caminho recebe caminho
    public void setCaminho(ArrayList<Integer> caminho) {
		this.caminho = caminho;
	}
}