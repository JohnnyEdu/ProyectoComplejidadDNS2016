package utils;



import java.util.ArrayList;
import arboles.ArbolGeneralDNS;
import listas.ListaConArreglo;
import listas.ListaEnlazada;
import listas.Nodo;
import listas.Pila;
/**
 * @author Jonathan Baez
 * */
public class Utilidades {
	/**
	 * Metodo pensado para en caso de que venga un www borrarlo e invertir la url
	 * */
	@Deprecated
	public static String invertirWWW(String aInvertir){
		String[] splits = aInvertir.toString().split("\\.");
		String www= splits[0];
		splits[0] = splits[splits.length-1];
		String reverse ="";
		//borro el www
		for (int i = 0; i < (splits.length)-1; i++) {
			reverse += splits[i]+".";
		}
		reverse = reverse.substring(0,reverse.length()-1);
		return reverse;
	}
	/**
	 * Agrega  la url pasada como lista
	 * */
	@Deprecated
	public static void  agregarUrlEnArbol(ListaConArreglo elem, ArbolGeneralDNS nuevoArbol){
		//toString modificado de object para implementacion de ListaConArreglo
		ListaConArreglo datos = (ListaConArreglo)elem;
		String url = datos.elemento(0).toString();
		String ip = datos.elemento(1).toString();
		ArrayList<String>servicios = null;
		ListaEnlazada listaServicios = new ListaEnlazada();
		if (datos.getTamaño()>=3){
			servicios = (ArrayList<String>)datos.elemento(datos.getTamaño()-1);
			for (int i = 0; i < servicios.size(); i++) {
				listaServicios.agregar(new Nodo(servicios.get(i)));
			}
		}
		else{
			listaServicios = new ListaEnlazada();
		}		
		String[] separar = url.toString().split("\\.");
		ListaConArreglo nodosAInsertar = new ListaConArreglo();
		
		
		for (int i = 0; i < separar.length; i++) {
			String sinGuion = separar[i].replace("-", "");
			nodosAInsertar.agregar(sinGuion,i);
		}
		//agrego al arbol la parte mas a la derecha (.com,.org,.net)
		nuevoArbol.agregarNuevaUrl(nodosAInsertar,ip,listaServicios);
	}

	/**
	 * Retorna si el dato ingresado es una url valida del formato : xxx.xxx.xxx o xxx.xxx.xx.xx nunca de menos terminos
	 * */
	public static Boolean esUrl(String url){
		Boolean esUrl = false;
		int contador =0;
		//logica ----> si tiene 3 puntos es url
		for (char a : url.toCharArray()){
			String caracter = ""+a;
			if(caracter.equals(".")){
				contador+=1;
			}
		}
		if (contador >=2){
			esUrl = true;
		}
		return esUrl;
	}
	
	/**
	 * Invierte una pila 
	 * */
	public static Pila invertirPila(Pila pila){
		Pila pilaOrig = pila;
		Pila pilaAlternativa = new Pila(new ListaConArreglo());
		while(!pilaOrig.esVacia()){
			pilaAlternativa.poner(pilaOrig.sacar());
		}
		return pilaAlternativa;
	}
}