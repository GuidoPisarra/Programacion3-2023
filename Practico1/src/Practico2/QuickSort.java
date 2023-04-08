package Practico2;

public class QuickSort {
	
	private int low;
	private int high;
	
	public void sort(int[] arr) {
		this.low=0;
		this.high=arr.length-1;
		this.sort(arr, low, high);
	}
	
	public void sort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

	// Este método toma el último elemento como pivote, lo coloca en su posición correcta
    // posición en la matriz ordenada y coloca todos los más pequeños (más pequeños que el pivote)
    // a la izquierda del pivote y todos los elementos mayores a la derecha del pivote
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
