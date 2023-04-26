package Practico2Punto1;

public class TreeNode<T> {
  private TreeNode izq;
  private TreeNode der;
  private T info;
  
  public TreeNode (T info) {
	  this.info = info;
	  this.der = null;
	  this.izq = null;
  }
  
  public TreeNode(){
	  this.info = null;
	  this.der = null;
	  this.izq = null;
  }
  
  public T getInfo() {
	  return this.info; 
  }
  
  public void setInfo(T info) {
	  this.info = info;
  }
  
  public TreeNode<T> getIzq(){
	  return this.izq;
  }
  
  public void setIzq(TreeNode<T> izq) {
	  this.izq = izq;
  }
  
  public TreeNode<T> getDer(){
	  return this.der;
  }
  
  public void setDer(TreeNode<T> der) {
	  this.der = der;
  }
  
 
  
  
}
