package TrabajoPractico1;

public class MyDoubleLinkedList<T> {

	private NodeDouble<T> first = new NodeDouble<T>();
	private NodeDouble<T> last =new NodeDouble<T>();
	private int size; 
	
	public MyDoubleLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		NodeDouble<T> tmp = new NodeDouble<T>(info, null, null);
		if(this.first == null) {
			tmp.setPrevious(this.first);
			tmp.setNext(this.last);
			this.first = tmp;
			this.last= tmp;
		}else {
			tmp.setNext(this.first);
			this.first.setPrevious(tmp);
			this.first = tmp;
		}	
		this.size++;
	}
	
	public void insertLast(T info) {
		NodeDouble<T> tmp =  new NodeDouble<T>(info, null, null); 
		if(this.last !=null) {
			this.last.setNext(tmp);
			tmp.setPrevious(this.last);
			this.last = tmp;
		}else {
			tmp.setPrevious(this.first);
			tmp.setNext(this.last);
			this.first = tmp;
			this.last = tmp;
		}
		this.size++;
	}
	
	public T extractFront() {
		if(this.first != null) {
			T info = this.first.getInfo();
			this.first.setNext(this.first.getNext());
			this.first.setPrevious(null);
			this.first = this.first.getNext();
			this.size--;
			return info;
		}
		return null; 
	}
	
	public T extractLast() {
		if(this.last!=null) {
			T info = this.last.getInfo();
			NodeDouble<T> tmp = this.last;
			tmp = tmp.getPrevious();
			tmp.setNext(null);
			this.last = tmp;
			return info;
		}
		return null;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public T get(int index) {
		if((index<=this.size-1)&&(index>=0)) {
			NodeDouble<T> tmp = this.first;
			int pos = 0;
			while(pos<index) {
				pos++;
				tmp = tmp.getNext();
			}
			return tmp.getInfo();
		}
		return null;
	}
	
	public int indexOf(T info) {
		NodeDouble<T> tmp = this.first;
		int index = 0;
		while(tmp != null) {
			if(tmp.getInfo() == info) {
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
		NodeDouble<T> tmp = this.first;
		while(tmp != null) {
			cadena += tmp.getInfo();
			if(tmp.getNext() != null) {
				cadena += ", ";
			}
			tmp = tmp.getNext();
		}
		return cadena;
	}
	
}
