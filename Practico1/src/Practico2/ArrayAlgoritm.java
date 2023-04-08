package Practico2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ArrayAlgoritm {

	public int[] createArrayNumRandom() {
		System.out.println("Ingrese el tamaño del array: ");
	       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	       int longitud = -1;
	       try {
			longitud = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	       return this.createArray(longitud);
	}
	
	public int[] createArray(int num) {
		int[] array = new int[num];
		for(int i = 0; i<num;i++) {
			int rdmNum = (int) Math.floor(Math.random()*1000+1);
			array[i] = rdmNum;
		}
		
		return array;
		
	}
	
}
