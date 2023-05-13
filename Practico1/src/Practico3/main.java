package Practico3;

public class main {

	public static void main(String[] args) {

		GrafoDirigido<Integer> grafoDirigido = new GrafoDirigido<Integer>();
		
		grafoDirigido.agregarVertice(1);
		grafoDirigido.agregarVertice(2);
		grafoDirigido.agregarVertice(3);
		grafoDirigido.agregarVertice(4);
		
		grafoDirigido.agregarArco(1, 2, 12);
		grafoDirigido.agregarArco(1, 3, 13);
		grafoDirigido.agregarArco(4, 1, 41);
		grafoDirigido.agregarArco(3, 4, 34);
		grafoDirigido.agregarArco(3, 2, 32);

		//grafoDirigido.toString();
		
		ServicioDepthFirstSearch dfs = new ServicioDepthFirstSearch(grafoDirigido);

		System.out.println(dfs.containCiclo());
	}

}
