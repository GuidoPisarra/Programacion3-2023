package NooooPractico1;

import java.util.Iterator;

public class ListWithCursorOLD<T> implements Iterator<T>{
	private Node<T> first;
	private Node<T> cursor;
	private Node<T> last;
	private int size;

	
	public ListWithCursorOLD(){
		this.first = null;
		this.cursor = null;
		this.last = null;
		this.size = 0 ;
	}
	
	// TODO cursor,last, insertlast, getlast resetcursor, movecursosr, get cursor 

	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		if(this.first != null) {
			tmp.setNext(this.first);
			this.size++;
			this.first = tmp;
			return;
		}
		this.first = tmp;
		this.cursor= tmp;
		this.last = tmp;
		this.size++;		
	}
	
	public void insertLast(T info) {
		Node<T> tmp = new Node<T>(info,null);
		if(this.last!=null) {
			this.last.setNext(tmp);
			this.last = tmp;
			this.size++;
			return;
		}
		this.first = tmp;
		this.last = tmp;
		this.size++;
	}
	
	public T getLast() {
		if(this.last != null) {
			return this.last.getInfo();
		}
		return null;
	}
	
	public T getCursor() {
		if (this.cursor != null) {
			return this.cursor.getInfo();
		}
		return null;
	}
	
	public Node<T> getNodeCursor(){
		Node<T> tmp= new Node<T>(this.getCursor(),this.cursor.getNext());
		return tmp;
	}
	
	public void moveCursor() {
		Node<T> tmp = this.cursor;
		if(this.cursor !=null) {
			tmp = tmp.getNext();
			this.cursor = tmp;
			return;
		}
		this.cursor = this.first;
	}
	
	public void resetCursor() {
		this.cursor = this.first;
	}
	
	
	
	public ListWithCursorOLD<T> listCommonOrder(ListWithCursorOLD<T> listaCursor1, ListWithCursorOLD<T> listaCursor2){
		ListWithCursorOLD<T> listCommonOrderAux = new ListWithCursorOLD<T>();
		listaCursor1.resetCursor();
		listaCursor2.resetCursor();
		while(listaCursor1.hasNext()) {
			while(listaCursor2.hasNext()) {		

				if(((Comparable<Integer>) listaCursor1.getNodeCursor().getInfo()).compareTo((Integer) listaCursor2.getNodeCursor().getInfo())==0) {
					listCommonOrderAux.insertInOrder(listaCursor1.getNodeCursor().getInfo());
				}
				listaCursor2.moveCursor();
			}
			listaCursor2.resetCursor();
			listaCursor1.moveCursor();
		}
		System.out.println("lista antessssssssssssssssss");
		System.out.println(listCommonOrderAux.toString());
		return listCommonOrderAux;
	}
	
	public void insertInOrder(T info) {
		Node<T> cursorAux = this.first;
		Boolean fin = false;
		while((this.hasNext())&&(!fin)) {
			if(((Comparable<Integer>) cursorAux.getInfo()).compareTo((Integer)info)<0) {
				this.moveCursor();
			}else {
				fin=true;
			}
			
		}
		if(this.first==null) {
			Node<T> tmp = new Node<T> (info,null);
			this.first = tmp;

		}else {
			if(((Comparable<Integer>) cursorAux.getInfo()).compareTo((Integer)info)>0){
				Node<T> tmp = new Node<T> (info,null);
				tmp.setNext( cursorAux.getNext());
				cursorAux.setNext(tmp);
			}
		}
		
		
	}
	
	

	@Override
	public boolean hasNext() {
		return this.cursor != null;
	}

	@Override
	public T next() {
		T info = this.cursor.getInfo();
		this.cursor =  this.cursor.getNext();
		return info;
	}
	
	@Override
	public String toString() {
		String cadena = "";
		Node<T> tmp = this.first;
		while (tmp != null) {
			cadena = cadena + tmp.getInfo() + ", ";
			tmp= tmp.getNext();
		}
		return cadena;
	}


}
