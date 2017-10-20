package arboles;


import Modulos.ModAdmin;
import Modulos.ModCons;
import listas.Cola;
import listas.ListaConArreglo;
import listas.ListaEnlazada;
import listas.Pila;
import nivelesNodo.*;

/**
 * @author Jonathan Baez
 * */
public class ArbolGeneralDNS extends ArbolGeneral {
	private NivelNodo nivelNodo;
	private ModAdmin modAdmin = new ModAdmin(this);
	private ModCons modCons = new ModCons(this);
	/**
	 * Devuelve el nivel del nodo
	 * */
	public NivelNodo getNivelNodo() {
		return nivelNodo;
	}
	/**
	 * Guarda el nivel al que pertenece el nodo
	 * */
	public void setNivelNodo(NivelNodo nivelNodo) {
		this.nivelNodo = nivelNodo;
	}
	//tuve muchos problemas con los metodos y el polimorfismo con respecto a las clasespadres
	public ArbolGeneralDNS(NodoGeneral raiz) {
		super(raiz);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo que agrega un nodo a un nivel, si existe no se agrega.
	 * */
	public ArbolGeneralDNS agregarHijo(ArbolGeneralDNS hijo){
		return modAdmin.agregarHijo( hijo);
		}
	
	
	//--------> modulo de administracion ------->
	/**
	 * Metodo que elimina una maquina del servidor DNS , pasando como parametro la URL
	 * @param url
	 * */
	//se pasa como lista para ir iterando
	public void eliminar(ListaConArreglo nodosMaquina){
		modAdmin.eliminar( nodosMaquina);
		if(!ModAdmin.existe){
			System.err.println("El dominio indicado no existe en la base");
		}
		ModAdmin.existe=false;
	}
	
	public void eliminarMaquina(ListaConArreglo nodosMaquina,ListaConArreglo listaOriginal, Cola cola){
		modAdmin.eliminarMaquina(nodosMaquina, listaOriginal, cola);
		if(!ModAdmin.existe){
			System.err.println("El dominio indicado no existe en la base");
		}
	}
	
	
	/**
	 * Metodo que va agregando por cada nodo de la url de derecha a izquierda en el arbol
	 * @param url
	 * @param ip
	 * @param servicios
	 * */
	public void agregarNuevaUrl(ListaConArreglo url,String ip,ListaEnlazada servicios) {
		modAdmin.agregarMaquina( url, ip, servicios);
	}
	public void agregarAux(ArbolGeneralDNS arbolRaiz,ListaConArreglo url,ArbolGeneralDNS nodoInsertado,String ip,ListaEnlazada servicios){
		modAdmin.agregarAux(url, nodoInsertado, ip, servicios);
	}
	//------------->modulo de consultas >>>>>>
	/**
	 * Imprime el nivel superior
	 * */
	public void imprimirNivelSuperior(){
		modCons.imprimirNivelSuperior();
	}
	/**
	 * Imprime el nivel medio
	 * */
	
	public void imprimirNivelMedio(){
		modCons.imprimirNivelMedio();
	}
	/**
	 * Usado por los metodos que imprimen
	 * */
	public void imprimirHijos(){
		modCons.imprimirHijos();
	}

	/**
	 * Dado un nodo(subdominio) imprime todos nombres de dominio que dependen de el
	 * */
	public void imprimirSubdominios(String dominio,Pila pila){
			modCons.imprimirSubdominios(dominio,pila);
	}
	
	
	
	public String toString(){
		return this.getRaiz().getDato();
	}
	
	
	/**
	 * Imprime los datos de la maquina de un dominio
	 * */
	public void imprimirDescripcionDominio(Pila url){
		modCons.imprimirDescripcionDominio(url);
		
	}

	public void imprimirPorProfundidad(int profundidad){
		modCons.imprimirPorProfundidad(profundidad);
	}
	/**
	 * Metodo usado para imprimir las ramas que desprenden de un nodo(imprime todas sin validacion)
	 * */
	public Pila imprimirRamasHijas(Pila pila,ArbolGeneralDNS subdominioLimite){
		modCons.imprimirRamasHijas(pila,subdominioLimite);
		return pila;
	}
	
	public void ayudaImpresion(int profundidad,int profundidadIterativa,Cola cola, Cola cola2){
		modCons.ayudaImpresion(profundidad,profundidadIterativa, cola, cola2);
		
	}
}
