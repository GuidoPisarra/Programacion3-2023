package Practico3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class main {

	public static void main(String[] args) {

		GrafoDirigido<Integer> grafoDirigido = new GrafoDirigido<Integer>();
		
		grafoDirigido.agregarVertice(1);
		grafoDirigido.agregarVertice(2);
		grafoDirigido.agregarVertice(3);
		grafoDirigido.agregarVertice(4);
		grafoDirigido.agregarVertice(5);
		grafoDirigido.agregarVertice(6);

		
		grafoDirigido.agregarArco(1, 2, 12);
		grafoDirigido.agregarArco(1, 3, 13);
		grafoDirigido.agregarArco(4, 1, 41);
		grafoDirigido.agregarArco(3, 4, 34);
		grafoDirigido.agregarArco(3, 2, 32);
		grafoDirigido.agregarArco(3, 6, 25);
		grafoDirigido.agregarArco(2, 5, 25);
		grafoDirigido.agregarArco(5, 6, 55);

//		Ejercicio 3.
//		Implemente un algoritmo que determine si un grafo dirigido tiene algún ciclo.
		ServicioDepthFirstSearch dfs = new ServicioDepthFirstSearch(grafoDirigido);
//		System.out.println(dfs.containCiclo());
		
//		Ejercicio 4.
//		Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el
//		camino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponerse que
//		el grafo de entrada es acíclico.
		
//		System.out.println( dfs.caminoMayorLongitud(1,2).toString());

//		Ejercicio 5.
//		Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
//		con todos los vértices a partir de los cuales exista un camino en G que termine en v.

//		System.out.println(dfs.caminosQueLleguenAlVertice(2));
		
//		Ejercicio 6.
//		Supongamos una conexión entre computadoras (1, ... ,n) que se encuentra modelada
//		mediante un grafo. Se requiere, si existe, dar una conexión entre dos computadoras a y b
//		existentes sabiendo que la computadora i está fuera de servicio.

		//Preguntar No entiendo la consigna
		
		
//		Ejercicio 7.
//		Supongamos que una ciudad se encuentra modelada mediante un grafo, donde cada nodo
//		es una esquina, y las aristas representan las calles. Diseñe un algoritmo tal que dadas dos
//		esquinas, devuelva el camino más corto entre ambas de manera de caminar la menor
//		cantidad de cuadras posible.

//		System.out.println(dfs.caminoMasCorto(1,2).toString());

//		Ejercicio 8
//		Dados un grafo G con sus vértices rotulados con colores y dos vértices v1 y v2, escriba un
//		algoritmo que encuentre un camino desde el vértice v1 al vértice v2 tal que no pase por
//		vértices rotulados con el color rojo.
		
//		ServicioBreadthFirstSearch bfs =  new ServicioBreadthFirstSearch(grafoDirigido);
//		System.out.println(bfs.caminoSinRojo(1, 6));
		
//		Ejercicio 9
//		Dado un grafo no orientado que modela las rutas de la provincia de Buenos Aires, devolver
//		todos los caminos alternativos que se pueden tomar para ir desde la ciudad de Buenos
//		Aires a la ciudad de Tandil, considerando que en el tramo Las Flores-Rauch está cortado al
//		tránsito.
		
		GrafoNoDirigido<Integer> grafoNoDirigido =  new GrafoNoDirigido<Integer>();
		
		grafoNoDirigido.agregarVertice(1); //bs as 
		grafoNoDirigido.agregarVertice(2); //monte  
		grafoNoDirigido.agregarVertice(3); // las flores 
		grafoNoDirigido.agregarVertice(4); // rauch
		grafoNoDirigido.agregarVertice(5); //ayacucho 
		grafoNoDirigido.agregarVertice(6); // azul 
		grafoNoDirigido.agregarVertice(7); //tandil 
		grafoNoDirigido.agregarVertice(8); //tapalque
		grafoNoDirigido.agregarVertice(9); //olavarria
		
		grafoNoDirigido.agregarArco(1, 2, 100);// bsas monte
		grafoNoDirigido.agregarArco(2, 3, 101);// monte - las flores
		grafoNoDirigido.agregarArco(3, 4, 102);// las flores rauch
		grafoNoDirigido.agregarArco(4, 5, 103);// rauch ayacucho
		grafoNoDirigido.agregarArco(3, 6, 104);//las flores azul
		grafoNoDirigido.agregarArco(6, 9, 105);//azul olavarria
		grafoNoDirigido.agregarArco(5, 7, 107); //ayacucho -tandil
		grafoNoDirigido.agregarArco(6, 5, 108);// azul ayacucho
		grafoNoDirigido.agregarArco(6, 7, 109);// azul tandil
		grafoNoDirigido.agregarArco(9, 7, 110);// 
		grafoNoDirigido.agregarArco(2, 5, 108);// 

		ServicioDepthFirstSearch dfsCaminosAlternativos = new ServicioDepthFirstSearch(grafoNoDirigido);

//		ArrayList<List<Integer>> listado = new ArrayList<List<Integer>>();
//		listado = (ArrayList<List<Integer>>) dfs.caminosAlternativos(1, 7);
//		for(int i = 0; i< listado.size(); i++) {
//			System.out.println( listado.get(i).toString());
//		}
		dfsCaminosAlternativos.caminosAlternativos(1, 7);
		
	}

}
