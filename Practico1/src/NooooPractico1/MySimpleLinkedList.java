package NooooPractico1;

import java.util.Iterator;


public class MySimpleLinkedList<T> implements Iterable<T> {
	
	private Node<T> first;
	private int size; 

	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public Node<T> getFirst(){
		Node<T> firstCopy = this.first;
		return firstCopy;
	}
	
	public void setFirst(Node<T> node){
		this.first = node;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setSize(int num) {
		this.size = num;
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
		
	public int indexOf(T element) {
		Node<T> tmp =  this.first;
		int posicion = 0;
		while(tmp != null){
			if(tmp.getInfo()== element) {
				return posicion;
			}
			tmp = tmp.getNext();
			posicion++;
		}
		return -1;
	}
	
	public T top() {
		if(first!=null) {
			return first.getInfo();
		}
		return null;
	}
	
	public void recorer() {
		
	}
	
	@Override
	public Iterator<T> iterator() {
		return new MyIterador<T>(this.first);
	}
	
	
	
	/*public Iterator<Integer> recorrer() {
	Iterator<Integer> it = MySimpleLinkedList.recorrer();
	while(it.hasNext()){
		System.out.println(it.next());
	}
}*/
	
	public MySimpleLinkedList<T> commonElementsList(MySimpleLinkedList<T> list1,MySimpleLinkedList<T> list2 ){
		MySimpleLinkedList<T> resultList = new MySimpleLinkedList<T>();
		Node<T> tmpLista1 = list1.getFirst();		
		
		while(tmpLista1 != null) {
			Node<T> tmpLista2 = list2.getFirst();
			while(tmpLista2 != null) {
				if(tmpLista1.getInfo()==tmpLista2.getInfo()) {
					resultList.insertFront(tmpLista1.getInfo());
				}
				tmpLista2 = tmpLista2.getNext();
			}
			tmpLista1 = tmpLista1.getNext();				
		}	
		return resultList;
	}
	
	public MySimpleLinkedList<T> listElementsDiff(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2){
		MySimpleLinkedList<T> resultList = new MySimpleLinkedList<T>();
		Node<T> tmpList1 = list1.getFirst(); 
		while(tmpList1!=null){
			Node<T> tmpList2 = list2.getFirst();
			boolean inList = false;
			while(tmpList2 != null) {
				if(tmpList1.getInfo() == tmpList2.getInfo()) {
					inList =true;
				}
				tmpList2=tmpList2.getNext();
			}
			if(!inList) {
				resultList.insertFront(tmpList1.getInfo());
			}
			tmpList1 =tmpList1.getNext();
			
		}
		return resultList;
	}
	
	public boolean isPalindroma(String word) {
		boolean isPalindroma = true;
		int longitud = word.length()-1;
		int indice = 0;
		while((longitud/2) >indice) {
			if(word.charAt(longitud)!=word.charAt(indice)) {
				isPalindroma=false;
			}
			indice++;			
			longitud=longitud-indice;
		}
		
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
