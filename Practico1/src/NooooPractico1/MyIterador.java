package NooooPractico1;

import java.util.Iterator;

public class MyIterador <T> implements Iterator<T>{

	private Node<T> cursor;
	
	public MyIterador(Node<T> first) {
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

	
	
	
	

}
