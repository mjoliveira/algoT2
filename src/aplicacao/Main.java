//------------------------------------------------------
package aplicacao;
//------------------------------------------------------
import java.io.IOException;
import java.util.Scanner;
//------------------------------------------------------

public class Main {
    public static void main(String[] args) throws IOException{
    	
    	String aux;
    	Scanner in = new Scanner(System.in);
    	 
        System.out.printf("Informe o nome de caso de teste:\n");
        String nome = in.nextLine();
    	
        long tempoInicial = System.currentTimeMillis(); // Tempo inicial do sistema.
        
        
        Controle controle = new Controle(nome);
        
        aux = (controle.carregarArquivo(nome))?"Concluído!" :"Falha no carregamento.";
		System.out.println("Carregamento do arquivo " + nome + " ... " + aux);
		
		aux = (controle.gerarGrafo())?"Concluído!" :"Falha no carregamento.";
		System.out.println("Gerando o Grafo ... " + aux);
        
        // calculo do tempo final do sistema.
        long tempoFinal = System.currentTimeMillis();
    	System.out.println("\nTempo de execução: " + (tempoFinal - tempoInicial) + " milissegundos");
    }
}
