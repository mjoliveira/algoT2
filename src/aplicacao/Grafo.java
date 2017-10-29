//------------------------------------------------------
package aplicacao;
//------------------------------------------------------
import java.util.List;
import java.util.ArrayList;
//------------------------------------------------------

public class Grafo {
   
	public class Nodo { // Classe Nodo (Classe interna de grafo).
        String nome;
        List<Aresta> adjacentes; // Lista de adjacências.

        public Nodo(String nome) { // Construtor do Nodo.
            this.nome = nome;
            this.adjacentes = new ArrayList<Aresta>();
        }

        void addAdjacente(Aresta a) { // Adiciona um adjacente na lista.
        	adjacentes.add(a);
        }
    }

    public class Aresta { // Classe Aresta (Classe interna de grafo).
    	int valor;
    	Nodo origem;
    	Nodo destino;

        public Aresta(int valor,Nodo origem, Nodo destino) { // Construtor da Aresta.
        	this.valor = valor;
            this.origem = origem;
            this.destino = destino;
        }
        
        public int getValor() {
    		return valor;
    	}
    }

    List<Nodo> nodos; // Lista de nodos.
    List<Aresta> arestas; // Lista de arestas.

    public Grafo() { // Construtor do Grafo.
    	nodos = new ArrayList<Nodo>();
        arestas = new ArrayList<Aresta>();
    }

    public Nodo addNodo(String nome) { // Adiciona um novo nodo ao Grafo.
    	Nodo v = new Nodo(nome);
    	nodos.add(v);
        return v;
    }

    public Aresta addAresta(int valor, Nodo origem, Nodo destino) { // Adiciona um nova aresta ao Grafo.
        Aresta a = new Aresta(valor, origem, destino);
        origem.addAdjacente(a);
        arestas.add(a);
        return a;
    }

    public String toString() { // Apresenta em tela a lista de nodos e seus adjacentes - Usado para teste.
        String r = "";
        for (Nodo nodo : nodos) {
            r += nodo.nome + ": ";
            for (Aresta a : nodo.adjacentes) {
            	Nodo v = a.destino;
                r += v.nome + ", ";
            }
            r += "\n";
        }
        return r;
    }
}
