package Practico2;

import java.lang.reflect.Array;

public class RecursiveAlgoritms {

	
	
	public boolean arrayInOrder(int[] array,int index) {
		if((index<array.length-1)&&(array[index]<=array[index+1])) {
			return arrayInOrder(array,index+1);			
		}
		if(index==(array.length-1)) {
			return true;
		}
		
		return false;
	}
	
	public int binarySearch(int[]array , int num, int init, int end) {
		int middle;		
		if(end<init) {
			return -1;
		}else {
			middle = (init+end)/2;
			if(array[middle] < num) {
				return binarySearch(array, num, middle+1, end);
			}else {
				if(array[middle] > num) {
					return binarySearch(array, num , init, middle-1);
				}else {
					return middle;
				}
			}
		}	
	}
	
	public void toBinary(int number) {
		if(number>0) {			
			toBinary(number/2);
			System.out.print(number%2);
		}
	}
	
	public int fibonacci(int num) {
		//n = n-1 + n-2.
		if(num == 0) {
			return 0;
		}else {
			if(num==1) {
				return 1;
			}else {
				return fibonacci(num-1) + fibonacci(num-2);
			}
		}

	}
	
	public int valueEqualPosition(int[] array, int index) {
		
		if((array[index]!=index)&&(index<array.length)) {
			System.out.println(index);// preguntar, asi muestro la pila de ejecucion?
			return valueEqualPosition(array, index+1);
		}else {
			if(array[index]==index) {
				return index;
			}else {
				return -1;
			}
		}
		
	}
	
}
