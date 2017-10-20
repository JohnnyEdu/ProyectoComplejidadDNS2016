package Modulos;

import arboles.ArbolGeneralDNS;
import arboles.NodoGeneral;
import listas.Cola;
import listas.Lista;
import listas.ListaConArreglo;
import listas.ListaEnlazada;
import listas.Nodo;
import listas.Recorredor;
import nivelesNodo.*;
/**
 * @author Jonathan Baez
 * Modulo utilizado para abstraer la clase arbol de las operaciones de admin
 * */
public class ModAdmin {
	ArbolGeneralDNS arbolTarget;
	public static Boolean existe=false;
	public ModAdmin(ArbolGeneralDNS arbol){
		arbolTarget = arbol;
	}
	/**
	 * Metodo que agrega un subarbol a un nodo si no existe
	 * @param arbol al cual insertarle el hijo
	 * @param arbol a insertar dicho hijo
	 * @return ArbolGeneralDNS insertado o si ya estaba, el que estaba.
	 * */
	public ArbolGeneralDNS agregarHijo(ArbolGeneralDNS hijoAInsertar){
		NodoGeneral raiz = arbolTarget.getRaiz();
		//guardo en arbolInsertado el nodo ya que si no se agrega porque existe
		//estaria trabajando sobre un nodo que no esta en el arbol.
		ArbolGeneralDNS arbolInsertado = null;
		if (raiz.getHijos().esVacia()){
			raiz.getHijos().agregar(new Nodo(hijoAInsertar));
			arbolInsertado = hijoAInsertar;
		}
		else{
			Recorredor recorrerListaSubArboles = Lista.recorredor(raiz.getHijos());
			recorrerListaSubArboles.comenzar();
			Boolean existeYa=false;
			while (!recorrerListaSubArboles.fin()){
				//por cada hijo, volver a preguntar lo mismo de arriba.
				 Nodo actual = (Nodo)recorrerListaSubArboles.elemento();
				 ArbolGeneralDNS arbol = (ArbolGeneralDNS)actual.getDato();
				 String datoArbolHijo = arbol.getRaiz().getDato();
				 String datoHijoAInsertar = hijoAInsertar.getRaiz().getDato();
				 if (datoArbolHijo.equalsIgnoreCase(datoHijoAInsertar)){
					 //evaluo por cada hijo de la misma altura si existe el dominio
					 existeYa = true;
					 arbolInsertado = arbol;
					 break;
				 }
				 recorrerListaSubArboles.proximo();
			}
			if (!existeYa){
				raiz.getHijos().agregar(new Nodo(hijoAInsertar));
				arbolInsertado = hijoAInsertar;
				}
			}
		return arbolInsertado;
	};
	
	
	
	/**
	 * Metodo que elimina una maquina del servidor DNS , pasando como parametro la URL
	 * @param url
	 * */
	public void eliminar(ListaConArreglo nodosMaquina){
		ListaConArreglo listaOriginial = new ListaConArreglo();
		//tengo que agregar los elementos de la lista 1 a la lista 2
		//mediante un iterador ya que la asignacion en java se hacer por referencia
		//y al modificar 1 me pisa 2.
		Recorredor recorrerNodos = Lista.recorredor(nodosMaquina);
		while(!recorrerNodos.fin()){
			listaOriginial.agregar(recorrerNodos.elemento(),listaOriginial.getTamaño());
			recorrerNodos.proximo();
		}
		Cola cola = new Cola(new ListaConArreglo());
		eliminarMaquina( nodosMaquina,listaOriginial,cola);
	}
	
