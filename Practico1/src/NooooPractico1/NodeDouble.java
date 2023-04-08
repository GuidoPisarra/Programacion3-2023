package NooooPractico1;

public class NodeDouble<T> {
	private T info;
	private NodeDouble<T> next;
	private NodeDouble<T> previous;
	
	public NodeDouble () {
		this.info = null;
		this.next = null;
		this.previous = null;
	}
	
	public NodeDouble(T info, NodeDouble<T> next, NodeDouble<T> previous) {
		this.info = info;
		this.next = next;
		this.previous = previous;		
	}
	
	public NodeDouble<T> getNext() {
		return this.next;
	}
	
	public void setNext(NodeDouble<T> next){
		this.next = next;
	}
	
	public NodeDouble<T> getPrevious(){
		return this.previous;
	}
	
	public void setPrevious(NodeDouble<T> previous) {
		this.previous = previous;
	}
	
	public T getInfo() {
		return this.info;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
}
