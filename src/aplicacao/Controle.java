//------------------------------------------------------
package aplicacao;
//------------------------------------------------------
import java.io.IOException;
import java.util.List;

//import aplicacao.Grafo.Aresta;
//import aplicacao.Grafo.Nodo;
//------------------------------------------------------

public class Controle {
	private String nome;
	
	private List<String[]> arquivo;
	private String [] contas;
	private Grafo grafo;
	
	public Controle(String nome) { // Construtor do Controle.
		this.nome = nome;
		grafo = new Grafo();
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
			
			String conta = null, origem = null, destino = null;
			
			contas = arquivo.remove(arquivo.size()-1);
			String inicio = contas[0].trim(), fim = contas[1].trim();
			
			
			
			for(String[] vet : getArquivo()){

				
				conta = vet[0];  //Integer.parseInt(vet[0]);
				origem = vet[1];
				destino = vet[2];
				
				grafo.addVizinho(origem, destino);
				grafo.addVizinho(destino,origem);
				grafo.addAresta(conta, origem, destino);
				grafo.addAresta(conta, destino, origem);
				grafo.buscarConta(destino,origem);
				
				
				
			}
			
			grafo.caminhamento(inicio, fim);
			
			System.out.println(grafo.apresentação(inicio, fim));
			
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
