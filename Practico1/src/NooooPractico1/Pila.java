package NooooPractico1;

public class Pila<T> extends MySimpleLinkedList<T>{

	private MySimpleLinkedList<T> pila = new MySimpleLinkedList<T>();
	
	public void push(T element) {
		Node<T> tmp = new Node<T>(element, null);
		tmp.setNext(pila.getFirst());
		pila.setSize(pila.getSize()+1);
		pila.setFirst(tmp);
	}
	
	public T pop(){
		Node<T> tmp =pila.getFirst();
		T aux;
		if(pila.getFirst()!=null) {
			aux = pila.getFirst().getInfo();
			pila.setFirst(tmp.getNext());
			return aux;
		}
		return null;
	}
	
	@Override
	public T top() {
		if(pila.getFirst() != null) {
			T aux = pila.getFirst().getInfo();
			return aux;
		}
		return null;
	}
	
	
	
	public void reverse() {
		Pila<T> pilaAuxiliar = new Pila<T>();
		Node<T> tmp = pila.getFirst();
		while(tmp!=null) {
			pilaAuxiliar.insertFront(tmp.getInfo());	//Podria utilizar también insertFront()
			tmp=tmp.getNext();
		}
		pila.setFirst(pilaAuxiliar.getFirst());
	}
	
	@Override
	public String toString() {
		String cadena = "";
		Node<T> tmp = pila.getFirst();
		while(tmp !=null) {
			cadena = cadena + tmp.getInfo() + ", ";
			tmp = tmp.getNext();
		}
		return cadena;
	}
	
}
