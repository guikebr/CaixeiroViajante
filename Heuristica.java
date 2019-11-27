public class Heuristica {
     
	// Atributos
	private int numeroDeCidades;
    private int numeroDeCidadesPow;
    
    //Construtor default
    public Heuristica() {}

    //Solucao do problema
    public Solucao solucao(Problema problema) {
        Solucao solucao = new Solucao();
        setNumeroDeCidades(problema.getNumeroDeCidades());
        setNumeroDeCidadesPow((int)Math.pow(2, getNumeroDeCidades()));
        int matrizDP[][] = new int [getNumeroDeCidades()][getNumeroDeCidadesPow()]; 
		int matrizCaminho[][] = new int [getNumeroDeCidades()][getNumeroDeCidadesPow()];
        
        for (int i = 0; i < getNumeroDeCidades(); i++) {
			for (int j = 0; j < getNumeroDeCidadesPow(); j++) {
				matrizDP[i][j] = -1;
				matrizCaminho[i][j] = -1;
			}
        }
        
        for (int i = 0; i < getNumeroDeCidades(); i++) {
			matrizDP[i][0] = problema.getDistancia(i, 0);
        }
        
        solucao.addCidadeNoCaminho(Globals.INICIAR_CIDADE);
		solucao.setDistanciaMinima(algoritmoHeuristica(0, getNumeroDeCidadesPow() - 2, matrizDP, matrizCaminho, problema));
		getCaminho(0, getNumeroDeCidadesPow() - 2, matrizCaminho, solucao);
		solucao.addCidadeNoCaminho(Globals.INICIAR_CIDADE);
		return solucao;
    }

    //Algoritmo heuristica
    public int algoritmoHeuristica(int inicio, int set, int[][]matrizDP, int[][]matrizCaminho, Problema problema) {
		int mascara, marcado, resultado = -1, temp;
		if(matrizDP[inicio][set] != -1)
			return matrizDP[inicio][set];
		else {
			for (int i = 0; i < getNumeroDeCidades(); i++) {
				mascara = getNumeroDeCidadesPow() - 1 - (int) Math.pow(2, i);
				marcado = set & mascara;
				if(marcado != set) {
					temp = problema.getDistancia(inicio, i) + algoritmoHeuristica(i, marcado, matrizDP, matrizCaminho, problema);
					if(resultado == -1 || resultado > temp) {
						resultado = temp;
						matrizCaminho[inicio][set] = i;
					}
				}
			}
			matrizDP[inicio][set] = resultado;
			return resultado;
		}
	}

    //Pega o peso do caminho e adicina na lista de cidades
    public void getCaminho(int start, int set, int[][]matrizCaminho, Solucao solucao) {
		if(matrizCaminho[start][set] == -1)
			return;
		int x = matrizCaminho[start][set];
		int mascara = getNumeroDeCidadesPow() -1 - (int)Math.pow(2, x);
		int marcado = set & mascara;
		
		solucao.addCidadeNoCaminho(x);
		getCaminho(x, marcado, matrizCaminho, solucao);
	}

	//retorna numero de cidades
	public int getNumeroDeCidades() {
		int aux = numeroDeCidades;
		return aux;
    }
    
	// numeroDeCidades recebe numero de cidades
	public void setNumeroDeCidades(int numeroDeCidades) {
		this.numeroDeCidades = numeroDeCidades;
    }
    
	//retorna numeroDeCidadesPow
	public int getNumeroDeCidadesPow() {
		int aux = numeroDeCidadesPow;
		return aux;
	}
	
	//numeroDeCidadesPow recebe numero de cidades
	public void setNumeroDeCidadesPow(int numeroDeCidadesPow) {
		this.numeroDeCidadesPow = numeroDeCidadesPow;
	}
}