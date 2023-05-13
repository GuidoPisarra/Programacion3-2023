package Practico3;

import java.util.HashMap;
import java.util.Iterator;

public class ServicioDepthFirstSearch {

	private int time;
	private HashMap<Integer, String> colores = new HashMap<Integer, String>();
	private Grafo<?> grafo;
	
	
	public ServicioDepthFirstSearch (Grafo<?> grafo ) {
		this.grafo = grafo;		
	}
	
	public void routeGrafo() {
		Iterator<Integer> vertices = this.grafo.obtenerVertices();

		while (vertices.hasNext()) {
			this.colores.put(vertices.next(), "BLANCO");
		}
		
		this.time = 0;
		vertices=this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			System.out.println(vertices.next());
			if(colores.get(vertices.next()).equals("BLANCO")) {
				this.visit_DFS(vertices.next());
			}
		}
	}
	
	private void visit_DFS (int verticeId) {
		colores.replace(verticeId,"AMARILLO");
		this.time ++;
		Iterator<Integer> verticesAdyacentes = this.grafo.obtenerAdyacentes(verticeId);
		
		while(verticesAdyacentes.hasNext()) {
			int adyacente = verticesAdyacentes.next();
			if(colores.get(adyacente).equals("BLANCO")) {
				visit_DFS(adyacente);
			}
		}
		colores.replace(verticeId, "NEGRO");
		
	}
	
	public boolean containCiclo() {
		Iterator<Integer> vertices = this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			int vertice = vertices.next();
			this.colores.put(vertice, "BLANCO");
		}
		vertices = this.grafo.obtenerVertices();
		while (vertices.hasNext()) {
			int vertice = vertices.next();
			if(colores.get(vertice).equals("BLANCO")) {
				return this.recorrerParaCiclo(vertice);
			}

		}
		return false;		
	}
	
	private boolean recorrerParaCiclo(int verticeId) {
		Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(verticeId);
		
		colores.replace(verticeId, "AMARILLO");
		
		while(adyacentes.hasNext()) {
			Integer adyacente = adyacentes.next();
		
			if(colores.get(adyacente).equals("BLANCO")) {
				if(recorrerParaCiclo(adyacente)) return true;
			}else {
				if(colores.get(adyacente).equals("AMARILLO")) {
					return true;
				}				
			}
		}
		
		return false;		
	}
	
	
	
}
