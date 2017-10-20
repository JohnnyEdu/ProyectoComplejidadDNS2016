package arboles;


import java.util.ArrayList;

import listas.ListaEnlazada;

/**
 * @author Jonathan Baez
 * Cada Arbol posee una raiz de tipo NodoGeneral
 * */
public class NodoGeneral {
	String dato = null;
	ListaEnlazada hijos = new ListaEnlazada();
	
	public NodoGeneral(String dato){
		this.setDato(dato);
	}
	
	public String getDato() {
		return dato;
	}
	public void setDato(String dato) {
		this.dato = dato;
	}
	public ListaEnlazada getHijos() {
		return hijos;
	}
	public void setHijos(ListaEnlazada hijos) {
		this.hijos = hijos;
	}
	public String toString(){
		//imprimo el dato del nodo mas sus hijos si tiene
		return new String(this.getDato());
//		return this.getDato() + (this.getHijos().getRaiz() == null?"":this.getHijos());
	}
	
}
