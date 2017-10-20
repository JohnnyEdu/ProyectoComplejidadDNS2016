package clasesTesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import arboles.ArbolGeneralDNS;
import arboles.NodoGeneral;
import listas.Cola;
import listas.Lista;
import listas.ListaConArreglo;
import listas.ListaEnlazada;
import listas.Nodo;
import listas.Pila;
import listas.Recorredor;
import utils.Utilidades;

/**
 * Clase testing original de pruebas estaticas
 * */
public class Testing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nombre1 ="";
		int contador = 0;
		ListaConArreglo urls = new ListaConArreglo();
		ListaConArreglo datosUrl = new ListaConArreglo();
		
		// emulacion de entrada de consola
		ArrayList<String> servicios = new ArrayList<>();
		datosUrl.agregar("www.reckles.net",0);
		datosUrl.agregar("111.111.111.111", 1);
		servicios.add("WWW");
		servicios.add("Routing");
		servicios.add("Proxy");
		datosUrl.agregar(servicios,2);
		urls.agregar(datosUrl, 0);
		datosUrl = new ListaConArreglo();
		servicios =new ArrayList<>();
		datosUrl.agregar("www.google.com",0);
		datosUrl.agregar("222.222.222.222", 1);
		servicios.add("FTP");
		servicios.add("P2P");
		servicios.add("Proxy");
		datosUrl.agregar(servicios,2);
		urls.agregar(datosUrl, 1);
		servicios = new ArrayList<>();
		datosUrl = new ListaConArreglo();;
		datosUrl.agregar("pickes.papo.com",0);
		datosUrl.agregar("333.333.333.333", 1);
		servicios.add("Routing");
		servicios.add("FTP");
		servicios.add("DNS");
		datosUrl.agregar(servicios,2);
		urls.agregar(datosUrl, 2);
		datosUrl = new ListaConArreglo();
		servicios = new ArrayList<>();
		datosUrl.agregar("pepet.google.com",0);
		datosUrl.agregar("444.444.444.444", 1);
		urls.agregar(datosUrl,3);
		datosUrl = new ListaConArreglo();;
		datosUrl.agregar("guarani.unaj.edu.ar",0);
		datosUrl.agregar("555.555.555.555", 1);
		urls.agregar(datosUrl,4);
		datosUrl = new ListaConArreglo();;
		datosUrl.agregar("www.unaj.edu.ar",0);
		datosUrl.agregar("666.666.666.666", 1);
		urls.agregar(datosUrl,5);
		datosUrl = new ListaConArreglo();;
		datosUrl.agregar("www.hardvard.edu",0);
		datosUrl.agregar("777.777.777.777", 1);
		urls.agregar(datosUrl,6);
		datosUrl = new ListaConArreglo();;
		datosUrl.agregar("fresh.capoclan.edu",0);
		datosUrl.agregar("888.888.888.888", 1);
		urls.agregar(datosUrl,7);
		datosUrl = new ListaConArreglo();;
		datosUrl.agregar("mate.capoclan.edu",0);
		datosUrl.agregar("999.999.999.999", 1);
		urls.agregar(datosUrl,8);
		
		Recorredor recorrerUrls = Lista.recorredor(urls);
		recorrerUrls.comenzar();
		//Arbol inicial
		ArbolGeneralDNS nuevoArbol = new ArbolGeneralDNS(new NodoGeneral("Servidor DNS"));
		while (!recorrerUrls.fin()){
			//por cada URL , ej: ar.google.com
			Utilidades.agregarUrlEnArbol((ListaConArreglo)recorrerUrls.elemento(),nuevoArbol);
			recorrerUrls.proximo();
		}
		//elimino nodo unico
//		ListaConArreglo maquinaAELminar = new ListaConArreglo();
//		maquinaAELminar.agregar("guarani",0);
//		maquinaAELminar.agregar("unaj",1);
//		maquinaAELminar.agregar("edu",2);
//		maquinaAELminar.agregar("ar",3);
//		nuevoArbol.eliminar(maquinaAELminar);
		
		//elimino nodo con hermanos
		ListaConArreglo maquinita = new ListaConArreglo();
		maquinita.agregar("www",0);
		maquinita.agregar("google",1);
		maquinita.agregar("com",2);
		nuevoArbol.eliminar(maquinita);
		

		nuevoArbol.imprimirNivelSuperior();
		nuevoArbol.imprimirNivelMedio();
//		nuevoArbol.imprimirSubdominios("net",new Pila(new ListaConArreglo()));
//		nuevoArbol.imprimirSubdominios("com",new Pila(new ListaConArreglo()));
//		nuevoArbol.imprimirSubdominios("ar",new Pila(new ListaConArreglo()));
		nuevoArbol.imprimirSubdominios("edu",new Pila(new ListaConArreglo()));
		
		
		Pila pila = new Pila(new ListaConArreglo());
		pila.poner("pickes");
		pila.poner("papo");
		pila.poner("com");
		nuevoArbol.imprimirDescripcionDominio(pila);
		
		
		nuevoArbol.imprimirPorProfundidad(2);
	}
	
	

}
