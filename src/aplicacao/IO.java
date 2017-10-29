//------------------------------------------------------
package aplicacao;
//------------------------------------------------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
//------------------------------------------------------

public class IO {
	
	public static List<String[]> carregarArquivo(String arquivo) throws IOException{ //Lê as contas e seus usuários.
		
		List<String[]> lista = new LinkedList<String[]>();
		
		FileReader arq = new FileReader(arquivo);
	    BufferedReader lerArq = new BufferedReader(arq);
		
	    int quantidade = Integer.parseInt(lerArq.readLine()); // Lê a primeira linha.
		int aux = 0;
		
		String linha = null;
		while (aux != quantidade) {   
			linha = lerArq.readLine();
			lista.add(linha.split(" ", 3));
			aux++;
			// Cada linha tera um vetor de três posições: Ex:
			//		linha = "123 Maria João"
			//	 	linha.split(" ", 3) -> vet[0] = "123", vet[1] = "Maria" e vet[2] = "João"	
		}
		
		return lista;
		
	}
	
	public static List<String[]> carregarTranferencia(String arquivo) throws IOException{
		
		List<String[]> lista = new LinkedList<String[]>();
		
		FileReader arq = new FileReader(arquivo);
	    BufferedReader lerArq = new BufferedReader(arq);
		
	    int quantidade = Integer.parseInt(lerArq.readLine()); // Lê a primeira linha.
		int aux = 1;
		String linha = null;
		
		quantidade += 2;
		
		
		while (aux != quantidade) {   
			
			if(aux == quantidade){
				linha = lerArq.readLine();
				lista.add(linha.split(" ", 2));
				aux++;
				// Cada linha tera um vetor de duas posições: Ex:
				//		linha = "Maria João"
				//	 	linha.split(" ", 2) -> vet[0] = "Maria" e vet[1] = "João"	
			} else aux++;
		}
		
		return lista;
		
	}
	
	
}