	public void eliminarMaquina(ListaConArreglo nodosMaquina,ListaConArreglo listaOriginal,Cola cola){
		cola.poner(arbolTarget);
		if (!nodosMaquina.esVacia()){
			String nodoABuscar = (String)nodosMaquina.elemento(nodosMaquina.getTamaño()-1);
			Recorredor recorrerListaSubArboles = Lista.recorredor(arbolTarget.getHijos());
			recorrerListaSubArboles.comenzar();
			while (!recorrerListaSubArboles.fin() && !nodosMaquina.esVacia()){
				 Nodo actual = (Nodo)recorrerListaSubArboles.elemento();
				 ArbolGeneralDNS arbol = (ArbolGeneralDNS)actual.getDato();
				 String datoRaizHijo = arbol.getRaiz().getDato();
				 if(datoRaizHijo.equalsIgnoreCase(nodoABuscar)){
					 nodosMaquina.eliminar(nodoABuscar);
					 //llegue al ultimo, tengo que borrar la hoja
					 if (nodosMaquina.esVacia()){
						 //existe, variable estatica utilizada para arrojar mensaje cuando no encontramos el dominio
						 existe = true;
						 //cuando borro la hoja, tengo que borrar el padre si no tiene mas hijos
						 if (arbolTarget.getHijos().getTamaño()>1){
							 //simplemente borrarla si no es hija unica
							 arbolTarget.getHijos().eliminar(actual);
							 break;
						 }
						 else{
							 ArbolGeneralDNS raizOriginal = (ArbolGeneralDNS)cola.tope();
							 if (arbolTarget.equals(raizOriginal)){
								 arbolTarget.getHijos().eliminar(actual);
								 break;
							 }
							 else{
								 //mientras tenga 1 hijo solo tengo que ir borrando para arriba
								 listaOriginal.eliminar(nodoABuscar);
								 Recorredor recorrerListaOriginal = Lista.recorredor(listaOriginal);
								 while(!recorrerListaOriginal.fin()){
									 nodosMaquina.agregar(recorrerListaOriginal.elemento(),nodosMaquina.getTamaño());
									 recorrerListaOriginal.proximo();
								 }
								raizOriginal.eliminarMaquina(nodosMaquina,listaOriginal,cola);
							 }
							
						 }
					 }
					 else{
						 //si quedan nodos por visitar en la busqueda, visitar
						 arbol.eliminarMaquina(nodosMaquina,listaOriginal,cola);
					 }
				 }
				 recorrerListaSubArboles.proximo();
			}
		}

	}
	
	
	
	/**
	 * Metodo que va agregando por cada nodo de la url de derecha a izquierda en el arbol
	 * @param url
	 * @param ip
	 * @param servicios
	 * */
	public void agregarMaquina(ListaConArreglo url,String ip,ListaEnlazada servicios) {
		ArbolGeneralDNS nodoInsertado = null;
		agregarAux(url,nodoInsertado,ip,servicios);
	}
	public void agregarAux(ListaConArreglo url,ArbolGeneralDNS nodoInsertado,String ip,ListaEnlazada servicios){
		if (!url.esVacia()){
			String nodoNivelSuperior = (String)url.elemento(url.getTamaño()-1);
			ArbolGeneralDNS nodo = new ArbolGeneralDNS(new NodoGeneral(nodoNivelSuperior));//nodo .com,.org,.net
			if (url.getTamaño() >=3){
				nodo.setNivelNodo(new NivelSuperior());
			}
			else{
				nodo.setNivelNodo(new Subdominio());
			}
			//uso el return del metodo agregarHijo debido al inconveniente que cuando evaluo si
			//agrego o no un nodo, cuando ya se encuentra el nodo no lo agrega y yo trabajaba sobre
			//el nodo que no  se habia agregado , por ende nunca impactaba el cambio
			//ahora si no lo agrega me quedo con el que encontre igual.
			//ver metodo agregarHijo (arbolInsertado)
			nodoInsertado = arbolTarget.agregarHijo(nodo);
			url.eliminar(nodoNivelSuperior);
			nodoInsertado.agregarAux(arbolTarget,url,nodoInsertado,ip,servicios);
		}
		else{
			if (nodoInsertado!=null){
				Maquina nivelNodo = new Maquina();
				nivelNodo.setIp(ip);
				nivelNodo.setServicios(servicios);
				nodoInsertado.setNivelNodo(nivelNodo);
			}
		}
	}
}
