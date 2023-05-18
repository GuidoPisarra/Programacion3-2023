package Practico3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
			int vertice = vertices.next();
			this.verticesVisitados.put(vertice, false);
		}
		vertices = this.grafo.obtenerVertices();
		this.fila.clear();	
		while(vertices.hasNext()) {
			int vertice = vertices.next();
			if(this.verticesVisitados.get(vertice)) {
				this.visit_BFS(vertice);
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
				int adyacente = adyacentes.next();
				if(!this.verticesVisitados.get(adyacente)) {
					this.verticesVisitados.replace(adyacente, true);
					fila.add(adyacente);
				}
			}
		}
	}
	
	public List<Integer> caminoSinRojo(int verticeId1, int verticeId2){
		// Reemplazo "ROJO" por 3 para comprobar
		if(this.grafo.contieneVertice(verticeId1)&& this.grafo.contieneVertice(verticeId2)) {
			Iterator<Integer> vertices = this.grafo.obtenerVertices();
			this.fila.clear();
			while (vertices.hasNext()) {
				int vertice = vertices.next();
				this.verticesVisitados.put(vertice, false);
			}
			return this.caminosSinRojo(verticeId1, verticeId2);		
		}
		return null;
	}
	
	private List<Integer> caminosSinRojo(int origen, int destino){
		Iterator <Integer> adyacentes = this.grafo.obtenerAdyacentes(origen);
		LinkedList<Integer> camino = new LinkedList<Integer>();
		this.fila.add(origen);
		this.verticesVisitados.replace(origen, true);
		if(!this.fila.isEmpty()) {
			this.fila.poll();			
			while (adyacentes.hasNext()) {				
				int adyacente = adyacentes.next();
				if(!this.verticesVisitados.get(adyacente) && adyacente!=3) {
					camino.add(origen);
				    camino.addAll(caminosSinRojo(adyacente,destino));
				}
			}
			this.verticesVisitados.replace(origen,false);			
		}
		return camino;	
	}
	

	
}
