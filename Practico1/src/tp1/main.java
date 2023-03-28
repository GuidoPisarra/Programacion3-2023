package tp1;

public class main {

	public static void main(String[] args) {
		// Ejercicio 1
		MySimpleLinkedList<Integer> Lista = new MySimpleLinkedList<Integer>();
		//Insertar		
		Lista.insertFront(1);
		Lista.insertFront(8);
		//toString()
		System.out.println("Listar");
		Lista.toString();
		System.out.println(" ");
		//Extraer
		System.out.println("Primer valor, luego se extrae");
		System.out.println(Lista.extractFront());

		//Size
		System.out.println("Size");
		System.out.println(Lista.size());
		//IsEmpty
		System.out.println("isEmpty");
		System.out.println(Lista.isEmpty());
		
		
		// Ejercicio 2
		// 1. O(1);
		// 2. O(n)
		// 3. O(1) si utilizo la variable size sino es O(n)
		
		// Ejercicio 3
		System.out.println("push");
		Lista.push(88);
		Lista.toString();
		System.out.println("pop");
		System.out.println(Lista.pop());
		System.out.println("Lista despues de pop");
		Lista.toString();
		System.out.println("Top");
		System.out.println(Lista.top());
		System.out.println("Lista despues de top");
		Lista.toString();
		
		//Reverse
		Lista.insertFront(10);
		Lista.insertFront(7);
		Lista.insertFront(22);
		System.out.println("Lista original");
		Lista.toString();
		System.out.println("Lista despues de reverse");
		Lista.reverse();
		Lista.toString();		
		
		
		//Ejercicio 4
		System.out.println("Indice de elemento");
		System.out.println(Lista.indexOf(22));
		
		//Ejercicio 5 PREGUNTAR , no creo que exista ventaja computacional
		Lista.iterator().toString();
		
		
	}

}
