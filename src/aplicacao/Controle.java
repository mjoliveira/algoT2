//------------------------------------------------------
package aplicacao;
//------------------------------------------------------
import java.io.IOException;
import java.util.List;

import aplicacao.Grafo.Aresta;
import aplicacao.Grafo.Nodo;
//------------------------------------------------------

public class Controle {
	private String nome;
	
	private List<String[]> arquivo;
	private List<Aresta> arestas;
	private Grafo grafo;
	
	public Controle(String nome) { // Construtor do Controle.
		this.nome = nome;
		
		setGrafo(null);
	}
	
	public boolean carregarArquivo(String nome) {
				
        try{
        	setArquivo(IO.carregarArquivo(nome));
			
		}catch (IOException e){
			return false;
		}
  
		return true;
	}
	
	public boolean gerarGrafo() {
		
		try{
			for(String[] vet : getArquivo()){
			
				int conta = Integer.parseInt(vet[0]);
				String origem = vet[1];
				String destino = vet[2];
				
				//System.out.println("Origem: " + origem + "   Destino: " + destino);
				
				
				Nodo nodoOrigem = grafo.addNodo(origem);
				Nodo nodoDestino = grafo.addNodo(destino);
				arestas = (List<Aresta>) grafo.addAresta(conta, nodoOrigem, nodoDestino);
				
			}
		}catch (NullPointerException  e){
			return false;
		}
		
		
		return true;
	}
	
	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}
	
	public void setArquivo(List<String[]> arquivo) {
		this.arquivo = arquivo;
	}
	
	public List<String[]> getArquivo() {
		return arquivo;
	}
}
