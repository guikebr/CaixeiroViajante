import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {
    //Atributos
    private int numeroDeCidades;
    private ArrayList<ArrayList<Integer>> distancias = new ArrayList<>();

    //Construtor
    public Arquivo(String nomeArquivo) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(nomeArquivo));
            String linha = "";
            boolean formatoCorreto = true;
            parseNumeroDeCidades(br.readLine());
            for(int i = 0; i < numeroDeCidades; i++) {
				distancias.add(new ArrayList<Integer>());
				for(int j = 0; j < numeroDeCidades; j++) {
					distancias.get(i).add(0);	
				}
            }
            while((linha = br.readLine()) != null && formatoCorreto) {
				formatoCorreto = parseDistancias(linha);
			}
        } catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
    }

    //validade numero da cidade
    public boolean parseNumeroDeCidades(String primeiraLinha) {
		numeroDeCidades = Integer.parseInt(primeiraLinha);
		return true;
	}
    
    //encontra as distancias
    public boolean parseDistancias(String linha) {
        String[] distanciaText = linha.split(" ");
        int[] distancia = new int[distanciaText.length];
        for(int i = 0; i < distancia.length; i++) 
            distancia[i] = Integer.parseInt(distanciaText[i]);

        if(distancia.length != 3) {
            System.out.println("dados com com problema na entrada.");
            return false;
        }else {
            distancias.get(distancia[0] - 1).set(distancia[1] - 1, distancia[2]);
            distancias.get(distancia[1] - 1).set(distancia[0] - 1, distancia[2]);
            return true;
        }
        
    }

	//retorna o numero de cidades 
	public int getNumeroDeCidades() {
		return numeroDeCidades;
    }
    
	//retorna as distancias
	public ArrayList<ArrayList<Integer>> getDistancias() {
		return distancias;
    }
}