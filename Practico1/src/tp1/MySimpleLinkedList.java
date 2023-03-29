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
		return this.size == 0;
	}
	
	public T get(int index) {
		Integer indexAux = -1;
		Node<T> tmp = this.first;
		while((tmp.getNext() != null) && (indexAux >= index)) {
			tmp=tmp.getNext();
			indexAux++;
			if(indexAux == index) {
				return tmp.getInfo();
			}
		}
		
		return tmp.getInfo();
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
	
	public MySimpleLinkedList<T> commonElementsList(MySimpleLinkedList<T> list1,MySimpleLinkedList<T> list2 ){
		MySimpleLinkedList<T> resultList = new MySimpleLinkedList<T>();
		Node<T> tmpLista1 = list1.first;		
		
		while(tmpLista1 != null) {
			Node<T> tmpLista2 = list2.first;
			while(tmpLista2 != null) {
				if(tmpLista1.getInfo()==tmpLista2.getInfo()) {
					resultList.push(tmpLista1.getInfo());
				}
				tmpLista2 = tmpLista2.getNext();
			}
			tmpLista1 = tmpLista1.getNext();				
		}	
		return resultList;
	}
	
	public MySimpleLinkedList<T> listElementsDiff(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2){
		MySimpleLinkedList<T> resultList = new MySimpleLinkedList();
		
		return resultList;
	}
	
	
	@Override
	public String toString() { // ver como sacar la ultima ","
		Node<T> tmp = this.first;	
		String cadena = "";
		while(tmp != null) {
			cadena = cadena + tmp.getInfo() + ", ";
			tmp = tmp.getNext();
		}
		return cadena;
	}
	
}
