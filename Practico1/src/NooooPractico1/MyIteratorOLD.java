package NooooPractico1;

import java.util.Iterator;


public class MyIteratorOLD<T> implements Iterator<T>{
	private Node<T> cursor;

	public MyIteratorOLD(Node<T> first) {
		this.cursor = first;
	}
	@Override
	public boolean hasNext() {
		return this.cursor != null;		
	}

	@Override
	public T next() {
		T info = this.cursor.getInfo();
		this.cursor = this.cursor.getNext();
		return info;
	}
	
	@Override
	public String toString() { //no me parece que sea asi
		Node<T> tmp = this.cursor;
		while(tmp != null) {
			System.out.print(tmp.getInfo()+" ");
			tmp = tmp.getNext();
		}
		return null;
	}
	
	

}
