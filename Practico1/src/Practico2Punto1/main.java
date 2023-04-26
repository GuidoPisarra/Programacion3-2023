package Practico2Punto1;

public class main {

	public static void main(String[] args) {

		Tree<Integer> arbol = new Tree<Integer>();
		arbol.add(90);
		arbol.add(80);
		arbol.add(100);
		arbol.add(110);
		arbol.add(79);
		arbol.add(78);
		arbol.add(91);
		arbol.add(98);
		arbol.add(92);
		arbol.add(93);


		System.out.println(arbol.getRoot());
		System.out.print("PreOrder: ");
		arbol.printPreOrder();
		System.out.println();
		System.out.print("PostOrder: ");
		arbol.printPostOrder();
		System.out.println();
		System.out.print("InOrder: ");
		arbol.printInOrder();
		//arbol.delete(91);
		//System.out.print("InOrder despues de eliminar:  ");
		//arbol.printInOrder();
		System.out.println();
		System.out.print("Altura: " +arbol.getHeigth());
		System.out.println();
		System.out.print("Rama mas larga: " );
		arbol.getLongestBranch();
		System.out.println();
		System.out.print("Frontera: " );
		arbol.getFrontera();
		System.out.print("Maximo Elemento: " + arbol.getMaxElement());
		System.out.println();
		System.out.print("Element at level: " + arbol.getElemAtLevel(2).toString() );
		
		
		System.out.println();
		//EJERCICIO 2
		System.out.print("Suma Nodos Internos: "+ arbol.getSumaNodosInternos());
		
		System.out.println();
		//EJERCICIO 3
		System.out.print("Valores Mayores: "+ arbol.getValoresMayores(80));
		
		System.out.println();
		//EJERCICIO 4
		System.out.print("Completar Arbol: ");
		arbol.completarArbol();
		
		System.out.println();
		//EJERCICIO 5
		Tree<Character> arbolLetras = new Tree<Character>();
		

		System.out.print("Palabras por cantidad vocales: "+ arbolLetras.getPalabrasPorCantVocales(1));
	}

}
