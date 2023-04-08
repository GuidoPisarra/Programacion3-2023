package TrabajoPractico1;

import java.util.Iterator;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MySimpleLinkedList<Integer> lista = new MySimpleLinkedList();
//		lista.insertFront(9);
//		lista.insertFront(8);
//		lista.insertFront(7);
		
//		Ejercicio 1	
//		Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría
//		(insertFront, extractFront, isEmpty, size, toString). Agregar también el método: T get(index)

//		System.out.println("Lista");
//		System.out.println(lista.toString());
//		System.out.println("Size");
//		System.out.println(lista.size());
//		System.out.println("isEmpty");
//		System.out.println(lista.isEmpty());
//		System.out.println("extractFront");
//		System.out.println(lista.extractFront());
//		System.out.println(lista.toString());
//		System.out.println(lista.getIndex(2));
		
//		Ejercicio 2
//		Considerando la implementación de la Lista realizado en el ejercicio anterior, comparar la
//		complejidad computacional contra un array en las siguientes operaciones:
//		1.- Insertar al principio. O(1)
//		2.- Buscar un elemento en una posición. O(n)
//		3.- Determinar la cantidad de elementos. O(n sin size)  O(1 con size)
		
//		Ejercicio 3
//		Implemente una Pila utilizando la Lista del ejercicio 1. A una pila se le pueden agregar
//		elementos utilizando el método push(T o). Para retirar elementos de la colección se utiliza el
//		método pop(), que retorna el último elemento agregado a la colección y lo elimina de la
//		misma. Es posible consultar el tope de la pila (sin eliminarlo) utilizando el método top(). Por
//		último, es posible invertir el orden de los elementos de la pila mediante el método reverse().
//		Pila<Integer> pila = new Pila<Integer>();
//		pila.push(99);
//		pila.push(88);
//		pila.push(77);
//		System.out.println("Pila");
//		System.out.println(pila.toString());
//		System.out.println("pop");
//		System.out.println(pila.pop());
//		System.out.println("resultado despues pop");
//		System.out.println(pila.toString());
//		System.out.println("top");
//		System.out.println(pila.top());
//		pila.reverse();
//		System.out.println(pila.toString());
	
//		Ejercicio 4
//		A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
//		indexOf, que reciba un elemento y retorne el índice donde está almacenado ese elemento, o
//		-1 si el elemento no existe en la lista
//		System.out.println(lista.indexOf(9));
		
//		Ejercicio 5
//		A partir de la clase Lista implementada en el ejercicio 1, implemente el patrón
//		iterator-iterable, para que la lista sea iterable. ¿Existe alguna ventaja computacional a la
//		hora de recorrer la lista de principio a fin si se cuenta con un iterador?
		
		// ver MyIterator
//		Iterator<Integer> iterador = lista.iterator();
//		while(iterador.hasNext()) {
//		    int num = iterador.next();
//		    System.out.println(num);
//		}
		
// 		Ejercicio 6
//		Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
//		suponiendo que: 
//			a) Las listas están desordenadas y la lista resultante debe quedar ordenada. 
//			b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
		
//		ListWithCursor<Integer> listaConCursor1 = new ListWithCursor<Integer>();
//		ListWithCursor<Integer> listaConCursor2 = new ListWithCursor<Integer>();

//		listaConCursor.insertFront(888);
//		listaConCursor.insertFront(900);
//		listaConCursor.insertLast(777);
//		listaConCursor.insertLast(666);
//		listaConCursor1.insertInOrder(5);
//		listaConCursor1.insertInOrder(6);
//		listaConCursor1.insertInOrder(7);
//		listaConCursor1.insertInOrder(11);
//		listaConCursor1.insertInOrder(12);
//		System.out.println(listaConCursor1.toString());
//		listaConCursor2.insertInOrder(9);
//		listaConCursor2.insertInOrder(10);
//		listaConCursor2.insertInOrder(11);
//		listaConCursor2.insertInOrder(11);
//		listaConCursor2.insertInOrder(12);
//		System.out.println(listaConCursor2.toString());
		//System.out.println(listaConCursor2.getIndex(577));
		//ListWithCursor<Integer> result = listaConCursor1.commonElementsInOrder(listaConCursor1, listaConCursor2);
		//System.out.println(result.toString());
		
//		Ejercicio 7
//		Escriba una función que dadas dos listas construya otra con los elementos que están en la
//		primera pero no en la segunda.

//		ListWithCursor<Integer> result = listaConCursor1.diffElements(listaConCursor1, listaConCursor2);
//		System.out.println(result.toString());
		
//		Ejercicio 8
//		Considerando la implementación de Lista del ejercicio 1, realice una Lista doblemente
//		vinculada
		
//		MyDoubleLinkedList<Integer> lista = new MyDoubleLinkedList<Integer>();
//		lista.insertFront(9);
//		lista.insertFront(8);
//		lista.insertFront(7);
//		lista.insertFront(15);
//		lista.insertFront(22);
//		System.out.println("extractFront: "+ lista.extractFront());
//		System.out.println("isEmpty: "+ lista.isEmpty());
//		System.out.println("size: "+lista.size());
//		System.out.println("get: "+lista.get(4));
//		System.out.println("indexOf: "+lista.indexOf(7));
//		lista.insertLast(32);
//		System.out.println("extractLast: "+ lista.extractLast());
//		System.out.println(lista.toString());

		
//		Ejercicio 9.
//		Verificar si una cadena de texto es palindroma (capicua).
		
		ListWithCursor<Character> palabra = new ListWithCursor<Character>();
		String word = "neuquen";
		int pos = 0;
		while(word.length()>pos) {
			palabra.insertFront(word.charAt(pos));
			pos++;
		}
		System.out.println(palabra.toString());
		System.out.println(palabra.isPalindroma());


	}

}
