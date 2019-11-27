import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\tProblema do Caixeiro Viajante resolvido com Heuristica\n");
        System.out.println("Informe o caminho completo do arquivo de entrada:");
        
        Scanner entradaArquivo = new Scanner(System.in);
        String nomeArquivo = entradaArquivo.nextLine().replace("\\", "\\\\");
        Arquivo arquivo = new Arquivo(nomeArquivo);

        Problema problema = new Problema(arquivo.getNumeroDeCidades(), arquivo.getDistancias());
        System.out.println("\nInformacao:\n" + problema.toS());
        
        Heuristica heuristica = new Heuristica();

        Solucao solucao = new Solucao();
        
        System.out.println("\nProcurando caminho... ");
        solucao = heuristica.solucao(problema);
        System.out.println(solucao.toS());
        entradaArquivo.close();

    }
}