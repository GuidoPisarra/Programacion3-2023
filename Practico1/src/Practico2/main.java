package Practico2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) {
		 
//		  Ejercicio 1.
//			Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
//				1. ¿Qué complejidad O tiene? (La complejidad en el peor caso) --> O(2n) 
//				2. ¿Trae algún problema hacerlo recursivo? ¿Cuál? 
//				3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?
		 
		
//	       int[] array = {1,2,3,4,5,6,7};
	       RecursiveAlgoritms algoritmo = new RecursiveAlgoritms();
//	       System.out.println(algoritmo.arrayInOrder(array, 0));
	       
//	       Ejercicio 2.
//	       Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado
//	       ascendentemente
	       
//		   int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,20,30,40,50};
//		   RecursiveAlgoritms algoritmo = new RecursiveAlgoritms();
//		   System.out.println(algoritmo.binarySearch(array, 50, 0, array.length-1));//Preguntar
		   
//			Ejercicio 3.
//			Implemente un algoritmo recursivo que convierta un número en notación decimal a su
//			equivalente en notación binaria.
//			int num = 25;
//	        algoritmo.toBinary(num);
	       
//	       Ejercicio 4.
//	       Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de
//	       Fibonacci.
//	       Por ej. los 6 primeros términos son: 0 1 1 2 3 5
	       
//	       for (int i = 0; i < 6; i++) {
//	    	    System.out.print(algoritmo.fibonacci(i) + " ");
//	    	}
	       
//	       Ejercicio 5.
//	       Dado un arreglo ordenado de números distintos A se desea construir un algoritmo que
//	       determine si alguno de los elementos de dicho arreglo contiene un valor igual a la posición en la
//	       cuál se encuentra, es decir, A[i] = i.
//	       1) Construir un algoritmo recursivo que responda a dicha verificación.
//	       2) Mostrar la pila de ejecución para la invocación algoritmo([-3, -1, 0, 2, 4, 6, 10])
	       
//		   int[] array = {1,2,2,4,5,6,7,8,9,10,11,12,20,30,40,50};
//		   int[] array = {-3, -1, 0, 2, 4, 6, 10};
//	       System.out.println(algoritmo.valueEqualPosition(array,0));
	       
//	       Ejercicio 6.
//	       Implemente un algoritmo de ordenamiento por selección en un arreglo.
//	       Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.
//	       1. ¿Qué complejidad O tienen estos algoritmos?
	       
	       int[] array = {3, -1, 0, 2, 1, 7, 6};
	       OrderAlgoritms algoritmOrder = new OrderAlgoritms();
//	       algoritmOrder.selectionSort(array);//complejidad O(n*n)???????
//	       for(int i = 0; i < array.length; i++) {
//	    	   System.out.print(array[i] + " ");
//	       }
	       
//	       algoritmOrder.bubbleSort(array);//complejidad O(n*n) ????
//	       for(int i = 0; i < array.length; i++) {
//	    	   System.out.print(array[i] + " ");
//	       }
	       
	       
//	       Ejercicio 7.
//	       Implemente un algoritmo de ordenamiento mergesort para un arreglo de tamaño N.
//	       Implemente un algoritmo de ordenamiento quicksort para un arreglo de tamaño N.
//	       1. ¿Cuál es su complejidad en el peor caso?
//	       2. ¿Cuál es su complejidad promedio?
	       
	       MergeSort mergeSort = new MergeSort();
//	       mergeSort.sort(array);
//	       for(int i = 0; i < array.length; i++) {
//	    	   System.out.print(array[i] + " ");
//	       }
	       
	       QuickSort quickSort = new QuickSort();
//	       quickSort.sort(array);
//	       for(int i = 0; i < array.length; i++) {
//	    	   System.out.print(array[i] + " ");
//	       }
	       
//	       Ejercicio 8.
//	       Implemente una función que cree un arreglo de tamaño N con números aleatorios. Corra los
//	       algoritmos de los ejercicios 3 y 4, 10000 veces consecutivas cada uno, y compruebe el tiempo
//	       de ejecución. Haga lo mismo con el método Arrays.sort(...) de Java, y compare los tiempos
//	       obtenidos. Investigue cómo está implementado el Array.sort()
	       
	       ArrayAlgoritm arregloAlgoritmo = new ArrayAlgoritm();
	        int[] arreglo = arregloAlgoritmo.createArrayNumRandom();
	        for(int i = 0 ;i<arreglo.length; i++) {
	        	System.out.print(arreglo[i] + " ");
	        }
	        
	       
	}

}
