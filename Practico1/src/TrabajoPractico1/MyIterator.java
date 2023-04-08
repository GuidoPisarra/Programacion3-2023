package TrabajoPractico1;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T>{

	private Node<T> cursor;
	
	
	public MyIterator(Node<T> first) {
		this.cursor = first;
	}
	@Override
	public boolean hasNext() {
		// Solo dice si el cursor es nulo o no
		return this.cursor != null;
	}

	@Override
	public T next() {
		// devuelve la info y lo extrae
		if(this.cursor!=null) {
			T info = this.cursor.getInfo();
			this.cursor = this.cursor.getNext();
			return info;
		}
		return null;
		
	}

}
