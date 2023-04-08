package NooooPractico1;

public class MyDoubleLinkedListOLD<T> {
	NodeDouble<T> first = new NodeDouble<T>();
	NodeDouble<T> last = new NodeDouble<T>();
	int size;
	
	public MyDoubleLinkedListOLD(){
		this.first =null;
		this.last = null;
		this.size =0;
	}
	
	public void insertFront(T info) {
		NodeDouble<T> tmp = new NodeDouble<T>(info, null, null);
		if(first == null) {
			tmp.setNext(this.last);
			tmp.setPrevious(this.first);
			first = tmp;
			last = tmp;
		}else {
			tmp.setNext(this.first);
			this.first.setPrevious(tmp);
			this.first = tmp;
		}
		this.size++;
	}
	
	public void insertLast(T info) {
		if(this.last == null) {
			this.insertFront(info);
		}else {
			NodeDouble<T> tmp = new NodeDouble<T>(info,null,null);
			this.last.setNext(tmp);
			tmp.setPrevious(this.last);
			this.last = tmp;
		}		
	}
	
	public T extractFront() {
		if(this.first != null) {
			T value;
			value = this.first.getInfo();
			this.first = this.first.getNext();
			this.size--;
			return value;
		}
		return null;
	}
	
	public T extractLast() {
		if(this.last != null) {
			T value;
			value = this.last.getInfo();
			this.last = this.last.getPrevious();
			this.last.setNext(null);
			this.size--;
			return value;
		}
		return null;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public T getIndex(int index) {
		if(index<=size && index>0) {
			NodeDouble<T> tmp = this.first;
			for(int i =0; i<index-1; i++) {
				tmp = tmp.getNext();
			}
			return tmp.getInfo();
		}
		return null;
	}
	
	
	
	@Override
	public String toString() {
		String cadena = "";
		NodeDouble<T> tmp = this.first;
		while (tmp != null) {
			cadena = cadena + tmp.getInfo() + " ";
			tmp = tmp.getNext();
		}
		return cadena;
	}
}
