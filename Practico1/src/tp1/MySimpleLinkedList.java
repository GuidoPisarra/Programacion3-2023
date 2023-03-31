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
	
	public Node<T> top() {
		if(first!=null) {
			return first;
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
		this.first = (Node<T>) ListaAuxiliar.top();
	}
	
	// TODO cursor,last, insertlast, getlast resetcursor, movecursosr, get cursor 
	
	
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
		Node<T> tmpLista1 = list1.top();		
		
		while(tmpLista1 != null) {
			Node<T> tmpLista2 = list2.top();
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
		MySimpleLinkedList<T> resultList = new MySimpleLinkedList<T>();
		Node<T> tmpList1 = list1.top(); 
		while(tmpList1!=null){
			Node<T> tmpList2 = list2.top();
			boolean inList = false;
			while(tmpList2 != null) {
				if(tmpList1.getInfo() == tmpList2.getInfo()) {
					inList =true;
				}
				tmpList2=tmpList2.getNext();
			}
			if(!inList) {
				resultList.push(tmpList1.getInfo());
			}
			tmpList1 =tmpList1.getNext();
			
		}
		return resultList;
	}
	
	public boolean palindroma(String word) {
		boolean isPalindroma = false;
		
		
		return isPalindroma; 
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
