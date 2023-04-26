package Practico2Punto1;


import java.util.ArrayList;
import java.util.List;

import TrabajoPractico1.ListWithCursor;

public class Tree<T> {
	private TreeNode<T> root = null;
	
	public Tree () {
		this.root = null;
	}
	
	public Tree (T info) {
		this.root = new TreeNode<T>(info);
	}
	
	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}
	
	private void add(TreeNode actual, Integer value) {
		if ((int)actual.getInfo() > (int)value) {
			if (actual.getIzq() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setIzq(temp);
			} else {
				add(actual.getIzq(),value);
			}
		} else {
			if ((int)actual.getInfo() < (int)value) {
				if (actual.getDer() == null) { 
					TreeNode temp = new TreeNode(value);
					actual.setDer(temp);
				} else {
					add(actual.getDer(),value);
				}
			}
		}
	}
	public T getRoot(){
		TreeNode<T> tmp = this.root;
		if(tmp == null) {
			return null;
		}
		return tmp.getInfo();
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public boolean hasElement(T info) {
		TreeNode<T> tmp = this.root;
		return this.findElement(info, tmp);
	}
	
	private boolean findElement(T info, TreeNode<T> node) {
		if((node!=null)&&(node.getInfo()!=info)) {
			if (((int)node.getInfo()>(int)info)&&(node.getIzq()!=null)) {
				this.findElement(info, node.getIzq());
			}
		
			if(((int)node.getInfo()<(int)info)&&(node.getDer()!=null)) {
				this.findElement(info, node.getDer());
			}
		}
		
		return !(node==null);
	}
	
	public void delete(int valor) {
		TreeNode<Integer> tmp = (TreeNode<Integer>) this.root;
		TreeNode<Integer> aux = (TreeNode<Integer>) this.root;

		if(tmp!=null) {
			this.delete(tmp, valor , aux);			
		}
	}
	
	private void delete(TreeNode<Integer> node, int valor, TreeNode<Integer> padre) {
		if(node!=null) {			
			if(node.getInfo() == valor) {				
				this.eliminar(node, padre);
			}else {
				if(node.getInfo()>valor) {
					delete(node.getIzq(), valor, node);
				}else {
					delete(node.getDer(), valor, node);
				}				
			}	
		}		
	}
	
	private void eliminar(TreeNode<Integer> node, TreeNode<Integer> padre ) {
		
		TreeNode<Integer> tmp = new TreeNode<Integer>();
		if(node.getDer()==null && node.getIzq()==null) {
			if(padre.getInfo()>node.getInfo()) {
				padre.setIzq(null);
			}else {
				padre.setDer(null);
			}
		}else {
			if(node.getDer()!=null) {
				tmp = buscarMasIzqDeMisDerechos(node.getDer());
			}else {
				if(node.getIzq()!=null) {
					tmp = buscarMasDerDeMisIzquierdos(node.getIzq());
				}
			}			
			System.out.println("tmp "+ tmp.getInfo());
			System.out.println("padre "+ padre.getInfo());
			System.out.println("nodo "+ node.getInfo());
			System.out.println("nodo izq"+ node.getIzq().getInfo());
			System.out.println("nodo "+ node.getDer().getInfo());

			if(padre.getInfo()>tmp.getInfo()) {
				padre.setIzq(tmp);
			}else {
				padre.setDer(tmp);
			}
			if(node.getIzq()!=null) {
				tmp.setIzq(node.getIzq());
			}
			if(node.getDer()!=null) {
				tmp.setDer(node.getDer());
			
			}
						
			this.delete(tmp.getInfo());
		}
	}
	
	
	private TreeNode<Integer> buscarMasDerDeMisIzquierdos(TreeNode<Integer> node) {
	    if (node.getDer() != null) {
	        return buscarMasDerDeMisIzquierdos(node.getDer());
	    }
	    return node;
	}
	
	private TreeNode<Integer> buscarMasIzqDeMisDerechos(TreeNode<Integer> node){
		if(node.getIzq()!=null) {
			return buscarMasIzqDeMisDerechos(node.getIzq());
		}
		return node;
	}
	
	
	
	public void printPreOrder() {
	  TreeNode<T> tmp = this.root;
	  this.imprimirPreOrder(tmp);
	} 
	
	
	
	private void imprimirPreOrder(TreeNode<T> node) {		
		if(node!=null) {	
			System.out.print(node.getInfo()+ " ");
			imprimirPreOrder(node.getIzq());
			imprimirPreOrder(node.getDer());
		}	
	}
	
	public void printPostOrder() {
		TreeNode<T> tmp = this.root;
		this.imprimirPostOrder(tmp);
	}
	
	private void imprimirPostOrder(TreeNode<T> node) {
		if(node!=null) {
			imprimirPostOrder(node.getIzq());
			imprimirPostOrder(node.getDer());
			System.out.print(node.getInfo() + " ");

		}
	}
	
	public void printInOrder() {
		TreeNode<T> tmp = this.root;
		this.imprimirInOrder(tmp);
	}
	
	private void imprimirInOrder(TreeNode<T> node) {
		if(node !=null) {
			imprimirInOrder(node.getIzq());
			System.out.print(node.getInfo() + " ");
			imprimirInOrder(node.getDer());
		}
	}
	
	public int getHeigth() {
		TreeNode<T> tmp = this.root;
		return this.getAltura(tmp);
	}
	
	private int getAltura(TreeNode<T> node) {
		if(node.getIzq()==null && node.getDer()==null) {
			return 0;
		}
		int der = 0;
		int izq = 0;
		if(node.getIzq()!=null) {
			izq = getAltura(node.getIzq())+1;
		}
		if (node.getDer()!=null) {
			der = getAltura(node.getDer())+1;
		}
		return Math.max(izq,der);
	}
	
	public void getLongestBranch() {
		TreeNode<Integer> tmp = (TreeNode<Integer>) this.root;
		List<Integer> longestBranch = this.getLongestBranch(tmp);		
		System.out.print(longestBranch.toString());		
	}

	public List<Integer> getLongestBranch(TreeNode<Integer> node) {
	    if (node == null) {
	        return new ArrayList<Integer>();
	    }
	    
	    List<Integer> izq = getLongestBranch(node.getIzq());
	    List<Integer> der = getLongestBranch(node.getDer());
	    
	    if (izq.size() > der.size()) {
	        izq.add(node.getInfo());
	        return izq;
	    } else {
	        der.add(node.getInfo());
	        return der;
	    }
	}
	
	public void getFrontera() {
		TreeNode<Integer> tmp = (TreeNode<Integer>)this.root;
		List<Integer>lista=this.getFrontera(tmp);
		System.out.println(lista.toString());
	}
	
	private List<Integer> getFrontera(TreeNode<Integer> node){
		ArrayList<Integer> frontera = new ArrayList<Integer>();

	     if(node.getDer()==null && node.getIzq()==null) {
	    	frontera.add(node.getInfo());    	
	    }	    		
		if(node.getIzq()!=null) {
			frontera.addAll(getFrontera(node.getIzq()));
		}
		if(node.getDer()!=null) {
			frontera.addAll(getFrontera(node.getDer()));
		}
  	
		return frontera;
	}
	
	public int getMaxElement() {
		TreeNode<Integer> tmp =(TreeNode<Integer>) this.root;
		return getMaxElement(tmp);
	}
	
	private int getMaxElement(TreeNode<Integer> node) {
		if(node == null) {
			return 0;
		}
		
		if(node.getDer()!=null) {
			return getMaxElement(node.getDer());
		}
		
		return node.getInfo();		
	}
	
	public List<Integer> getElemAtLevel(int level){
		TreeNode<Integer> tmp = (TreeNode<Integer>)this.root;
		int lvlActual = -1;
		List<Integer> lista = getElemAtLevel(tmp, level, lvlActual);


		return lista;
	}
	
	private List<Integer> getElemAtLevel(TreeNode<Integer> node , int level, int lvlActual){

		if(node == null) {
			return  null;
		}
		ArrayList<Integer> listado = new ArrayList<Integer>();
		
		lvlActual++;
		if(node.getIzq()!=null && lvlActual<level) {			
			listado.addAll(getElemAtLevel(node.getIzq(),level,lvlActual));
		}
		if(node.getDer()!=null && lvlActual<level) {			
			listado.addAll(getElemAtLevel(node.getDer(),level,lvlActual));		
		}
		
		if(level == lvlActual) {
			listado.add(node.getInfo());
			lvlActual=0;
		}
		return listado;
	}
	
	
	public int getSumaNodosInternos() {
		TreeNode<Integer> tmp =(TreeNode<Integer>) this.root;
		int total =0;
		total = getSumaNodosInternos(tmp);
		return total;
	}
	
	private int getSumaNodosInternos(TreeNode<Integer> node) {
		int total= 0;
		if(node!=null) {
			if(node.getIzq()!=null || node.getDer()!=null) {
				total= total + node.getInfo();
			}
			total+=getSumaNodosInternos(node.getIzq());
			total+=getSumaNodosInternos(node.getDer());
			
		}
		return total;
	}
	
	
	public List<Integer> getValoresMayores(int valor){
		TreeNode<Integer> tmp = (TreeNode) this.root;
		return getValoresMayores(tmp, valor);
		
	}
	
	private List<Integer> getValoresMayores(TreeNode<Integer> node, int valor){
		if(node == null) {
			return null;
		}
		
		ArrayList<Integer> listado = new ArrayList<Integer>();
		if(node!=null) {
			if(node.getInfo()>valor) {
				listado.add(node.getInfo());
				if(node.getDer()!=null) {
					listado.addAll(getValoresMayores(node.getDer(),valor));
				}
				if(node.getIzq()!=null) {
					listado.addAll(getValoresMayores(node.getIzq(),valor));
				}
			}
			if(node.getInfo()<=valor && node.getDer()!=null) {
				listado.addAll(getValoresMayores(node.getDer(),valor));
			}			
		}	
		return listado;
	}
	
	public void completarArbol() {
		TreeNode<Integer> tmp = (TreeNode<Integer>) this.root;
		completarArbol(tmp);
	}
	
	private void completarArbol(TreeNode<Integer> node) { 
		if (node !=null) { 
			if(node.getInfo()==null) {
				completarArbol(node.getIzq());
				completarArbol(node.getDer());
				if(node.getDer().getInfo()!=null || node.getIzq().getInfo()!=null) {
					int valorIzq=0;
					int valorDer =0;
					if(node.getDer().getInfo()!=null) {
						valorDer = node.getDer().getInfo();
					}
					if(node.getIzq().getInfo()!=null) {
						valorIzq = node.getIzq().getInfo();
					}
					node.setInfo(valorDer-valorIzq);
				}
			}			
		}
	}

	public List<String> getPalabrasPorCantVocales(int cantVocales) {
		TreeNode<Character> tmp = (TreeNode<Character>) this.root;
		String pal = "";
		return getPalabrasPorCantVocales(tmp, cantVocales, pal);
	}
	
	private List<String> getPalabrasPorCantVocales(TreeNode<Character> node ,  int cantVocales, String palabra) {
		ArrayList<String> listadoPalabras = new ArrayList<String>();
		if(node !=null) {
			int cantVocalesAux = cantVocales;
			palabra += node.getInfo();
			if(this.isVocal(node.getInfo())) {
				cantVocalesAux--;
			}
			if(cantVocalesAux==0 && node.getDer()==null && node.getIzq()==null) {
				listadoPalabras.add(palabra);
			}
			if(node.getIzq()!=null) {
				listadoPalabras.addAll(getPalabrasPorCantVocales(node.getIzq(), cantVocales, palabra));
			}
			if(node.getDer()!=null) {
				listadoPalabras.addAll(getPalabrasPorCantVocales(node.getDer(), cantVocales, palabra));
			}
			
		}	
		return listadoPalabras;
	}
	
	private boolean isVocal(Character letra) {
		char[] vocales = {'a','e','i','o','u'};
		for(int i = 0; i<vocales.length; i++) {
			if(vocales[i]==letra) {
				return true;
			}
		}
		return false;
	} 
}
