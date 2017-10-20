package Modulos;

import java.util.Scanner;

import arboles.ArbolGeneralDNS;
import ejecutable.Ejecutable;
import listas.ListaConArreglo;
import listas.ListaEnlazada;
import listas.Nodo;
import utils.Utilidades;
/**
 * @author Jonathan Baez
 * Pantalla de opciones de administracion, salida en pantalla y operaciones
 * */
public class PantallaOpcionesAdmin {
	static Scanner sc = new Scanner(System.in);
	ArbolGeneralDNS arbolNuevo;
	
	public PantallaOpcionesAdmin(ArbolGeneralDNS arbol) {
		arbolNuevo = arbol;
	}
	/**
	 * Metodo para mostrar la pantalla de opciones de administracion
	 * */
	public  void pantallaOpcionesAdmin(){
		System.out.println(">>>Modulo de Administración>>>");
		System.out.println("¿Que desea hacer?");
		System.out.println("1-Agregar un dominio a la base de datos del servidor");
		System.out.println("2-Eliminar un dominio de la base de datos del servidor");
		System.out.println("3-Volver");
		System.out.println("4-Salir de la aplicación");
		System.out.println("Su opcion es:");
		String opcion = sc.nextLine();
		while(!opcion.equals("4")){
			if (opcion.equals("1")){
				procesoAgregar();
			}
			else if (opcion.equals("2")){
				procesoEliminar();
			}
			else if(opcion.equals("3")){
				Ejecutable.main(new String[0]);
			}
			opcion = sc.nextLine();
		}
		System.err.println("Saliendo de la aplicación...");
		System.exit(0);

		
	}
	/**
	 * Metodo que agrega un dominio al Servidor DNS
	 * */
	private void procesoAgregar(){
		ListaEnlazada servicios = new ListaEnlazada();		
		System.out.println("Por favor ingrese el nombre del dominio:");
		String url = sc.nextLine();
		if(!Utilidades.esUrl(url)){
			System.err.println("Por favor ingrese un nombre de dominio válido");
			url = sc.nextLine();
		}
		System.out.println("Por favor ingrese la IP del dominio:");
		String ip = sc.nextLine();
		System.out.println("Por favor ingrese los servicios que provee el dominio:");
		String servicio = sc.nextLine();
		while(!servicio.equals("fin")){
			servicios.agregar(new Nodo(servicio));
			System.out.println("Puede ingresar otro mas o finalizar escribiendo 'fin'");
			servicio = sc.nextLine();
		}
		
		String[] elementosUrl = url.split("\\.");
		ListaConArreglo listaNodos = new ListaConArreglo();
		for (int i = 0; i < elementosUrl.length; i++) {
			listaNodos.agregar(elementosUrl[i], listaNodos.getTamaño());
		}
		
		arbolNuevo.agregarNuevaUrl(listaNodos, ip, servicios);
		pantallaOpcionesAdmin();
	}
	
	
	private void procesoEliminar(){	
		System.out.println("Por favor ingrese el nombre del dominio a eliminar:");
		String url = sc.nextLine();
		if(!Utilidades.esUrl(url)){
			System.err.println("Por favor ingrese un nombre de dominio válido");
			url = sc.nextLine();
		}
		String[] elementosUrl = url.split("\\.");
		ListaConArreglo listaNodos = new ListaConArreglo();
		for (int i = 0; i < elementosUrl.length; i++) {
			listaNodos.agregar(elementosUrl[i], listaNodos.getTamaño());
		}
		arbolNuevo.eliminar(listaNodos);
		pantallaOpcionesAdmin();
	}
}
