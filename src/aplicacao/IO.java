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
	
	public static List<String[]> carregarArquivo(String arquivo) throws IOException{ //L� as contas e seus usu�rios.
		
		List<String[]> lista = new LinkedList<String[]>();
		
		FileReader arq = new FileReader(arquivo);
	    BufferedReader lerArq = new BufferedReader(arq);
		
	    int quantidade = Integer.parseInt(lerArq.readLine()); // L� a primeira linha.
		int aux = 0;
		
		String linha = null;
		while (aux != quantidade) {   
			linha = lerArq.readLine();
			lista.add(linha.split(" ", 3));
			aux++;
			// Cada linha tera um vetor de tr�s posi��es: Ex:
			//		linha = "123 Maria Jo�o"
			//	 	linha.split(" ", 3) -> vet[0] = "123", vet[1] = "Maria" e vet[2] = "Jo�o"	
		}
		
		linha = lerArq.readLine();
		lista.add(linha.split(" ", 2));
		
		return lista;
		
	}
	
	
	
	
}
