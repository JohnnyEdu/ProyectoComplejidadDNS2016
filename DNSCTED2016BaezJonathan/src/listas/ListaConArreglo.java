package listas;

import java.util.ArrayList;
/**
 * @author Jonathan Baez
 * */
public class ListaConArreglo extends Lista{
	ArrayList<Object> datos = new ArrayList<Object>();
	
	
	public Object elemento(int pos){
		Object elem= null;
		if(!esVacia()){
			if (this.tamanio<1){
				elem =datos.get(0);
			}
			else{
				elem = datos.get(pos);
			}
		}
		return elem;
	}
	public void agregar(Object elem,int pos){
		if (pos >= 0){
			this.datos.add(pos,elem);
		}
		this.tamanio+=1;
	}
	

	public void eliminar(Object elem){
		this.datos.remove(elem);
		this.tamanio -=1;
	}
	
	public Boolean esVacia(){
		return this.datos.isEmpty();
	}
	

	public String toString(){
		String presentacion = "";
		if(!this.esVacia()){
			Recorredor recorrerHijos = recorredor(this);
			recorrerHijos.comenzar();
			while (!recorrerHijos.fin()){
				presentacion += recorrerHijos.elemento().toString()+".";
				recorrerHijos.proximo();
			}
		}
		String sinComaFinal = presentacion.substring(0,presentacion.length()-1);
		return sinComaFinal;
	}
}
