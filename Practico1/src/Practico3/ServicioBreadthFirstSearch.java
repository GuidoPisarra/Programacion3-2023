package Practico3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ServicioBreadthFirstSearch {

	private Grafo<?> grafo;
	private HashMap<Integer, Boolean> verticesVisitados = new HashMap<Integer,Boolean>() ; 
	private LinkedList<Integer> fila = new LinkedList<Integer>();
	
	public ServicioBreadthFirstSearch(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
	public void routeGrafo() {
		Iterator<Integer> vertices = this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			this.verticesVisitados.put(vertices.next(), false);
		}
		
		this.fila.clear();	
		while(vertices.hasNext()) {
			if(vertices.next().equals(false)) {
				this.visit_BFS(vertices.next());
			}
		}
		
	}
	
	private void visit_BFS(int verticeId) {
		this.verticesVisitados.put(verticeId, true);
		this.fila.add(verticeId);
		while(!fila.isEmpty()) {
			fila.poll();
			Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(verticeId);
			while (adyacentes.hasNext()) {
				if(adyacentes.next().equals(false)) {
					this.verticesVisitados.replace(verticeId, true);
					fila.add(adyacentes.next());
				}
			}
		}
	}

	
}
