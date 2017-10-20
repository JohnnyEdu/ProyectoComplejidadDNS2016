package Modulos;

import java.io.Console;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.SwingUtilities;

import arboles.ArbolGeneralDNS;
import ejecutable.Ejecutable;
import listas.Cola;
import listas.ListaConArreglo;
import listas.Pila;
/**
 * @author Jonathan Baez
 * Pantalla de consulta, con la salida en consola y las operaciones
 * */
public class PantallaOpcionesConsulta {
	ArbolGeneralDNS arbolNuevo;
	Scanner sc = new Scanner(System.in);
	
	public PantallaOpcionesConsulta(ArbolGeneralDNS arbol){
		this.arbolNuevo = arbol;
	}
	
	public void pantallaOpcionesConsulta() {
		System.out.println(">>>Módulo de consultas>>>");
		System.out.println("Por favor elija una de las siguientes opiciones:");
		System.out.println("1-Imprimir informacion propia de un dominio");
		System.out.println("2-Imprimir equipos dependientes a un subdominio");
		System.out.println("3-Imprimir dominios de nivel superior");
		System.out.println("4-Imprimir dominios que se encuentran a una profundidad determinada");
		System.out.println("5-Volver");
		System.out.println("6-Salir de la aplicación");
		String opcion = sc.nextLine();
		
		while(!opcion.equals("6")){
			if (opcion.equals("1")){
				System.out.println("Por favor ingrese el nombre del dominio a buscar:");
				opcion = sc.nextLine();
				imprimirDominioCompleto(opcion);
			}
			else if (opcion.equals("2")){
				System.out.println("Por favor ingrese nombre del subdominio para la busqueda de equipos:");
				opcion = sc.nextLine();
				imprimirSubdominiosDependientes(opcion);
			}
			else if(opcion.equals("3")){
				imprimirNivelSuperiorArbol();
			}
			else if(opcion.equals("4")){
				System.out.println("Por favor ingrese profundidad:");
				opcion = sc.nextLine();
				try{
				imprimirPorProfundidad(Integer.parseInt(opcion));
				}
				catch(Exception e){
					System.err.println("Por favor ingrese una profundidad válida");
				}
			}
			else if(opcion.equals("5")){
				Ejecutable.main(new String[0]);
			}
			pantallaOpcionesConsulta();
			opcion = sc.nextLine();
		}
			System.err.println("Saliendo de la aplicación...");
			System.exit(0);
		
		
	}
	
	public void imprimirNivelSuperiorArbol(){
		arbolNuevo.imprimirNivelSuperior();
	} 
	public void imprimirNivelMedioArbol(){
		arbolNuevo.imprimirNivelMedio();
	} 
	
	public void imprimirSubdominiosDependientes(String dominio){
		//TODO: pasar la cola de forma diferente
		arbolNuevo.imprimirSubdominios(dominio,new Pila(new ListaConArreglo()));
	} 	
	
	public void imprimirDominioCompleto(String url){
		String[] nodosUrl = url.split("\\.");
		Pila pila = new Pila(new ListaConArreglo());
		for (int i = 0; i < nodosUrl.length; i++) {
			pila.poner(nodosUrl[i]);
		}
		arbolNuevo.imprimirDescripcionDominio(pila);
	} 	
	public void imprimirPorProfundidad(int profundidad){
		try{
			arbolNuevo.imprimirPorProfundidad(profundidad);
		}
		catch(NumberFormatException e){
			throw new NumberFormatException("Dato ingresado no valido");
		}
	}
	
	
	
}
