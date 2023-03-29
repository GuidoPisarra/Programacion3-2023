package tp1;

public class main {

	public static void main(String[] args) {
		// Ejercicio 1
		MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();
		
		//Insertar		
		lista.insertFront(1);
		lista.insertFront(8);
		
		//toString()
		System.out.println("listar");
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
		System.out.println("push");
		lista.push(88);
		System.out.println(lista.toString());
		System.out.println("pop");
		System.out.println(lista.pop());
		System.out.println("lista despues de pop");
		System.out.println(lista.toString());
		System.out.println("Top");
		System.out.println(lista.top());
		System.out.println("lista despues de top");
		System.out.println(lista.toString());
		
		//Reverse
		lista.insertFront(10);
		lista.insertFront(7);
		lista.insertFront(22);
		System.out.println("lista original");
		System.out.println(lista.toString());
		System.out.println("lista despues de reverse");
		lista.reverse();
		System.out.println(lista.toString());		
		
		
		//Ejercicio 4
		System.out.println("Indice de elemento");
		System.out.println(lista.indexOf(10));
		
		//Ejercicio 5 PREGUNTAR , no creo que exista ventaja computacional
		lista.iterator().toString();
		
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

		System.out.println("Lista 2");
		System.out.println(lista2.toString());
		
		MySimpleLinkedList<Integer> result = lista.commonElementsList(lista, lista2);
		System.out.println("Lista elementos comunes");
		System.out.println(result.toString());
		
		// Ejercicio 7.
		//  Escriba una función que dadas dos listas construya otra con los elementos que están en la
		//  primera pero no en la segunda.
		
		
	}

}
