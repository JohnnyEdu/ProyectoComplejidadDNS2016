package arboles;

import listas.Lista;
import listas.ListaEnlazada;
import listas.Nodo;
import listas.Recorredor;
/**
 * @author Jonathan Baez
 * */
public class ArbolGeneral {
	NodoGeneral raiz =  null;

	public ArbolGeneral(NodoGeneral raiz){
		this.setRaiz(raiz);
	}
	public NodoGeneral getRaiz() {
		return raiz;
	}

	private void setRaiz(NodoGeneral raiz) {
		this.raiz = raiz;
	}
	
	private String getDatoRaiz(){
		return this.getRaiz().getDato();
	}
	public ListaEnlazada getHijos(){
		return this.getRaiz().getHijos();
	}
	
	public void agregarHijo(ArbolGeneral hijo){
		NodoGeneral raiz = this.getRaiz();
		if (raiz.getHijos().esVacia()){
			//si no tiene hijos (caso base) agregarselo
			raiz.getHijos().agregar(new Nodo(hijo));
		}
		else{
			Recorredor recorrerListaSubArboles = Lista.recorredor(raiz.getHijos());
			recorrerListaSubArboles.comenzar();
			while (!recorrerListaSubArboles.fin()){
				//por cada hijo, volver a preguntar lo mismo de arriba.
				 Nodo actual = (Nodo)recorrerListaSubArboles.elemento();
				 ArbolGeneral arbol = (ArbolGeneral)actual.getDato();
				 arbol.agregarHijo(hijo);
				 recorrerListaSubArboles.proximo();
			}
		}
	}
	
	public void eliminarHijo(ArbolGeneral hijo){
		if (this.getRaiz().equals(hijo.getRaiz())){
			this.setRaiz(null);
		}
		else{
			Recorredor recorrerListaSubArboles = Lista.recorredor(this.getHijos());
			recorrerListaSubArboles.comenzar();
			Nodo actual = null;
			while (!recorrerListaSubArboles.fin()){
				actual = (Nodo)recorrerListaSubArboles.elemento();
				ArbolGeneral arbol = (ArbolGeneral)actual.getDato();
				if (arbol.getDatoRaiz().equals(hijo.getDatoRaiz())){
					this.getHijos().eliminar(actual);
					break;
				}
				else{
					ArbolGeneral arbolNuevo = (ArbolGeneral)actual.getDato();
					arbolNuevo.eliminarHijo(hijo);
				}
				recorrerListaSubArboles.proximo();
			}
		}
	}
	



}
