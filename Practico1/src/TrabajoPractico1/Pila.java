package TrabajoPractico1;

public class Pila<T> extends MySimpleLinkedList<T>{
	MySimpleLinkedList<T> pila;
	
	public Pila() {
		this.pila = new MySimpleLinkedList<T>();
	}
	
	public void push(T info) {
		pila.insertFront(info);
	}
	
	public T pop() {
		return pila.extractFront();
	}
	
	public T top() {
		return pila.getIndex(0);
	}
	
	public void reverse(){
		Pila<T> pilaAux = new Pila<T>();
		while(this.top()!= null) {
			pilaAux.push(this.pop());
		}
		this.pila = pilaAux;	
	}
	
	@Override
	public String toString() {
		return pila.toString();
	}
}
