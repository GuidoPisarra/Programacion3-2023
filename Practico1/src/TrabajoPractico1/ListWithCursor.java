package TrabajoPractico1;

import java.util.Iterator;



public class ListWithCursor<T> implements Iterable<T> {
	
	private Node<T> first;
	private Node<T> last;
	private Node<T> cursor;
	private int size;

	public ListWithCursor() {
		this.first = null;
		this.last = null;
		this.cursor = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info, null);
		if(this.first == null) {
			this.cursor = tmp;
			this.last = tmp;
		}else {
			tmp.setNext(this.first);			
		}
		this.first = tmp;
		this.size++;
	}
	
	public T extractFront() {
		if (this.first != null) {
			T info = this.first.getInfo();
			Node<T> tmp = this.first;
			tmp = tmp.getNext();
			this.first= tmp;
			this.size--;
			return info;
		}
		return null;
	}

	
	public void insertLast(T info) {
		Node<T> tmp = new Node<T> (info, null);
		if(this.last == null) {
			this.first = tmp;
			this.cursor = tmp;
		}else {
			this.last.setNext(tmp);
		}
		this.last = tmp;
		this.size++;
	}
	
	public T extractLast() {
		if(this.last != null) {
			int pos = 0;
			Node<T> tmp = this.first; 
			while(pos < this.size-2) {
				tmp = tmp.getNext();
				pos++;
			}
			tmp.setNext(null);
			this.last= tmp;
			this.size--;

		}
		return null;
	}
	
	
	
	public T getLast() {
		if(this.last != null) {
			return this.last.getInfo();
		}
		return null;
	}
	
	public T getCursorInfo(){
		if (this.cursor != null) {
			return this.cursor.getInfo();
		}
		return null;
	}
	
	public Node<T> getCursor(){
		if(this.cursor!=null) {
			Node<T> tmp = new Node<T>(this.cursor.getInfo(), this.cursor.getNext());
			return tmp;
		}
		return null;
	}
	
	public void moveCursor() {
		if(this.cursor.getNext() != null) {
			this.cursor = this.cursor.getNext();			
		}else {
			this.cursor = null;
		}
	}
	
	public void resetCursor() {
		this.cursor = this.first;
	}
	
	public int getIndex(T info) {
		Node<T> tmp = this.first;
		int index = 0;
		while(tmp != null) {
			if((((Comparable<Integer>)tmp.getInfo()).compareTo((Integer)info)==0)) {
				return index;
			}
			tmp = tmp.getNext();
			index++;
		}
		return -1;
	}
	
	public void insertInOrder(T info) {
		Node<T> tmp = this.first;
		
		if(tmp != null) {
			if(((Comparable<Integer>)info).compareTo((Integer)tmp.getInfo())<0) {//info es menor
				this.insertFront(info);
			}else {
				Node<T> aux = tmp;
				while((tmp !=null) && (((Comparable<Integer>)info).compareTo((Integer)tmp.getInfo())>0)) {//info es mayor
				        if(tmp.getNext()!=null) {
				        	aux =tmp;
					        tmp = tmp.getNext();
				        }else {
				        	tmp=null;
				        }				    
				}

				if(tmp == null) {
					this.insertLast(info);
				}else {
					Node<T> nuevo = new Node<T>(info, null);
					nuevo.setNext(aux.getNext());
					aux.setNext(nuevo);
				}				
			}
			
		}else {
			this.insertFront(info);
		}
		this.size++;

	}
	
	
	public ListWithCursor<T> commonElementsInOrder(ListWithCursor<T> list1, ListWithCursor<T> list2){
		ListWithCursor<T> listAux = new ListWithCursor<T>();
		list1.resetCursor();
		list2.resetCursor();
		while((list1.getCursor() != null)&&(list2.getCursor() != null) ) {
			while((list2.getCursor() != null)&& ((((Comparable<Integer>)list1.getCursorInfo()).compareTo((Integer)list2.getCursorInfo())>0)) ){
						
				list2.moveCursor();
			}
			if(((Comparable<Integer>)list1.getCursorInfo()).compareTo((Integer)list2.getCursorInfo())==0) {
				if(listAux.getIndex(list1.getCursorInfo())<0) {
					listAux.insertInOrder(list1.getCursorInfo());					
				}					
			}
			list1.moveCursor();
		}
		list1.resetCursor();
		list2.resetCursor();
		return listAux;		
	}
	

	public ListWithCursor<T> diffElements(ListWithCursor<T> list1, ListWithCursor<T> list2){
		ListWithCursor<T> listAux = new ListWithCursor<T>();
		
		while(list1.getCursor()!= null) {
			if(list2.getIndex(list1.getCursorInfo())==-1) {
				listAux.insertInOrder(list1.getCursorInfo());
			}
			list1.moveCursor();
		}
		
		return listAux;
	}

	public boolean isPalindroma() {
		if(this.first != null) {
			Node<T> firstCopy = this.first;
			Node<T> lastCopy = this.last;
			int mitad = this.size/2;
			while((mitad >0)&&(firstCopy.getInfo()==lastCopy.getInfo())) {
				mitad--;
				this.extractFront();
				firstCopy = this.first;
				this.extractLast();
				lastCopy = this.last;

			}
			return mitad <=1;
			
		}
		return true;
	}
	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(this.first);
	}
	
	@Override
	public String toString() {
		String cadena = "";
		Node<T> tmp = this.first;
		while (tmp != null) {
			cadena += tmp.getInfo();
			if(tmp.getNext()!= null) {
				cadena += ", ";
			}
			tmp = tmp.getNext();
		}
		return cadena;
	}
}
