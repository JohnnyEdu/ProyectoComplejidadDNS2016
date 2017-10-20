package listas;
/**
 * @author Jonathan Baez
 * */
public class Nodo {
	private Object dato;
	private Nodo siguiente;
	
	public Nodo(Object dato) {
		this.dato = dato;
	}
	public Object getDato() {
		return dato;
	}
	public void setDato(Object dato) {
		this.dato = dato;
	}
	public Nodo getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	

	public String toString(){
		return dato.toString();
	}
}
