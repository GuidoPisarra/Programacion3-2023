package Practico2;

public class OrderAlgoritms {
	
	
	
	public void selectionSort(int[] array) {		
		for(int i = 0; i < array.length-1; i++) {
			int min = i;
			for(int j = i; j < array.length; j++) {
				if(array[j]<array[min]) {
					min = j;
				}
			}
			int tmp = array[min];
			array[min] = array[i];
			array[i] = tmp;			
		}		
	}
	
	public void bubbleSort(int[] array) {
		for (int i=0; i<array.length-1;i++) {
			for(int j=0; j<array.length-i-1; j++) {
				if(array[j]>array[j+1]) {
					int aux = array[j];
					array[j]=array[j+1];
					array[j+1]= aux;
				}
			}
		}
	}
	

}
