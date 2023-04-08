package TrabajoPractico1;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {

	private Node<T> first;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info, null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public T extractFront(){
		Node<T> tmp = this.first;
		this.first = this.first.getNext();
		this.size--;
		return tmp.getInfo();
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public T getIndex(int index) {
		if((index>this.size-1)||(index<0)) {
			return null;
		}
		int pos=0;
		Node<T> tmp = this.first;
		while(pos<(index)) {
			tmp = tmp.getNext();
			pos++;
		}
		return tmp.getInfo();
	}
	
	public int indexOf(T info) {
		Node<T> tmp = this.first;
		int index = 0;
		while (tmp != null) {
			if(tmp.getInfo()==info) {
				return index;
			}
			index++;
			tmp = tmp.getNext();
		}
		return -1;
	}
	
	
	
	@Override
	public String toString() {
		String cadena = "";
		Node<T> tmp = this.first;
		while(tmp !=null){
			cadena+= tmp.getInfo();
			if(tmp.getNext() !=null) {
				cadena+=", ";
			}
			tmp= tmp.getNext();

		}
		return cadena;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(this.first);
	}
}
