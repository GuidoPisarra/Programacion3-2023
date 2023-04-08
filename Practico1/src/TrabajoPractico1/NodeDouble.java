package TrabajoPractico1;

public class NodeDouble<T> {

	private NodeDouble<T> previous;
	private NodeDouble<T> next;
	private T info;
	
	public NodeDouble() {
		this.previous = null;
		this.next =null;
		this.info = null;
	}
	
	public NodeDouble(T info, NodeDouble<T> prev, NodeDouble<T> next) {
		this.info = info;
		this.previous = prev;
		this.next = next;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	public T getInfo() {
		return this.info;
	}
	
	public void setNext(NodeDouble<T> next) {
		this.next = next;
	}
	
	public NodeDouble<T> getNext(){
		return this.next;
	}
	
	public void setPrevious(NodeDouble<T> prev) {
		this.previous = prev;
	}
	
	public NodeDouble<T> getPrevious(){
		return this.previous;
	}
	
}
