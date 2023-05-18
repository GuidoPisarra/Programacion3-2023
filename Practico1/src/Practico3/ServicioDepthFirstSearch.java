package Practico3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
	
	public List<Integer> caminoMayorLongitud (int verticeId1, int verticeId2) {		
		if(this.grafo.contieneVertice(verticeId1) && this.grafo.contieneVertice(verticeId2) ) {
			Iterator<Integer> vertices = this.grafo.obtenerVertices();
			while(vertices.hasNext()) {
				int vertice = vertices.next();
				this.colores.put(vertice, "BLANCO");
			}
			return this.caminoMayor(verticeId1, verticeId2);			
		}		
		return null;			
	}
	
	private List<Integer> caminoMayor(int verticeId1,int verticeId2){
		LinkedList<Integer> caminoMayor = new LinkedList<Integer>();
		Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(verticeId1);
		if(verticeId1 == verticeId2 ) {
			caminoMayor.add(verticeId1);
		}else {		
			this.colores.replace(verticeId1, "AMARILLO");			
			while(adyacentes.hasNext()) {
				int adyacente = adyacentes.next();
				if(this.colores.get(adyacente).equals("BLANCO")) {
					LinkedList<Integer> camino = new LinkedList<Integer>();
					camino.addAll(caminoMayor(adyacente, verticeId2));		

					if(camino.size()>= caminoMayor.size()) {
						caminoMayor.clear();
						caminoMayor.add(verticeId1);
						caminoMayor.addAll(camino);
					}					
				}
			}
			this.colores.replace(verticeId1, "BLANCO");			
		}
		return caminoMayor;		
	}
	
	public List<Integer> caminosQueLleguenAlVertice(int verticeId){
		LinkedList<Integer> listado = new LinkedList<Integer>();
		if(this.grafo.contieneVertice(verticeId)) {
			Iterator<Integer> vertices = this.grafo.obtenerVertices();
			while (vertices.hasNext()) {
				int vertice = vertices.next();
				this.colores.put(vertice,"BLANCO");
				 if(llegaAlVertice(vertice,verticeId)) {
					 listado.add(vertice);
				 }
			}
		}
		return listado;	
	}
	
	private boolean llegaAlVertice(int vertice, int verticeId){
		Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice);
		
		while(adyacentes.hasNext()) {
			int adyacente =  adyacentes.next();
			this.colores.replace(vertice, "AMARILLO");
			if(adyacente == verticeId) {				
				return true;
			}
			llegaAlVertice(adyacente, verticeId);
			this.colores.replace(vertice, "BLANCO");
			
		}
		return false;
	}
	
	
	public List<Integer> caminoMasCorto(int verticeId1, int verticeId2){
		
		if(this.grafo.contieneVertice(verticeId1) && this.grafo.contieneVertice(verticeId2)) {
			Iterator<Integer> vertices = this.grafo.obtenerVertices();
			while (vertices.hasNext()) {
				int vertice = vertices.next();
				this.colores.put(vertice, "BLANCO");
			}			
			return this.caminoMenor(verticeId1, verticeId2);	
		}
		return null;
	}
	
	private List<Integer> caminoMenor(int verticeId1, int verticeId2){	
		LinkedList<Integer> camMenor = new LinkedList<Integer>();
		Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(verticeId1);
		if(verticeId1 == verticeId2 ) {
			camMenor.add(verticeId1);
		}else {
			this.colores.replace(verticeId1, "AMARILLO");
			while (adyacentes.hasNext()) {
				int adyacente = adyacentes.next();
				if(this.colores.get(adyacente).equals("BLANCO")) {
					LinkedList<Integer> camino = new LinkedList<Integer>();
					camino.addAll(caminoMenor(adyacente,verticeId2));
					if(camino.size() <= camMenor.size() || camMenor.size()==0) {
						camMenor.clear();
						camMenor.add(verticeId1);
						camMenor.addAll(camino);
					}					
				}				
			}			
			this.colores.replace(verticeId1,"BLANCO");
		}
		return camMenor;	
	}
	
	public List<List<Integer>> caminosAlternativos(int verticeId1, int verticeId2){
		Iterator<Integer> vertices = this.grafo.obtenerVertices();
		if(this.grafo.contieneVertice(verticeId1) && this.grafo.contieneVertice(verticeId2)) {
			while(vertices.hasNext()) {
				int vertice =  vertices.next();
				this.colores.put(vertice, "BLANCO");
			}	
			return caminoAlterno(verticeId1, verticeId2);
		}
		return null;				
	}
	
	private List<List<Integer>> caminoAlterno(int origen, int destino){
		Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(origen);
		LinkedList<List<Integer>> caminos = new LinkedList<List<Integer>>();
		LinkedList<Integer> camino = new LinkedList<Integer>();

		if(origen == destino) {
			camino.add(origen);
		}else {
			this.colores.replace(origen, "AMARILLO");
			while(adyacentes.hasNext()) {
				int adyacente = adyacentes.next();
				if(this.colores.get(adyacente).equals("BLANCO")) {
					caminos.addAll(caminoAlterno(adyacente, destino));
					if(adyacente!=4) {
						camino.add(adyacente);
						caminos.add(camino);
					}
				}
			}
		}		
		this.colores.replace(origen, "BLANCO");
		return caminos;
	}
		
	
}
