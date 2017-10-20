package clasesTesting;

import listas.ListaEnlazada;
import listas.Nodo;

public class TestingLists {
	
	public static void main(String[] args) {
		//Testeo lista con arreglo
//		testListaArreglo();
		testListaEnlazada();
		
		//Testeo lista enlazada
	}
	
	private static void testListaArreglo(){
//		String[] nombres = {"Pepe","Popo","Papa","asdasdas","2312"};
//		ListaConArreglo lista = new ListaConArreglo(nombres);
//		System.out.println(lista.esVacia());
//		System.out.println(lista.elemento(4));
//		System.out.println(lista.getTamaño());
//		System.out.println(lista.incluye("Papa"));
//		lista.agregar("popoptee");
//		System.out.println(lista);
//		System.err.println(lista.display());
	}
	private static void testListaEnlazada(){
		Nodo uno = new Nodo("uno");
		Nodo dos = new Nodo("dos");
		Nodo tres = new Nodo("tres");
		Nodo cuatro = new Nodo("cuatro");
		Nodo cinco = new Nodo("cinco");
		ListaEnlazada lista = new ListaEnlazada();
		System.out.println(lista.esVacia());
		System.out.println(lista.getTamaño());
		lista.agregar(dos);
		lista.agregar(tres);
		lista.agregar(cuatro);
		lista.agregar(cinco);
		lista.eliminar(dos);
		lista.eliminar(tres);
	}
}
