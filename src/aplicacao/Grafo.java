package aplicacao;
//------------------------------------------------------
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//------------------------------------------------------

public class Grafo{

	Map<String, List<String>> dicionario;
	Map<String, String> marcados;
	Map<String, String> dicArestas;
	List<String> vizinhos;
	List<String> contas;
	String aresta;
	
	public Grafo(){
		dicionario = new HashMap<>();
		dicArestas = new HashMap<>();
	}
	
	public void addVizinho(String origem, String destino){
		
		vizinhos = dicionario.get(origem);

		if (vizinhos == null) {
		    vizinhos = new ArrayList<>();
		    dicionario.put(origem, vizinhos);
		}
		
		vizinhos.add(destino);
	}
	
	public void addAresta(String conta,String origem, String destino){
		
		aresta = dicArestas.get(origem + " " + destino);

		if (aresta == null) dicArestas.put(origem + " " + destino, aresta);
			
		dicArestas.put(origem + " " + destino, conta);
		
	}
	
	public String buscarConta(String origem, String destino){
		
		String teste = dicArestas.get(origem + " " + destino);

		return teste = teste + " (" + origem + " " + destino + ")\n";
		
	}
	
	public void caminhamento(String origem, String destino){
		
		marcados = new HashMap<>();
		List<String> fila = new ArrayList<>();
		
		marcados.put(origem, " ");
		
		fila.add(origem);
		
		while (fila.isEmpty() == false){
			
			String pessoa = fila.remove(0);

			if(pessoa == destino) break;
			
			List<String> visinhosBusca = new ArrayList<>();
			visinhosBusca = dicionario.get(pessoa);
			int tamanho = visinhosBusca.size();
			
			for (int i = 0; i < tamanho; i++){
				
				String aux = marcados.get(visinhosBusca.get(i));
				
				if(aux == null){ // Se for igual a null o vizinho não esta na lista de marcados.
					marcados.put(visinhosBusca.get(i), pessoa);
					fila.add(visinhosBusca.get(i));
				}
			}
		}
		
	}
	
	public String apresentação(String origem, String destino){
		
		String pessoaAtual = destino;
		String pessoaDestino = marcados.get(pessoaAtual);
		//System.out.println("Atual: " + pessoaAtual + "    Destino: " +pessoaDestino);
		
		
		List<String> contas = new ArrayList<>();
		String mensagem;
				
		if(pessoaDestino == null) return mensagem = "Usuário não encontrado!";
			
		String conta = buscarConta(pessoaDestino, destino);
		contas.add(conta);
		
		while (pessoaDestino != origem) {
			
			pessoaAtual = pessoaDestino;
			pessoaDestino = marcados.get(pessoaAtual);
			conta = buscarConta(pessoaDestino, pessoaAtual);
			contas.add(conta);	
			//System.out.println(conta);
			
		}
		
		return contas.toString();
	}
	
	
	public List<String> getVizinho() {
		return vizinhos;
	}
	
	
	public void setVizinhos(List<String> vizinhos) {
		this.vizinhos = vizinhos;
	}
	
	

}
	
	
	


