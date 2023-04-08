package NooooPractico1;

import java.util.Iterator;

public class main {

	public static void main(String[] args) {
		// Ejercicio 1
		MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();
		
		//Insertar		
		lista.insertFront(1);
		lista.insertFront(8);
		
		//toString()
		System.out.println("Resultado lista insertar");
		System.out.println(lista.toString());

		//Extraer
		System.out.println("Primer valor, luego se extrae");
		System.out.println(lista.extractFront());
		
		//Size
		System.out.println("Size");
		System.out.println(lista.size());
		
		//IsEmpty
		System.out.println("isEmpty");
		System.out.println(lista.isEmpty());
		
		
		// Ejercicio 2
		// 1. O(1);
		// 2. O(n)
		// 3. O(1) si utilizo la variable size sino es O(n)
		
		// Ejercicio 3
		Pila<Integer> pila = new Pila<Integer>();
		System.out.println("push");
		pila.push(88);
		pila.push(99);
		pila.push(100);
		pila.push(188);
		System.out.println(pila.toString());
		System.out.println("pop");
		System.out.println(pila.pop());
		System.out.println("Pila despues de pop");
		System.out.println(pila.toString());
		System.out.println("Pila top");
		System.out.println(pila.top());
		System.out.println("Pila despues de top");
		System.out.println(pila.toString());
		
		//Reverse
		pila.push(10);
		pila.push(7);
		pila.push(22);
		System.out.println("Pila original");
		System.out.println(pila.toString());
		System.out.println("Pila despues de reverse");
		pila.reverse();
		System.out.println(pila.toString());		
		
		
		//Ejercicio 4
		lista.insertFront(4);
		lista.insertFront(6);
		lista.insertFront(10);
		lista.insertFront(8);
		System.out.println("Imprimo lista antes de ver el indice");
		System.out.println(lista.toString());
		System.out.println("Indice de elemento");
		System.out.println(lista.indexOf(1));
		
		//Ejercicio 5 
		System.out.println("Lista Iterator");
		Iterator<Integer> it = lista.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+ ", ");
		}
		//Ejercicio 6.
		// Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
		// suponiendo que: 
		// a) Las listas están desordenadas y la lista resultante debe quedar ordenada. 
		// b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
		MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<Integer>(); 
		lista2.insertFront(8);
		lista2.insertFront(7);
		lista2.insertFront(9);
		lista2.insertFront(10);

		System.out.println("");
		System.out.println("Lista 2");
		System.out.println(lista2.toString());
		
		MySimpleLinkedList<Integer> result = lista.commonElementsList(lista, lista2);
		System.out.println("Lista elementos comunes");
		System.out.println(result.toString());
		System.out.println("Lista elementos comunes con comparable");
		ListWithCursorOLD<Integer> listCursor1 = new ListWithCursorOLD<Integer>();
		ListWithCursorOLD<Integer> listCursor2 = new ListWithCursorOLD<Integer>();

		listCursor1.insertFront(33);
		listCursor1.insertFront(22);
		listCursor1.insertFront(28);
		listCursor2.insertFront(22);
		listCursor2.insertFront(33);
		listCursor2.insertFront(33);
		listCursor2.insertFront(9);
		ListWithCursorOLD<Integer> resultCursor = listCursor1.listCommonOrder(listCursor1, listCursor2);
		System.out.println("Cursorrrrrrrrrrrrrrrrr");

		System.out.println(resultCursor.toString());
		// Ejercicio 7.
		//  Escriba una función que dadas dos listas construya otra con los elementos que están en la
		//  primera pero no en la segunda.
		System.out.println("Lista elementos NO comunes");
		MySimpleLinkedList<Integer> resultNoCommon = lista.listElementsDiff(lista, lista2);

		System.out.println(resultNoCommon.toString());
		
		
		//Ejercicio 8.
		//Considerando la implementación de Lista del ejercicio 1, realice una Lista doblemente
		//vinculada.
		
		MyDoubleLinkedListOLD<Integer> listaDoble = new MyDoubleLinkedListOLD<Integer>();
		listaDoble.insertFront(9);
		listaDoble.insertFront(8);
		listaDoble.insertFront(7);
		System.out.println("Imprimir lista doble insert front");
		System.out.println(listaDoble.toString());
		System.out.println("Imprimir lista doble extract front");
		listaDoble.extractFront();
		System.out.println(listaDoble.toString());
		System.out.println("Is empty");
		System.out.println(listaDoble.isEmpty());
		System.out.println("size");
		System.out.println(listaDoble.size());
		System.out.println("get index");
		System.out.println(listaDoble.getIndex(2));
		System.out.println("insert last");
		listaDoble.insertLast(88);
		listaDoble.insertLast(99);
		System.out.println(listaDoble.toString());
		System.out.println("extract last");
		listaDoble.extractLast();
		System.out.println(listaDoble.toString());
		System.out.println("palindroma");
		System.out.println(lista.isPalindroma("neuquenx"));
		System.out.println(lista.isPalindroma("arenera"));
		System.out.println(lista.isPalindroma("reconocerr"));
		System.out.println(lista.isPalindroma("sometemos"));

		// Ejercicio Juan
		ListWithCursorOLD<Integer> listaCursor = new ListWithCursorOLD<Integer>();
		System.out.println("Lista con cursor insertFront e insertLast");
		listaCursor.insertLast(5);
		listaCursor.insertFront(8);
		listaCursor.insertFront(7);
		listaCursor.insertFront(6);
		listaCursor.insertLast(9);
		listaCursor.insertLast(10);
		System.out.println(listaCursor.toString());
		System.out.println("Lista con cursor getLast");
		System.out.println(listaCursor.getLast());
		System.out.println("Lista con cursor getCursor");
		System.out.println(listaCursor.getCursor());
		System.out.println("Lista con cursor mover cursor");
		listaCursor.moveCursor();
		listaCursor.moveCursor();
		listaCursor.resetCursor();
		System.out.println(listaCursor.getCursor());
		

		
		
	}

}
