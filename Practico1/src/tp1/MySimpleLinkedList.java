package tp1;

import java.util.Iterator;


public class MySimpleLinkedList<T> {
	
	private Node<T> first;
	private int size; 
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.size++ ;
		this.first = tmp;
	}
	
	public T extractFront() {			
		if(this.first != null) {
			T valor;
			valor=this.first.getInfo();
			this.first = this.first.getNext();
			this.size--;
			return valor;
		}		
		return null;
	}

	public boolean isEmpty() {
		if(this.size>0) {
			return false;
		}
		return true;
	}
	
	public T get(int index) {
		int indexAux = 0;
		Node<T> tmp = this.first;
		while((tmp.getNext() != null) && (indexAux <= index)) {
			tmp=tmp.getNext();
			indexAux++;
		}
		if(indexAux == index) {
			return tmp.getInfo();
		}
		return null;
	}
	
	public int size() {
		return this.size;
	}
	
	public void push(T element) {
		Node<T> tmp = new Node<T>(element, null);
		tmp.setNext(this.first);
		this.size++;
		this.first=tmp;
	}
	
	public T pop(){
		Node<T> tmp =first;
		T aux;
		if(first!=null) {
			aux = first.getInfo();
			first = tmp.getNext();
			return aux;
		}
		return null;
	}
	
	public T top() {
		if(first!=null) {
			return first.getInfo();
		}
		return null;
	}
	// TODO Preguntar!!!! 
	
	public void reverse() {
		MySimpleLinkedList<T> ListaAuxiliar = new MySimpleLinkedList();
		Node<T> tmp = this.first;
		while(tmp!=null) {
			ListaAuxiliar.push(tmp.getInfo());	//Podria utilizar también insertFront()
			tmp=tmp.getNext();
		}
		this.first = ListaAuxiliar.first;
	}
	
	
	
	public int indexOf(T element) {
		Node<T> tmp =  this.first;
		int posicion = 0;
		while(tmp != null){
			if(tmp.getInfo()==element) {
				return posicion;
			}
			tmp = tmp.getNext();
			posicion++;
		}
		return -1;
	}
	
	public Iterator<T> iterator() {
		return new MyIterator<T>(this.first);
	}
	
	
	@Override
	public String toString() { // no me convence que sea asi
		Node<T> tmp = this.first;		
		while(tmp != null) {
			System.out.print(tmp.getInfo() + " ");
			tmp = tmp.getNext();
		}
		System.out.println();
		return null;
	}
	
}
