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
	Map<String, String> dicArestas;
	List<String> vizinhos;
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
		
		//System.out.println(dicionario);
	}
	
	public void addAresta(String conta,String origem, String destino){
		
		aresta = dicArestas.get(origem + " " + destino);

		if (aresta == null) dicArestas.put(origem + " " + destino, aresta);
			
		dicArestas.put(origem + " " + destino, conta);
		
		//System.out.println(dicArestas);
		
	}
	
	public void buscarConta(String origem, String destino){
		
		String teste = dicArestas.get(origem + " " + destino);
		
		System.out.println(teste);
		
	}
	
	public void caminhamento(String origem, String destino){
		
		//Fila fila = new Fila(ini);
		
	}	
	
	public void setVizinhos(List<String> vizinhos) {
		this.vizinhos = vizinhos;
	}
	
	

}
	
	
	


