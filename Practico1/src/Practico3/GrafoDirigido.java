package Practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class GrafoDirigido<T> implements Grafo<T> {
	
	HashMap<Integer, HashMap<Integer, T>> vertices = new HashMap<>();

	HashMap<Integer, String> colores = new HashMap<>();
		
	@Override
	public void agregarVertice(int verticeId) {
		if (!vertices.containsKey(verticeId)) {
			vertices.put(verticeId, new HashMap<>());
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		for(int i : vertices.keySet()) {
			vertices.get(i).remove(verticeId);			
		}
		vertices.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)) {
			vertices.get(verticeId1).put(verticeId2, etiqueta);
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if(vertices.containsKey(verticeId1)) {			
			vertices.get(verticeId1).remove(verticeId2);			
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if(vertices.containsKey(verticeId1)) {
			if(vertices.get(verticeId1).containsKey(verticeId2)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if(vertices.containsKey(verticeId1) && vertices.get(verticeId1).containsKey(verticeId2)) {
			Arco<T> tmp = new Arco<T> (verticeId1, verticeId2, vertices.get(verticeId1).get(verticeId2));
			return tmp;
		}
		return null;
	}

	@Override
	public int cantidadVertices() {		
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int cantidadDeArcos =0;
		for(int i: vertices.keySet()) {
			cantidadDeArcos += vertices.get(i).size(); 
		}
		return cantidadDeArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		return vertices.get(verticeId).keySet().iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		LinkedList<Arco<T>> arcos = new LinkedList<Arco<T>>();
		for(int i: vertices.keySet()) {
			for(int j: vertices.get(i).keySet()) {
				Arco<T> tmp = new Arco<T>(i,j,vertices.get(i).get(j));
				arcos.add(tmp);
			}
		}
		return arcos.iterator();
	}// investigar entry
	
	
	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		LinkedList<Arco<T>> arcos = new LinkedList<Arco<T>>();
		
		for(int i: vertices.get(verticeId).keySet()) {
				Arco<T> tmp = new Arco<T> (verticeId,i, vertices.get(verticeId).get(i));
				arcos.add(tmp);
			
		}
		return arcos.iterator();
	}
	

	@Override
	public String toString() {
		for(int i : vertices.keySet()) {
			System.out.println("Vertice: " + i );
			for(int j : vertices.get(i).keySet()) {
				System.out.print("      " + "--> " + j + " : " + vertices.get(i).get(j));
			}
			System.out.println("");
		}
		
		return "";
		
	}

}